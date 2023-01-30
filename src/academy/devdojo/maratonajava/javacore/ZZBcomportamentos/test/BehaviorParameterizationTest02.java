package academy.devdojo.maratonajava.javacore.ZZBcomportamentos.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.domain.Car;
import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.domain.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class BehaviorParameterizationTest02 {
    private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019), new Car("black", 1978), new Car("green", 2013), new Car("red", 2006));

    public static void main(String[] args) {
        List<Car> greenCars = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("green");
            }
        });
        System.out.println(greenCars);

        List<Car> redCars = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("red");
            }
        });
        System.out.println(redCars);

        List<Car> carsBeforeYear = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getYear() < 2015;
            }
        });
        System.out.println(carsBeforeYear);
    }

    private static List<Car> filter(List<Car> cars, CarPredicate predicate) {
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars) {
            if (predicate.test(car)) {
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }

}
