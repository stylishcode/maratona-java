package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

import java.sql.SQLException;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) throws SQLException {
        Producer producer = Producer.builder().name("MAPPA").build();
        Producer producerToUpdate = Producer.builder().id(3L).name("MADHOUSE").build();
//        ProducerService.save(producer);
//        ProducerService.delete(5L);
//        ProducerService.update(producerToUpdate);
//        List<Producer> producers = ProducerService.findAll();
//        log.info("Producers found '{}'", producers);
//        List<Producer> producers = ProducerService.findByName("MAPPA");
//        log.info("Producers found '{}'", producers);
//        ProducerService.showProducerMetaData();
        ProducerService.showDriverMetaData();
    }
}

