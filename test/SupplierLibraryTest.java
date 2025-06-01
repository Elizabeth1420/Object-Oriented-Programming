package test;

import app.SupplierLibrary;

import app.Supplier;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class SupplierLibraryTest {

  @Test
  public void TestAddSupplierManually() {
    SupplierLibrary supplierLibrary = new SupplierLibrary();
    
    //Simulate adding a valid supplier name (string only)

    boolean added = supplierLibrary.addSupplier("Lola Ltd");
    assertTrue("addSupplier should remain true for valid input", added);

  }

  public void testInitialSupplierList() {
    SupplierLibrary supplierLibrary = new SupplierLibrary();
    ArrayList<Supplier> suppliers = supplierLibrary.getSuppliers();
    
    assertEquals("Should start with 5 default suppliers", 5, suppliers.size());
    assertEquals("First supplier should be Lola Ltd", "Lola Ltd", suppliers.get(0).getSupplierName());

  }

  public void TestRemoveExistingSupplierByName() {
    SupplierLibrary supplierLibrary = new SupplierLibrary();

    int initialSize = supplierLibrary.getSuppliers().size();

    ArrayList<Supplier> removed = supplierLibrary.removeSupplier("Lola Ltd", true);

    // verify the supplier list size decreased
    assertEquals("Supplier should be removed", initialSize - 1, supplierLibrary.getSuppliers().size());

    // check the removed list contains the correct supplier
    assertEquals("Should remove one supplier", 1, removed.size());
    assertEquals("Removed supplier should be 'Lola Ltd'", "Lola Ltd", removed.get(0).getSupplierName());

  }

  // testing removing a supplier that does not exist

  public void testRemoveNonExistentSupplierByName() {
    SupplierLibrary supplierLibrary = new SupplierLibrary();

    int initialSize = supplierLibrary.getSuppliers().size();

    ArrayList<Supplier> removed = supplierLibrary.removeSupplier("NonExistent", true);

    // Supplier list size should remain the same
    assertEquals("Supplier list should remain unchanged", initialSize, supplierLibrary.getSuppliers().size());

    // Removed list should be empty
    assertTrue("No Suppliers should be removed", removed.isEmpty());
  }


}


