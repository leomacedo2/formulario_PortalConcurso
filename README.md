# Formulário de Aprovados em Concursos

Aplicação simples com frontend em HTML e backend em Java para cadastro de aprovados em concursos públicos.

## Tecnologias
- Java
- HTML
- Upload de arquivos (multipart)

## Funcionalidades
- Cadastro de nome, e-mail, telefone
- Lista de concursos aprovados
- Upload de imagem
- Salvamento local dos dados

## Como rodar o projeto

### Pré-requisitos
- Java 17+ instalado

### Passos
1. Clone ou extraia o projeto
2. Abrir terminal na pasta raiz do projeto
2. Compilar:
   javac FormularioServidor.java
3. Rodar:
   java FormularioServidor
4. Acessar: http://localhost:8000

obs: 
As imagens enviadas são salvas na pasta /uploads, e os dados textuais são persistidos no arquivo dados.txt, contendo o nome do arquivo da imagem associada ao cadastro.

