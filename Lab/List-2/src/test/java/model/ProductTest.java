package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private final String testProductId = "product1";
    private final String testProductName = "product first";
    private final float testNettoPrice = 10;
    private final float testTaxRate = 23;

    @Test
    public void testGetProductName() {
        Product product = createProductUnderTest();
        assertEquals(product.getProductName(),testProductName);
    }

    @Test
    public void testGetNettoPrice() {
        Product product = createProductUnderTest();
        assertEquals(product.getNettoPrice(),testNettoPrice);
    }

    @Test
    public void testGetTaxRate() {
        Product product = createProductUnderTest();
        assertEquals(product.getTaxRate(),testTaxRate);
    }

    @Test
    public void testGetProductId() {
        Product product = createProductUnderTest();
        assertEquals(product.getProductId(),testProductId);
    }

    protected Product createProductUnderTest() {
        return new Product( testProductId, testProductName, testNettoPrice, testTaxRate) ;
    }
}