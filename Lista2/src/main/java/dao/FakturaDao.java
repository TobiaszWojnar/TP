package dao;

import model.Faktura;

import java.util.List;

/**
 * <code>main.dao.FakturaDao</code> is data access object interface for {@link Faktura}.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>main.dao.FakturaDao</code> is data access object interface for {@link Faktura}.
 * Enables separation of implemented database and logic of application
 * (Low Coupling rule form GRASP methodology).
 * <code>main.dao.FakturaDao</code> has 5 methods:
 * delete(), add(), getById(), getAll() and checkIfInExist()
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public interface FakturaDao {

    /**
     * Deletes faktura from database with matching id.
     * If none found does nothing.

     * @param fakturaId id of the article to be deleted.
     */
    void delete(String fakturaId);

    /**
     * Inserts faktura to database.

     * @param faktura faktura to be inserted into database.
     * @return id of the added faktura.
     */
    String add(Faktura faktura);

    /**
     * Returns faktura with matching id.

     * @param fakturaId id of the searched faktura.
     * @return faktura if one with matching id exists or null.
     */
    Faktura get(String fakturaId);

    /**
     * Returns list of all faktura.

     * @return list of all faktura.
     */
    List<Faktura> getAll();

    /**
     * Returns list of all faktura issued for client.

     * @param clientId Id of client for whom faktura were issued.
     * @return list of all faktura issued for client
     */
    List<Faktura> getAllForClient(String clientId);

    /**
     * Checks if faktura with matching id exists in database.

     * @param fakturaId id of the searched faktura.
     * @return true if faktura with matching id exists in database.
     */
    boolean checkIfInExist(String fakturaId);
}

