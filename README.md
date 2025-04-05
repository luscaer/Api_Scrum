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

### 📌 POST – Criar ProductOwner

**URL:**  
`http://localhost:1894/api/product-owner/save`

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

### ✏️ PUT – Atualizar ProductOwner

**URL:**  
`http://localhost:1894/api/product-owner/update/{id}`

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

### ❌ DELETE – Deletar ProductOwner

**URL:**  
`http://localhost:1894/api/product-owner/delete/{id}`

**Método:** `DELETE`

### 📄 GET – Buscar todos os ProductOwners

**URL:**  
`http://localhost:1894/api/product-owner/findAll`

**Método:** `GET`

### 🔍 GET – Buscar ProductOwner por ID

**URL:**  
`http://localhost:1894/api/product-owner/findById/{id}`

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
