package be.intecbrussel.repository.implementations;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Person;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.EntityRepository;
import be.intecbrussel.repository.entities.IPersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class PersonRepository extends EntityRepository<Person> implements IPersonRepository {

    @Override
    public List<Person> readPeople(Storage favStorage) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        String queryString = "select p from Person join p.favoriteStorage s where s.id = ?1";
        Query query = em.createQuery(queryString);
        query.setParameter(1, favStorage.getId());

        // Will throw exception if product is not part of a storage
        List<Person> resultList = query.getResultList();

        em.close();

        return resultList;

    }
}
