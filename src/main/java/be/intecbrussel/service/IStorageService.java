package be.intecbrussel.service;

import be.intecbrussel.model.Storage;

public interface IStorageService {
    // CREATE
    void addStorage(Storage storage);

    // READ
    Storage getStorage(String name);

    // UPDATE
    void updateStorage(Storage storage);

    // DELETE
    void deleteStorage(String name);


}
