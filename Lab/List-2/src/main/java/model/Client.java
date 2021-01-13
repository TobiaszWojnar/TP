package model;

/**
 * The <code>Client</code> is simple data class type
 * in application issuing invoices (Polish: <b>main.model.Faktura</b>).
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>Client</code> has 6 parameters and get methods for them:
 *  clientId, client name, nip, address, city and postal code.
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class Client {
    /**
     * Client identification.
     */
    private final String clientId;
    /**
     * Client full name.
     */
    private final String name;
    /**
     * Client tax identification number.
     */
    private final String nip;
    /**
     * Client address.
     */
    private final String address;
    /**
     * Client city.
     */
    private final String city;
    /**
     * Client postal address.
     */
    private final String postal;

    /**
     * Client constructor.

     * @param clientId Client identification.
     * @param name Client full name.
     * @param nip Client tax identification number.
     * @param address Client address.
     * @param city Client city.
     * @param postal Client postal address.
     */
    public Client(
            String clientId, String name, String nip, String address, String city, String postal
    ) { //NOPMD
        this.clientId = clientId;
        this.name = name;
        this.nip = nip;
        this.address = address;
        this.city = city;
        this.postal = postal;
    }

    /**
     * @return Client full name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Client tax identification number.
     */
    public String getNip() {
        return nip;
    }

    /**
     * @return Client address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return Client city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @return Client postal address.
     */
    public String getPostal() {
        return postal;
    }

    /**
     * @return Client Id.
     */
    public String getId() {
        return clientId;
    }

}
