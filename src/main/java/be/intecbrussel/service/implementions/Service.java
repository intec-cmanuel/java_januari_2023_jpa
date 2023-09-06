package be.intecbrussel.service.implementions;

import be.intecbrussel.model.Storage;
import be.intecbrussel.service.entities.IJobService;

public class Service {
    private static KeyService keyService = new KeyService();
    private static PersonService personService = new PersonService();
    private static ProductService productService = new ProductService();
    private static StorageService storageService = new StorageService();
    private static JobService jobService = new JobService();

    static {
        keyService.storageService = storageService;

        personService.storageService = storageService;
        personService.jobService = jobService;

        productService.storageService = storageService;

        storageService.personService = personService;
        storageService.keyService = keyService;
        storageService.productService = productService;

        jobService.personService = personService;
    }

    public static KeyService getKeyService() {
        return keyService;
    }

    public static PersonService getPersonService() {
        return personService;
    }

    public static ProductService getProductService() {
        return productService;
    }

    public static StorageService getStorageService() {
        return storageService;
    }

    public static IJobService getJobService() {
        return jobService;
    }
}
