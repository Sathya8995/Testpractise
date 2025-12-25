package org.example.SolidPrinciples;

class MySQLDatabase {
    public void connect() {
        System.out.println("Connecting to MySQL database...");
    }

    public void saveUserData(String user) {
        System.out.println("Saving user to MySQL: " + user);
    }
}

// UserService.java (High-level module)
public class UserServiceBeforeDIP {
    private MySQLDatabase mySQLDatabase;

    public UserServiceBeforeDIP() {
        this.mySQLDatabase = new MySQLDatabase();  // Tightly coupled to MySQL

    }

    public void addUser(String user) {
        mySQLDatabase.connect();
        mySQLDatabase.saveUserData(user);
    }

    public static void main(String[] args) {
        UserServiceBeforeDIP userService = new UserServiceBeforeDIP();
        userService.addUser("John Doe");
    }
}
