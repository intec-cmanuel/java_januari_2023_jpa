package be.intecbrussel.service;

import be.intecbrussel.model.Person;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.IPersonRepository;
import be.intecbrussel.repository.IStorageRepository;
import be.intecbrussel.repository.PersonRepository;

public class PersonService implements IPersonService{
    private IStorageService storageService;
    private IPersonRepository personRepository = new PersonRepository();

    protected PersonService(StorageService ss) {
        this.storageService = ss;
    }

    public PersonService() {
        this.storageService = new StorageService();
    }

    @Override
    public void addPerson(Person person) {
        Storage favStorage = person.getFavoriteStorage();
        if (favStorage != null && favStorage.getId() == 0) {
            storageService.addStorage(favStorage);
        }

        personRepository.createPerson(person);
    }

    @Override
    public Person getPerson(long id) {
        return null;
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(long id) {

    }
}
