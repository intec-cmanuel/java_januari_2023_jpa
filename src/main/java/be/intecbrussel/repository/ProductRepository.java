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

        Product product1 = new Product(2,  "test", 1, 1);

        em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        em.persist(product1);
        em.getTransaction().commit();

        em.close();


        System.out.println(product);
    }

    @Override
    public Product readProduct(long id) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Product product) {

    }
}
