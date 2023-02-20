package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("Aha uhu o DevDojo é foda");
        Optional<String> o2 = Optional.ofNullable(null);
        Optional<String> o3 = Optional.empty();
        System.out.println(o1); // Optional[Aha uhu o DevDojo é foda]
        System.out.println(o2); // Optional.empty
        System.out.println(o3); // Optional.empty

        Optional<String> nameOptional = Optional.ofNullable(findName("Willian"));
        String emptyOrNot = nameOptional.orElse("EMPTY");
        System.out.println(emptyOrNot);
    }

    private static String findName(String name) {
        List<String> list = List.of("Willian", "DevDojo");
        int i = list.indexOf(name);
        if (i != 1) {
            return list.get(i);
        }
        return null;
    }
}
