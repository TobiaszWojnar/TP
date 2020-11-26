package dao.memory;

import dao.FakturaItemDao;
import model.FakturaItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <code>FakturaItemMemoryDao</code> implements
 * data access object interface for {@link FakturaItem}.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>FakturaItemMemoryDao</code> implements
 * data access object interface for {@link FakturaItem} as List.
 * Enables separation of implemented database and logic of application
 * (Low Coupling rule form GRASP methodology).
 * <code>main.dao.FakturaItemDao</code> has 5 methods:
 * delete(), add(), getById(), getAll() and checkIfInExist()
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class FakturaItemMemoryDao implements FakturaItemDao {

    /**
     * Database stored as List.
     */
    private final List<FakturaItem> allFakturaItems;

    /**
     * Initialize list as ArrayList.
     */
    public FakturaItemMemoryDao() {
        allFakturaItems = new ArrayList<>();
    }

    /**
     * Deletes fakturaItem from database with matching id.
     * If none found does nothing.

     * @param fakturaItemId id of the fakturaItem to be deleted.
     */
    @Override
    public void delete(String fakturaItemId) {
        allFakturaItems.remove(get(fakturaItemId));
    }

    /**
     * Inserts fakturaItem to database.

     * @param fakturaItem fakturaItem to be inserted into database.
     * @return id of the added fakturaItem.
     */
    @Override
    public String add(FakturaItem fakturaItem) {
        allFakturaItems.add(fakturaItem);
        return fakturaItem.getFakturaItemId();
    }

    /**
     * Returns fakturaItem with matching id.

     * @param fakturaItemId id of the searched fakturaItem.
     * @return fakturaItem if one with matching id exists or null
     */
    @Override
    public FakturaItem get(String fakturaItemId) {
        for (FakturaItem fakturaItem : allFakturaItems) {
            if (fakturaItem.getFakturaItemId().equals(fakturaItemId)) {
                return fakturaItem;
            }
        }
        return null;
    }

    /**
     * Returns list of all items in faktura.

     * @param fakturaId Id of faktura containing items.
     * @return list of all items in faktura.
     */
    @Override
    public List<FakturaItem> getByFakturaId(String fakturaId) {
        List<FakturaItem> itemsList = new LinkedList<>();
        for (FakturaItem fakturaItem : allFakturaItems) {
            if (fakturaItem.getFakturaId().equals(fakturaId)) {
                itemsList.add(fakturaItem);
            }
        }
        return itemsList;
    }

    /**
     * Deletes all items in faktura.
     * Method should be called after deleting faktura.

     * @param fakturaId Id of faktura containing items.
     */
    @Override
    public void deleteAllForFaktura(String fakturaId) {
        for (FakturaItem fakturaItem : getByFakturaId(fakturaId)) {
            allFakturaItems.remove(fakturaItem);
        }
    }

    /**
     * Checks if fakturaItem with matching id exists in database.

     * @param fakturaItemId id of the searched fakturaItem.
     * @return true if fakturaItem with matching id exists in database.
     */
    @Override
    public boolean checkIfInExist(String fakturaItemId) {
        boolean exist = false;
        for (FakturaItem fakturaItem : allFakturaItems) {
            if (fakturaItem.getFakturaItemId().equals(fakturaItemId)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    /**
     * Method returns id for faktura item not yet present in database.

     * @return id for faktura item not yet present in database.
     */
    @Override
    public String getNextId() {
        int nextId = allFakturaItems.size();
        while (checkIfInExist(String.valueOf(nextId))) {
            nextId++;
        }
        return String.valueOf(nextId);
    }

}
