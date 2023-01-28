package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Boat;

import java.util.ArrayList;
import java.util.List;

public class ProfitableBoatService {
    List<Boat> availableBoats = new ArrayList<>(List.of(
        new Boat("Lancha"),
        new Boat("Iate")
    ));

    public Boat getAvailableBoat() {
        System.out.println("Buscando barco disponível....");
        Boat boat = availableBoats.remove(0);
        System.out.println("Alugando barco: " + boat);
        System.out.println("Barcos disponíveis para alugar:");
        System.out.println(availableBoats);
        return boat;
    }

    public void getRentedBoat(Boat boat) {
        System.out.println("Devolvendo barco: " + boat);
        availableBoats.add(boat);
        System.out.println("Barcos disponíveis para alugar: ");
        System.out.println(availableBoats);
    }
}
