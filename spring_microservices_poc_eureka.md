# 🧩 Spring Boot Microservices POC

A production-grade, interview-ready microservices proof-of-concept built with Spring Boot 3, Docker, Kafka, OpenTelemetry, Resilience4j, AOP, Spring Batch, OAuth2, and the Saga Pattern.

---

## 📐 Architecture Overview

```
                +---------------------+
                |   API Gateway       |
                | (Spring Cloud GW)   |
                +---------+-----------+
                          |
         +----------------+-----------------+
         |                |                 |
+--------v-----+  +-------v-------+  +------v-------+
| user-service |  | order-service |  | product-service |
| (REST + DB)  |  | (Saga + Kafka)|  | (Inventory DB)  |
+--------------+  +---------------+  +-----------------+
                         |
                +--------v--------+
                | notification-svc |
                |  (Kafka Consumer)|
                +------------------+
```

---

## ⚙️ Tech Stack

| Layer            | Tools Used                                  |
| ---------------- | ------------------------------------------- |
| Language         | Java 17                                     |
| Framework        | Spring Boot 3.x                             |
| Build Tool       | Maven                                       |
| Config Server    | Spring Cloud Config                         |
| Service Registry | Eureka                                      |
| Gateway          | Spring Cloud Gateway                        |
| DB               | PostgreSQL (per service)                    |
| Messaging        | Apache Kafka                                |
| Async Pattern    | Saga Pattern (Choreography)                 |
| Batch Jobs       | Spring Batch                                |
| Security         | Spring Security + OAuth2                    |
| Observability    | OpenTelemetry, Prometheus, Grafana, Datadog |
| Tracing          | Spring Cloud Sleuth + Zipkin or Jaeger      |
| AOP              | Spring AOP (method logging, metrics)        |
| Circuit Breaker  | Resilience4j                                |
| Containerization | Docker, Docker Compose                      |
| CI/CD            | GitHub Actions (build, push, deploy)        |

---

## 🧩 Microservices Breakdown

### 1. `user-service`

-   REST API for user registration, retrieval
-   PostgreSQL
-   Eureka Client
-   Config client
-   Exposes `GET /users/{id}`, `POST /users`
-   Protected with Spring Security + OAuth2

### 2. `order-service`

-   Places orders
-   Publishes `order.placed` Kafka event
-   Participates in a Saga (choreography)
-   Uses Resilience4j Circuit Breaker for user lookup
-   Contains scheduled or triggered Spring Batch jobs for order cleanup

### 3. `product-service`

-   CRUD for product catalog and inventory
-   Basic search/filter APIs

### 4. `notification-service`

-   Kafka consumer
-   Listens to `order.placed` event
-   Sends mock email/SMS

---

## 🔄 Saga Pattern (Choreography)

**Flow:**

1. `order-service` places order → emits `order.placed`
2. `notification-service` listens → sends confirmation
3. Compensating actions can be implemented by emitting `order.failed`

---

## 🔌 Inter-Service Communication

| Type        | Technology        |
| ----------- | ----------------- |
| Synchronous | Feign + Eureka    |
| Async       | Kafka (Event Bus) |

---

## 🎯 AOP Setup

Implemented via `@Aspect`:

-   Logs every method call entry and exit
-   Captures execution time
-   Pushes custom metrics to Micrometer (Prometheus backend)

---

## ⚡ Resilience4j (Circuit Breaker)

Example: in `order-service`, calling `user-service`:

```java
@CircuitBreaker(name = "userService", fallbackMethod = "fallback")
@Retry(name = "userService")
public User fetchUser(Long id) {
    return userClient.getUser(id);
}

public User fallback(Long id, Throwable t) {
    // Return dummy user or throw custom exception
}
```

Also includes:

-   `@Retry`
-   `@RateLimiter`

Configured in `application.yml`.

---

## 📊 Observability Stack

| Component      | Details                                |
| -------------- | -------------------------------------- |
| **Tracing**    | OpenTelemetry + Sleuth → Zipkin/Jaeger |
| **Metrics**    | Micrometer → Prometheus                |
| **Dashboards** | Grafana (Dashboards for app + JVM)     |
| **Logging**    | Structured logs via Spring Boot + OTEL |

OpenTelemetry Java Agent can be injected at runtime via:

```bash
-javaagent:/otel/opentelemetry-javaagent.jar \
-Dotel.service.name=order-service \
-Dotel.exporter.otlp.endpoint=http://otel-collector:4317
```

---

## 🚀 Deployment

### 🐳 Docker Compose (Local)

-   Run all services and infrastructure in a single `docker-compose.yml`
-   Includes: services, Eureka, Kafka, Zipkin, Postgres, Prometheus, Grafana

<!-- ### ☸️ Kubernetes (Dev/Prod)

- Each service has its own `Deployment`, `Service`, `ConfigMap`, `Secret`
- Uses namespace isolation
- Helm charts optional
- Supports ECS or EKS deployment targets

--- -->

## 📦 CI/CD

### GitHub Actions Flow

1. Checkout & Test
2. Build JAR
3. Build Docker image
4. Push to ECR
5. Update ECS Task Definition
6. Trigger rolling update in ECS

---

## ✅ Summary

This project demonstrates a full-scale, modern microservices setup optimized for interviews and real-world readiness. You’ll showcase:

-   Microservices mastery (communication, autonomy, deployment)
-   Kafka event-driven architecture
-   Saga pattern for async flow
-   Spring Batch for scheduled processing
-   OAuth2-secured endpoints
-   Observability with tracing, logging, metrics
-   Resilience with circuit breakers and retries
-   AOP for cross-cutting concerns
-   Docker + Kubernetes for scalable deployment

---

> Ready to begin? Start with `user-service` and build each service layer by layer.

```bash
cd user-service
./mvnw spring-boot:run
```

Happy hacking! 💻
Folder Structure

## 📁 Folder Structure

```
spring-microservices-eureka-poc/
├── pom.xml                      # Parent POM
│
├── config-server/              # Spring Cloud Config Server
│   ├── pom.xml
│   └── src/
│
├── config-repo/                # Local config repository (YAML files only)
│   └── application.yml, user-service.yml, ...
│
├── discovery-server/           # Eureka Discovery Service
│   ├── pom.xml
│   └── src/
│
├── gateway-service/            # API Gateway (Spring Cloud Gateway)
│   ├── pom.xml
│   └── src/
│
├── user-service/               # User microservice
│   ├── pom.xml
│   └── src/
│
├── order-service/              # Order microservice
│   ├── pom.xml
│   └── src/
│
├── product-service/            # Product microservice
│   ├── pom.xml
│   └── src/
│
├── notification-service/       # Kafka-based Notification microservice
│   ├── pom.xml
│   └── src/
│
├── docker/                     # Optional Dockerfiles or Compose setup
│   └── Dockerfile.*
│
└── docs/                       # Documentation
    ├── architecture.md
    └── deployment.md
```

---

## 🌐 Service Port Table

| Service                | Description                  | Port |
| ---------------------- | ---------------------------- | ---- |
| `config-server`        | Spring Cloud Config Server   | 8888 |
| `discovery-server`     | Eureka Discovery Server      | 8761 |
| `gateway-service`      | API Gateway                  | 8080 |
| `user-service`         | User Service                 | 8081 |
| `order-service`        | Order Service                | 8082 |
| `product-service`      | Product Service              | 8083 |
| `notification-service` | Notification Service (Kafka) | 8084 |
