# JPA & Hibernate

## What is JPA?

The Java Persistence API (JPA) is a specification of Java. It is used to persist data between Java object and relational database. JPA acts as a bridge between object-oriented domain models and relational database systems.

As JPA is just a specification, it doesn't perform any operation by itself. It requires an implementation. So, ORM(Object–relational mapping) tools like Hibernate, TopLink and iBatis implements JPA specifications for data persistence.

### Object–relational mapping 

Object Relational Mapping (ORM) is a functionality which is used to develop and maintain a relationship between an object and relational database by mapping an object state to database column. It is capable to handle various database operations easily such as inserting, updating, deleting etc.

---

## Working of JDBC (Java Database Connectivity)

<img src="Screenshots/JDBC.jpeg" alt="How JDBC works" width="960"/> 

- Read & Write operation using JDBC

<img src="Screenshots/JDBC read.png" alt="Read Operation using JDBC" width="480"/> <img src="Screenshots/JDBC write.png" alt="Write Operation using JDBC" width="480"/>

JPA simplifies these operations with Object–relational mapping  

<img src="Screenshots/without JPA.jpeg" alt="without JPA.jpeg" width="480"/> <img src="Screenshots/with JPA.jpeg" alt="with JPA.jpeg" width="480"/>