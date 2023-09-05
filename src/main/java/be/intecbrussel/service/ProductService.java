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
    public void add(Product product) {
        repo.create(product);
    }

    @Override
    public Product get(Long id) {
        return repo.read(Product.class, id);
    }

    @Override
    public void update(Product product) {
        repo.update(product);
    }

    @Override
    public void delete(Long id) {
        repo.delete(Product.class, id);
    }

    @Override
    public void deleteProduct(Product product) {
        storageService.deleteProductFromStorage(product);
        delete(product.getId());
    }
}
