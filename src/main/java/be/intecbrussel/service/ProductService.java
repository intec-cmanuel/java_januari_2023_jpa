package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.repository.IProductRepository;
import be.intecbrussel.repository.ProductRepository;

public class ProductService implements IProductService{
    private IProductRepository repo = new ProductRepository();

    @Override
    public void addProduct(Product product) {
        repo.createProduct(product);
    }

    @Override
    public Product getProduct(long id) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(long id) {

    }

    @Override
    public void deleteProduct(Product product) {

    }
}
