# Idle Realms - Social Service

A microservice responsible for the social layer of the **Idle Realms** game. This project focuses on guild management, shared player resources, and real-time cross-system communication.

* Hexagonal Architecture – strict separation of business logic from infrastructure
* **Apache Kafka** – asynchronous processing of player activity events
* **PostgreSQL & Flyway** – relational database with automated schema versioning
* **Docker & Docker Compose** – full containerization of the development environment


The service follows **Domain-Driven Design (DDD)** principles and Hexagonal Architecture:
- **Domain:** Pure business logic for guilds and resources.
- **Application:** Input ports and application services.
- **Infrastructure:** Adapters for Kafka, Database (JPA), and REST API.



##  Quick Start
To spin up the infrastructure (Kafka and PostgreSQL), run:
```bash
docker-compose up -d