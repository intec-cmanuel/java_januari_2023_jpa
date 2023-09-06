package be.intecbrussel.repository.entities;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.IEntityRepository;

public interface IStorageRepository extends IEntityRepository<Storage> {
    Storage readStorage(Product product);
}
