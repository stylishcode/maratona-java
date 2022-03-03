package academy.devdojo.maratonajava.javacore.Minterfaces.domain;

public interface DataLoader {
   void load();
   /*
   * A partir de versão 8 do Java:
   * Por padrão os métodos das interfaces são abstratos, mas é possível ter métodos concretos dentro de interfaces
   * Que podem ser sobrescritos pelas classes que implementam a interface
   */
   default void checkPermissions() {
      System.out.println("Fazendo checagem de permissões");
   }
}
