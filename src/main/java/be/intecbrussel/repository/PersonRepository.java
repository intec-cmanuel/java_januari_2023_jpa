package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Person;
import jakarta.persistence.EntityManager;

public class PersonRepository extends EntityRepository<Person> implements IPersonRepository{

}
