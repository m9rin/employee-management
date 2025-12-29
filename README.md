# Employee Management API

API REST para cadastro e gerenciamento de funcionários, desenvolvida em **Java** com **Spring Boot**.

Este projeto implementa operações de CRUD (Create, Read, Update, Delete) de funcionários, servindo como exemplo de backend para sistemas de gestão de pessoas.

> Projeto baseado no conteúdo da [java10x.dev](https://java10x.dev).

---

## 🧰 Tecnologias utilizadas

- Java 17+ (ajuste conforme sua versão)
- Spring Boot
  - Spring Web
  - Spring Data JPA
  - Bean Validation
- Banco de Dados (H2 / MySQL / PostgreSQL – conforme configurado no `application.properties`)
- Maven

---

## 📁 Estrutura do projeto

```text
employee-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...              # Pacotes da aplicação
│   │   │       ├── controller/  # Controllers REST
│   │   │       ├── service/     # Camada de serviço (regras de negócio)
│   │   │       ├── repository/  # Interfaces de repositório (Spring Data JPA)
│   │   │       └── model/       # Entidades (JPA)
│   │   └── resources/
│   │       ├── application.properties  # Configurações da aplicação
│   │       └── data.sql / schema.sql   # (opcional) scripts de inicialização do banco
├── pom.xml
└── ...
```

> Atualize os nomes de pacotes e pastas acima se necessário, de acordo com a estrutura real do seu código.

---

## 👥 Entidade Funcionário (Employee)

Os campos podem variar conforme a sua implantação. Um exemplo comum de atributos:

- `id` (Long) – identificador único do funcionário
- `name` (String) – nome completo
- `email` (String) – e-mail corporativo ou pessoal
- `position` (String) – cargo/função
- `salary` (BigDecimal / Double) – salário

---

## 🚀 Como executar o projeto

### Pré-requisitos

- Java 17+ instalado
- Maven instalado (ou usar o wrapper `mvnw` incluso no projeto)
- IDE de sua preferência (IntelliJ, VS Code, Eclipse, etc.)

### Clonar o repositório

```bash
git clone https://github.com/m9rin/employee-management.git
cd employee-management
```

### Rodar com Maven usando o wrapper

Linux / macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

Ou, se tiver o Maven instalado globalmente:

```bash
mvn spring-boot:run
```

A aplicação deve iniciar por padrão em:

- `http://localhost:8080`

---

## 🔗 Endpoints principais

> Os caminhos abaixo são exemplos, supondo que o resource principal seja mapeado em `/api/employees`. Ajuste para os endpoints reais configurados no seu controller.

### 1. Criar funcionário

**POST** `/api/employees`

**Body (JSON) exemplo:**

```json
{
  "name": "Maria Silva",
  "email": "maria.silva@example.com",
  "position": "Desenvolvedora Backend",
  "salary": 8500.0
}
```

**Resposta (201 Created) exemplo:**

```json
{
  "id": 1,
  "name": "Maria Silva",
  "email": "maria.silva@example.com",
  "position": "Desenvolvedora Backend",
  "salary": 8500.0
}
```

---

### 2. Listar todos os funcionários

**GET** `/api/employees`

**Resposta (200 OK) exemplo:**

```json
[
  {
    "id": 1,
    "name": "Maria Silva",
    "email": "maria.silva@example.com",
    "position": "Desenvolvedora Backend",
    "salary": 8500.0
  },
  {
    "id": 2,
    "name": "João Souza",
    "email": "joao.souza@example.com",
    "position": "Analista de Sistemas",
    "salary": 7000.0
  }
]
```

---

### 3. Buscar funcionário por ID

**GET** `/api/employees/{id}`

Exemplo:

```http
GET /api/employees/1
```

**Resposta (200 OK) exemplo:**

```json
{
  "id": 1,
  "name": "Maria Silva",
  "email": "maria.silva@example.com",
  "position": "Desenvolvedora Backend",
  "salary": 8500.0
}
```

Possíveis respostas de erro:

- **404 Not Found** – caso o funcionário não seja encontrado.

---

### 4. Atualizar funcionário

**PUT** `/api/employees/{id}`

**Body (JSON) exemplo:**

```json
{
  "name": "Maria S. Silva",
  "email": "maria.s.silva@example.com",
  "position": "Senior Backend Developer",
  "salary": 12000.0
}
```

**Resposta (200 OK) exemplo:**

```json
{
  "id": 1,
  "name": "Maria S. Silva",
  "email": "maria.s.silva@example.com",
  "position": "Senior Backend Developer",
  "salary": 12000.0
}
```

Possíveis respostas de erro:

- **404 Not Found** – caso o funcionário não seja encontrado.

---

### 5. Deletar funcionário

**DELETE** `/api/employees/{id}`

Exemplo:

```http
DELETE /api/employees/1
```

**Resposta:**

- **204 No Content** – exclusão realizada com sucesso
- **404 Not Found** – caso o funcionário não seja encontrado

---

## 🧪 Testando a API

Você pode testar a API com:

- Postman
- Insomnia
- `curl` via terminal
- Extensões de REST Client na IDE

Exemplo usando `curl`:

```bash
curl -X POST http://localhost:8080/api/employees   -H "Content-Type: application/json"   -d '{
    "name": "Maria Silva",
    "email": "maria.silva@example.com",
    "position": "Backend Developer",
    "salary": 8500.0
  }'
```

---

## ⚙️ Configuração do banco de dados

A configuração do banco de dados é feita em `src/main/resources/application.properties` (ou `application.yml`).

### Exemplo com H2 em memória

```properties
spring.datasource.url=jdbc:h2:mem:employeedb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

Acesso ao console H2 (caso habilitado):

- `http://localhost:8080/h2-console`

---

