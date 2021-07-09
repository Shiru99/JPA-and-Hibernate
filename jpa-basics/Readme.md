# JPA basics

## Work-flow

1. Add hibernate-entitymanager & postgresql dependencies
2. persistence.xml - Tell JPA library where database exists 

<br>


## Some Basic Terms & Definitions :

* <b>JPA Entity</b> :

    Entities represent persistent data stored in a relational database automatically using container-managed persistence. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.

* <b>EntityManagerFactory</b> :

    This is a factory class of EntityManager. It creates and manages multiple EntityManager instances.

* <b>EntityManager</b> :

    It is an Interface, it manages the persistence operations on objects. It works like factory for Query instance.