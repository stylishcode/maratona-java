package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;

import java.sql.SQLException;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) throws SQLException {
        Producer producer = Producer.builder().name("MAPPA").build();
        Producer producerToUpdate = Producer.builder().id(3L).name("MADHOUSE").build();
//        ProducerService.save(producer);
//        ProducerService.delete(5L);
        ProducerService.update(producerToUpdate);
    }
}
