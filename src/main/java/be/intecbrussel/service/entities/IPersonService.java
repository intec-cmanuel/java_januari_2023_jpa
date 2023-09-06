package be.intecbrussel.service.entities;

import be.intecbrussel.model.Person;
import be.intecbrussel.model.Storage;
import be.intecbrussel.service.IEntityService;

public interface IPersonService extends IEntityService<Person, Long> {
    void deleteStorageFromPerson(Storage storage);
}
