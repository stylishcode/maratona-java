package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest01 {
    public static void main(String[] args) {

        /*
        * Sempre que declaramos uma variável ou criamos um objeto, ela é armazenada na memória.
        * Em um nível alto, Java divide a memória em dois blocos: pilha e heap. Ambas as memórias
        * armazenam tipos específicos de dados e possuem padrões diferentes para seu armazenamento e acesso.
        *
        * O String constant pool é uma área de memória especial. Quando declaramos uma literal String,
        * a JVM cria o objeto no pool e armazena sua referência na pilha. Antes de criar cada objeto String
        * na memória, a JVM executa algumas etapas para diminuir a sobrecarga de memória.

        * O String constant pool usa um Hashmap em sua implementação. Cada bucket do Hashmap contém
        * uma lista de Strings com o mesmo código hash. Em versões anteriores do Java, a área de armazenamento
        * para o pool tinha um tamanho fixo e muitas vezes poderia levar ao erro "Não foi possível reservar
        * espaço suficiente para heap de objeto".
        *
        * Quando o sistema carrega as classes, as literals String de todas as classes vão para o pool de nível
        * de aplicativo. Isso se deve ao fato de que literals String iguais de classes diferentes precisam
        * ser o mesmo Object. Nessas situações, os dados do pool devem estar disponíveis para cada classe
        * sem qualquer dependência.
        *
        * Strings em Java são objetos que são suportados internamente por uma matriz char. Como os arrays
        * são imutáveis (não podem crescer), Strings também são imutáveis. Sempre que uma alteração em
        * uma String é feita, uma String totalmente nova é criada.
        *
        * Sempre que um Objeto String é criado como um literal, o objeto será criado no string constant pool.
        * Isso permite que a JVM otimize a inicialização do literal String.
        *
        * A string também pode ser declarada usando o operador new, ou seja, alocado dinamicamente.
        * No caso de String serem alocados dinamicamente, eles são atribuídos a um novo local de memória
        * no heap. Esta string não será adicionada ao string constant pool.
        *
        * Se você quiser armazenar essa string no pool constante, precisará "interná-la"
        * Por exemplo:
        *
        * String internadoString = str.intern();
        * // isso adicionará a string ao pool de constantes de string.
        *
        * It is preferred to use String literals as it allows JVM to optimize memory allocation
        * */

        String name = "Willian";
        String name2 = "Willian";
        /*
         * Cria uma nova String com o valor " Suane" e não concatena com "Willian"
         * E ainda cria outra nova String com o valor "Willian Suane" que foi a concatenação
         * Porém tanto " Suane" quanto "Willian Suane" não possuem variáveis de referência para
         * que sejam acessadas e o "Willian" original se manteve, graças a imutabilidade
         * */
        name.concat(" Suane");
        /*
        * Claro que é possível reatribuir a variável name o valor de name.concat
        * */
        name = name.concat(" Suane");

        // Comparando se as variáveis de referência estão apontando para o mesmo objeto
        // String.equals compara o valor, == compara a referência do objeto
        System.out.println(name == name2);
        // nome3 faz referência para um objeto que encapsula "Willian", que está dentro do pool de strings
        String name3 = new String("Willian"); //false
        System.out.println(name2 == name3);
        // Precisariamos comparar usando a função interna pra comparar com o que está dentro da pool e não o objeto encapsulado
        System.out.println(name2 == name3.intern()); // true
    }
}
