# OMDB

**Linguagem:** 

- Java

**Framework:** 

- Spring

**Dependencias:**

- Lombok

- Spring Boot JPA

- Spring Boot Web

- Spring Openfeign

- Spring Boot Devtools

- H2

- Spring Hateoas

**H2:**
- URL: http://localhost:8080/omdb/h2

- JDBC URL: jdbc:h2:mem:test

- User Name: h2

- Senha em branco

**Requisições no Postman:**

- Consumo da API (GET): localhost:8080/omdb/movie/omdb/(nome do filme em inglês) 

- Salvar Filme (POST): localhost:8080/omdb/movie ---> Body --->JSON

- Pesquisar filmes salvos(GET):  localhost:8080/omdb/movie/(id do filme salva)
