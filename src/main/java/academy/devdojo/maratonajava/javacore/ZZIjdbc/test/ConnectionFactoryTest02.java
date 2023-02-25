package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
//        Producer producerToUpdate = Producer.builder().id(1L).name("nhk").build();
//        ProducerServiceRowSet.updateJdbcRowSet(producerToUpdate);
//        log.info("-------------------------");
//        List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet("");
//        log.info(producers);
        Producer producerToUpdate = Producer.builder().id(1L).name("MADHOUSE").build();
        ProducerServiceRowSet.updateCachedRowSet(producerToUpdate);
    }
}
