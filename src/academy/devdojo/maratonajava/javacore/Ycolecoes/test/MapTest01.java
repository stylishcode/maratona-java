package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
        // Map não faz parte das collections. É uma interface que veio para substituir a classe Dictionary
        // que era totalmente abstrata
        Map<String, String> map = new HashMap<>();
        map.put("JAVA_HOME", "/usr/share/local/java/jdk-17.0.1");
        map.put("ASDF_DIR", "$HOME/.local/share/asdf");
        map.put("ZDOTDIR", "$HOME/.config/zsh");
        // map.put("ZDOTDIR", "$HOME/.config/zsh2"); adicionar com a mesma chave substitui o valor anterior
        map.putIfAbsent("ZDOTDIR", "$HOME/.config/zsh2"); // adiciona somente se a chave ainda não existe
        // impressão simples
        System.out.println(map);

        // imprime as chaves
        for (String key: map.keySet()) {
            System.out.println(key);
        }

        // imprime os valores
        for (String value: map.values()) {
            System.out.println(value);
        }

        // imprime os valores a partir da chave
        for (String key: map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        // imprime chaves e valores
        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
