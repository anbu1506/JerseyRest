# Simple Jersey REST Application

This is a simple RESTful application built using Jersey. It demonstrates basic REST principles and includes examples of advanced concepts like filters and interceptors.

## Prerequisites

- Java 8 or higher
- Maven
- Apache Tomcat

## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/anbu1506/JerseyRest.git
   cd jersey-rest-app
   ```

2. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

3. **Deploy to Tomcat:**
   - Copy the generated WAR file (`target/jersey-rest-app.war`) to the `webapps` directory of your Tomcat installation.

## Running the Application

1. **Start Tomcat:**
   - Navigate to the `bin` directory of your Tomcat installation and start the server:
     ```bash
     ./catalina.sh start
     ```
   - For Windows:
     ```bash
     startup.bat
     ```

2. **Access the endpoints:**
   - Open your browser or use a tool like `curl` or Postman to access the endpoints at `http://localhost:8080/jersey-rest-app/api`.


## REST Endpoints

- `GET /jersey/webapi/books/isbn001` - Returns info about a book.

## Filters

Filters allow you to process requests and responses before and after resource methods are called. An example filter is provided in the `filters` package.

## Interceptors

Interceptors allow you to implement cross-cutting concerns like logging and security. An example interceptor is provided in the `interceptors` package.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a Pull Request.
