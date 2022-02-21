package academy.devdojo.maratonajava.javacore.Bintroducaometodos.domain;

public class Calculator {
    public void sum() {
        System.out.println(10 + 10);
    }

    public void subtract() {
        System.out.println(21 - 2);
    }

    public void multiply(int num, int num2) {
        System.out.println(num * num2);
    }

    public double divide(double num, double num2) {
        return num / num2;
    }

    public double divideV2(double num, double num2) {
        if (num2 != 0) {
            return num / num2;
        }
        return 0;
    }

    public void divideV3(double num, double num2) {
        if (num2 == 0) {
            System.out.println("Não existe divisão por zero");
            return;
        }
        System.out.println(num / num2);
    }

    public void change(int numero, int numero2) {
        numero = 99;
        numero2 = 33;
        System.out.println("Dentro do altera dois números");
        System.out.println("Num: " + numero);
        System.out.println("Num2: " + numero2);
    }
}
