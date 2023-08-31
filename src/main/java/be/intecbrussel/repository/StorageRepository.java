package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

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
        return null;
    }

    @Override
    public void updateStorage(Storage storage) {

    }

    @Override
    public void deleteStorage(long id) {

    }
}
