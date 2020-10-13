# Touristic-Bot
Telegram Bot to give a user relevant info about places to visit in this or that city.

Telegram Bot Name: **@TouristicBot**

Token is not needed for deployment, it's listed in **src/main/resources/application.properties** file and injected right from there.
## Discription
By getting this project running you'll get Telegram Bot that has 2 registred commands
- **/start**
- **/info**

and on your request with a city name gets you info about interesting things to do in that city, when it has any data about the requested city in the DB, of course.

Apart from that there is a functioning REST Web Service to operate the data in the DB with endpoints:
- **POST /cities** *Add a new city to the store (both city name and city info)*
- **GET /cities** *Get all cities in the store*
- **GET /cities/{id}** *Find a city by id*
- **PUT /cities/{id}** *Fully update an excisting city (have to specify city name and city info)*
- **PATCH /cities/{id}** *Partially update an exciting city (have to specify either city name or city info)*
- **DELETE /cities/{id}** *Delete a city by id*
## Getting Started
This instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
### Prerequisites
In order to run the project you need a MySQL Server running on your machine and Maven dependency management tool installed.

To make the bot work with the DB you need to specify some propeties in **src/main/resources/application.properties** file.

Changes:

```
spring.datasource.url=jdbc:mysql://IP-ADDRESS:PORT-YOUR-SERVER-RUNNING-ON/touristic_bot?serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username=YOUR-USERNAME
spring.datasource.password=YOUR-PASSWORD
```
## Deployment
In order to deploy the project from the command line you first need to navigate to the root folder of the project, where pom.xml file lies.

Then you need to build the project typing into the command line

```
mvn install
```

Next, to run the app type

```
mvn spring-boot:run
```
## Built With
- MySQL - RDBMS
- Spring Framework - The web framework used
- Hibernate - ORM
- Maven - Dependecy Management
