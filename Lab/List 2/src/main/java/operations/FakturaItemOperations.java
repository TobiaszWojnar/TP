package operations;

import dao.FakturaItemDao;
import dao.ProductDao;
import model.FakturaItem;

import java.io.BufferedReader;

/**
 * The <code>FakturaItemOperations</code> is responsible for sending requests form GUI to {@link FakturaItem} database.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>ClientOperations</code> enables adding and deleting items from {@link FakturaItemDao}.
 * Using operation class enables high cohesion code.
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class FakturaItemOperations {
    /**
     * Database access object.
     */
    private final FakturaItemDao fakturaItemDao;
    /**
     * Database access object.
     */
    private final ProductDao productDao;

    /**
     * Constructor requires two databases.
     * Because adding item to {@link model.Faktura} requires coping them from existing {@link model.Product} .

     * @param fakturaItemDao database of {@link FakturaItemDao}.
     * @param productDao database of {@link ProductDao}.
     */
    public FakturaItemOperations(FakturaItemDao fakturaItemDao, ProductDao productDao) {
        this.fakturaItemDao = fakturaItemDao;
        this.productDao = productDao;
    }


    /**
     * Reads all information required to make new {@link FakturaItem}.

     * @param fakturaId id of faktura to which item is added.
     * @param reader passing it as a parameter provides one application-wide reader.
     */
    public void add(String fakturaId, BufferedReader reader) {
        try {
            System.out.println("Add product to faktura\nEnter article id:");
            String articleId = reader.readLine();
            if (productDao.checkIfIdExist(articleId)) {
                System.out.println("Enter quantity:");
                float quantity = Float.parseFloat(reader.readLine());
                String fakturaItemId = fakturaItemDao.getNextId();
                fakturaItemDao.add(new FakturaItem(
                        fakturaId,
                        fakturaItemId,
                        articleId,
                        productDao.getById(articleId).getProductName(),
                        quantity,
                        productDao.getById(articleId).getNettoPrice(),
                        productDao.getById(articleId).getTaxRate()
                ));
                System.out.println("Addition successful.");
                System.out.println("Item id = '" + fakturaItemId + "'");
            } else {
                System.out.println("Id not exist in database.");
                System.out.println("Addition unsuccessful.");
            }
        } catch (Exception e) {
            System.out.println("Unsupported datatype - " + e.getMessage());
            System.out.println("Addition unsuccessful.");
        }
    }

    /**
     * Deletes form database item with matching Id.

     * @param fakturaItemId id of item is a short string of numbers given on entering new item to database.
     */
    public void delete(String fakturaItemId) {
        fakturaItemDao.delete(fakturaItemId);
    }

}
