# Teste — API E-commerce (Spring Boot) 🛒

API REST de **e-commerce** em **Spring Boot**, com gerenciamento de clientes e pedidos, documentação interativa, envio de e-mail e tratamento de exceções centralizado.

> 💡 Apesar do nome do repositório (`Teste`), trata-se de um projeto funcional e estruturado. Vale renomear para algo como `api-ecommerce` para refletir o conteúdo.

## ✨ Funcionalidades

- CRUD de **Clientes** e **Pedidos** (com seus respectivos DTOs)
- **Segurança** com Spring Security
- **Envio de e-mail** (Spring Mail)
- **Tratamento de exceções** centralizado (`ControllerExceptionHandler`, `ErroResposta`, exceções customizadas como `EmailException` e `ProductCodeException`)
- Documentação interativa com **Swagger**

## 🛠️ Tecnologias

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat&logo=postgresql&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=flat&logo=swagger&logoColor=black)

- **Java + Spring Boot** (Web, Data JPA, Security, Mail, Validation)
- **PostgreSQL** · **Springfox / Swagger**

## 🚀 Como executar

```bash
git clone https://github.com/limongi1234/Teste.git
cd Teste
# configure o PostgreSQL e o e-mail em src/main/resources/application.properties
./mvnw spring-boot:run
```

Swagger em `http://localhost:8080/swagger-ui.html`.
