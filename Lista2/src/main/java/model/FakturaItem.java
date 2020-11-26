package model;

/**
 * The <code>main.model.FakturaItem</code> class is responsible for storing information
 * about invoice items, such as goods and services .
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>main.model.FakturaItem</code> extends {@link Product} by having additional variables and methods:
 * <code>fakturaId</code> is a String and is unique in whole database,
 * <code>fakturaItemId</code> is a String and is unique in whole database,
 * <code>quantity</code> is a float.
 * Variables from {@link Product}:
 * <code>productId</code> is a String and is unique in all database.
 * <code>productName</code> is a String.
 * <code>nettoPrice</code> is a float.
 * <code>taxRate</code> is a float given in percent.
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class FakturaItem extends Product {

    /**
     * Id of faktura witch contain item.
     */
    private final String fakturaId;
    /**
     * Item id.
     */
    private final String fakturaItemId;
    /**
     * Quantity of good bought.
     */
    private final float quantity;

    /**
     * Constructor of FakturaItem.

     * @param fakturaId Id of faktura witch contain item.
     * @param fakturaItemId Item id.
     * @param productId Product Id.
     * @param productName Full name of good or service.
     * @param quantity  Quantity of good bought.
     * @param nettoPrice Net price of product.
     * @param taxRate Tax rate on product in percentages.
     */
    public FakturaItem(String fakturaId, String fakturaItemId,
                       String productId, String productName,
                       float quantity, float nettoPrice, float taxRate) {
        super(productId, productName, nettoPrice, taxRate);
        this.fakturaId = fakturaId;
        this.fakturaItemId = fakturaItemId;
        this.quantity = quantity;
    }

    /**
     * Getter for id of faktura.

     * @return Id of faktura witch contain item.
     */
    public String getFakturaId() {
        return fakturaId;
    }

    /**
     * Getter for item id.

     * @return Item id.
     */
    public String getFakturaItemId() {
        return fakturaItemId;
    }

    /**
     * Getter for quantity of good bought.

     * @return Quantity of good bought.
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     * Getter for netto price.

     * @return netto price multiplied by quantity.
     */
    public float getNettoValue() {
        return getQuantity() * getNettoPrice();
    }

    /**
     * @return value of tax on item.
     */
    public float getTaxValue() {
        return getQuantity() * getNettoPrice() * getTaxRate() / 100;
    }

    /**
     * @return True price customer.
     */
    public float getBruttoValue() {
        return getNettoValue() + getTaxValue();
    }

}

