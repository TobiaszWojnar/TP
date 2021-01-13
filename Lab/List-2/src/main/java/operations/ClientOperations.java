package operations;

import dao.ClientDao;
import model.Client;

import java.io.BufferedReader;

/**
 * The <code>ClientOperations</code> is responsible for sending requests form GUI to {@link Client} database.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>ClientOperations</code> enables adding and deleting items from {@link ClientDao}.
 * Using operation class enables high cohesion code.
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class ClientOperations {
    /**
     * Database access object.
     */
    private final ClientDao clientDao;

    /**
     * Constructor requires only database.

     * @param clientDao database of {@link Client}.
     */
    public ClientOperations(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    /**
     * Reads all information required to make new {@link Client}.

     * @param reader passing it as a parameter provides one application-wide reader.
     */
    public void add(BufferedReader reader) {
        try {
            System.out.println("Add client");
            System.out.println("Enter a name:");
            String clientName = reader.readLine();
            System.out.println("Enter a id:");
            String clientId = reader.readLine();
            if (clientDao.checkIfInExist(clientId)) {
                System.out.println("Id exist in database. Addition unsuccessful");
            } else {
                System.out.println("Enter nip (10-digit number):");
                String nip = reader.readLine();
                System.out.println("Enter address:");
                String address = reader.readLine();
                System.out.println("Enter city:");
                String city = reader.readLine();
                System.out.println("Enter postal code:");
                String postal = reader.readLine();
                clientDao.add(new Client(clientId, clientName, nip, address, city, postal));
                System.out.println("addition successful");
            }
        } catch (Exception e) {
            System.out.println("Unsupported datatype - " + e.getMessage());
            System.out.println("Addition unsuccessful");
        }
    }

    /**
     * Deletes form database client with matching Id.

     * @param clientId id of client is a short string of characters given on entering new client to database.
     */
    public void delete(String clientId) {
        clientDao.delete(clientId);
    }

}
