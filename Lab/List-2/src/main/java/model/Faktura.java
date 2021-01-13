package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.time.LocalDate.now;

/**
 * The <code>Faktura</code> is simple data class type
 * in application issuing invoices (Polish: <b>main.model.Faktura</b>).
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>Faktura</code> has 5 parameters and get methods for them:
 *  fakturaNr, dateOfIssue, sellerId, buyerId and fakturaItems.
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */

public class Faktura {
    /**
     * Faktura id.
     */
    private final String fakturaNr;
    /**
     * Faktura day of issue.
     */
    private final LocalDate dateOfIssue;
    /**
     * Person or institution issuing invoice.
     */
    private final String sellerId;
    /**
     * Person or institution to whom the invoice was issued.
     */
    private final String buyerId;

    /**
     * List of all goods and services.
     */
    private List<FakturaItem> fakturaItems;

    /**
     * Status of payment.
     */
    enum Status {
        PAID, UNPAID
    }

    /**
     * Status of payment.
     */
    private Status status;

    /**
     * Faktura constructor.

     * @param fakturaNr Faktura id.
     * @param sellerId Person or institution issuing invoice.
     * @param buyerId Person or institution to whom the invoice was issued.
     */
    public Faktura(String fakturaNr, String sellerId, String buyerId) {
        this.fakturaNr = fakturaNr;
        dateOfIssue = now();
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        fakturaItems = new ArrayList<>();
        status = Faktura.Status.UNPAID;
    }

    /**
     * @return Faktura id.
     */
    public String getFakturaId() {
        return fakturaNr;
    }

    /**
     * @return Faktura day of issue.
     */
    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    /**
     * @return Person or institution issuing invoice.
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * @return Person or institution to whom the invoice was issued.
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * @return List of all goods and services.
     */
    public List<FakturaItem> getItems() {
        return fakturaItems;
    }

    /**
     * @param fakturaItems is set as list of all goods and services.
     */
    public void setFakturaItems(List<FakturaItem> fakturaItems) {
        this.fakturaItems = fakturaItems;
    }

    /**
     * @return Status of payment.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param newStatus Status of payment.
     */
    public void setStatus(String newStatus) { //TODO implement
        if ("yes".equals(newStatus) || "paid".equals(newStatus)) {
            status = Status.PAID;
        } else if ("no".equals(newStatus) || "unpaid".equals(newStatus)) {
            status = Status.UNPAID;
        }
    }

}
