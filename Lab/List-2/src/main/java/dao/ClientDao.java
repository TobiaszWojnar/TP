package dao;

import model.Client;

import java.util.List;

/**
 * <code>main.dao.ClientDao</code> is data access object interface for {@link Client}.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>main.dao.ClientDao</code> is data access object interface for {@link Client}.
 * Enables separation of implemented database and logic of application
 * (Low Coupling rule form GRASP methodology).
 * <code>main.dao.ClientDao</code> has 5 methods:
 * delete(), add(), getById(), getAll() and checkIfInExist()
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public interface ClientDao {

    /**
     * Deletes clients from database with matching id.
     * If none found does nothing.

     * @param clientId id of the client to be deleted.
     */
    void delete(String clientId);

    /**
     * Inserts client to database.

     * @param client client to be inserted into database.
     * @return id of the added client.
     */
    String add(Client client);

    /**
     * Returns client with matching id.

     * @param clientId id of the searched client.
     * @return client if one with matching id exists or null
     */
    Client get(String clientId);

    /**
     * Returns list of all client.

     * @return list of all client.
     */
    List<Client> getAll();

    /**
     * Checks if client with matching id exists in database.

     * @param clientId id of the searched client.
     * @return true if client with matching id exists in database.
     */
    boolean checkIfInExist(String clientId);

}
