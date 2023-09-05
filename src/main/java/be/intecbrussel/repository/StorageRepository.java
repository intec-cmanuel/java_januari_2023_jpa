package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class StorageRepository extends EntityRepository<Storage> implements IStorageRepository{

    @Override
    public Storage readStorage(Product product) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        String queryString = "select s from Storage s join s.storageContent p where p.id = ?1";
        Query query = em.createQuery(queryString);
        query.setParameter(1, product.getId());

        // Will throw exception if product is not part of a storage
        Storage resultList = (Storage) query.getSingleResult();
        return resultList;
    }
}
