import dao.ClientDao;
import dao.FakturaDao;
import dao.FakturaItemDao;
import dao.ProductDao;
import dao.memory.ClientMemoryDao;
import dao.memory.FakturaItemMemoryDao;
import dao.memory.FakturaMemoryDao;
import dao.memory.ProductMemoryDao;
import gui.CommandLineMenu;
import operations.ClientOperations;
import operations.FakturaItemOperations;
import operations.FakturaOperations;
import operations.ProductOperations;
import printers.ClientPrinter;

/**
 * The <code>InvoiceApplication</code> is simple application issuing invoices (Polish: <b>main.model.Faktura</b>).
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>InvoiceApplication</code> mocking object databases, GUI and operational classes.
 *     The mocking GUI is a {@link CommandLineMenu}.
 *     In this applications there are important types of data:
 *     {@link model.Client}, {@link model.Product},
 *     {@link model.Faktura} and {@link model.FakturaItem}.
 *     For each of those there are operating classes
 *     ({@link ClientOperations}, {@link ProductOperations},
 *     {@link FakturaOperations} and {@link FakturaItemOperations}),
 *     data access object interfaces
 *     ({@link ClientDao}, {@link ProductDao},
 *     {@link FakturaDao} and {@link FakturaItemDao}).
 *     Application does not have "proper" database
 *     but a mocking object implementation using lists with classes:
 *     {@link ClientMemoryDao}, {@link ProductMemoryDao},
 *     {@link FakturaMemoryDao} and {@link FakturaItemMemoryDao}.
 *     In <code>main.InvoiceApplication</code> we start
 *     our "databases", operational classes and menu.
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class InvoiceApplication {

    private final CommandLineMenu commandLineMenu;

    /**
     * Creates mocking object databases, GUI and operational classes.
     */
    public InvoiceApplication () {

        ClientDao clientDao = new ClientMemoryDao();
        ProductDao productDao = new ProductMemoryDao();
        FakturaItemDao fakturaItemDao = new FakturaItemMemoryDao();
        FakturaDao fakturaDao = new FakturaMemoryDao();

        ClientOperations clientOperations = new ClientOperations(clientDao);
        ProductOperations productOperations = new ProductOperations(productDao);
        FakturaItemOperations fakturaItemOp = new FakturaItemOperations(fakturaItemDao, productDao);
        FakturaOperations fakturaOperations = new FakturaOperations(fakturaDao, clientDao, fakturaItemDao);

        ClientPrinter clientPrinter = new ClientPrinter(clientDao);
        commandLineMenu = new CommandLineMenu(
                clientOperations, productOperations, fakturaOperations, fakturaItemOp, clientPrinter);
    }

    /**
     * <code>run</code> method calls {@link CommandLineMenu#run()}.
     */
    public void run() {
        commandLineMenu.run();
    }

    /**
     * Creates <code>main.InvoiceApplication</code> and runs it.

     * @param args is not used.
     */
    public static void main(String[] args) { //NOPMD
        InvoiceApplication application = new InvoiceApplication();
        application.run();
    }
}
