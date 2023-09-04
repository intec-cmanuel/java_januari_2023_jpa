package be.intecbrussel.service;

import be.intecbrussel.model.Person;

public interface IPersonService {

    void addPerson(Person person);

    Person getPerson(long id);

    void updatePerson(Person person);

    void deletePerson(long id);

}
