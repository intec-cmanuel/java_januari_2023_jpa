package be.intecbrussel.service.implementions;

import be.intecbrussel.model.Storage;

public class Service {
    private static KeyService keyService = new KeyService();
    private static PersonService personService = new PersonService();
    private static ProductService productService = new ProductService();
    private static StorageService storageService = new StorageService();

    static {
        keyService.storageService = storageService;

        personService.storageService = storageService;

        productService.storageService = storageService;

        storageService.personService = personService;
        storageService.keyService = keyService;
        storageService.productService = productService;
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
}
