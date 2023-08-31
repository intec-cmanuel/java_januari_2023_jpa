package be.intecbrussel.service;

import be.intecbrussel.model.Product;

import java.util.Collection;

public interface IProductService {
    // CREATE
    void addProduct(Product product);

//    void addOrUpdateAllProducts(Collection<Product> products);

    // READ
    Product getProduct(long id);

    // UPDATE
    void updateProduct(Product product);

    // DELETE
    void deleteProduct(long id);
    void deleteProduct(Product product);



}
