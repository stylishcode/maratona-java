package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.domain;

public interface Currency {
    String getSymbol();
}

class Real implements Currency {
    @Override
    public String getSymbol() {
        return "R$";
    }

}

class USD implements Currency {
    @Override
    public String getSymbol() {
        return "$";
    }
}
