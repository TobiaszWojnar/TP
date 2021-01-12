package dao;

import model.Product;

import java.util.List;

/**
 * <code>ArticleDao</code> is data access object interface for {@link Product}.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>ProductDao</code> is data access object interface for {@link Product}.
 * Enables separation of implemented database and logic of application
 * (Low Coupling rule form GRASP methodology).
 * <code>ProductDao</code> has 5 methods:
 * delete(), add(), getById(), getAll() and checkIfInExist()
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public interface ProductDao {

    /**
     * Deletes article from database with matching id.
     * If none found does nothing.

     * @param articleId id of the article to be deleted.
     */
    void delete(String articleId);

    /**
     * Inserts article to database.

     * @param product article to be inserted into database.
     * @return id of the added article.
     */
    String add(Product product);

    /**
     * Returns article with matching id.

     * @param articleId id of the searched article.
     * @return article if one with matching id exists or null
     */
    Product getById(String articleId);

    /**
     * Returns list of all articles.

     * @return list of all articles.
     */
    List<Product> getAll();

    /**
     * Checks if article with matching id exists in database.

     * @param articleId id of the searched article.
     * @return true if article with matching id exists in database.
     */
    boolean checkIfIdExist(String articleId);

}
