# Backend Template para Aplicação com Autenticação JWT e Autorização por Roles - Java / Spring Boot

Este projeto é um template backend para uma aplicação qualquer. Ele oferece funcionalidades como autenticação e autorização de usuários, utilizando tokens JWT (JSON Web Tokens) e um sistema de roles via RBAC. O backend é construído em Java / Spring Boot com o banco de dados MySQL8 via Docker.

## Exemplos de Recursos

- **Autenticação de Usuário**: Sistema de login e registro de usuários.
- **Autorização via JWT**: Após o login, os usuários recebem um token JWT para acessos subsequentes.

## Tecnologias Utilizadas

- **Java / Spring Boot**: Ambiente de execução do servidor.
- **MySQL 8**: Banco de dados relacional eficiente para armazenar os dados dos usuários e informações da aplicação.
- **JWT (JSON Web Tokens)**: Utilizado para a autenticação e autorização de usuários com base em roles.

## Documentação da API

A documentação completa das APIs está disponível no endpoint `/swagger-ui/index.html`. A documentação é interativa e permite testar os endpoints diretamente pela interface do Swagger.

## Instruções de Instalação e Uso

1. Clone o repositório: `git clone [URL_DO_REPOSITORIO]`

2. Navegue até a pasta do projeto e instale as dependências: `cd [NOME_DA_PASTA_DO_PROJETO]` e depois execute `mvn install` para gerar a atualização das dependências e o JAR da aplicação (caso desejar).

3. **Instalação do Docker / MySQL 8** (Opcional):
   - Baixe o Docker do site oficial: [Download Docker - Windows, por exemplo](https://docs.docker.com/desktop/install/windows-install/).
   - Siga as instruções de instalação para o seu sistema operacional.
   - Crie um novo banco de dados em um contâiner Docker utilizando estes comandos:
   
   `docker compose up -d`

   Neste projeto, como já existe um docker file com a descrição da imagem do BD, ele faz o pull da imagem automaticamente.
   
5. Inicie o servidor: execute a aplicação pela classe main da mesma na sua IDE preferida (recomendo Intellij IDEA Community ou Ultimate).

6. Acesse `http://localhost:8080/swagger-ui/index.html` em seu navegador para visualizar a documentação da API.

---

Desenvolvido com ❤️ por Samuel Baldasso
