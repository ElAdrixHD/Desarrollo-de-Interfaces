package es.adrianmmudarra.recycleruserview.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.adrianmmudarra.recycleruserview.model.User;

public class RepositoryUser {

    private static RepositoryUser instance;
    private ArrayList<User> list;

    private RepositoryUser(){
        initialize();
    }

    private void initialize() {
        list = new ArrayList<>();
        list.add(new User("Adrian Muñoz","eladrixhd@gmail.com"));
        list.add(new User("Pepe Lopez","pepelopez@gmail.com"));
        list.add(new User("Raul Prieto","raulpb00@gmail.com"));
        list.add(new User("Guillermo Vera","vfguille@gmail.com"));
        list.add(new User("Pablo Lopez","esviapalva@gmail.com"));
        list.add(new User("Adrian Muñoz","eladrixhd@gmail.com"));
        list.add(new User("Adrian Muñoz","eladrixhd@gmail.com"));
        list.add(new User("Adrian Muñoz","eladrixhd@gmail.com"));
        list.add(new User("Pepe Lopez","pepelopez@gmail.com"));
        list.add(new User("Raul Prieto","raulpb00@gmail.com"));
        list.add(new User("Guillermo Vera","vfguille@gmail.com"));
        list.add(new User("Pablo Lopez","esviapalva@gmail.com"));
        list.add(new User("Adrian Muñoz","eladrixhd@gmail.com"));
        list.add(new User("Adrian Muñoz","eladrixhd@gmail.com"));
        list.add(new User("Adrian Muñoz","eladrixhd@gmail.com"));
        list.add(new User("Pepe Lopez","pepelopez@gmail.com"));
        list.add(new User("Raul Prieto","raulpb00@gmail.com"));
        list.add(new User("Guillermo Vera","vfguille@gmail.com"));
        list.add(new User("Pablo Lopez","esviapalva@gmail.com"));
        list.add(new User("Adrian Muñoz","eladrixhd@gmail.com"));
        list.add(new User("Adrian Muñoz","eladrixhd@gmail.com"));
    }

    public static RepositoryUser getInstance(){
        if (instance == null){
            instance = new RepositoryUser();
        }
        return instance;
    }

    public ArrayList<User> getUsers(){
        return list;
    }

}
