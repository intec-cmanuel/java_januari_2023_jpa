package be.intecbrussel;

import be.intecbrussel.model.Key;
import be.intecbrussel.model.Person;
import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.ProductRepository;
import be.intecbrussel.service.*;

public class StorageApp {
    public static void main(String[] args) {

        Product p1 = new Product("Apple", 1.50, 2.75);
        Product p2 = new Product("Potato is now a fruit", 0.95, 0.50);
        Product p3 = new Product("Banana", 3.60, 4.50);
        Product p4 = new Product("Train", 50, 60);

        Storage s1 = new Storage("Fruits And Trains");
        s1.add(p1,p2,p3,p4);

        Product pp1 = new Product("a",1,1);
        Product pp2 = new Product("b",1,1);
        Product pp3 = new Product("c",1,1);

        Storage s2 = new Storage("oops");
        s2.add(pp1,pp2,pp3);

        Person person = new Person("Jean-Bon");
        person.setFavoriteStorage(s1);

        Person person1 = new Person("Jean-tille");
        person1.setFavoriteStorage(s1);

        Person person2 = new Person("Jean-Neymar");
        person2.setFavoriteStorage(s2);

        Key key = new Key();
        key.setStorage(s2);

        IProductService productService = new ProductService();
        IStorageService storageService = new StorageService();
        IPersonService personService = new PersonService();
        IKeyService keyService = new KeyService();

        keyService.addKey(key);
        personService.addPerson(person);
        personService.addPerson(person1);
        personService.addPerson(person2);

        productService.
//        storageService.addStorage(s1);
//        storageService.addStorage(s2);

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
