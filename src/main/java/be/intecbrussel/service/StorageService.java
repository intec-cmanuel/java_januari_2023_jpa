package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.IStorageRepository;
import be.intecbrussel.repository.StorageRepository;

public class StorageService implements IStorageService{
    private IStorageRepository storageRepository = new StorageRepository();
    private IProductService productService;

    protected StorageService (ProductService productService) {
        this.productService = productService;
    }

    public StorageService () {
        productService = new ProductService(this);
    }

    @Override
    public void addStorage(Storage storage) {
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                productService.addProduct(product);
            } else {
                productService.updateProduct(product);
            }
        }
        storageRepository.createStorage(storage);
    }

    @Override
    public Storage getStorage(long id) {
        return storageRepository.readStorage(id);
    }

    @Override
    public void updateStorage(Storage storage) {
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                productService.addProduct(product);
            }
        }

        storageRepository.updateStorage(storage);
    }

    @Override
    public void deleteStorage(long id) {
        storageRepository.deleteStorage(id);
    }

    @Override
    public void deleteProductFromStorage(Product product) {
        Storage dbStorage = storageRepository.readStorage(product);
        dbStorage.getStorageContent().remove(product);
        updateStorage(dbStorage);
    }
}
