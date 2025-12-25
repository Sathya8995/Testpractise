package org.example.SolidPrinciples;

public interface MultiFunctionDeviceBeforeISP {
    void print();
    void scan();
    void fax();
}

class BasicPrinter implements MultiFunctionDeviceBeforeISP {
    public void print() {
        System.out.println("Printing...");
    }
    public void scan() {
        // Not implemented
    }
    public void fax() {
        // Not implemented
    }
}
