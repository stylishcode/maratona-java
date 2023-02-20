package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import java.util.List;

public class ProfitableService<T> {
    private final List<T> rentalsAvailable;

    public ProfitableService(List<T> rentalsAvailable) {
        this.rentalsAvailable = rentalsAvailable;
    }

    public T getRentalsAvailable() {
        System.out.println("Buscando objetos disponíveis...");
        T t = rentalsAvailable.remove(0);
        System.out.println("Alugando objeto: " + t);
        System.out.println("Objetos disponíveis para alugar: ");
        System.out.println(rentalsAvailable);
        return t;
    }

    public void getRentedObject(T t) {
        System.out.println("Devolvendo objeto alugado: " + t);
        rentalsAvailable.add(t);
        System.out.println("Objetos disponíveis para alugar: ");
        System.out.println(rentalsAvailable);
    }
}
