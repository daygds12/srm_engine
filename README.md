# Credit Engine - Currency Manager

## Sobre o projeto

Aplicação desenvolvida para gerenciamento de moedas, permitindo cadastrar, consultar e excluir moedas através de uma API REST desenvolvida em Spring Boot e uma interface web desenvolvida em Angular.

O objetivo do projeto é demonstrar a construção de uma aplicação full stack utilizando boas práticas de desenvolvimento, separação de responsabilidades e comunicação entre frontend e backend.

---

# Arquitetura da solução

A aplicação foi estruturada seguindo uma arquitetura em camadas:

```
Frontend Angular
        |
        |
HTTP REST
        |
        |
Backend Spring Boot
        |
        |
Service Layer
        |
        |
Repository JPA
        |
        |
Banco de Dados
```

## Backend

Responsável por:

* Exposição dos endpoints REST
* Validação das requisições
* Regras de negócio
* Persistência dos dados
* Comunicação com banco de dados

Camadas:

```
controller
   ↓
service
   ↓
repository
   ↓
database
```

## Frontend

Responsável por:

* Interface de gerenciamento das moedas
* Cadastro de novas moedas
* Consulta das moedas cadastradas
* Comunicação com a API REST

---

# Tecnologias utilizadas

## Backend

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Maven
* Swagger/OpenAPI
* Banco de dados relacional

## Frontend

* Angular
* TypeScript
* HTML
* CSS
* HttpClient

---

# Funcionalidades

## Moedas

### Cadastrar moeda

Permite cadastrar uma nova moeda informando:

* Código da moeda
* Descrição

Exemplo:

```
Código: USD
Descrição: Dólar Americano
```

---

### Consultar moedas

Lista todas as moedas cadastradas.

Exemplo de resposta:

```json
[
  {
    "id": 1,
    "code": "USD",
    "description": "Dólar Americano"
  }
]
```

---

### Excluir moeda

Permite remover uma moeda através do identificador.

---

# Como executar o projeto

## Pré-requisitos

Antes de iniciar, tenha instalado:

* Java 17+
* Maven
* Node.js
* Angular CLI

---

# Executando o Backend

Entre na pasta do backend:

```bash
cd credit-engine
```

Execute:

```bash
mvn clean install
```

Depois:

```bash
mvn spring-boot:run
```

A aplicação ficará disponível em:

```
http://localhost:8080
```

---

# Executando o Frontend

Entre na pasta:

```bash
cd credit-engine-front
```

Instale as dependências:

```bash
npm install
```

Execute:

```bash
ng serve
```

A aplicação ficará disponível em:

```
http://localhost:4200
```

---

# Documentação da API

A documentação dos endpoints está disponível através do Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

---

# Endpoints principais

## Consultar moedas

GET

```
/currencies
```

---

## Cadastrar moeda

POST

```
/currencies
```

Exemplo:

```json
{
  "code": "EUR",
  "description": "Euro"
}
```

---

## Excluir moeda

DELETE

```
/currencies/{id}
```

Exemplo:

```
DELETE /currencies/1
```

---

# Validações e boas práticas aplicadas

* Separação entre Controller, Service e Repository
* Injeção de dependência utilizando Spring
* Uso de Spring Data JPA para persistência
* API REST seguindo padrões HTTP
* Documentação utilizando Swagger
* Componentização no Angular
* Comunicação frontend/backend via HTTP

---

# Melhorias futuras

Algumas evoluções possíveis:

* Implementar autenticação utilizando JWT
* Criar testes unitários com JUnit e Mockito
* Adicionar paginação na listagem
* Criar tratamento global de exceções
* Containerizar aplicação utilizando Docker
* Pipeline CI/CD

---

# Autor

Desenvolvido por Dayane Silva
