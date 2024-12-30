<h1 align=center>Voll Med API</h1>

## About

Voll Med is an API developed for integration with a frontend application, where it is possible to consult a list of doctors and patients, register them in the system and schedule an appointment.

This project is the result of Alura's "Java and Spring Boot" training.

Project status: in progress.

## Table of Contents
  - Layout Mobile
  - Technologies
  - Installation
  - Usage
  - API EndPoints
  - License

## Layout Mobile
The frontend model for which this API was developed can be found [here](https://www.figma.com/proto/N4CgpJqsg7gjbKuDmra3EV/Voll.med?node-id=46-992)

## Technologies
  - Java 21
  - Spring Framework
  - JPA / Hibernate
  - PostgreSQL
  - Docker

## Installation
1. Clone the repository
```
   git clone https://github.com/your-username/Voll-API.git
```

2. Install [Docker](https://www.docker.com/)
- There are different ways to install docker, see for your operating system.

## Usage

Build Voll Med project with docker-compose.yml
```
docker compose up
```
Make sure that the vollMed_api and vollMed_api_test databases are created in the postgres container
```
docker exec -it <CONTAINER_ID> bash
psql -U postgres
\l
```
To login and get the access token, make sure to create a user in the users table by entering the login and password in Bcrypt format.

Start aplication with maven:
```
mvn spring-boot:run
```
The API will be accessible at http://localhost:8080

An easy way to obtain a working development environment is to use the development container provided (see folder .devcontainer).

IDEs usually have integration or extensions that allow you to work with dev containers. Consult this information in your IDE.

## API EndPoints

```
GET /medicos:
GET /pacientes:
GET /medicos/{id}:
GET /pacientes/{id):
POST /medicos:
POST /pacientes:
PUT /medicos:
PUT /pacientes:
DELETE /medicos/{id}:
DELETE /pacientes/{id}:
POST /consultas:
POST /login:

```

## License

his project is licensed under the MIT License - see the [LICENSE](https://github.com/EricArnou/Voll-API/blob/main/LICENSE) file for details.
