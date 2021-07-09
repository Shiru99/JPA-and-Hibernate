package io.summer;


/**
 *  JPA basics
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee employee = new Employee(1,"John Doe");

        System.out.println(employee.getName());
    }
}
