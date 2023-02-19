package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.domain;

public class CurrencyFactory {
    public static Currency newCurrency(Country country) {
        switch (country) {
            case USA:
                return new USD();
            case BRAZIL:
                return new Real();
            default:
                throw new IllegalArgumentException();
        }
    }
}
