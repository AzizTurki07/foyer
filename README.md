# MonProjetSpringBoot

Application Spring Boot Maven pour gérer des fonctionnalités spécifiques (ex : gestion des utilisateurs, des tâches, etc.).

---

## 📦 Technologies utilisées

- Java 17
- Spring Boot 3.x
- Maven
- Spring Data JPA
- Spring Web
- H2 / MySQL
- Lombok (optionnel)
- Thymeleaf / REST API (selon le projet)

---

## 🚀 Installation et exécution

1. **Cloner le projet**
```bash
git clone https://github.com/AzizTurki07/foyer.git
cd foyer
```

2. **Compiler le projet**
```bash
mvn clean install
```

3. **Lancer l’application**
```bash
mvn spring-boot:run
```

---

## ⚙️ Configuration

- Les fichiers de configuration se trouvent dans `src/main/resources/application.properties` ou `application.yml`.
- Exemple pour MySQL :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nom_de_la_db
spring.datasource.username=root
spring.datasource.password=motdepasse
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🛠 Structure du projet

```
src
└─ main
   ├─ java
   │  └─ com.example.monprojet
   │     ├─ controllers
   │     ├─ services
   │     ├─ repositories
   │     └─ entities
   └─ resources
      ├─ static
      ├─ templates
      └─ application.properties
```

---

## 📌 Fonctionnalités

- CRUD utilisateurs
- Gestion des tâches
- API REST pour les opérations principales

---

## 🔗 Liens utiles

- Documentation Spring Boot : [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
- Maven : [https://maven.apache.org/](https://maven.apache.org/)

---

## 📄 Licence

Ce projet est sous licence MIT.
