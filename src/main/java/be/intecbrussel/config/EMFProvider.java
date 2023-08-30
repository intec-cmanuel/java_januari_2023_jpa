package be.intecbrussel.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// EMF = Entity Manager Factory
public class EMFProvider {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEMF() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("mysql");
        }

        return entityManagerFactory;
    }

    private EMFProvider(){}
}
