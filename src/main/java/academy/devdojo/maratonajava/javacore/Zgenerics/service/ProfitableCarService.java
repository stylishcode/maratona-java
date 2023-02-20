package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ProfitableCarService {
    List<Car> availableCars = new ArrayList<>(List.of(
        new Car("BMW"),
        new Car("Fusca")
    ));

    public Car getAvailableCar() {
        System.out.println("Buscando carro disponível....");
        Car car = availableCars.remove(0);
        System.out.println("Alugando carro: " + car);
        System.out.println("Carros disponíveis para alugar:");
        System.out.println(availableCars);
        return car;
    }

    public void getRentedCar(Car car) {
        System.out.println("Devolvendo carro: " + car);
        availableCars.add(car);
        System.out.println("Carros disponíveis para alugar: ");
        System.out.println(availableCars);
    }
}
