# Books API

This project is an API which allows simple CRUD operations of books in a MYSQL database.

The purpose was to create a simple API, which development process could be shown in a Youtube Video. In other words, I made this project for my channel, where I talk and create tutorials about software development.

## Tech Stack
![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![](https://img.shields.io/badge/Heroku-430098?style=for-the-badge&logo=heroku&logoColor=white)
![](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

- Java 17
- Spring 2.6.7
- MySQL
- Heroku
- IDE IntelliJ
- Maven

## Demo

You can check the API out on the online Swagger UI available at the following link:

[https://crocarneiro-books-api.herokuapp.com/swagger-ui/index.html?configUrl=/api-docs/swagger-config#/book-controller/findAllBooks](https://crocarneiro-books-api.herokuapp.com/swagger-ui/index.html?configUrl=/api-docs/swagger-config#/book-controller/findAllBooks)

Also, there is an [Insomnia](https://insomnia.rest/download) collection available in the `docs` folder. Or in the following link:

[Insomnia collection](https://github.com/crocarneiro/books-api/blob/fa41d53573f211754d8f7b66d3d5c4b62131c5b5/docs/Insomnia_2022-05-17.json)

## Build
To build this application you'll need Maven and a JDK 17 distribution.

Clone or download the repository, go to the root folder and run the following command:

```shell
mvn package
```

## Running the application locally

To run the application locally, first you will need a MySQL instance running. If you already have one, then you can set the application to run with it with the following environment variables:

<table>
    <tr>
        <th>Variable</th>
        <th>Description</th>
        <th>Default Value</th>
    </tr>
    <tr>
        <td>MYSQL_HOST</td>
        <td>The IP or host name of the server where the MySQL instance is running.</td>
        <td>localhost</td>
    </tr>
    <tr>
        <td>MYSQL_PORT</td>
        <td>The port where the MySQL instance is running.</td>
        <td>3306</td>
    </tr>
    <tr>
        <td>MYSQL_USERNAME</td>
        <td>The username used to connect to the MySQL instance.</td>
        <td>root</td>
    </tr>
    <tr>
        <td>MYSQL_PASSWORD</td>
        <td>The password used to connect to the MySQL instance.</td>
        <td>root</td>
    </tr>
</table>

Then just run the application with the command below:

```shell
java -jar target/books-api-0.0.1-SNAPSHOT.jar
```