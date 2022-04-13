package academy.devdojo.maratonajava.javacore.Ycolecoes.domain;

import java.util.Objects;

public class Manga {
    private final Long id;
    private final String name;
    private final double price;

    public Manga(Long id, String name, double price) {
        Objects.requireNonNull(id, "Id não pode ser null");
        Objects.requireNonNull(name, "Nome não pode ser null");
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Double.compare(manga.price, price) == 0 && id.equals(manga.id) && name.equals(manga.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
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
}
