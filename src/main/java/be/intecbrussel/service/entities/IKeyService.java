package be.intecbrussel.service.entities;

import be.intecbrussel.model.Key;
import be.intecbrussel.model.Storage;
import be.intecbrussel.service.IEntityService;

public interface IKeyService extends IEntityService<Key, Long> {
    void deleteKeyByStorage(Storage storage);
}
