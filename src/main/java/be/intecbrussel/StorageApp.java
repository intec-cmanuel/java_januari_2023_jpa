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
        productService.addProduct(p1);

        p1.setName("Shiny Apple");

        IStorageService storageService = new StorageService();
        storageService.addStorage(s1);


        //        System.out.println(s1);

//        Product dbApple = p1;

//        Product dbApple = productService.getProduct(1);
//        System.out.println("DB APPLE: " + dbApple);
//
//        dbApple.setName("Apple from the DB");
//        productService.updateProduct(dbApple);
//        dbApple.setWeight(5000);
//        productService.updateProduct(dbApple);
//
//        System.out.println("Update DB APPLE: " + dbApple);

//        productService.deleteProduct(dbApple);

//        Product deletedApple = productService.getProduct(dbApple.getId());
//        System.out.println(deletedApple);


    }

}
