package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.domain.Calculator;

public class CalculatorTest04 {
    public static void main(String[] args) {
        // Argumentos do tipo primitivo passam uma cópia para as funções
        // A variável original não é alterada
        Calculator calculator = new Calculator();
        int a = 1;
        int b = 2;
        calculator.change(a, b);
        System.out.println("Dentro de CalculatorTest04");
        System.out.println("Num: " + a);
        System.out.println("Num2: " + b);
    }
}
