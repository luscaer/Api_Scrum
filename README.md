# 🧠 API Scrum

API desenvolvida com Spring Boot para gerenciar um ambiente Scrum com Product Owners, projetos e afins.

---

## 🚀 Como rodar o projeto

1. **Clone o repositório:**

```bash
git clone https://github.com/luscaer/Api_Scrum.git
# ou via SSH:
git clone git@github.com:luscaer/Api_Scrum.git
```

2. **Acesse a raiz do projeto:**

```bash
cd Api_Scrum
```

3. **Execute o Docker Compose para subir a aplicação e o banco de dados:**

```bash
docker compose up
```

> 💡 **Dica:** Certifique-se de ter o Docker e o Docker Compose instalados no seu sistema.  
> A aplicação estará disponível em: `http://localhost:1894`

---

## 📮 Endpoints disponíveis

### 📌 POST – Criar ProductOwner | Projeto

**URL:**  
`http://localhost:1894/api/product-owner/save` <br>
`http://localhost:1894/api/project/save`

**Método:** `POST`

**Body (JSON):**
```json
{
  "name": "name",
  "email": "name@email.com",
  "phone": "11999999999",
  "gender": "MALE",
  "responsibilities": "responsibilities"
}
```
```json
{
  "name": "name",
  "expectations": "expectations",
  "initialDate": "2025-01-01",
  "finalDate": "2025-01-01",
  "productOwner": {
    "id": 1
  }
}
```

### ✏️ PUT – Atualizar ProductOwner | Projeto

**URL:**  
`http://localhost:1894/api/product-owner/update/{id}` <br>
`http://localhost:1894/api/project/update/{id}`

**Método:** `PUT`

**Body (JSON):**
```json
{
  "name": "name",
  "email": "name@email.com",
  "phone": "11999999999",
  "gender": "MALE",
  "responsibilities": "responsibilities updated"
}
```
```json
{
  "name": "name",
  "expectations": "expectations",
  "initialDate": "2025-01-01",
  "finalDate": "2025-01-01",
  "productOwner": {
    "id": 1
  }
}
```

### ❌ DELETE – Deletar ProductOwner | Projeto

**URL:**  
`http://localhost:1894/api/product-owner/delete/{id}` <br>
`http://localhost:1894/api/project/delete/{id}`

**Método:** `DELETE`

### 📄 GET – Buscar em ProductOwners

**URL:**  
`http://localhost:1894/api/product-owner/findAll` <br>
`http://localhost:1894/api/product-owner/findById/{id}` <br>
`http://localhost:1894/api/product-owner/findByName?name=name` <br>
`http://localhost:1894/api/product-owner/findByGender?gender=gender`

**Método:** `GET`

### 🔍 GET – Buscar em Projeto

**URL:**  

`http://localhost:1894/api/project/findAll` <br>
`http://localhost:1894/api/project/findById/{id}` <br>
`http://localhost:1894/api/project/findByName?name=name` <br>
`http://localhost:1894/api/project/findByProductOwner?id=id` <br>
`http://localhost:1894/api/project/searchByDate?start=2025-01-01&end=2027-01-01`

**Método:** `GET`

---

### 🛠 Tecnologias utilizadas

- Java 21
- Spring Boot
- Docker & Docker Compose
- PostgreSQL
- JPA / Hibernate
- Lombok

---

### 📂 Estrutura do projeto

```bash
src/
└── main/
    ├── java/
    │   └── br/com/luscaer/api_scrum/
    │       ├── controller/
    │       ├── entity/
    │       ├── model/         # DTOs futuramente
    │       ├── repository/
    │       └── service/
    └── resources/
        └── application.properties
```

---

### ✉️ Contato

Caso tenha dúvidas, sugestões ou queira contribuir, fique à vontade para abrir uma issue ou entrar em contato comigo:

[🔗 GitHub – @luscaer](https://github.com/luscaer)
