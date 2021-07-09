package io.summer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    Entity - Entities in JPA are nothing but POJOs (Plain old Java object) representing data that can be persisted to the database. An entity represents a table stored in a database. Every instance of an entity represents a row in the table.

    In most cases, the name of the table in the database and the name of the entity will not be the same. If we do not use the @Table annotation, the name of the entity will be considered the name of the table.
*/

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {

    @Id                 // primary key
    private int id;
    private String name;

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}