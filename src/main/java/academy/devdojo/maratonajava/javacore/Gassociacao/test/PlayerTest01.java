package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Player;

public class PlayerTest01 {
    public static void main(String[] args) {
        Player player = new Player("Pelé");
        Player player2 = new Player("Romário");
        Player player3 = new Player("Cafú");
        Player[] players = new Player[] {player, player2, player3};
        for (Player p : players) {
            p.print();
        }
    }
}
