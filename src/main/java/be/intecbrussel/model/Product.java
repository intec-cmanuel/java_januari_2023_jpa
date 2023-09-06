package be.intecbrussel.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double value;
    private double weight;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Storage storage;

    protected Product () {

    }

    public Product (String name, double value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public Product (long id, String name, double value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.id = id;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;

        if (!storage.getStorageContent().contains(this)) {
            storage.add(this);
        }

    }

    public Storage getStorage() {
        return storage;
    }

    public long getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.value, value) == 0 && Double.compare(product.weight, weight) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value, weight);
    }
}


