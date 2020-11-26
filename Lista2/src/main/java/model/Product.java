package model;

/**
 * The <code>main.model.Product</code> class is responsible for storing information about goods or services.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>main.model.Product</code> has 4 variables and get methods for them:
 * <code>productId</code> is a String and is unique in all database.
 * <code>productName</code> is a String.
 * <code>nettoPrice</code> is a float.
 * <code>taxRate</code> is a float given in percent.
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class Product {
    /**
     * Product Id.
     */
    private final String productId;

    /**
     * Full name of good or service.
     */
    private final String productName;
    /**
     * Net price of product.
     */
    private final float nettoPrice;
    /**
     * Tax rate on product in percentages.
     */
    private final float taxRate;

    /**
     * Product constructor.

     * @param productId  Product Id.
     * @param productName Full name of good or service.
     * @param nettoPrice Net price of product.
     * @param taxRate Tax rate on product in percentages.
     */
    public Product(String productId, String productName, float nettoPrice, float taxRate) {
        this.productId = productId;
        this.productName = productName;
        this.nettoPrice = nettoPrice;
        this.taxRate = taxRate;
    }

    /**
     * @return Full name of good or service.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @return Net price of product.
     */
    public float getNettoPrice() {
        return nettoPrice;
    }

    /**
     * @return Tax rate on product in percentages.
     */
    public float getTaxRate() {
        return taxRate;
    }

    /**
     * @return Product Id.
     */
    public String getProductId() {
        return productId;
    }
}

