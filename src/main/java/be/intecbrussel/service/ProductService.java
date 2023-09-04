package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.repository.IProductRepository;
import be.intecbrussel.repository.ProductRepository;

import java.util.Collection;

public class ProductService implements IProductService{
    private IProductRepository repo = new ProductRepository();
    private StorageService storageService;

    protected ProductService (StorageService storageService) {
        this.storageService = storageService;
    }

    public ProductService() {
        storageService = new StorageService(this);
    }

    @Override
    public void addProduct(Product product) {
        repo.createProduct(product);
    }

    @Override
    public Product getProduct(long id) {
        return repo.readProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        repo.updateProduct(product);
    }

    @Override
    public void deleteProduct(long id) {
        deleteProduct(getProduct(id));
    }

    @Override
    public void deleteProduct(Product product) {
        storageService.deleteProductFromStorage(product);
        repo.deleteProduct(product);
    }
}
