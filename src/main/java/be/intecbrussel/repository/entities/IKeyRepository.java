package be.intecbrussel.repository.entities;

import be.intecbrussel.model.Key;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.IEntityRepository;

public interface IKeyRepository extends IEntityRepository<Key> {
    Key readKey(Storage storage);
}
