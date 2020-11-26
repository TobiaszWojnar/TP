package printers;

import dao.ClientDao;
import model.Client;

/**
 * The <code>ClientPrinter</code> is responsible for enabling printing all {@link Client} or a specific one.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>ClientPrinter</code> intakes items form database {@link ClientDao}
 * and prints then on standard output.
 * It has methods for printing <code>Client</code> objects,
 * prints form database by Id and for printing all.

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class ClientPrinter {
    /**
     * Database access object.
     */
    private final ClientDao clientDao;

    /**
     * Constructor of printer.
     * Requires only database.

     * @param clientDao database of {@link Client}.
     */
    public ClientPrinter(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    /**
     * Prints on standard output {@link Client}.

     * @param client client has 5 parameters:
     *               Id, Nip, Address, City and Postal Code.
     */
    public void print(Client client) {
        System.out.println(client.getName());
        System.out.println("NIP\t" + client.getNip());
        System.out.println("Street\t" + client.getAddress());
        System.out.println("City\t" + client.getCity() + "\tPostal Code\t" + client.getPostal());
    }

    /**
     * Prints on standard output {@link Client}.

     * @param personId Id of {@link Client}.
     */
    public void print(String personId) {
        Client person = clientDao.get(personId);
        print(person);
    }

    /**
     * Prints whole database.
     */
    public void printAll() {
        for (Client person : clientDao.getAll()) {
            print(person);
        }
    }
}
