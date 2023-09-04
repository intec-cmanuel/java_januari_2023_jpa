package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class StorageRepository implements IStorageRepository{
    @Override
    public void createStorage(Storage storage) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        em.persist(storage);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public Storage readStorage(long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        Storage dbStorage = em.find(Storage.class, id);
        em.close();
        return dbStorage;
    }

    @Override
    public void updateStorage(Storage storage) {
        EntityManager entityManager = EMFProvider.getEMF().createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(storage);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public void deleteStorage(long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        Storage dbStorage = em.find(Storage.class, id);
        em.remove(dbStorage);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public Storage readStorage(Product product) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        String queryString = "select s from Storage s cross join Product p where p.id = ?1";
        Query query = em.createQuery(queryString);
        query.setParameter(1, product.getId());

        Storage resultList = (Storage) query.getSingleResult();
        return resultList;
    }
}
