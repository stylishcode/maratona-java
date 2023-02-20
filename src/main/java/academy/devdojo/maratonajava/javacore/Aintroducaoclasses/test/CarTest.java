package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.domain.Car;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car();
        car.name = "Volkswagen";
        car.model = "Gol";
        car.year = 2009;

        Car car2 = new Car();
        car2.name = "Ford";
        car2.model = "Ka";
        car2.year = 2013;

//        change reference
        car = car2;

        System.out.println(car.name);
        System.out.println(car.model);
        System.out.println(car.year);
        System.out.println("==========================");
        System.out.println(car2.name);
        System.out.println(car2.model);
        System.out.println(car2.year);
    }
}
