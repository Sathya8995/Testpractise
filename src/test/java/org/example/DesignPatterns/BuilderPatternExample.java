package org.example.DesignPatterns;

//product class
class Computer{
    //Required parameters
    private String HDD;
    private String RAM;

    //Optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public String getHDD(){
        return HDD;
    };

    public String getRAM(){
        return RAM;
    };

    public boolean isGraphicsCardEnabled(){
        return isGraphicsCardEnabled;
    };

    public boolean isBluetoothEnabled(){
        return isBluetoothEnabled;
    };

    //private constructor to enforce object creation through Builder
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    //Static nested class for Builder
    public static class ComputerBuilder {
        //Required parameters
        private String HDD;
        private String RAM;

        //Optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        //Constructor for Required parameters
        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        //Setter methods for Optional parameters
        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        //Method to build the object
        public Computer build(){return new Computer(this);}
    }
}
public class BuilderPatternExample {
    public static void main(String[] args) {

        //Create a Computer object using the Builder
        Computer computer = new Computer.ComputerBuilder("500 GB", "8 GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        System.out.println("HDD: " + computer.getHDD());
        System.out.println("RAM: " + computer.getRAM());
        System.out.println("Graphics Enabled: " + computer.isGraphicsCardEnabled());
        System.out.println("Bluetooth Enabled: " + computer.isBluetoothEnabled());
    }
}
