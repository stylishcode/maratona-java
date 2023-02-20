package academy.devdojo.maratonajava.javacore.Npolimorfismo.service;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.repositorio.Repository;

public class ArchiveRepository implements Repository {
    @Override
    public void save() {
        System.out.println("Salvando em um arquivo");
    }
}
