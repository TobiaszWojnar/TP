package dao.memory;

import dao.FakturaDao;
import model.Faktura;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>FakturaMemoryDao</code> implements data access object interface for {@link Faktura}.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>FakturaMemoryDao</code> implements data access object interface for {@link Faktura} as List.
 * Enables separation of implemented database and logic of application
 * (Low Coupling rule form GRASP methodology).
 * <code>main.dao.FakturaDao</code> has 5 methods:
 * delete(), add(), getById(), getAll() and checkIfInExist()
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class FakturaMemoryDao implements FakturaDao {

    /**
     * Database stored as List
     */
    private final List<Faktura> fakturaArrayList;

    /**
     * Initialize list as ArrayList
     */
    public FakturaMemoryDao() {
        fakturaArrayList = new ArrayList<>();
    }

    /**
     * Deletes faktura from database with matching id.
     * If none found does nothing.

     * @param fakturaId id of the article to be deleted.
     */
    @Override
    public void delete(String fakturaId) {
        fakturaArrayList.remove(get(fakturaId));
    }

    /**
     * Inserts faktura to database.

     * @param faktura faktura to be inserted into database.
     * @return id of the added faktura.
     */
    @Override
    public String add(Faktura faktura) {
        fakturaArrayList.add(faktura);
        return faktura.getFakturaId();
    }

    /**
     * Returns faktura with matching id.

     * @param fakturaId id of the searched faktura.
     * @return faktura if one with matching id exists or null.
     */
    @Override
    public Faktura get(String fakturaId) {
        Faktura fakturaTemp = null;
        for (Faktura faktura : fakturaArrayList) {
            if (faktura.getFakturaId().equals(fakturaId)) {
                fakturaTemp = faktura;
            }
        }
        return fakturaTemp;
    }

    /**
     * Returns list of all faktura.

     * @return list of all faktura.
     */
    @Override
    public List<Faktura> getAll() {
        return fakturaArrayList;
    }

    /**
     * Returns list of all faktura issued for client.

     * @param clientId Id of client for whom faktura were issued.
     * @return list of all faktura issued for client
     */
    @Override
    public List<Faktura> getAllForClient(String clientId) {
        List<Faktura> tempList = new ArrayList<>();
        for (Faktura faktura : fakturaArrayList) {
            if (faktura.getBuyerId().equals(clientId)) {
                tempList.add(faktura);
            }
        }
        return tempList;
    }

    /**
     * Checks if faktura with matching id exists in database.

     * @param fakturaId id of the searched faktura.
     * @return true if faktura with matching id exists in database.
     */
    @Override
    public boolean checkIfInExist(String fakturaId) {
        boolean exist = false;
        for (Faktura faktura : fakturaArrayList) {
            if (faktura.getFakturaId().equals(fakturaId)) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}
