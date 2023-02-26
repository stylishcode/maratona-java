package academy.devdojo.maratonajava.javacore.ZZJcrud.domain;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Producer {
    Long id;
    String name;
}