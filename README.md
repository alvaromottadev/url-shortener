# Encurtador de URL

Este projeto é um **encurtador de URL** desenvolvido para facilitar a criação de links curtos e gerenciáveis a partir de URLs longas. Com uma API robusta e intuitiva, ele permite que usuários criem, consultem e gerenciem URLs encurtadas de forma simples e eficiente.

## Funcionalidades

- **Criação de URLs encurtadas:** Gere links curtos para URLs longas facilmente.
- **Redirecionamento:** Acesse rapidamente a URL original a partir do link curto.
- **Documentação interativa:** API documentada e navegável usando Swagger.
- **Testes unitários:** Cobertura de testes para garantir a confiabilidade do sistema.

## Documentação

A documentação da API está disponível via **Swagger**. Após iniciar o serviço, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

## Variáveis de Ambiente

A aplicação utiliza as seguintes variáveis de ambiente para configuração:

| Variável            | Significado                                | Exemplo                |
|---------------------|--------------------------------------------|------------------------|
| `DBHOST`            | Endereço do banco de dados                 | `localhost`            |
| `DBPORT`            | Porta do banco de dados                    | `5433`                 |
| `DATABASE_USERNAME` | Usuário do banco de dados                  | `postgres`             |
| `DATABASE_PASSWORD` | Senha do banco de dados                    | `postgres`             |

## Como iniciar o projeto

1. **Ajuste as variáveis no `application.properties`.**
2. **Execute o docker-compose:**
   ```bash
   docker-compose up -d
   ```

   Isso irá subir o banco de dados.


3. **Execute a aplicação:**  

4. **Acesse a documentação:**
    - [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Resposta da URL Encurtada

Ao criar uma URL encurtada, a resposta retorna um link no formato:

```
http://localhost:8080/1292x3
```

A url `http://localhost:8080` pode ser alterada em UrlShortedResponse.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot** (framework principal)
- **Spring Data JPA** (persistência)
- **PostgreSQL** (banco de dados relacional)
- **Swagger / OpenAPI** (documentação de API)
- **Docker** e **Docker Compose**
- **JUnit** (testes unitários)

---

Sinta-se à vontade para abrir issues ou contribuir com o projeto!