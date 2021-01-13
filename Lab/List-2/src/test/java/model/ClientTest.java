package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    private final String clientId = "client1";
    private final String clientName = "First client";
    private final String clientNip = "1234567890";
    private final String clientAddress = "test street";
    private final String clientCity = "Example town";
    private final String clientPostal = "00-000";

    @Test
    public void testGetName() {
        Client client = createClientUnderTest();
        assertEquals(client.getName(),clientName);
    }

    @Test
    public void testGetNip() {
        Client client = createClientUnderTest();
        assertEquals(client.getNip(),clientNip);
    }

    @Test
    public void testGetAddress() {
        Client client = createClientUnderTest();
        assertEquals(client.getAddress(),clientAddress);
    }

    @Test
    public void testGetCity() {
        Client client = createClientUnderTest();
        assertEquals(client.getCity(), clientCity);
    }

    @Test
    public void testGetPostal() {
        Client client = createClientUnderTest();
        assertEquals(client.getPostal(), clientPostal);
    }

    @Test
    public void testGetId() {
        Client client = createClientUnderTest();
        assertEquals(client.getId(), clientId);
    }

    protected Client createClientUnderTest() {
        return new Client(
                clientId, clientName,
                clientNip, clientAddress,
                clientCity, clientPostal
        );
    }
}