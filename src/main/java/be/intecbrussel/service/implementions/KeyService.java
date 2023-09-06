package be.intecbrussel.service.implementions;

import be.intecbrussel.model.Key;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.entities.IKeyRepository;
import be.intecbrussel.repository.implementations.KeyRepository;
import be.intecbrussel.service.entities.IKeyService;

public class KeyService implements IKeyService {
    private StorageService storageService = new StorageService();
    private IKeyRepository keyRepository = new KeyRepository();

    @Override
    public void add(Key key) {
        if (key.getId() != 0) {
            update(key);
        }

        if (key.getStorage() != null && key.getStorage().getId() == 0) {
            storageService.add(key.getStorage());
        } else if (key.getStorage() != null) {
            storageService.update(key.getStorage());
        }

        keyRepository.create(key);
    }

    @Override
    public Key get(Long id) {
        return keyRepository.read(Key.class, id);
    }

    @Override
    public void update(Key key) {
        if (key.getStorage() != null && key.getStorage().getId() == 0) {
            storageService.add(key.getStorage());
        }

        keyRepository.update(key);
    }

    @Override
    public void delete(Long id) {
        keyRepository.delete(Key.class, id);
    }

    @Override
    public void deleteKeyByStorage(Storage storage) {
        Key key = keyRepository.readKey(storage);
        delete(key.getId());
    }
}
