package academy.devdojo.maratonajava.javacore.ZZKjunit.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MangaTest {
    private Manga manga1;
    private Manga manga2;

    @BeforeEach
    void setUp() {
        manga1 = new Manga("Kimetsu no Yaiba", 200);
        manga2 = new Manga("Kimetsu no Yaiba", 200);
    }

    @Test
    void acessors_ReturnData_WhenInitialized() {
        Assertions.assertEquals("Kimetsu no Yaiba", manga1.name());
        Assertions.assertEquals(200, manga1.chapters());
    }

    @Test
    void equals_ReturnTrue_WhenObjectsAreTheSame() {
       Assertions.assertEquals(manga1, manga2);
    }

    @Test
    void hashCode_ReturnTrue_WhenObjectsAreTheSame() {
        Assertions.assertEquals(manga1.hashCode(), manga2.hashCode());
    }

    @Test
    void contructor_ThrowNullPointerException_WhenNameIsNull() {
       Assertions.assertThrows(NullPointerException.class,() -> new Manga(null, 12));
    }

    @Test
    void isRecord_ReturnTrue_WhenCalledFromManga() {
        Assertions.assertTrue(Manga.class.isRecord());
    }
}