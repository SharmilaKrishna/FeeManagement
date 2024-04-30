# Fee Collection Microservice

This microservice manages student fee collection and provides RESTful APIs for adding students, collecting fees, and viewing receipts.

## Project Structure

The project follows the CodeFirst design approach.

- **src/main/java**: Contains Java source code.
- **src/main/resources**: Contains application properties and Swagger documentation.
- **src/test**: Contains unit and integration tests.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17 installed.
- Maven 3.x installed.
- Git installed.

## Getting Started

To get started, follow these steps:

1. Clone the repository:


git clone https://github.com/SharmilaKrishna/FeeManagement

2.Navigate to the project directory:
cd fee-collection-microservice
3.Build the project:

mvn clean install
4.To run the application, execute the following command:

java -jar target/fee-collection-microservice.jar
5.Once the application is running, you can access the Swagger documentation by navigating to:

http://localhost:9090/swagger-ui.html

API Endpoints

Collect Fee
POST /fees: Collect fee for a student.
View Receipts
GET /receipts: Get all receipts.
H2 Database Console
http://localhost:9090/h2-console

Use the following credentials:

JDBC URL: jdbc:h2:mem:feedb
Username: sa
Password: password

