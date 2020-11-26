package dao.memory;

import dao.ProductDao;
import model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>ArticleDao</code> implements data access object interface for {@link Product}.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>ProductMemoryDao</code> implements data access object interface for {@link Product} as List.
 * Enables separation of implemented database and logic of application
 * (Low Coupling rule form GRASP methodology).
 * <code>ProductMemoryDao</code> has 5 methods:
 * delete(), add(), getById(), getAll() and checkIfInExist()
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class ProductMemoryDao implements ProductDao {

    /**
     * Database stored as List
     */
    private final List<Product> productList;

    /**
     * Initialize list as ArrayList
     */
    public ProductMemoryDao() {
        productList = new ArrayList<>();
    }

    /**
     * Deletes article from database with matching id.
     * If none found does nothing.

     * @param articleId id of the article to be deleted.
     */
    @Override
    public void delete(String articleId) {
        productList.remove(getById(articleId));
    }

    /**
     * Inserts article to database.

     * @param product article to be inserted into database.
     * @return id of the added article.
     */
    @Override
    public String add(Product product) {
        productList.add(product);
        return product.getProductId();
    }

    /**
     * Returns article with matching id.

     * @param articleId id of the searched article.
     * @return article if one with matching id exists or null
     */
    @Override
    public Product getById(String articleId) {
        for (Product product : productList) {
            if (product.getProductId().equals(articleId)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Returns list of all articles.

     * @return list of all articles.
     */
    @Override
    public List<Product> getAll() {
        return productList;
    }

    /**
     * Checks if article with matching id exists in database.

     * @param articleId id of the searched article.
     * @return true if article with matching id exists in database.
     */
    @Override
    public boolean checkIfIdExist(String articleId) {
        boolean exist = false;
        for (Product product : productList) {
            if (product.getProductId().equals(articleId)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

}

