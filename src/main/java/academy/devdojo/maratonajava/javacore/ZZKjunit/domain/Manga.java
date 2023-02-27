package academy.devdojo.maratonajava.javacore.ZZKjunit.domain;

import java.util.Objects;

public record Manga(String name, int chapters) {
    // not allowed: anything relationed to instance
    // allowed: static things
    // constructor is allowed, but the recommended is to use compact constructor instead of the default

    public Manga {
        Objects.requireNonNull(name);
    }
}
