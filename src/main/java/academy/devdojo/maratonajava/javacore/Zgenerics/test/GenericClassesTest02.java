package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Boat;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.ProfitableBoatService;

public class GenericClassesTest02 {
    public static void main(String[] args) {
        ProfitableBoatService profitableBoatService = new ProfitableBoatService();
        Boat boat = profitableBoatService.getAvailableBoat();
        System.out.println("Usando o barco por um mês");
        profitableBoatService.getRentedBoat(boat);
    }
}
