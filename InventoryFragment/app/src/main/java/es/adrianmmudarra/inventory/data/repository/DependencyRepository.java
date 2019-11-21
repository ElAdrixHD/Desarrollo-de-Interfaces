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
        list.add(new Dependency("2º Ciclo de Grado Superior", "2ºCFGS", "Aula de informatica","2018","S"));
        list.add(new Dependency("1º Ciclo de Grado Superior", "1ºCFGS", "Aula de informatica","2019","S"));
        list.add(new Dependency("2º Ciclo de Grado Medio", "2ºCFGM", "Aula de informatica","2019","M"));
        list.add(new Dependency("1º Ciclo de Grado Medio", "1ºCFGM", "Aula de informatica","2020","M"));
        list.add(new Dependency("4º ESO", "4ºESO", "ESO","2020","E"));
        list.add(new Dependency("3º ESO", "3ºESO", "ESO","2019","E"));
        list.add(new Dependency("2º ESO", "2ºESO", "ESO","2019","E"));
        list.add(new Dependency("1º ESO", "1ºESO", "ESO","2019","E"));
        list.add(new Dependency("2º Bachillerato", "2ºBACH", "Bachillerato","2018","B"));
        list.add(new Dependency("1º Bachillerato", "1ºBACH", "Bachillerato","2018","B"));

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
