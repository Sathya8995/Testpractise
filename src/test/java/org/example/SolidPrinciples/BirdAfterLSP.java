package org.example.SolidPrinciples;

// Bird.java
public abstract class BirdAfterLSP {
    public abstract void eat();
}

// Flyable.java
interface Flyable {
    void fly();
}

interface Swimmable
{
    void swim();
}



// Sparrow.java (Flying Bird)
class Sparrow extends BirdAfterLSP implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow is eating");
    }

}

// Penguin.java (Non-flying Bird)
class Penguin1 extends BirdAfterLSP implements Swimmable {
    @Override
    public void eat() {
        System.out.println("Penguin is eating");
    }

    @Override
    public void swim() {

    }
}

// BirdWatcher.java
class BirdWatcher1 {
    public void watchBirdFly(Flyable bird) {
        bird.fly();
    }

    public void watchBirdEat(BirdAfterLSP bird) {
        bird.eat();
    }

    public static void main(String[] args) {
        BirdWatcher1 watcher = new BirdWatcher1();

        Sparrow sparrow = new Sparrow();
        watcher.watchBirdFly(sparrow); // Works fine
        watcher.watchBirdEat(sparrow); // Works fine

        Penguin1 penguin = new Penguin1();
        watcher.watchBirdEat(penguin); // Works fine
        // watcher.watchBirdFly(penguin); // This won't compile, which is correct
    }
}
