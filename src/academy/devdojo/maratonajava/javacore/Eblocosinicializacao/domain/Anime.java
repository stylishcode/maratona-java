package academy.devdojo.maratonajava.javacore.Eblocosinicializacao.domain;

public class Anime {
    private String name;
    private int[] episodes;
    /*
    * Ordem dos passos na criação de um objeto
    * 1 - É alocado espaço em memória pro objeto
    * 2 - Cada atributo de classe é criado inicializado com valores default ou o que for passado
    * 3 - Bloco de inicialização é executado
    * 4 - Construtor é executado
    * --------------------------------------------------------------------------------------------------
    * Bloco de inicialização (de instância) que será executado todas as vezes que esse objeto for criado
    */
    {
        // Inicializa episodios
        episodes = new int[100];
        for (int i = 0; i < episodes.length; i++) {
            episodes[i] = i+1;
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
        for (int episodes : episodes) {
            System.out.print(episodes + " ");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int[] getEpisodes() {
        return episodes;
    }
}
