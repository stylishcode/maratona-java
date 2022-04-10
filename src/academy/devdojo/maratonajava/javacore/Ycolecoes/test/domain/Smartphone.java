package academy.devdojo.maratonajava.javacore.Ycolecoes.test.domain;

public class Smartphone {
    private final String serialNumber;
    private final String brand;

    public Smartphone(String serialNumber, String brand) {
        this.serialNumber = serialNumber;
        this.brand = brand;
    }

    /*
    * (1) Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null
    * (2) Simétrico: para x e y diferentes de null, se x.equals(y) == true, logo y.equals(x) == true
    * (3) Transitividade: para x,y,z diferentes de null, se x.equals(y) == true e y.equals(x) == true, logo y.equals(z) == true
    * (4) Consistente: x.equals(x) sempre retorna true se x for diferente de null
    * (5) para x diferente de null, x.equals(null) tem que retornar false
    * */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Smartphone smartphone = (Smartphone) obj;
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
    }

    /*
    * O hashCode é uma ferramenta da JVM usada para montar a tabela de hash de modo correto.
    * Tabela Hash [também conhecida como Tabela de Dispersão ou Tabela de Espalhamento] é uma
    * tabela onde as informações são armazenadas conforme um "numero hash" calculado com base
    * nas propriedades da informação. Isso permite que seja muito rápido recuperar uma informação na tabela.
    *
    * Ex: imagine que a tabela hash é um armário cheio de gavetas, todas com um numero na frente.
    * Toda vez que você vai guardar alguma coisa nesse armário, primeiro se calcula um hash dessa
    * informação [o como a gente explica depois] e com esse número nós colocamos na gaveta especifica.
    * Se alguns anos mais tarde precisar dessa informação, apenas calculando o hash nós podemos ir direto
    * na gaveta certa!!!
    *
    * Desvantagem de não ter uma tabela hash: Se você fosse buscar um paciente em especial iria demorar
    * um tempo (O(n) numa busca linear ou O(log N) para buscas binarias) o que pode ser extremamente ruim
    * em uma situação real onde existe um volume de dados gigantescos. Usando uma tabela hash a busca reduz
    * seu tempo de busca (O(1)) para qualquer situação, bastando apenas o calculo do valor hash na entrada
    * e na saída da informação.
    *
    * E se existir colisão de hash (cálculo tem o mesmo resultado de um hash já existente)?: É para isso que
    * serve o equals, caso haja mais de uma informação com o mesmo hash no "bucket", o método equals irá determi
    * nar se os objetos são iguais ou não.
    *
    * Outra coisa importante é: hashCode e equals andam juntos! Se você implementar um DEVE fazer o mesmo com
    * o outro. Não vai dar erro se não o fizer, mas a chance de alguma lógica dar errado por conta disso é
    * muito grande.
    *
    * Outro fato: hashCode não foi escrito em Java, por isso ele possui a palavra native na declaração original
    * */
    // se x.equals(y) == true, y.hashCode() == x.hashCode()
    // y.hashCode() == x.hashCode() não necessariamente o equals de y.equals(x) tem que ser true
    // x.equals(y) == false
    // y.hashCode() != x.hashCode(), x.equals(y) deverá ser false
    @Override
    public int hashCode() {
        return serialNumber == null ? 0 : this.serialNumber.hashCode();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBrand() {
        return brand;
    }
}
