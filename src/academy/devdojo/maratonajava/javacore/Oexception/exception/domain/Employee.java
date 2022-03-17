package academy.devdojo.maratonajava.javacore.Oexception.exception.domain;

public class Employee extends Person {
    /*
    * Quando você está sobrescrevendo um método, você não é obrigado declarar as mesmas exceções
    * do método que está sendo sobrescrito (ver a classe Pessoa). Pois a funcionalidade da sobrescrita
    * que você está implementando pode ser completamente diferente e não lance uma exceção, porém você
    * pode:
    * - Declarar apenas uma das exceções
    * - Declarar as duas exceções
    * - Declarar qualquer outra exceção do tipo unchecked (ex.: ArithmeticException)
    * Você não pode:
    * - Declarar exceções de tipo mais genéricas do que foram declarados na classe pai, ou exceções de tipo
    * checked (que não foram declaradas na classe original, porém você pode declarar um tipo mais específico
    * do que foi declarado na classe pai
    * */
    @Override
    public void save() {
        System.out.println("Salvando funcionário");
    }
}
