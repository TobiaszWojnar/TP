package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FakturaItemTest {

    private final String testFakturaId = "faktura1";
    private final String testFakturaItemId = "item1";
    private final float testQuantity = 5;
    private final float testNettoPrice = 10;
    private final float testTaxRate = 23;

    @Test
    public void getFakturaId() {
        FakturaItem fakturaItem = createProductUnderTest();
        assertEquals(fakturaItem.getFakturaId(),testFakturaId);
    }

    @Test
    public void getFakturaItemId() {
        FakturaItem fakturaItem = createProductUnderTest();
        assertEquals(fakturaItem.getFakturaItemId(),testFakturaItemId);
    }

    @Test
    public void getQuantity() {
        FakturaItem fakturaItem = createProductUnderTest();
        assertEquals(fakturaItem.getQuantity(),testQuantity);
    }

    @Test
    public void getNettoValue() {
        FakturaItem fakturaItem = createProductUnderTest();
        assertEquals(fakturaItem.getNettoValue(),testQuantity*testNettoPrice);
    }

    @Test
    public void getTaxValue() {
        FakturaItem fakturaItem = createProductUnderTest();
        assertEquals(fakturaItem.getTaxValue(),testQuantity*testTaxRate*testNettoPrice/100);
    }

    @Test
    public void getBruttoValue() {
        FakturaItem fakturaItem = createProductUnderTest();
        Float brutto = testQuantity*testNettoPrice*(testTaxRate/100+1);
        assertEquals(brutto,fakturaItem.getBruttoValue());
    }

    protected FakturaItem createProductUnderTest() {
        String testProductId = "product1";
        String testProductName = "product first";
        return new FakturaItem(
                testFakturaId, testFakturaItemId,
                testProductId, testProductName,
                testQuantity, testNettoPrice, testTaxRate
        );
    }
}