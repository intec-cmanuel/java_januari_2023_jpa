package be.intecbrussel.service;

import be.intecbrussel.model.Key;
import be.intecbrussel.repository.IKeyRepository;
import be.intecbrussel.repository.KeyRepository;

public class KeyService extends EntityService<Key> implements IKeyService{
    private StorageService storageService = new StorageService();
    private IKeyRepository keyRepository = new KeyRepository();

    @Override
    public void add(Key key) {
        if (key.getStorage() != null && key.getStorage().getId() == 0) {
            storageService.addStorage(key.getStorage());
        }

        keyRepository.create(key);
    }
}
