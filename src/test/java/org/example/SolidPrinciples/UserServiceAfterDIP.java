package org.example.SolidPrinciples;

interface Database {
    void connect();
    void saveUserData(String user);
}

// MySQLDatabase.java (Low-level module, implementing the abstraction)
class MySQLDatabase1 implements Database {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database...");
    }

    @Override
    public void saveUserData(String user) {
        System.out.println("Saving user to MySQL: " + user);
    }
}

// PostgreSQLDatabase.java (Another low-level module, implementing the abstraction)
class PostgreSQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connecting to PostgreSQL database...");
    }

    @Override
    public void saveUserData(String user) {
        System.out.println("Saving user to PostgreSQL: " + user);
    }
}

class Couchbase implements Database{
    @Override
    public void connect() {
        System.out.println("Connecting to Couchbase database...");
    }

    @Override
    public void saveUserData(String user) {
        System.out.println("Saving user to Couchbase: " + user);
    }
}

// UserService.java (High-level module)
public class UserServiceAfterDIP {
    private Database database;  // Depends on the abstraction

    public UserServiceAfterDIP(Database database) {
        this.database = database;  // Dependency Injection
    }

    public void addUser(String user) {
        database.connect();
        database.saveUserData(user);
    }

    public static void main(String[] args) {
        // Using MySQLDatabase
        Database mySQL = new MySQLDatabase1();
        UserServiceAfterDIP userService1 = new UserServiceAfterDIP(mySQL);
        userService1.addUser("John Doe");

        // Switching to PostgreSQLDatabase without modifying UserService
        Database postgreSQL = new PostgreSQLDatabase();
        UserServiceAfterDIP userService2 = new UserServiceAfterDIP(postgreSQL);
        userService2.addUser("Jane Smith");
    }
}

