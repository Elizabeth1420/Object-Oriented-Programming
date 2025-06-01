package app;

import java.util.ArrayList;
import java.util.Scanner;


public class SupplierLibrary {
    private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
    public SupplierLibrary() {
        suppliers.add(new Supplier(1110, "Lola Ltd", 868878080));
        suppliers.add(new Supplier(1111, "Carriers ltd", 784830373));
        suppliers.add(new Supplier(1112, "The Hair Supplier", 749383902));
        suppliers.add(new Supplier(1113, "Hair for Us", 797382101));
        suppliers.add(new Supplier(1114, "New Wave", 758820102));

    }

    public Supplier getSupplierByName(String name) {
        for (Supplier supplier : suppliers) {
            if (supplier.getSupplierName().equalsIgnoreCase(name)) {
                return supplier;
            }
        }
        return null;
    }

    // Option 1 - Adding suppliers

    public void addSuppliers() { // method to add suppliers in the library
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the Supplier ID?");
        int supplierID = scanner.nextInt();

        System.out.println("What is the Supplier Name?");
        String supplierName = scanner.next();

        System.out.println("What is the Contact Number of the supplier?");
        int supplierContactNumber = scanner.nextInt();

        Supplier userSupplier = new Supplier(supplierID, supplierName, supplierContactNumber); // setting
                                                                                                        // arraylist of
                                                                                              // //
                                                                                                        // supplierID,
                                                                                                        // //
                                                                                                        // supplierName,
                                                                                                        // supperlierContactNumber
                                                                                                        // & Order Date
                                                                                                        // //
                                                                                                        // supplierContactInfo
                                                                                                        // in // library
        suppliers.add(userSupplier);

    }

    public boolean addSupplier(String supplier) {
        if (supplier == null || supplier.isEmpty()) {
            return false;
        }

        //suppliers.add(supplier);
        return true;

    }
    // Printing out added suppliers

    public void printSuppliers() {
        for (Supplier printSuppliers : suppliers) {
            System.out.println(" Supplier ID: " + printSuppliers.getSupplierId() + ", Supplier Name: "
                    + printSuppliers.getSupplierName() + ", Contact Info: "
                    + printSuppliers.getSupplierContactNumber());
        }
    }

    // Option 2 - Removing suppliers

    public void removeSupplier() { // method to remove supplier from the library
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1 to remove by Supplier Name");
        int userInput = scanner.nextInt();
        scanner.nextLine();
        if (userInput == 1) {
            System.out.println("What is the name of the Supplier you'd like to remove?"); // user inputing 1 to remove a
                                                                                          // supplier

            String supplierName = scanner.nextLine(); // user input
            ArrayList<Supplier> removedSuppliers = removeSupplier(supplierName, true);
            printRemovedSuppliers(removedSuppliers); // prinitng out removed suppliers
        } else {
            System.out.println("Invalid input");
        }
    }

    public void printRemovedSuppliers(ArrayList<Supplier> removedSuppliers) {
        for (Supplier removedSupplier : removedSuppliers) {
            System.out.println("You have successfully removed a supplier");
            System.out.println("Removed Supplier ID: " + removedSupplier.getSupplierId() + ", Supplier Name: "
                    + removedSupplier.getSupplierName() + ", Supplier Contact Info: "
                    + removedSupplier.getSupplierContactNumber());
        }
    }

    public ArrayList<Supplier> removeSupplier(String supplierToRemove, boolean isSupplierName) {
        ArrayList<Supplier> removedSuppliers = new ArrayList<Supplier>();
        for (int i = suppliers.size() - 1; i >= 0; i--) {
            if (isSupplierName) {
                if (suppliers.get(i).getSupplierName().equals(supplierToRemove)) {
                    Supplier tempRemoved = suppliers.remove(i);
                    removedSuppliers.add(tempRemoved);
                }

            }
        }
        return removedSuppliers;
    }
    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public String get(int string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

}

