package academy.devdojo.maratonajava.javacore.ZZClambdas.domain;

import academy.devdojo.maratonajava.javacore.ZZBcomportamentos.domain.Car;

@FunctionalInterface
public interface CarPredicate {
    // interfaces funcionais só permitem um método abstrato. Pode haver outros métodos, porém devem ser default
    boolean test(Car car);
}
