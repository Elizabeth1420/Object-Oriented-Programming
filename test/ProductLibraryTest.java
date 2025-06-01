package test;

import app.Product;
import app.ProductLibrary;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProductLibraryTest {

    @Test
    //testing a known product name returns a valid product object 
    public void testGetExistingProductByName() {
        Product product = ProductLibrary.getProductByName("Shampoo");
        assertNotNull(product);
        assertEquals("Shampoo", product.getProductName());
    }
    
    //testing an invalid product name returns null
    public void testGetNonExistingProductByName() {
        Product product = ProductLibrary.getProductByName("NonExistentProduct");
        assertNull("Expected null for a product that does not exist", product);
    }

    //testing that the product list is not empty
    public void testGetAllProductsReturnsList() {
        assertFalse("Product list should not be empty", ProductLibrary.getAllProducts(). isEmpty());
    }
}
