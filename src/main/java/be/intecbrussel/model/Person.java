package be.intecbrussel.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne (cascade = CascadeType.MERGE)
    private Storage favoriteStorage;

    @OneToMany(mappedBy = "person", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<PersonalJob> jobs = new ArrayList<>();

    protected Person() {}

    public Person(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Storage getFavoriteStorage() {
        return favoriteStorage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavoriteStorage(Storage favoriteStorage) {
        this.favoriteStorage = favoriteStorage;
    }

    public List<PersonalJob> getJobs() {
        return jobs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", favoriteStorage=" + favoriteStorage +
                '}';
    }
}
