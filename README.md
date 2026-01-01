# Formulário de Aprovados em Concursos

Aplicação simples com frontend em HTML e backend em Java para cadastro de aprovados em concursos públicos.

---

## 🌐 Deploy

A aplicação está disponível online para testes no seguinte endereço:

🔗 https://formulario-portalconcurso.onrender.com/

Nesse ambiente é possível acessar o formulário, preencher os dados e validar o funcionamento do fluxo frontend → backend.

---

## 💾 Persistência de Dados

No ambiente de deploy gratuito utilizado, o sistema de arquivos **não é persistente**.  
Por esse motivo:

- Os dados enviados **não são armazenados permanentemente** em produção.
- O upload de imagens funciona durante a execução, mas pode ser resetado caso o serviço reinicie.

👉 **Ao rodar a aplicação localmente**, a persistência funciona normalmente:
- Arquivo `dados.txt` para os registros
- Pasta `uploads/` para as imagens enviadas

---

## 🧪 Execução Local (Persistência Completa)

### Pré-requisitos
- Java 17+

### Passos
1. Clone ou extraia o projeto
2. Abra um terminal na pasta raiz
3. Compile:
   ```bash
   javac FormularioServidor.java
4. Execute:
   java FormularioServidor
5. Acesse:
   http://localhost:8000

## Tecnologias
- Java
- HTML
- Upload de arquivos (multipart)
- HttpServer (Java padrão)

## Funcionalidades

- Formulário HTML com os campos:
   - Nome
   - Email
   - Telefone
   - Concursos aprovados
   - Upload de imagem
- Backend em Java puro
- Upload e salvamento de imagens
- Armazenamento local dos dados



