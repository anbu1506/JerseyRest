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
   cd jerseyRest
   ```

2. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

3. **Deploy to Tomcat:**
   - Copy the generated WAR file (`target/jerseyRest.war`) to the `webapps` directory of your Tomcat installation.

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
   - Open your browser or use a tool like `curl` or Postman to access the endpoints at `http://localhost:8080/jerseyRest/webapi`.


## REST Endpoints

- `GET /jerseyRest/webapi/books/isbn001` - Returns info about a book.

## Filters

## Interceptors

## Contributing

