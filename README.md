# 🌐 **Ocean | Guarg - Global Solution 2024**

## **Integrantes**
- Ayslan Andrew Blanco Ricciardi Garcia, RM: 96841
- Leonardo Kurokawa Sagara, RM: 96934
- Matheus Oliveira dos Santos, RM: 96543
- Paulo Roberto Maldonado da Silva Gottardi, RM: 96877
- Pedro Henrique Kokuba, RM: 96604

## **Descrição**
Este é um projeto que tem como intuito utilizar drones submarinos implantados com inteligência artificial em suas câmeras, capazes de fazer o reconhecimento e o mapeamento do lixo presente em reservas de água (mar,rios e lagoas), disponibilizando em um site estas informações para que terceriros(Governos, ONGs, e voluntários) possam fazer a retirada dos dejetos.    

## **Tecnologias Utilizadas**

- **Spring Boot** 3.3.0:
  - `spring-boot-starter-data-jpa`: Suporte para JPA e Hibernate.
  - `spring-boot-starter-security`: Integração com Spring Security.
  - `spring-boot-starter-thymeleaf`: Suporte para Thymeleaf como motor de templates.
  - `spring-boot-starter-validation`: Suporte para validação de dados.
  - `spring-boot-starter-web`: Suporte para desenvolvimento web, incluindo aplicações RESTful.
  - `spring-boot-starter-test`: Suporte para testes unitários e de integração.

- **Thymeleaf Extras Spring Security**:
  - `thymeleaf-extras-springsecurity6`: Integração de Thymeleaf com Spring Security.

- **Banco de Dados**:
  - `h2database:h2`: Banco de dados em memória para desenvolvimento e testes.

- **Lombok**:
  - `org.projectlombok:lombok`: Biblioteca para reduzir boilerplate de código Java (anotado como opcional).

- **ModelMapper**:
  - `org.modelmapper:modelmapper`: Biblioteca para mapeamento de objetos.

- **Java**:
  - `java.version: 17`: Versão do Java utilizada no projeto.


## **Pré-requisitos**
- Java 17
- Maven
- Git

## **Como executar**
- Clone este repositório do Github

## **Instruções**
Após executar o projeto, abrir no navegador na URL `localhost:9090/`, para navegar entre os outros endpoints será necessário fazer o login em um usuário válido, inserir username: `user` e password: `password`.

## **Documentação da API**

| Método HTTP | Endpoint                           | Descrição                                         | Parâmetros                                                                                   |
|-------------|-------------------------------------|---------------------------------------------------|----------------------------------------------------------------------------------------------|
|   **DroneController**                                                                                                   |
| POST        | `/api/drones`                       | Cria um novo drone                                | Corpo da Requisição: `DroneDto`                                                              |
| GET         | `/api/drones`                       | Retorna uma lista paginada de drones              | Query Params: `page` (int, default: 0), `size` (int, default: 5)                             |
| GET| `/api/drones/{id}`                  | Retorna os detalhes de um drone específico        | Path Variable: `id` (Long)                                                                   |
| PUT         | `/api/drones/{id}`                  | Atualiza um drone existente                       | Path Variable: `id` (Long), Corpo da Requisição: `DroneDto`                                  |
| DELETE      | `/api/drones/{id}`                  | Deleta um drone específico                        | Path Variable: `id` (Long)                                                                   |
|**GarbageController**                                                                                               |
| POST        | `/api/garbages`                     | Cria um novo registro de lixo                     | Corpo da Requisição: `GarbageDto`                                                            |
| GET         | `/api/garbages`                     | Retorna uma lista de todos os registros de lixo   | Nenhum                                                                                       |
| GET         | `/api/garbages/detections/{droneId}`| Retorna uma lista paginada de lixos detectados por um drone | Path Variable: `droneId` (Long), Query Params: `page` (int, default: 0), `size` (int, default: 5) |
| GET         | `/api/garbages/{id}`                | Retorna os detalhes de um registro de lixo específico | Path Variable: `id` (Long)                                                               |
| PUT         | `/api/garbages/{id}`                | Atualiza um registro de lixo existente            | Path Variable: `id` (Long), Corpo da Requisição: `GarbageDto`                                |
| DELETE      | `/api/garbages/{id}`                | Deleta um registro de lixo específico             | Path Variable: `id` (Long)                                                                   |
