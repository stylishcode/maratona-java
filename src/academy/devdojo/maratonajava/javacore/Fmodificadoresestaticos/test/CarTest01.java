package academy.devdojo.maratonajava.javacore.Fmodificadoresestaticos.test;

import academy.devdojo.maratonajava.javacore.Fmodificadoresestaticos.domain.Car;

public class CarTest01 {
    public static void main(String[] args) {
        Car car = new Car("BWM", 280);
        Car car2 = new Car("Mercedes", 275);
        Car car3 = new Car("Audi", 290);

        Car.setLimitSpeed(180);

        car.print();
        car2.print();
        car3.print();
    }
}
