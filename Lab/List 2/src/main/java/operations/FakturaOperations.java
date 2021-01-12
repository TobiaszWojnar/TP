package operations;

import dao.ClientDao;
import dao.FakturaDao;
import dao.FakturaItemDao;
import model.Faktura;
import printers.ClientPrinter;
import printers.FakturaItemPrinter;

import java.io.BufferedReader;
/**
 * The <code>FakturaOperations</code> is responsible for sending requests form GUI to {@link Faktura} database.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>FakturaOperations</code> enables adding, deleting and printing items from {@link FakturaDao}.
 * Using operation class enables high cohesion code.
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class FakturaOperations {
    /**
     * Database access object.
     */
    private final FakturaDao fakturaDao;
    /**
     * Database access object.
     */
    private final ClientDao clientDao;
    /**
     * Database access object.
     */
    private final FakturaItemDao fakturaItemDao;
    /**
     * Printer of  Client database.
     */
    private final ClientPrinter clientPrinter;

    /**
     * Constructor requires three databases.
     * It initializes {@link ClientPrinter}

     * @param fakturaDao database of {@link FakturaDao}.
     * @param clientDao database of {@link ClientDao}.
     * @param fakturaItemDao database of {@link FakturaItemDao}.
     */
    public FakturaOperations(
            FakturaDao fakturaDao, ClientDao clientDao, FakturaItemDao fakturaItemDao) {
        this.fakturaDao = fakturaDao;
        this.clientDao = clientDao;
        this.fakturaItemDao = fakturaItemDao;

        clientPrinter = new ClientPrinter(clientDao);
    }

    /**
     * Reads all information required to make new {@link Faktura}.

     * @param reader passing it as a parameter provides one application-wide reader.
     */
    public void add(BufferedReader reader) {
        try {
            System.out.println("Add new faktura to database.");
            System.out.println("Enter faktura id:");
            String fakturaId = reader.readLine();
            if (fakturaDao.checkIfInExist(fakturaId)) {
                System.out.println("Id exist in database. Addition unsuccessful");
            } else {
                System.out.println("Enter buyer id:");
                String buyerId = reader.readLine();
                if (clientDao.checkIfInExist(buyerId)) {
                    System.out.println("Enter Enter seller id:");
                    String sellerId = reader.readLine();
                    if (clientDao.checkIfInExist(sellerId)) {
                        fakturaDao.add(new Faktura(fakturaId, sellerId, buyerId));
                        System.out.println("addition successful");
                    } else {
                        System.out.println("Id not exist in database. Addition unsuccessful");
                    }
                } else {
                    System.out.println("Id not exist in database. Addition unsuccessful");
                }
            }
        } catch (Exception e) {
            System.out.println("Unsupported datatype - " + e.getMessage());
            System.out.println("Addition unsuccessful.");
        }

    }

    /**
     * Deletes form database faktura with matching Id and all its items.

     * @param fakturaId id of faktura is a short string of characters given on entering new faktura to database.
     */
    public void delete(String fakturaId) {
        fakturaDao.delete(fakturaId);
        fakturaItemDao.deleteAllForFaktura(fakturaId);
    }

    /**
     * Prints on standard output {@link Faktura}.
     * Prints {@link Faktura} parameters in following lines.

     * @param faktura to be printed.
     */
    public void print (Faktura faktura) {
        System.out.println("Faktura nr\t" + faktura.getFakturaId());
        System.out.println("Date of issue\t" + faktura.getDateOfIssue());
        System.out.println("Seller\n");
        clientPrinter.print(clientDao.get(faktura.getSellerId()));
        System.out.println("Buyer\n");
        clientPrinter.print(clientDao.get(faktura.getBuyerId()));
        System.out.println("\nStatus\t" + faktura.getStatus());

        FakturaItemPrinter.printItemsForFaktura(faktura);
    }

    /**
     * Prints on standard output {@link Faktura}.

     * @param fakturaId Id of {@link Faktura}.
     */
    public void print(String fakturaId) {
        Faktura faktura = fakturaDao.get(fakturaId);
        faktura.setFakturaItems(fakturaItemDao.getByFakturaId(fakturaId));
        print(faktura);
    }

    /**
     * Prints whole database.
     */
    public void printAll() {
        for (Faktura faktura : fakturaDao.getAll()) {
            faktura.setFakturaItems(fakturaItemDao.getByFakturaId(faktura.getFakturaId()));
            print(faktura);
        }
    }

    /**
     * Prints all faktura's issued for specified client.

     * @param clientId of a client.
     */
    public void printAllFakturaForClient(String clientId) {
        for (Faktura faktura : fakturaDao.getAllForClient(clientId)) {
            faktura.setFakturaItems(fakturaItemDao.getByFakturaId(faktura.getFakturaId()));
            print(faktura);
        }
    }

    /**
     * @param fakturaId Id of faktura to be checked for existing in database.
     * @return true if faktura with specific id exists.
     */
    public boolean checkIfInExist(String fakturaId) {
        return fakturaDao.checkIfInExist(fakturaId);
    }

}
