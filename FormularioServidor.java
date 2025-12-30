import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class FormularioServidor {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // Página inicial (formulário)
        server.createContext("/", exchange -> {
            byte[] html = Files.readAllBytes(new File("form.html").toPath());
            exchange.sendResponseHeaders(200, html.length);
            exchange.getResponseBody().write(html);
            exchange.close();
        });

        // Endpoint que recebe o formulário
        server.createContext("/submit", new SubmitHandler());

        server.start();
        System.out.println("Servidor rodando em http://localhost:8000");
    }

    // =========================
    // HANDLER DO POST
    // =========================
    static class SubmitHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            String contentType = exchange.getRequestHeaders().getFirst("Content-Type");

            if (contentType == null || !contentType.contains("multipart/form-data")) {
                exchange.sendResponseHeaders(400, -1);
                return;
            }

            String boundary = contentType.split("boundary=")[1];

            byte[] bodyBytes = exchange.getRequestBody().readAllBytes();
            String body = new String(bodyBytes, "ISO-8859-1");

            String[] parts = body.split("--" + boundary);

            String nome = "";
            String email = "";
            String telefone = "";
            String concursos = "";
            String nomeImagem = "";

            for (String part : parts) {

                if (part.contains("name=\"nome\"")) {
                    nome = extrairValor(part);

                } else if (part.contains("name=\"email\"")) {
                    email = extrairValor(part);

                } else if (part.contains("name=\"telefone\"")) {
                    telefone = extrairValor(part);

                } else if (part.contains("name=\"concursos\"")) {
                    concursos += extrairValor(part) + ", ";

                } else if (part.contains("name=\"imagem\"") && part.contains("filename=\"")) {

                    nomeImagem = part.substring(
                            part.indexOf("filename=\"") + 10,
                            part.indexOf("\"", part.indexOf("filename=\"") + 10)
                    );

                    int inicio = part.indexOf("\r\n\r\n") + 4;
                    int fim = part.lastIndexOf("\r\n");

                    byte[] imagemBytes = part.substring(inicio, fim)
                            .getBytes("ISO-8859-1");

                    // cria pasta uploads se não existir
                    File pasta = new File("uploads");
                    if (!pasta.exists()) pasta.mkdir();

                    FileOutputStream fos = new FileOutputStream("uploads/" + nomeImagem);
                    fos.write(imagemBytes);
                    fos.close();
                }
            }

            FileWriter fw = new FileWriter("dados.txt", true);
            fw.write(
                    "Nome: " + nome + "\n" +
                    "Email: " + email + "\n" +
                    "Telefone: " + telefone + "\n" +
                    "Concursos: " + concursos + "\n" +
                    "Imagem: " + nomeImagem + "\n" +
                    "-------------------------\n"
            );
            fw.close();

            String resposta =
                    "<html><body>" +
                    "<h2>Dados recebidos com sucesso!</h2>" +
                    "<a href='/'>Voltar</a>" +
                    "</body></html>";

            exchange.sendResponseHeaders(200, resposta.getBytes().length);
            exchange.getResponseBody().write(resposta.getBytes());
            exchange.close();
        }
    }

    // =========================
    // MÉTODO AUXILIAR
    // =========================
    private static String extrairValor(String part) {
        int inicio = part.indexOf("\r\n\r\n") + 4;
        return part.substring(inicio).trim();
    }
}
