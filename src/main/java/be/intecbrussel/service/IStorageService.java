package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;

public interface IStorageService extends IEntityService<Storage, Long> {
    void deleteProductFromStorage(Product product);
}
