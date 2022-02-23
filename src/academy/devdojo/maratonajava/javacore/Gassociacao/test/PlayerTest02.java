package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Player;
import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Team;

public class PlayerTest02 {
    public static void main(String[] args) {
        Player player = new Player("Pelé");
        Team team = new Team("Seleção brasileira");

        player.setTeam(team);
        player.print();
    }
}
