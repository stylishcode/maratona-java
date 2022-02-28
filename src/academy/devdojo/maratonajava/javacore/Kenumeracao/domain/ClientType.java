package academy.devdojo.maratonajava.javacore.Kenumeracao.domain;

public enum ClientType {
    /*
    * Quando você está criando uma enumeração, basicamente você está chamando um construtor, privado
    * Se você ir no arquivo decompilado de uma enum, irá ver ele
    * Se quisermos criar um valor padrão para as enums, como 1 para PESSOA_FISICA
    * e 2 para PESSOA_JURIDICA, precisamos criar um construtor que receba o valor que queremos atribuir a enum
    *
    * O que podemos fazer com esses valores?: Guardar em uma variável, que deve vir depois das enumerações
    *
    * Quem vai inicializar esse valor?: Quando você chamar a enumeração, ela vai automaticamente passar o valor
    * que você atribuiu a enumeração, no caso baixo, 1 em PESSOA_FISICA e 2 em PESSOA_JURIDICA
    * */
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    public final int VALUE;
    public final String REPORTNAME;

    ClientType(int value, String reportName) {
        this.VALUE = value;
        this.REPORTNAME = reportName;
    }

    // Você não vai querer setters porque o valor deve ser imutável
}
