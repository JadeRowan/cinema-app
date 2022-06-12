# Taxi Service
![taxi](images/introducing.jpg)

## Contents
+ [Overview](#Overview) 
+ [Use cases](#Use-cases)
+ [REST end points](#Rest-end-points)
+ [Used Technologies](#Used-Technologies) 
+ [Project structure](#Project-structure)
+ [Application startup](#Application-startup)

<a name="Overview"></a>
## Overview
Cinema-app is a web application where registered user clients can purchase tickets for a movie. Also it gives a lot of toolls for Admin user to perform CRUD operations to Movies, Cinema Halls and Movie Sessions.
<br/>Service include such tools as:
<br/> - Email validation
<br/> - Password hashing with salt (SHA512) 
<a name="Use-cases"></a>
## Use cases
When you enter the application website you enter like a guest and you have access only to these actions:
* Login
* Register as a new user

When you will log in as a user with role <b>"USER"</b>, you could perform these actions:
* See all existing cinema-hall, movies and movie-sessions
* Add a ticket to shopping cart after choosing movie-session
* Create order from previously added tickets
* See order history and purchased tickets of current user account
* Logout 

When you will log in as a user with role <b>"ADMIN"</b>, you could perform these actions:
* See all existing cinema-hall, movies and movie-sessions
* Create, modify and delete cinema-hall, movies and movie-sessions from database
* Get user info by email
* Logout 

<a name="Rest-end-points"></a>
## REST end points: 
```
POST: /login - all
POST: /register - all
GET: /cinema-halls - user/admin
POST: /cinema-halls - admin
GET: /movies - user/admin
POST: /movies - admin
GET: /movie-sessions/available - user/admin
POST: /movie-sessions - admin
PUT: /movie-sessions/{id} - admin
DELETE: /movie-sessions/{id} - admin
GET: /orders - user
POST: /orders/complete - user
PUT: /shopping-carts/movie-sessions - user
GET: /shopping-carts/by-user - user
GET: /users/by-email - admin
```

<a name="Used-Technologies"></a>
## Used Technologies
* Java version 11
* Spring web, security, mvc
* Hibernate
* Apache Tomcat (v9.0.50)
* MySQL
* Maven
* Maven Checkstyle Plugin

<a name="Project-structure"></a>
## Project structure
Project implemented refers to an n-tier structure and has three layers:

1. Data access layer (DAO)
1. Application layer (service)
1. Presentation layer (controllers)

Table relations 

![Table relations](images/entitySchema.png)

<a name="Application-startup"></a>
## Application startup

1. Install MySQL
1. Load dependencies which described in `pom.xml`
1. Change `username`, `password` and `URL` values in the `resources/db.properties` file to open a connection with your database
1. Configure Apache Tomcat (v9.0.50) for your IDE
1. Launch application and start using it at `http://localhost:%your_port%`