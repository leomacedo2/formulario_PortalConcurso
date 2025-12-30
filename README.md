# Formulário de Aprovados em Concursos

Aplicação simples com frontend em HTML e backend em Java para cadastro de aprovados em concursos públicos.

## Tecnologias
- Java
- HTML
- Upload de arquivos (multipart)

## Funcionalidades
- Formulário HTML com campos:
  - Nome
  - Email
  - Telefone
  - Concursos aprovados
  - Upload de imagem
- Backend em Java usando HttpServer
- Armazenamento local dos dados e imagens

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


## Observações
- Os dados enviados são armazenados localmente
- As imagens são salvas na pasta /uploads, contendo o nome do arquivo da imagem associada ao cadastro.

