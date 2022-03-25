package academy.devdojo.maratonajava.javacore.Tresourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {
    public static void main(String[] args) {
        /*
        * Essa classe serve pra traduzir o conteúdo de uma página (por exemplo) em diversas linguas
        * A sintaxe de criação do arquivo precisa ser a seguinte: <nome-do-arquivo>_<lingua>_<pais>.properties
        * Ex.: messages_en_US.properties
        * */
        System.out.println(Locale.getDefault());
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));
        System.out.println(bundle.getString("generic.message"));

        // Criando ResourceBundle para pt_BR
        bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));
        System.out.println(bundle.getString("generic.message"));

        /*
         * Fallback (O que o java procura se não encontrar o arquivo de .properties da lingua desejada)
         * Francês Canadá por exemplo (Locale("fr", "CA"))
         * 1 - messages_fr_CA.properties
         * 2 - messages_fr.properties
         * 3 - messages_en_US.properties (aqui é a lingua do sistema que ele vai procurar, nesse ex: en_US)
         * 4 - messages_en.properties
         * 5 - messages.properties
         * 6 - Lança exceção
        */
    }
}
