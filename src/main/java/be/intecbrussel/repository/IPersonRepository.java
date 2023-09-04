package be.intecbrussel.repository;

import be.intecbrussel.model.Person;

public interface IPersonRepository {

    void createPerson(Person person);

    Person readPerson(long id);

    void updatePerson (Person person);

    void deletePerson (long id);
}
