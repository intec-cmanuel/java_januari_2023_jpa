package be.intecbrussel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double value;
    private double weight;

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
}


