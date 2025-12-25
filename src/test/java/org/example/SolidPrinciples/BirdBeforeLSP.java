package org.example.SolidPrinciples;

// Bird.java
public class BirdBeforeLSP {
    public void fly() {

        System.out.println("Bird is flying");
    }
}

// Penguin.java
class Penguin extends BirdBeforeLSP {
    @Override
    public void fly() {

        throw new UnsupportedOperationException("Penguins can't fly");
    }
}


// BirdWatcher.java
class BirdWatcher {
    public void watchBirdFly(BirdBeforeLSP bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        BirdWatcher watcher = new BirdWatcher();

        BirdBeforeLSP sparrow = new BirdBeforeLSP();
        watcher.watchBirdFly(sparrow); // Works fine

        BirdBeforeLSP penguin = new Penguin();
        watcher.watchBirdFly(penguin); // Throws an exception
    }
}
