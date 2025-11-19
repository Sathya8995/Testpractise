package org.example;
import java.util.*;
import java.io.*;

class Animal{
    public Animal(){
        System.out.println("Inside Animal constructor");
    }
    public Animal(int n){
        System.out.println("Inside Animal parameterized constructor");
    }
    public void show(){
        System.out.println("Animal show");
    }
    public void show1(){
        System.out.println("Animal show1");
    }
    public void makeSound(){
        System.out.println("Animal makes a sound");
    }
    public void eat(){
        System.out.println("Animal is eating");
    }
}

class Human extends Animal{
    private String name;
    private int age;
    
    public Human(){
        super(1);
        System.out.println("Inside Human constructor");
    }

    public void show(){
        System.out.println("Human--show");
    }

    public void show2(){
        System.out.println("Human--show2");
    }
    // Getter and Setter for name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter and Setter for age
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public void makeSound(){
        System.out.println("Human speaks");
    }
    
    @Override
    public void eat(){
        System.out.println("Human eats with utensils");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Dog barks");
    }
    
    @Override
    public void eat(){
        System.out.println("Dog eats from bowl");
    }
    
    public void fetch(){
        System.out.println("Dog fetches ball");
    }
}

class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Cat meows");
    }
    
    @Override
    public void eat(){
        System.out.println("Cat eats from bowl");
    }
    
    public void climb(){
        System.out.println("Cat climbs tree");
    }
}
public class Demo { 
    
    // WHY USE Animal reference? - Scenario 1: Working with Collections
    public static void demonstrateCollection(){
        System.out.println("\n=== SCENARIO 1: WORKING WITH COLLECTIONS ===");
        System.out.println("Problem: What if you need to store different animal types together?\n");
        
        // Using Animal reference allows storing different subclasses
        List<Animal> animals = new ArrayList<>();
        animals.add(new Human());    // Animal reference = Human object
        animals.add(new Dog());      // Animal reference = Dog object
        animals.add(new Cat());      // Animal reference = Cat object
        
        System.out.println("✅ Can store all types in one collection using Animal reference!");
        System.out.println("\nProcessing all animals:");
        for (Animal animal : animals) {
            animal.makeSound();  // Each calls its own implementation (Polymorphism!)
            animal.eat();
            System.out.println("---");
        }
        
        System.out.println("❌ IMPOSSIBLE with Human reference:");
        System.out.println("   List<Human> list = new ArrayList<>();");
        System.out.println("   list.add(new Dog());  // ❌ COMPILATION ERROR!");
        System.out.println("   list.add(new Cat());  // ❌ COMPILATION ERROR!");
    }
    
    // Scenario 2: Method Parameters
    public static void feedAnimal(Animal animal){
        System.out.println("Feeding animal...");
        animal.eat();
    }
    
    public static void makeAnimalSound(Animal animal){
        animal.makeSound();
    }
    
    // Scenario 3: Flexibility to change implementation
    public static void demonstrateFlexibility(){
        System.out.println("\n=== SCENARIO 2: FLEXIBILITY & MAINTAINABILITY ===");
        System.out.println("You can easily switch implementations:\n");
        
        // Today: Use Human
        Animal creature = new Human();
        creature.makeSound();
        
        // Tomorrow: Change to Dog without changing rest of code
        creature = new Dog();
        creature.makeSound();
        
        // Later: Change to Cat
        creature = new Cat();
        creature.makeSound();
        
        System.out.println("\n✅ Same code works with ANY Animal subclass!");
        System.out.println("❌ With Human reference, you'd need to rewrite code for each type");
    }
    
    // Scenario 4: Following Design Principles
    public static void demonstrateDesignPrinciples(){
        System.out.println("\n=== SCENARIO 3: DESIGN PRINCIPLES (SOLID) ===");
        System.out.println("Using Animal reference follows important design principles:\n");
        
        Animal[] zoo = {new Human(), new Dog(), new Cat()};
        
        System.out.println("1. OPEN/CLOSED PRINCIPLE:");
        System.out.println("   ✅ Open for extension (can add new Animal subclasses)");
        System.out.println("   ✅ Closed for modification (don't need to change existing code)");
        
        System.out.println("\n2. LISKOV SUBSTITUTION PRINCIPLE:");
        System.out.println("   ✅ Any Animal subclass can replace Animal");
        System.out.println("   ✅ Human, Dog, Cat all work where Animal is expected");
        
        System.out.println("\nDemonstration - Process all animals uniformly:");
        for(Animal a : zoo){
            a.makeSound();  // Works for all types!
        }
    }
    
    // Scenario 5: Real-world example
    public static void demonstrateRealWorld(){
        System.out.println("\n=== SCENARIO 4: REAL-WORLD EXAMPLE ===");
        System.out.println("Example: A veterinary clinic system\n");
        
        System.out.println("Vet can treat any Animal:");
        Animal[] patients = {new Human(), new Dog(), new Cat()};
        
        for(Animal patient : patients){
            System.out.print("Patient: ");
            patient.makeSound();
            feedAnimal(patient);  // Can pass to method expecting Animal
            makeAnimalSound(patient);
            System.out.println("---");
        }
        
        System.out.println("✅ Vet doesn't need separate methods for each animal type!");
        System.out.println("❌ With specific references, would need:");
        System.out.println("   treatHuman(Human h), treatDog(Dog d), treatCat(Cat c)...");
    }
    
    public static void main(String[] args) throws InterruptedException{
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║  WHY USE Animal person = new Human()?                       ║");
        System.out.println("║  When Human person = new Human() gives more access?         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
        
        System.out.println("KEY ANSWER: Polymorphism & Code Reusability!");
        System.out.println("Using parent reference enables writing generic, flexible code.\n");
        
        demonstrateCollection();
        demonstrateFlexibility();
        demonstrateDesignPrinciples();
        demonstrateRealWorld();
        
        System.out.println("\n=== SUMMARY: WHEN TO USE WHICH? ===");
        System.out.println("Use Animal reference when:");
        System.out.println("  ✅ Working with collections of different subclasses");
        System.out.println("  ✅ Writing methods that work with any Animal");
        System.out.println("  ✅ Need flexibility to change implementation");
        System.out.println("  ✅ Want to follow SOLID principles");
        System.out.println("  ✅ Building extensible/framework code");
        
        System.out.println("\nUse Human reference when:");
        System.out.println("  ✅ Need Human-specific methods (getName, setName, etc.)");
        System.out.println("  ✅ Working exclusively with Human objects");
        System.out.println("  ✅ Need direct access to Human features");
        
        System.out.println("\n💡 PRO TIP: Use the most generic type that meets your needs!");
        System.out.println("   Start with Animal reference, downcast only when needed.");
    }
}
