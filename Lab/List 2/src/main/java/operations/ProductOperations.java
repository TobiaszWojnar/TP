package operations;

import dao.ProductDao;
import model.Product;

import java.io.BufferedReader;

/**
 * The <code>ProductOperations</code> is responsible for sending requests form GUI to {@link Product} database.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>ProductOperations</code> enables adding, deleting and printing items from {@link ProductDao}.
 * Using operation class enables high cohesion code.
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class ProductOperations {

    /**
     * Database access object.
     */
    private final ProductDao productDao;

    /**
     * Constructor requires only database.

     * @param productDao database of {@link Product}.
     */
    public ProductOperations(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * Reads all information required to make new {@link Product}.

     * @param reader passing it as a parameter provides one application-wide reader.
     */
    public void add(BufferedReader reader) {
        try {
            System.out.println("Add product to database.");
            System.out.println("Enter product name:");
            String articleName = reader.readLine();
            System.out.println("Enter a id:");
            String articleId = reader.readLine();
            if (productDao.checkIfIdExist(articleId)) {
                System.out.println("Id exist in database. Addition unsuccessful");
            } else {
                System.out.println("Enter netto price:");
                float nettoPrice = Float.parseFloat(reader.readLine());
                System.out.println("Enter tax rate (percentage):");
                float taxRate = Float.parseFloat(reader.readLine());

                productDao.add(new Product(articleId, articleName, nettoPrice, taxRate));
                System.out.println("Addition successful");
            }
        } catch (Exception e) {
            System.out.println("Unsupported datatype - " + e.getMessage());
            System.out.println("Addition unsuccessful");
        }

    }

    /**
     * Deletes form database product with matching Id and all its items.

     * @param productId id of product is a short string of characters given on entering new product to database.
     */
    public void delete(String productId) {
        productDao.delete(productId);
    }

    /**
     * Prints on standard output {@link Product}.
     * Prints {@link Product} parameters in following lines.

     * @param product to be printed.
     */
    public void print(Product product) {
        System.out.println("Name\t" + product.getProductName());
        System.out.println("Id\t" + product.getProductId());
        System.out.println("Netto prize\t" + product.getNettoPrice());
        System.out.println("Tax rate\t" + product.getTaxRate());
        System.out.println("------");
    }

    /**
     * Prints on standard output {@link Product}.

     * @param productId Id of {@link Product}.
     */
    public void print(String productId) {
        Product product = productDao.getById(productId);
        print(product);
    }

    /**
     * Prints whole database.
     */
    public void printAll() {
        for (Product product : productDao.getAll()) {
            print(product);
        }
    }

}

