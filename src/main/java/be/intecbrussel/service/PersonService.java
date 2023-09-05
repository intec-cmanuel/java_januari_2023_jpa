package be.intecbrussel.service;

import be.intecbrussel.model.Person;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.IPersonRepository;
import be.intecbrussel.repository.IStorageRepository;
import be.intecbrussel.repository.PersonRepository;

public class PersonService extends EntityService<Person> implements IPersonService{
    private IStorageService storageService;
    private IPersonRepository personRepository = new PersonRepository();

    protected PersonService(StorageService ss) {
        this.storageService = ss;
    }

    public PersonService() {
        this.storageService = new StorageService();
    }

    @Override
    public void add(Person person) {
        Storage favStorage = person.getFavoriteStorage();
        if (favStorage != null && favStorage.getId() == 0) {
            storageService.add(favStorage);
        }

        personRepository.create(person);
    }

    @Override
    public Person get(Long id) {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Long id) {

    }

}
