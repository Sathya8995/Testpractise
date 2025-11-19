package org.example.claudePracticeProblems.ImmutablePerson;

import java.util.Objects;

public final class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println("=== Immutable Person Class Demo ===\n");

        // Creating Person objects
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);
        Person person3 = new Person("Alice", 25);

        // Test toString()
        System.out.println("--- toString() Test ---");
        System.out.println("person1: " + person1);
        System.out.println("person2: " + person2);
        System.out.println("person3: " + person3);

        // Test equals()
        System.out.println("\n--- equals() Test ---");
        System.out.println("person1.equals(person2): " + person1.equals(person2)); // false
        System.out.println("person1.equals(person3): " + person1.equals(person3)); // true
        System.out.println("person1 == person3: " + (person1 == person3));         // false (different objects)

        // Test hashCode()
        System.out.println("\n--- hashCode() Test ---");
        System.out.println("person1.hashCode(): " + person1.hashCode());
        System.out.println("person2.hashCode(): " + person2.hashCode());
        System.out.println("person3.hashCode(): " + person3.hashCode());
        System.out.println("person1 and person3 have same hashCode: " +
                (person1.hashCode() == person3.hashCode())); // true

        // Using in collections (HashMap example)
        System.out.println("\n--- Using in Collections ---");
        java.util.HashMap<Person, String> personMap = new java.util.HashMap<>();
        personMap.put(person1, "Engineer");
        personMap.put(person2, "Doctor");

        System.out.println("Looking up person1: " + personMap.get(person1));
        System.out.println("Looking up person3 (equals person1): " + personMap.get(person3));
    }
}
