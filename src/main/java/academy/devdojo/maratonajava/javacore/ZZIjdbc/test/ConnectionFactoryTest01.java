package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepository;

import java.sql.SQLException;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) throws SQLException {
        Producer producer = new Producer("NHK");
        ProducerRepository.save(producer);
    }
}
