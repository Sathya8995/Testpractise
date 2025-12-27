package org.example.DesignPatterns;

//Product interface
interface Logger{
    void log(String message);
}

// Concrete product classes
class ConsoleLogger implements Logger{

    @Override
    public void log(String message) {
        System.out.println("Console Logger: " + message);
    }
}

class FileLogger implements Logger{

    @Override
    public void log(String message) {
        System.out.println("File Logger: " + message);
    }
}

class DataBaseLogger implements Logger{

    @Override
    public void log(String message) {
        System.out.println("Database Logger: " + message);
    }
}

//Factory class
class LoggerFactory{
    public static Logger getLogger(String type){

        return switch (type){
            case "console" -> new ConsoleLogger();
            case "file" -> new FileLogger();
            case "database" -> new DataBaseLogger();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}
public class FactoryPatternExample {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("console");
        logger.log("This is a console message");

        logger = LoggerFactory.getLogger("file");
        logger.log("This is a file message");

        logger = LoggerFactory.getLogger("database");
        logger.log("This is a database message");




    }
}
