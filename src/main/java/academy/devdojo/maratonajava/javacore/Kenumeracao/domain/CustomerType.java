package academy.devdojo.maratonajava.javacore.Kenumeracao.domain;

public enum CustomerType {
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
    public final String REPORTVALUE;

    CustomerType(int value, String reportValue) {
        this.VALUE = value;
        this.REPORTVALUE = reportValue;
    }

    /*
    *Object.valueOf() retorna a enumeração baseada no nome como PESSOA_FISICA ou PESSOA_JURIDICA
    * Se você quiser retornar uma enumeração baseada nos atributos como 1 ou "Pessoa Física", pode usar o método abaixo
    * */
    public static CustomerType getByReportValue(String reportValue) {
        // values() retorna um array com todas as enumerações
        for (CustomerType customerType : values()) {
            if (reportValue.equals(customerType.REPORTVALUE)) {
                return customerType;
            }
        }
        return null;
    }

    // Você não vai querer setters porque o valor deve ser imutável
}
