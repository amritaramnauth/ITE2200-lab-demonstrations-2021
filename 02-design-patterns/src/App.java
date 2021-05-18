import composite.CompanyDirectory;
import composite.Developer;
import composite.Manager;
import observer.GoldPriceChanger;
import observer.GoldPriceSubscriber;
import strategy.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        /*
        * observer pattern
        * */
        System.out.println("Observer pattern");
        // instantiate publisher
        var goldPriceChanger = new GoldPriceChanger();

        // register subscribers
        var customer1 = new GoldPriceSubscriber(goldPriceChanger);
        var customer2 = new GoldPriceSubscriber(goldPriceChanger);

        goldPriceChanger.setGoldPrice(193.00);
        goldPriceChanger.unregister(customer1);
        goldPriceChanger.setGoldPrice(350);


        /*
        * strategy pattern
        * */
        System.out.println("\nStrategy pattern");

        // allow payment method from input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which payment method: 1- cash, 2-credit, 3-debit ");
        int selection = scanner.nextInt();

        PayStrategy strategy;

        if (selection == 1) {
            strategy = new CashPayment();
        } else if (selection == 2) {
            strategy = new CreditCardPayment();
        } else {
            strategy = new DebitCardPayment();
        }

        OrderContext order = new OrderContext();
        order.makePayment(strategy);

        /*
         * composite pattern
         */

        System.out.println("\nComposite pattern");
        var dev1 = new Developer("Jane Doe", 1000, "Application developer");
        var dev2 = new Developer("Jason Doe", 1001, "Engineer");

        var manager1 = new Manager("Scrimply Jane", 1002, "Engineering manager");
        var manager2 = new Manager("John Fred", 1003, "Development manager");
        var manager3 = new Manager("Koolio King", 1004, "General manager");

        // engineer directory
        var engDirectory = new CompanyDirectory();
        engDirectory.addEmployee(dev1);
        engDirectory.addEmployee(dev2);
        engDirectory.addEmployee(manager1);
        engDirectory.addEmployee(manager2);

        var operationDirectory = new CompanyDirectory();
        operationDirectory.addEmployee(manager3);
        operationDirectory.addEmployee(engDirectory);

        var companyDirectory = new CompanyDirectory();
        companyDirectory.addEmployee(operationDirectory);
        companyDirectory.showEmployeeDetails();

    }

}
