package be.intecbrussel;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.ProductRepository;
import be.intecbrussel.service.IProductService;
import be.intecbrussel.service.IStorageService;
import be.intecbrussel.service.ProductService;
import be.intecbrussel.service.StorageService;

public class StorageApp {
    public static void main(String[] args) {

        Product p1 = new Product("Apple", 1.50, 2.75);
        Product p2 = new Product("Potato is now a fruit", 0.95, 0.50);
        Product p3 = new Product("Banana", 3.60, 4.50);
        Product p4 = new Product("Train", 50, 60);

        Storage s1 = new Storage("Fruits And Trains");
        s1.add(p1,p2,p3,p4);

        IProductService productService = new ProductService();
        IStorageService storageService = new StorageService();

        storageService.addStorage(s1);

        s1.setName("A bit of everything");
        Product jonathan = new Product("Spoilers", 0, 79);
        s1.add(jonathan);

        storageService.updateStorage(s1);

//        storageService.deleteStorage(1);
        productService.deleteProduct(p2);

        Storage dbStorage = storageService.getStorage(1);

        System.out.println(dbStorage);

    }

}
