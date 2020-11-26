package dao.memory;


import dao.ClientDao;
import model.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>ClientMemoryDao</code> implements data access object interface for {@link Client}.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>ClientMemoryDao</code> implements data access object interface for {@link Client} as List.
 * Enables separation of implemented database and logic of application
 * (Low Coupling rule form GRASP methodology).
 * <code>main.dao.ClientDao</code> has 5 methods:
 * delete(), add(), getById(), getAll() and checkIfInExist()
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class ClientMemoryDao implements ClientDao {
    /**
     * Database stored as List
     */
    private final List<Client> clientList;

    /**
     * Initialize list as ArrayList
     */
    public ClientMemoryDao() {
        clientList = new ArrayList<>();
    }

    /**
     * Deletes clients from list with matching id.
     * If none found does nothing.

     * @param clientId id of the client to be deleted.
     */
    @Override
    public void delete(String clientId) {
        clientList.remove(get(clientId));
    }

    /**
     * Inserts client to list.

     * @param client client to be inserted into database.
     * @return id of the added client.
     */
    @Override
    public String add(Client client) {
        clientList.add(client);
        return client.getId();
    }

    /**
     * Returns client with matching id.

     * @param clientId id of the searched client.
     * @return client if one with matching id exists or null
     */
    @Override
    public Client get(String clientId) {
        for (Client person : clientList) {
            if (person.getId().equals(clientId)) {
                return person;
            }
        }
        return null;
    }

    /**
     * Returns list of all client.

     * @return list of all client.
     */
    @Override
    public List<Client> getAll() {
        return clientList;
    }

    /**
     * Checks if client with matching id exists in database.

     * @param clientId id of the searched client.
     * @return true if client with matching id exists in database.
     */
    @Override
    public boolean checkIfInExist(String clientId) {
        boolean exist = false;
        for (Client client : clientList) {
            if (client.getId().equals(clientId)) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}
