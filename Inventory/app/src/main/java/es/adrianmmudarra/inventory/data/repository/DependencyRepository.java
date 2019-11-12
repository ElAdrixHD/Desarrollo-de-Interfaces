package es.adrianmmudarra.inventory.data.repository;

import java.util.ArrayList;

import es.adrianmmudarra.inventory.data.model.Dependency;

public class DependencyRepository {
    private static DependencyRepository instance;
    private ArrayList<Dependency> list;

    /*static {
        instance = new DependencyRepository();
    }*/

    public DependencyRepository() {
        initialice();
    }

    private void initialice() {
        list = new ArrayList<>();
        list.add(new Dependency("2º Ciclo de Grado Superior", "2ºCFGS", "Aula de informatica","S"));
        list.add(new Dependency("1º Ciclo de Grado Superior", "1ºCFGS", "Aula de informatica","S"));
        list.add(new Dependency("2º Ciclo de Grado Medio", "2ºCFGM", "Aula de informatica","M"));
        list.add(new Dependency("1º Ciclo de Grado Medio", "1ºCFGM", "Aula de informatica","M"));
        list.add(new Dependency("4º ESO", "4ºESO", "ESO","E"));
        list.add(new Dependency("3º ESO", "3ºESO", "ESO","E"));
        list.add(new Dependency("2º ESO", "2ºESO", "ESO","E"));
        list.add(new Dependency("1º ESO", "1ºESO", "ESO","E"));
        list.add(new Dependency("2º Bachillerato", "2ºBACH", "Bachillerato","B"));
        list.add(new Dependency("1º Bachillerato", "1ºBACH", "Bachillerato","B"));

    }

    public static DependencyRepository getInstance(){
        if (instance == null){
            instance = new DependencyRepository();
        }
        return instance;
    }

    public ArrayList<Dependency> getDependencies(){
        return  list;
    }
}
