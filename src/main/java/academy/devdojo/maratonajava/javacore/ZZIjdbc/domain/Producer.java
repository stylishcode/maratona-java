package academy.devdojo.maratonajava.javacore.ZZIjdbc.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Producer {
    Long id;
    String name;
}
