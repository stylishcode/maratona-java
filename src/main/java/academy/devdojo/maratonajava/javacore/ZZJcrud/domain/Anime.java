package academy.devdojo.maratonajava.javacore.ZZJcrud.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Anime {
    Long id;
    String name;
    Producer producer;
}
