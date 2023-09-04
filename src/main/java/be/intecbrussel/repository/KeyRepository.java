package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Key;
import jakarta.persistence.EntityManager;

public class KeyRepository implements IKeyRepository{
    @Override
    public void createKey(Key key) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        em.persist(key);
        em.getTransaction().commit();

        em.close();
    }
}
