markdown

# Object-Oriented-Programming

This Java-based Warehouse Mangement System was developed for the Object-Oriented Programming module. It allows users to manage suppliers, inventory, customer and purchase orders and financial records using a text based menu interface.

--
## Project Structure 

app/
├── Main.java
├── CustomerOrder.java
├── OnlineOrder.java
├── Product.java
├── ProductLibrary.java
├── Supplier.java
├── SupplierLibrary.java
├── PurchaseOrder.java
├── FinanceTracker.java
├── Stock.java
├── StockLibrary.java
├── StockMonitor.java

test/
├── ProductLibraryTest.java
├── FinanceTrackerTest.java
├── OnlineOrderTest.java
├── PurchaseOrderTest.java
├── StockLibraryTest.java
├── StockMonitorTest.java
├── SupplierLibraryTest.java



## Requirements 
- Java JDK 8
- JUnit 4 for running test classes

-----

## How to run the application

1. **Download or Clone the Repository**

```bash
git clone https://github.com/Elizabeth1420/Object-Oriented-Programming.git
cd Object-Oriented-Programming

2. Complie the Application
javac app/*.java

3. Run the program
java app.Main

-----

## How to Run the Tests - JUnit 4:
Download these JARs
junit-4.13.2.jar & hamcrest-core-1.3.jar

Compile Test Classes:
javac -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" test/*.java

Run a Test Class:
java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore test.ProductLibraryTest

(Replace ProductLibraryTest with the name of the file you want to run)


markdown
## Author

**Elizabeth Adeleke**
Module: COM5043 - Object Oriented Programming
Student ID: 22233594 
