package academy.devdojo.maratonajava.javacore.Ycolecoes.domain;

import java.util.Objects;

// Comparable é necessário para o sort de objetos
public class Manga implements Comparable<Manga> {
    private final Long id;
    private final String name;
    private final double price;
    private int amount;

    public Manga(Long id, String name, double price) {
        Objects.requireNonNull(id, "Id não pode ser null");
        Objects.requireNonNull(name, "Nome não pode ser null");
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Manga(Long id, String name, double price, int amount) {
        this(id, name, price);
        this.amount = amount;
    }

    // Equals e hashscode necessários para o exemplo de sort de objetos

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Manga manga = (Manga) obj;
        return Objects.equals(id, manga.id) && Objects.equals(name, manga.name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    // Método que Comparable obriga a implementar
    @Override
    public int compareTo(Manga otherManga) {
        // regras para comparação
        // 1) qualquer valor negativo se this < otherManga
        // 2) se this == otherManga, retorna 0
        // 3) qualquer valor positivo se this > otherManga
        // obs: Se o tipo de organização for por tipo Wrapper, pode usar o compareTo do
        // próprio Wrapper
        // caso seja primitivo, ai precisa do código abaixo
        // if(this.id < otherManga.getId()) {
        // return -1;
        // }
        // if (this.id.equals(otherManga.getId())) {
        // return 0;
        // }
        // return 1;
        // Ou desse código que usar o Wrapper Double pegando o primitivo
        // Double.valueOf(price).compareTo(otherManga.getPrice());
        // Ou desse código
        // Double.compare(price, otherManga.getPrice());
        // Caso seja Wrapper, esse código
        // return this.getId().compareTo(otherManga.getId()); // compareTo que todos os
        // tipos Wrappers tem
        // Por nome (String, que também implementa Comparable)
        return this.name.compareTo(otherManga.getName());
    }
}
