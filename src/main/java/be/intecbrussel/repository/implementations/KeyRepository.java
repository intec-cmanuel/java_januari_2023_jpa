package be.intecbrussel.repository.implementations;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Key;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.EntityRepository;
import be.intecbrussel.repository.entities.IKeyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class KeyRepository extends EntityRepository<Key> implements IKeyRepository {

    @Override
    public Key readKey(Storage storage) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        String queryString = "select k from KeyTable k join k.storage s where s.id = ?1";
        Query query = em.createQuery(queryString);
        query.setParameter(1, storage.getId());

        // Will throw exception if product is not part of a storage
        Key resultList = (Key) query.getSingleResult();

        em.close();

        return resultList;

    }
}
