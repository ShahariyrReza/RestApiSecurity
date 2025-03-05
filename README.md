# RestApiSecurity

### A Basic Authorization Project with Spring Boot Starter Security 🚀

Welcome to **RestApiSecurity**! This project demonstrates the implementation of basic authorization using **Spring Boot Starter Security**, offering multiple ways to manage user login and database access.

---

## Features 🌟

- **Secure Login System**: 
  - Supports multiple users accessing a database securely.
- **Three Implementation Approaches**:
  1. **In-memory Authentication**: Username and password defined in Java code.
  2. **Database Authentication**: User credentials stored in a **MySQL database**.
  3. **Encrypted Authentication**: User data secured using **bcrypt encryption**, stored in the MySQL database.

---

## How It Works 🔍

### 1️⃣ **In-Memory Authentication**
- User credentials are hardcoded in a Java class.
- Ideal for quick testing and learning Spring Security basics.

### 2️⃣ **Database Authentication**
- Usernames and passwords are stored in a MySQL database.
- Configured to authenticate users by checking credentials against the database.

### 3️⃣ **Encrypted Authentication with bcrypt**
- User passwords are encrypted using **bcrypt** before storage.
- Authentication verifies the encrypted password in the database, enhancing security.

---

## Technology Stack 🛠️

- **Java 17+**
- **Spring Boot 3.x**
  - Spring Boot Starter Security
  - Spring Data JPA
- **MySQL**
- **BCrypt Password Encoder**

---

## How to Run 🚀

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/RestApiSecurity.git
   cd RestApiSecurity
   ```

2. **Configure the MySQL Database:**
   - Set up a MySQL database and update the `application.properties` file:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     ```

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Test the endpoints:**
   - Use tools like **Postman** or **curl** to test login and authentication.

---

## Endpoints 📡
localhost:8080/api/employees

---

## License 📜

This project is licensed under the **Apache License**.

---

## Acknowledgments 🙏

- **Spring Boot Documentation** for excellent resources.
- Community contributors for inspiring ideas.

---

Ready to dive in? Let's build something secure and amazing! 🌟

---
