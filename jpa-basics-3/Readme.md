# JPA basics

<center><img src="Screenshots/entity-life-cycle.png" alt="Entity Life Cycle" width="600"/> </center>


## Some Basic Terms & Definitions : [@](https://dzone.com/articles/resource-local-vs-jta-transaction-types-and-payara)

* <b>What Is a Persistent-Unit?</b>

    Think to the persistent-unit as a box holding all the needed information for creating an EntityManagerFactory instance. Among this information, we have details about the data source (JDBC URL, user, password, SQL dialect, etc), the list of entities that will be managed, and other specific properties.

    <i>Persistence unit as RESOURCE_LOCAL or JTA?</i> 

* <b>What Is EntityManagerFactory?</b>

    An EntityManagerFactory is a factory capable to create on-demand EntityManager instances.

    Basically, we provide the needed information via the persistent-unit, and JPA can use this information to create an EntityManagerFactory that exposes a method named, createEntityManager(), which returns a new application-managed EntityManager instance at each invocation.


* <b>What Is EntityManager? & persistence-context </b>

    <center><img src="Screenshots/transaction.png" alt="transaction" width="600"/></center>

    https://dzone.com/articles/resource-local-vs-jta-transaction-types-and-payara


* <b>Persistence unit as RESOURCE_LOCAL or JTA?</b>

    * <b> JTA </b> if :

        * The application server is going to  manage the transactions? 
        * The application server is going to manage the persistence-context lifespan 
        * If Transactions span multiple persistent-units (databases) or systems (e.g., JMS, JCA, etc) 
    
    * else <b> RESOURCE_LOCAL </b>

---
