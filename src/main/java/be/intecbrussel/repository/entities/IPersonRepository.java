package be.intecbrussel.repository.entities;

import be.intecbrussel.model.Person;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.IEntityRepository;

import java.util.List;

public interface IPersonRepository extends IEntityRepository<Person> {
    List<Person> readPeople(Storage favStorage);
}
