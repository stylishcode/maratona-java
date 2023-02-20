package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Boat;
import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Car;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.ProfitableService;

import java.util.ArrayList;
import java.util.List;

public class GenericClassesTest03 {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(List.of(new Car("BMW"), new Car("Fusca")));
        ProfitableService<Car> carProfitableService = new ProfitableService<>(cars);
        Car car = carProfitableService.getRentalsAvailable();
        System.out.println("Usando o carro por um mês");
        carProfitableService.getRentedObject(car);

        System.out.println("----------------------------------------------");

        List<Boat> boats = new ArrayList<>(List.of(new Boat("Lancha") , new Boat("Iate")));
        ProfitableService<Boat> boatProfitableService = new ProfitableService<>(boats);
        Boat boat = boatProfitableService.getRentalsAvailable();
        System.out.println("USando o barco por um mês");
        boatProfitableService.getRentedObject(boat);

    }
}
