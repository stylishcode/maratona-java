package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Player;
import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Team;

public class PlayerTest03 {
    public static void main(String[] args) {
        Player player = new Player("Pelé");
        Player player2 = new Player("Cafú");
        Team team = new Team("Selecão brasileira");
        Player[] players = new Player[] {player, player2};

        player.setTeam(team);
        player2.setTeam(team);
        team.setPlayers(players);

        System.out.println("--- Jogador ---");
        player.print();
        player2.print();

        System.out.println("--- Time ---");
        team.print();
    }
}
