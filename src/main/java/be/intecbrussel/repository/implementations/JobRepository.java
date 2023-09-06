package be.intecbrussel.repository.implementations;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Job;
import be.intecbrussel.model.Person;
import be.intecbrussel.repository.EntityRepository;
import be.intecbrussel.repository.entities.IJobRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class JobRepository extends EntityRepository<Job> implements IJobRepository {

    @Override
    public List<Job> readJobs(Person person) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        String queryString = "select j from Job j join j.employees e where e.id = ?1";
        Query query = em.createQuery(queryString);
        query.setParameter(1, person.getId());

        // Will throw exception if product is not part of a storage
        List<Job> resultList = query.getResultList();

        em.close();

        return resultList;

    }
}
