package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Car;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.ProfitableCarService;

public class GenericClassesTest01 {
    public static void main(String[] args) {
        ProfitableCarService profitableCarService = new ProfitableCarService();
        Car car = profitableCarService.getAvailableCar();
        System.out.println("Usando o carro por um mês");
        profitableCarService.getRentedCar(car);
    }
}
