package be.intecbrussel.model;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private String name;

    private List<Product> storageContent;

    public Storage (String name) {
        this.name = name;
        this.storageContent = new ArrayList<>();
    }

    public void add(Product... products) {
        for (Product product : products) {
            add(product);
        }
    }

    public void add(Product product) {
        storageContent.add(product);
    }

    public String getName() {
        return name;
    }

    public List<Product> getStorageContent() {
        return storageContent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStorageContent(List<Product> storageContent) {
        this.storageContent = storageContent;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                ", storageContent=" + storageContent +
                '}';
    }
}
