# Consultation Service API

A Spring Boot REST API for handling consultations, where users answer questions and receive an eligibility decision for a medical prescription in JSON format.

## Table of Contents
- [Project Overview](#project-overview)
- [Tech Stack](#tech-stack)
- [Setup Instructions](#setup-instructions)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Validation Details](#validation-details)
- [Sample API Usage](#sample-api-usage)
- [Notes](#notes)


## Project Overview

The Consultation Service API provides REST endpoints to:
1. Serve consultation questions to users.
2. Accept and validate answers from users.
3. Determine the user's eligibility for a prescription.

This application uses in-memory collections for data management, so no permanent storage is required.


## Tech Stack

- **Java**: Version 17 or later (tested with Java 21).
- **Spring Boot**: For building REST APIs.
- **Maven**: For dependency management and build tasks.
- **Lombok**: To reduce boilerplate code.
- **OpenAPI (Swagger)**: For API documentation.


## Setup Instructions

### Prerequisites

- **JDK**: Ensure you have JDK 21.
- **Maven**: Ensure Maven 3.8.5 or later is installed.

### Project Configuration

Clone the repository and navigate to the project directory:

```bash
git clone <repository-url>
cd consultation
```

### Configure Java Version
1. Make sure the JAVA_HOME environment variable points to JDK 21.
2. In IntelliJ or your IDE, confirm that both Project SDK and Maven Runner are set to JDK 21.

#### Build the Project
To build the project, run:
```bash
mvn clean install
```
### Running the Application
To start the application locally, use:
```bash
mvn spring-boot:run
```

Once started, the API will be available at http://localhost:8080.

## API Documentation

The API is documented via Swagger and can be accessed at the following endpoints:

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

### Endpoints Overview

| HTTP Method | Endpoint                       | Description                       |
|-------------|--------------------------------|-----------------------------------|
| GET         | `/api/v1/questions`            | Fetches all consultation questions |
| POST        | `/api/v1/consultation/submit`  | Submits consultation answers      |

### Validation Details

Each answer in the `ConsultationAnswer` object is validated with the following criteria:

- `List<Answer>` cannot be null, empty, or blank.
- Each `Answer` must have a non-null, non-empty `questionId` and `answer`.

## Sample API Usage
Here are sample cURL commands to interact with the API.

### Fetch Consultation Questions
```bash
curl -X GET http://localhost:8080/api/v1/questions
```

### Submit Consultation Answers

```bash
curl -X POST http://localhost:8080/api/v1/consultation/submit \
-H "Content-Type: application/json" \
-d '{
    "answers": [
        {
            "questionId": "1",
            "answer": "yes"
        },
        {
            "questionId": "2",
            "answer": "no"
        }
    ]
}'
```
Expected JSON Response:
```bash
{
    "canPrescribe": false,
    "message": "We cannot prescribe the medication."
}

```

## Notes
**Error Handling**: If validation fails, a 400 Bad Request error is returned with validation details.

**Lombok**: Ensure Lombok is installed in your IDE to avoid compilation issues.