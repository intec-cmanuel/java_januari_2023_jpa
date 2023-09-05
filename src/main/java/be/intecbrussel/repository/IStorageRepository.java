package be.intecbrussel.repository;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;

public interface IStorageRepository extends IEntityRepository<Storage> {
    Storage readStorage(Product product);
}
