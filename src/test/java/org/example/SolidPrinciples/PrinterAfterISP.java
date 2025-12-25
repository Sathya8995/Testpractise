package org.example.SolidPrinciples;

public interface PrinterAfterISP {
    void print();
}

// Scanner.java
interface Scanner {
    void scan();
}

interface ColoredPrint
{
    void coloredPrint();
}

// BasicPrinter.java
class BasicPrinter1 implements PrinterAfterISP {
    public void print() {
        System.out.println("Printing...");
    }
}

// MultiFunctionPrinter.java
class MultiFunctionPrinter implements PrinterAfterISP, Scanner, ColoredPrint {
    public void print() {
        System.out.println("Printing...");
    }

    public void scan() {
        System.out.println("Scanning...");
    }

    @Override
    public void coloredPrint() {
        System.out.println("Colored Printing...");
    }
}

