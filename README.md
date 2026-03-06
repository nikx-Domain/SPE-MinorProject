# Scientific Calculator — CI/CD DevOps Pipeline

A **menu-driven Java scientific calculator** integrated with a complete **DevOps CI/CD pipeline**.
The project demonstrates how modern development workflows automate **build, testing, containerization, and deployment**.

---

## 🚀 Features

The calculator supports several scientific operations:

* Square Root (`√x`)
* Factorial (`x!`)
* Natural Logarithm (`ln(x)`)
* Power Function (`x^b`)

---

## 🛠 Tech Stack

| Category                 | Technology        |
| ------------------------ | ----------------- |
| Language                 | Java (JDK 11)     |
| Build Tool               | Maven             |
| Testing                  | JUnit             |
| CI/CD                    | Jenkins           |
| Webhook Tunnel           | ngrok             |
| Containerization         | Docker            |
| Container Registry       | Docker Hub        |
| Configuration Management | Ansible           |
| Notifications            | SMTP Email Alerts |
| Source Control           | GitHub            |

---

## 📂 Project Structure

```
.
├── ansible/
│   ├── inventory
│   └── playbook.yml
│
├── src/
│   ├── main/java/
│   │   └── ScientificCalculator.java
│   └── test/java/
│       └── CalculatorTest.java
│
├── Dockerfile
├── Jenkinsfile
├── pom.xml
└── README.md
```

---

## ⚙️ CI/CD Pipeline Workflow

The project follows a fully automated **Continuous Integration / Continuous Deployment pipeline**:

1. **Code Push**

   * Developer pushes code to GitHub.

2. **Webhook Trigger**

   * GitHub webhook triggers Jenkins via **ngrok tunnel**.

3. **Build & Test**

   * Jenkins runs Maven:

   ```
   mvn clean package
   ```

   * JUnit tests are executed automatically.

4. **Failure Notification**

   * If tests fail, Jenkins sends an **SMTP email alert**.

5. **Docker Image Build**

   * Jenkins builds a Docker image.

6. **Push to Registry**

   * The image is pushed to Docker Hub.

7. **Deployment**

   * Ansible pulls the latest image and deploys it.

---

## 🛠 Running the Project

### Run Locally (Maven)

```bash
mvn clean package
java -cp target/scientific-calculator-1.0-SNAPSHOT.jar ScientificCalculator
```

---

### Run Using Docker

Pull the container image:

```bash
docker pull nikxdomain/scientific-calculator:latest
```

Run the container:

```bash
docker run -it nikxdomain/scientific-calculator:latest
```

---

### Deploy Using Ansible

```bash
cd ansible
ansible-playbook -i inventory playbook.yml
```

---

## 📧 Automated Email Notifications

The CI pipeline automatically sends **email alerts** when a build fails.

Recipient:

```
niks2veg@gmail.com
```

This allows immediate feedback when a push introduces errors.

---

## 🔗 Project Links

**GitHub Repository**

[https://github.com/nikx-Domain/SPE-MinorProject](https://github.com/nikx-Domain/SPE-MinorProject)

**Docker Hub**

[https://hub.docker.com/r/nikxdomain/scientific-calculator](https://hub.docker.com/r/nikxdomain/scientific-calculator)

---

## 📌 DevOps Lifecycle Demonstrated

This project demonstrates the following DevOps practices:

* Source Control Integration
* Automated Build
* Automated Testing
* Continuous Integration
* Containerization
* Continuous Deployment
* Infrastructure Automation
* Monitoring & Notifications

---

## 📜 License

This project is for **educational and demonstration purposes**.
