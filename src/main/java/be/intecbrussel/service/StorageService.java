package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.IStorageRepository;
import be.intecbrussel.repository.StorageRepository;

public class StorageService implements IStorageService{
    private StorageRepository storageRepository = new StorageRepository();
    private IProductService productService;

    protected StorageService (ProductService productService) {
        this.productService = productService;
    }

    public StorageService () {
        productService = new ProductService(this);
    }

    @Override
    public void add(Storage storage) {
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                productService.add(product);
            } else {
                productService.update(product);
            }
        }
        storageRepository.create(storage);
    }

    @Override
    public Storage get(Long id) {
        return storageRepository.read(Storage.class, id);
    }

    @Override
    public void update(Storage storage) {
        for (Product product : storage.getStorageContent()) {
            if (product.getId() == 0) {
                productService.add(product);
            }
        }

        storageRepository.update(storage);
    }

    @Override
    public void delete(Long id) {
        storageRepository.delete(Storage.class, id);
    }

    @Override
    public void deleteProductFromStorage(Product product) {
        Storage dbStorage = storageRepository.readStorage(product);
        dbStorage.getStorageContent().remove(product);
        update(dbStorage);
    }
}
