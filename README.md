# User and Task Management Project (Todo App) with Java and Spring Boot

This is a sample project to create a task management application (Todo App) using Java and Spring Boot, with an embedded H2 database. This application allows users to create, update and view tasks, as well as manage user information.

## Prerequisites

Before getting started with the application, make sure you have the following installed on your system:

- [Java](https://www.java.com/) (version 17 or higher)
- [Maven](https://maven.apache.org/)
- An IDE of your choice (e.g., [Eclipse](https://www.eclipse.org/), [IntelliJ IDEA](https://www.jetbrains.com/idea/), or [Visual Studio Code](https://code.visualstudio.com/))

## Configuration

1. Clone the repository:

git clone https://github.com/gabeps2/rocketseat-todoapp-java.git

2. Navigate to the project directory:


cd todo-app-java-spring


3. Import the project into your IDE as a Maven project.

4. Build the project:

You can use the IDE to build the project or run the following command:

`mvn clean install`

## Running the Application

1. Run the application from your IDE or use the following command to start the embedded Spring Boot server:

`java -jar /target/todolist-1.0.0.jar`

2. The application will be available at `http://localhost:8080`.

## API Endpoints

- `POST /users/`: Create a new user.
- `POST /tasks/`: Create a new task.
- `GET /tasks/`: List task.
- `PUT /tasks/{id}`: Update an existing task.

Make sure to check the API documentation for detailed information on how to use these endpoints.

## H2 Database

The application uses an embedded H2 database to store data. You can access the database's admin console at `http://localhost:8080/h2-console`. The default H2 database settings are as follows:

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `admin`
- Password: `admin`

## Contributing

Feel free to contribute to this project. If you encounter issues or wish to add new features, create an issue or submit a pull request.

---

Enjoy using and exploring the task management application! If you have any questions or need assistance, don't hesitate to reach out.
