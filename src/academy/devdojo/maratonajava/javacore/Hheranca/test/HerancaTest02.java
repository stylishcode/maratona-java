package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.domain.Employee;

public class HerancaTest02 {
    public static void main(String[] args) {
        Employee employee = new Employee("Jiraya");
        /*
        * Sequência de inicialização:
        *
        * 1- Executa todos os componentes estáticos na ordem em que eles aparecem assim que a classe é carregada na JVM
        * 2- Executa todos os componentes de instância na ordem em que eles aparecem na classe, assim que um objeto desta classe é instanciado
        * 3- Executa o construtor.
        *
        * Mais detalhado:
        * 0 - Bloco de inicialização estático da superclasse é executado quando a JVM carregar a classe pai
        * 1 - Bloco de inicialização estático da subclasse é executado quando a JVM carregar a classe filha
        * 2 - Alocado espaço em memória para o objeto da superclasse
        * 3 - Cada atributo de superclasse é criado inicializado com os valores default ou o que for passado
        * 4 - Bloco de inicialização da superclasse é executado na ordem em que aparece
        * 5 - Construtor da superclasse é executado
        * 6 - Alocado espaço em memória pro objeto da subclasse
        * 7 - Cada atributo de subclasse é criado e inicializado com os valores default ou o que for passado
        * 8 - Bloco de inicialização da subclasse é executado na ordem em que aparece
        * 9 - Construtor da subclasse é executado
         */
    }
}
