package academy.devdojo.maratonajava.javacore.ZZBcomportamentos.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BehaviorParameterizationTest03 {
    private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019), new Car("black", 1978), new Car("green", 2013), new Car("red", 2006));

    public static void main(String[] args) {
        // usando a nova sintaxe lambda (java 8), mas ainda é uma classe anônima, só que escrita em forma curta
        // carros verdes
        System.out.println(filter(cars, car -> car.getColor().equals("green")));
        // carros vermelhos
        System.out.println(filter(cars, car -> car.getColor().equals("red")));
        // carros lançados antes de 2015
        System.out.println(filter(cars, car -> car.getYear() < 2015));
        // números pares de uma lista
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(filter(nums, num -> num % 2 == 0));
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                filteredList.add(e);
            }
        }
        return filteredList;
    }
}
