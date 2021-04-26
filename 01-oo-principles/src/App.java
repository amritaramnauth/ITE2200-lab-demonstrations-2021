import entities.*;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        // create instance of a store
        Store store = new Store("Jame's Furniture Store", "123 Queenstown, Geede");

        // create furniture instance
        Furniture f1 = new Furniture("table", "mahogany finish", 80000);

        // create an outdoor furniture
        OutdoorFurniture outdoorFurniture1 = new OutdoorFurniture("chair", "has four legs", 20000,
                "pinewood", 35.09, 19.3);

        Inventory inventory = new Inventory();

        // add furniture to inventory
        inventory.addFurniture(f1);
        inventory.addFurniture(outdoorFurniture1);

        // remove furniture from inventory
        inventory.removeFurniture(outdoorFurniture1);

        System.out.println(inventory.getInventoryCount());
        System.out.println(inventory.toString());

        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        // create employee
        Employee e1 = new Employee("John Doe", "650-0098", "Cashier");
        Employee e2 = new Employee("Jane Doe", "650-0098", "Cashier");

        // add employees to list
        employeeList.add(e1);
        employeeList.add(e2);

    }
}
