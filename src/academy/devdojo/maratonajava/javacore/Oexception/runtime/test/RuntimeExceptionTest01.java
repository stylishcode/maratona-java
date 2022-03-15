package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest01 {
    public static void main(String[] args) {
        /*
         * Checked (checadas): são excessões filhas da classe Exception, DIRETAMENTE e essas ex
         * cessões se não tratadas, lançam um erro em tempo de compilação, ou seja, nem chega a
         * gerar o .class. Exemplos: Manipulação de arquivos (IOException), Operações SQL (SQL Exception).. etc
         *
         * Unchecked: são excessões filhas de Runtime Exception, ou a própria Runtime Exception. São excessões
         * que quando lançadas pelo programa (obviamente você também pode lançar exceções), quase 100% das vezes
         * o problema é de quem escreveu o código. Exemplo: Formatar número mas o número é um caractere (Number
         * Format Exception), Casting de um objeto que não pode (ClassCastException), acessar objeto que não existe
         * (NullPointerException), acessar posição no array que não existe (ArrayIndexOfBoundsException)
         * */

        Object object = null;
        System.out.println(object.toString());
    }
}
