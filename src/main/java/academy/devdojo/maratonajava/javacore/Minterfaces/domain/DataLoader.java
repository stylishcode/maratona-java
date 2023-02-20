package academy.devdojo.maratonajava.javacore.Minterfaces.domain;

public interface DataLoader {
   /**
    * Modificador de acesso do mais restritivo para o mais liberal:
    * private -> default (modificador de pacote, quando não colocamos modificador) -> protected -> public
    * Se o método criado for público, qualquer outro modificador será mais restritivo, ou seja, a sobrescrita te força
    * a ter um método público, mas se por acaso em uma classe abstrata você colocar default ou protected, ela pode ser
    * sobrescrita como protected ou public, nunca private
    *
    * Por padrão os métodos das interfaces são públicos e abstratos, então é redundante declarar isso
    * Por padrão os atributos das interfaces são públicos, estáticos e constantes
    */
   public static final int MAX_DATA_SIZE = 10;
   public abstract void load();
   /*
   * A partir de versão 8 do Java:
   * Por padrão os métodos das interfaces são abstratos, mas é possível ter métodos concretos dentro de interfaces
   * Que podem ser sobrescritos pelas classes que implementam a interface
   */
   default void checkPermissions() {
      System.out.println("Fazendo checagem de permissões");
   }
   /*
   * A partir do java 8 é possível adicionar métodos estáticos a interface. Métodos estáticos nunca poderão ser
   * sobrescritos, porque pertencem a classe, ou no caso aqui, a interface
   * */
   public static void retrieveMaxDataSize() {
      System.out.println("Dentro do retrieveMaxDataSize na interface");
   }
}
