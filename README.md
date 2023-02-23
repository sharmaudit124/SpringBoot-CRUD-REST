# Basic Spring Boot CRUD Application

This repository contains a Basic Spring Boot CRUD Application where Entity is Person having attributes like personId, firstName, lastName, age, emailId, and address.

## Entity

- **personId:** This is the unique identifier of a person.
- **firstName:** This is the first name of a person.
- **lastName:** This is the last name of a person.
- **age:** This is the age of a person.
- **emailId:** This is the email address of a person.
- **address:** This is the address of a person.

## Controller Functions

- **getPersonDetailsByEmailId:** This function takes an emailId as input and returns the details of the person associated with that emailId.
- **getPersonDetailById:** This function takes a personId as input and returns the details of the person associated with that personId.
- **getAllPersonDetails:** This function returns the details of all the persons in the database.
- **addPersonDetail:** This function adds a new person to the database.
- **updatePersonDetails:** This function updates the details of an existing person in the database.
- **deletePerson:** This function deletes a person from the database.

## Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## How to Use

1. Clone the repository.
2. Open the project in your preferred IDE.
3. Set up a MySQL database and update the application.properties file with the necessary details.
4. Run the application and test the API endpoints using Postman or any other API testing tool.

## Credits

This project was created by **Udit Sharma**. Feel free to use and modify the code as per your requirements. If you have any questions or suggestions, please feel free to contact me.
