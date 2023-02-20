package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest01 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        /*
         * Sintaxe:
         * (parâmetro) -> <expressão>
         * (Car car) -> car.getColor().equals("green");
         * car -> car.getColor().equals("green");
         * car -> {
         *  return car.getColor().equals("green"));
         * }
         * (car, boat) -> // ...
         * */

        List<Integer> evenList = filter(nums, num -> num % 2 == 0);
        System.out.println(evenList);

        List<Car> cars = List.of(new Car("green", 1998), new Car("red", 1978), new Car("green", 2015));
        List<Car> greenCarsList = filter(cars, car -> car.getColor().equals("green"));
        System.out.println(greenCarsList);
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
