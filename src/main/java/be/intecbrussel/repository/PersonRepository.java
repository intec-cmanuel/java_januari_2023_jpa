package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Person;
import jakarta.persistence.EntityManager;

public class PersonRepository implements IPersonRepository{
    @Override
    public void createPerson(Person person) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public Person readPerson(long id) {
        return null;
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(long id) {

    }
}
