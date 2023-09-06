package be.intecbrussel.repository.implementations;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.EntityRepository;
import be.intecbrussel.repository.entities.IStorageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class StorageRepository extends EntityRepository<Storage> implements IStorageRepository {

    @Override
    public Storage readStorage(Product product) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        String queryString = "select s from Storage s join s.storageContent p where p.id = ?1";
        Query query = em.createQuery(queryString);
        query.setParameter(1, product.getId());

        // Will throw exception if product is not part of a storage
        Storage resultList = (Storage) query.getSingleResult();

        em.close();

        return resultList;
    }
}
