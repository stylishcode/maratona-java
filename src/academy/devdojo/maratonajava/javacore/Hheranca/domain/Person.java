package academy.devdojo.maratonajava.javacore.Hheranca.domain;

public class Person {
    // Libera acesso a todas as subclasses e classes no mesmo pacote
    private String name;
    private String cpf;
    private Address address;

    public void print() {
        System.out.println(name);
        System.out.println(cpf);
        System.out.println(address.getStreet());
        System.out.println(address.getCep());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
