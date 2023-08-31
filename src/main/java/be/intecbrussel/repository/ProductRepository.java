package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    @Override
    public void createProduct(Product product) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public Product readProduct(long id) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        Product dbProduct = em.find(Product.class, id);
        em.close();

        return dbProduct;
    }

    @Override
    public void updateProduct(Product product) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        Product mergedProduct = em.merge(product);

        if (!mergedProduct.equals(product)) {
            em.getTransaction().rollback();
        } else {
            em.getTransaction().commit();
        }

         em.close();
    }

    @Override
    public void deleteProduct(Product product) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        Product product1 = em.find(Product.class, product.getId());
        em.remove(product1);
        em.getTransaction().commit();

        em.close();
    }
}
