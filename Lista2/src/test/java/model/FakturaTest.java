package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.*;

public class FakturaTest {
    private final String testFakturaNr = "faktura1";
    private final String testSellerId = "seller1";
    private final String testBuyerId = "buyer1";

    @Test
    public void testGetFakturaId() {
        Faktura faktura = createFakturaUnderTest();
        assertEquals(faktura.getFakturaId(),testFakturaNr);
    }

    @Test
    public void testGetDateOfIssue() {
        Faktura faktura = createFakturaUnderTest();
        assertEquals(faktura.getDateOfIssue(),now());
    }

    @Test
    public void testGetSellerId() {
        Faktura faktura = createFakturaUnderTest();
        assertEquals(faktura.getSellerId(),testSellerId);
    }

    @Test
    public void testGetBuyerId() {
        Faktura faktura = createFakturaUnderTest();
        assertEquals(faktura.getBuyerId(),testBuyerId);
    }

    @Test
    public void testGetItems() {
        Faktura faktura = createFakturaUnderTest();
        assertEquals(faktura.getItems(),new ArrayList<>());
    }
    protected Faktura createFakturaUnderTest() {
        return new Faktura(
                testFakturaNr, testSellerId, testBuyerId
        );
    }
}