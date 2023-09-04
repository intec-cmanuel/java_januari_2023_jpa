package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
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
    public void readStorage(Product product) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        Query query = em.createQuery(
                "SELECT * " +
                        "FROM storage " +
                        "JOIN storage_product ON storage.id = storage_product.storage_id" +
                        "JOIN product ON product.id = storage_product.storageContent_id" +
                        "WHERE product.id = " + product.getId());

        List resultList = query.getResultList();
        System.out.println(resultList);
    }
}
