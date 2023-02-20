package academy.devdojo.maratonajava.javacore.Fmodificadoresestaticos.domain;

public class Anime {
    private String name;
    private static int[] episodes;
    /*
     * Ordem dos passos na criação de um objeto
     * 0 - Bloco inicialização estático é executado quando a JVM carregar a classe
     * 1 - É alocado espaço em memória pro objeto
     * 2 - Cada atributo de classe é criado inicializado com valores default ou o que for passado
     * 3 - Bloco de inicialização é executado
     * 4 - Construtor é executado
     * --------------------------------------------------------------------------------------------------
     * Bloco de inicialização (estático) que será executado apenas uma vez quando a classe é carregada
     * pela JVM, que ocorre antes mesmo de você ter espaço em memória e isso acontece para todos os atributos
     * e métodos estáticos. É por esse motivo que não se pode acessar atributos de instância dentro de
     * contextos estáticos, pois os objetos ainda nem existem em memória
     */
    static {
        System.out.println("Dentro do bloco de inicialização");
        // Inicializa episodios
        Anime.episodes = new int[100];
        for (int i = 0; i < Anime.episodes.length; i++) {
            Anime.episodes[i] = i+1;
        }
    }
    /*
     * Esse construtor irá impedir a execução do construtor que inicializa os episódios (já que não há sobrecarga de métodos)
     * Fazendo com que os episódios não sejam inicializados
     * Seria necessário replicar o código de inicialização em todos os construtores criados
     * Para evitar isso, existem os blocos de inicialização
     */
    public Anime(String nome) {
        this.name = name;
    }

    /*
     * A inicialização dos objetos ocorrem antes mesmo da execução do construtor
     * Imagine o cenario onde é necessário inicializar episodios com 100 episodios
     */
    public Anime() {
        // Inicializa episodios
        /*for (int i = 0; i < episodes.length; i++) {
           episodes[i] = i+1;
        }*/
        // Exibe episodios
        for (int episodes : Anime.episodes) {
            System.out.print(episodes + " ");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int[] getEpisodes() {
        return Anime.episodes;
    }
}
