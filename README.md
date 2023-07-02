# Bookstore Application

This is a README file for the Bookstore application, a REST API built using Spring Boot, Java, MySQL as the database, and Hibernate. The application offers various functionalities for managing books, including creating, updating, deleting, and selecting books by ISBN or title. It also provides sorting capabilities based on price or any other parameter in any direction. Additionally, the application supports pagination, providing information about the total number of elements, the current page number, and whether it is the last page.

## Getting Started

To run the Bookstore application locally, follow the instructions below:

### Prerequisites

- Java Development Kit (JDK) version 11 or higher
- MySQL database

### Installation of STS

1. Please follow the following steps: https://www.javatpoint.com/spring-boot-download-and-install-sts-ide


### Running the Application

1. Clone the repository: git clone https://github.com/Ashirvad121/Bookstore
2. Import the project into STS:
Click File > Import...
•
Select Maven > Existing Maven Projects and click Next
•
Browse to the project directory and click Finish
•
3. Update the values in application.properties with your MySQL database connection details.
4. Run the app: Right-click the project in the Package Explorer and click Run As > Spring Boot App. 

The application will start running on `http://localhost:8888`.

## API Endpoints

The Bookstore API provides the following endpoints:

- `POST /registerbook` - Create a new book
- `PUT /books/{id}` - Update a book by its ID
- `DELETE /books/{id}` - Delete a book by its ID
- `GET /bookbyisbn/{isbn}` - Get a book by its ISBN
- `GET /bookbytitle/{name}` - Get books by their title 
- `Get /bookbyauthor/{author}` - Get books by their author
- `GET /allBook?sort={field}&direction={asc|desc}` - Get books sorted by a specified field (e.g., `price`) and direction (ascending or descending)
- `Put /updatebook`- To update book
- `Delete /deletebook/{isbn}`- To delete book useing ISBN

Note: Replace `{id}`, `{isbn}`, `{title}`, `{field}`, `{asc|desc}`, `{page}`, and `{size}` with the actual values.

## Database Schema

The Bookstore application uses a MySQL database to store book information. The database schema consists of a single table named `books` with the following columns:

- `id` (integer) - The unique identifier of the book
- `isbn` (integer) - The ISBN number of the book
- `title` (string) - The title of the book
- `author` (string) - The author of the book
- `price` (integer) - The price of the book
- `description (description)` - Description of the book
- `publishDate (Date)` - When the book was published
- `status (boolean)` - currently the book is available or not

## Technologies Used

The Bookstore application utilizes the following technologies:

- Spring Boot - Java framework for building the REST API
- Java - The programming language used for the application
- MySQL - Relational database management system
- Hibernate - Object-relational mapping tool for database operations

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgements

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Hibernate Documentation](https://hibernate.org/orm/documentation/)
