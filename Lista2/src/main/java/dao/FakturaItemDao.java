package dao;

import model.FakturaItem;

import java.util.List;

/**
 * <code>main.dao.FakturaItemDao</code> is data access object interface for {@link FakturaItem}.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>main.dao.FakturaItemDao</code> is data access object interface for {@link FakturaItem}.
 * Enables separation of implemented database and logic of application
 * (Low Coupling rule form GRASP methodology).
 * <code>main.dao.FakturaItemDao</code> has 5 methods:
 * delete(), add(), getById(), getAll() and checkIfInExist()
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public interface FakturaItemDao {
    /**
     * Deletes fakturaItem from database with matching id.
     * If none found does nothing.

     * @param fakturaItemId id of the fakturaItem to be deleted.
     */
    void delete(String fakturaItemId);

    /**
     * Inserts fakturaItem to database.

     * @param fakturaItem fakturaItem to be inserted into database.
     * @return id of the added fakturaItem.
     */
    String add(FakturaItem fakturaItem);

    /**
     * Returns fakturaItem with matching id.

     * @param fakturaItemId id of the searched fakturaItem.
     * @return fakturaItem if one with matching id exists or null
     */
    FakturaItem get(String fakturaItemId);

    /**
     * Returns list of all items in faktura.

     * @param fakturaId Id of faktura containing items.
     * @return list of all items in faktura.
     */
    List<FakturaItem> getByFakturaId(String fakturaId);

    /**
     * Deletes all items in faktura.
     * Method should be called after deleting faktura.

     * @param fakturaId Id of faktura containing items.
     */
    void deleteAllForFaktura(String fakturaId);

    /**
     * Checks if fakturaItem with matching id exists in database.

     * @param fakturaItemId id of the searched fakturaItem.
     * @return true if fakturaItem with matching id exists in database.
     */
    boolean checkIfInExist(String fakturaItemId);

    /**
     * Method returns id for faktura item not yet present in database.

     * @return id for faktura item not yet present in database.
     */
    String getNextId();
}

