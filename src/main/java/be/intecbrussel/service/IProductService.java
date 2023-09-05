package be.intecbrussel.service;

import be.intecbrussel.model.Product;

import java.util.Collection;

public interface IProductService extends IEntityService<Product, Long> {
    void deleteProduct(Product product);
}
