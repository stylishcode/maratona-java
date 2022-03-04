package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.repositorio.Repository;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.service.DatabaseRepository;

public class RepositoryTest01 {
    public static void main(String[] args) {
        /*
        * A interface é a mesma e podemos mudar apenas o objeto e cada um tem uma implementação de save();
        * Para quem usa a interface não importa a implementação, porque ela conhece apenas o método save()
        * da interface.
        * Ao invés de usar um tipo mais específico e isso aumenta a flexibilidade e capacidade de manutenção
        * do código, isso é programar orientado a interface
        * */
        Repository repository = new DatabaseRepository();
        repository.save();
    }
}
