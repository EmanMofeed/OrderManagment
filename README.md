# OrderManagment

This is a Java project that demonstrates a secure API using various packages, entities, exceptions, repositories, and services.

## Packages

1. Config: Contains configurations for securing the API.
2. Entity: Includes the following entities:
   - Customer
   - Order
   - Product
   - ProductOrder
   - Stock
   - UserEntity
3. Exception: Handles custom exceptions for the project.
4. Repository: Provides repositories for each entity.
5. Service: Includes service interfaces for each entity.
6. ServiceImpl: Contains the implementation classes for the service interfaces.

## Prerequisites

Before running the application, ensure that you have the following installed:

- Java Development Kit (JDK)
- Docker (for creating and running Docker images)

## Getting Started

Follow the steps below to build the application and create/run the Docker image.

### Building the Application

1. Clone the repository to your local machine.
2. Open a terminal and navigate to the project directory.
3. Build the application using the following command:
 ./gradlew build
This command will compile the source code, run tests, and generate the executable JAR file.

### Creating and Running the Docker Image

1. Ensure that Docker is installed and running on your machine.
2. In the terminal, navigate to the project directory (where the Dockerfile is located).
3. Build the Docker image by executing the following command: docker build -t your-image-name .
Replace `your-image-name` with the desired name for your Docker image.

4. Once the image is successfully built, you can run a container based on that image using the following command:
docker run -p 8081:8081 your-image-name
This command maps the host machine's port 8081 to the container's port 8081, allowing access to the application.

5. Access the application by opening a web browser and navigating to `http://localhost:8081`.

## Additional Notes

- Ensure that you configure the necessary environment variables and database connections as required by your application.





