package app;

public class Supplier {
    private int supplierId; 
    private String supplierName;
    private int supplierContactNumber; 


    public Supplier (int supplierID, String supplierName, int supplierContactNumber){
    this.supplierId = supplierID;
    this.supplierName = supplierName; 
    this.supplierContactNumber = supplierContactNumber; 

}


// Method to get supplierID
    public int getSupplierId () {
        return supplierId;
    }

// Method to get supplier name 
    public String getSupplierName () {
        return supplierName;
    }

//Method to get contact info 
    public int getSupplierContactNumber () { 
        return supplierContactNumber;
    }

public String getInfo() {
    return supplierId + " " + supplierName + " " + supplierContactNumber;
    }      


    public void displayOrderDetails(){
    System.out.println("Supplier ID: " + supplierId);
    System.out.println("Supplier Name: " + supplierName);
    System.out.println("Supplier Contact Number: " + supplierContactNumber);
}
     
}






