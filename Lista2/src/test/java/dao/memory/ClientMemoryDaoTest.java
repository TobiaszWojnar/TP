package dao.memory;

import model.Client;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ClientMemoryDaoTest {

    private final String clientId = "client1";

    @Test
    void testAddIdMatching() {
        ClientMemoryDao clientMemoryDao = new ClientMemoryDao();
        assertEquals(clientId,clientMemoryDao.add(createClientUnderTest()));
    }
    @Test
    void testGetNull() {
        ClientMemoryDao clientMemoryDao = new ClientMemoryDao();
        assertNull(clientMemoryDao.get(clientId));
    }
    @Test
    void testGetClient() {
        ClientMemoryDao clientMemoryDao = new ClientMemoryDao();
        clientMemoryDao.add(createClientUnderTest());
        assertNotNull(clientMemoryDao.get(clientId));
    }


    @Test
    void testDelete() {
        ClientMemoryDao clientMemoryDao = new ClientMemoryDao();
        clientMemoryDao.add(createClientUnderTest());
        clientMemoryDao.delete(clientId);
        assertNull(clientMemoryDao.get(clientId));
    }

    @Test
    void testGetAllEmpty() {
        ClientMemoryDao clientMemoryDao = new ClientMemoryDao();
        assertEquals(clientMemoryDao.getAll(),new ArrayList<>());
    }
    @Test
    void testGetAllNotEmpty() {
        ClientMemoryDao clientMemoryDao = new ClientMemoryDao();
        clientMemoryDao.add(createClientUnderTest());
        assertNotNull(clientMemoryDao.getAll());
    }

    @Test
    void testCheckIfInExistEmpty() {
        ClientMemoryDao clientMemoryDao = new ClientMemoryDao();
        assertFalse(clientMemoryDao.checkIfInExist(clientId));
    }

    @Test
    void testCheckIfInExistFalse() {
        ClientMemoryDao clientMemoryDao = new ClientMemoryDao();
        clientMemoryDao.add(createClientUnderTest());
        assertFalse(clientMemoryDao.checkIfInExist(clientId + "1"));
    }

    @Test
    void testCheckIfInExistTrue() {
        ClientMemoryDao clientMemoryDao = new ClientMemoryDao();
        clientMemoryDao.add(createClientUnderTest());
        assertTrue(clientMemoryDao.checkIfInExist(clientId));
    }

    protected Client createClientUnderTest() {
        String clientAddress = "test street";
        String clientCity = "Example town";
        String clientNip = "1234567890";
        String clientName = "First client";
        String clientPostal = "00-000";
        return new Client(
                clientId, clientName,
                clientNip, clientAddress,
                clientCity, clientPostal
        );
    }
}