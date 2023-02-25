package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        List<Producer> producerList = List.of(
                Producer.builder().name("Toei Animation").build(),
                Producer.builder().name("White fox").build(),
                Producer.builder().name("Studio Ghibli").build()
        );
        // O método executará sem erros, porém nada será salvo no banco. Pois tiramos essa autoridade do mesmo
        // com o setAutoCommit(false)
        // Para salvar, agora NÓS, dizemos no método saveTransaction com o método commit()
        ProducerService.saveTransaction(producerList);
    }
}
