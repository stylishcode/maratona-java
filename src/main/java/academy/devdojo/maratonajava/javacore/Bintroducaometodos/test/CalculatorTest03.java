package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.domain.Calculator;

public class CalculatorTest03 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double result = calculator.divide(20, 2);
        System.out.println(result);
        System.out.println(calculator.divideV2(20, 0));
        System.out.println("------------");
        calculator.divideV3(86, 0);
    }
}
