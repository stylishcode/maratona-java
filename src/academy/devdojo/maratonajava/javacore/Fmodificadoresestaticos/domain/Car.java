package academy.devdojo.maratonajava.javacore.Fmodificadoresestaticos.domain;

public class Car {
    private String name;
    private double maxSpeed;
    //  Faz parte da classe e não das instâncias
    public static double limitSpeed = 250;

    public Car(String name, double maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public void print() {
        System.out.println("------------------");
        System.out.println("nome: " + this.name);
        System.out.println("maxSpeed: " + this.maxSpeed);
        System.out.println("limitSpeed: " + Car.limitSpeed);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
