package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstantTest01 {
    public static void main(String[] args) {
        /*
        * Instant é parecida com a classe Date, porém Date trabalha com milissegundos a partir 01/01/1970, já
        * a classe Instant trabalha com nanossegundos de 1970 até agora. Ela representa um ponto em
        * uma linha do tempo
        * */
        Instant instant = Instant.now();
        System.out.println(instant);
        // Comparando com a LocalDateTime.now()
        System.out.println(LocalDateTime.now());
        /*
        * T -> Ponto onde termina a data e começa o horário
        * Z -> Zulu time, equivalente ao UTC mas usado por militares
        * Zulu Time é muito utilizado em aplicações que precisam de data específica e que precisa
        * ser guardada no banco de dados. Por exemplo, se um dado é salvo em determinado fuso horário,
        * determinada região e for aberto em outro lugar com outro fuso horário e região, a hora será diferente.
        * Por isso é necessário representar a Timezone quando for salvar para calcular a diferença de horário
        *
        * Um caso interessante é que os nanossegundos são armazenados em um Long muito grande, que não cabem em
        * um só Long, então o pessoal do Java resolveu dividir em duas variáveis, o nano e o epochsecond
        * */
        System.out.println(instant.getEpochSecond()); // Long
        /*
         * Integer(representa o nanossegundo do segundo com máx de 999.999.999)
         * 1 segundo tem quase 1 bilhão de nanossegundos, ou seja, 1 segundo = 999.999.999 + 1
         * */
        System.out.println(instant.getNano());
        // 3 segundos de 1970
        System.out.println(Instant.ofEpochSecond(3)); //1970-01-01T00:00:03Z
        // 3 segundos e 0 nanossegundos de 1970
        System.out.println(Instant.ofEpochSecond(3, 0)); // 1970-01-01T00:00:03Z
        // 4 segundos de 1970 (3 segundos + 1 bilhão de nanossegundos)
        System.out.println(Instant.ofEpochSecond(3, 1_000_000_000)); // 1970-01-01T00:00:04Z
        // 2 segundos de 1970 (3 segundos - 1 bilhão de nanossegundos)
        System.out.println(Instant.ofEpochSecond(3, -1_000_000_000));
    }
}
