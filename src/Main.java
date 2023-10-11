import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // create a scanner to take input from user.
        Scanner user = new Scanner(System.in);
        // make a menu and welcome message.
        System.out.println("Hello and welcome to the menu");
        System.out.println("Please choose one option, 1 = Pay salary, 2 = create an new invoice, 3 = pay one or more invoice");
        try {
            // read the user's choice.
            int usersChoice = user.nextInt();
            // option 1 pay salaries.
            if (usersChoice == 1) {
                // ask user how many employees to pay
                System.out.println("Please write how many employees you want to pay salaries to");
                int employeer = user.nextInt();
                int[] employees = new int[employeer];

                // Read salary amounts for each employee.
                for (int i = 0; i < employeer; i++) {
                    System.out.println("Please write how much you want to pay employee number " + (i + 1));
                    employees[i] = user.nextInt();
                }

                // Display salaries after tax for each employee.
                System.out.println("salaries after tax for each employee:");
                for (int i = 0; i < employeer; i++) {
                    double afterTax = employees[i] * 0.7;
                    System.out.println("Salary for employee " + (i + 1) + " after tax is " + afterTax);
                }

            } else if (usersChoice == 2) {
                //option 2 create an invoice.
                System.out.println("please write the value of the invoice");
                double sum = user.nextDouble();
                double Grosssum = sum;
                // Calculate and display VAT and Net Amount.
                System.out.println(" Your Grosssum is " + sum + " sek ");
                double vat = (sum / 100) * 25;
                System.out.println(" Your VAT is " + vat + " sek ");
                double noVat = (sum / 100) * 75;
                System.out.println(" Your Net Amount is " + noVat + " sek ");

            } else if (usersChoice == 3) {
                // option 3 pay one or more invoices.
                System.out.println("State account balance and please make sure you have sufficiently balance to pay all invoice");
                double accountBal = user.nextDouble();
                // Get the number of invoices to pay.
                System.out.println("State the number of invoices you want to pay");
                int numOfInvoice = user.nextInt();
                double[] invoice = new double[numOfInvoice];
                // Read the balance for each invoice.
                for (int i = 0; i < numOfInvoice; i++) {
                    System.out.println("State balance for invoice " + (i + 1));
                    invoice[i] = user.nextInt();
                }
                // display amount left after each invoice.
                for (int i = 0; i < numOfInvoice; i++) {
                    accountBal -= invoice[i];
                    System.out.println("Account balance after invoice " + (i + 1) + " has been payed: " + accountBal + "sek");
                }

            }
            // read the input for wrong input and message try again.
        }catch (InputMismatchException e) {
            System.out.println("Invalid input try again");
        }
    }
}
