package mvc.view;

import mvc.models.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrii on 28.07.17.
 */
public class ConsoleViewEng implements ConsoleView {
    private static ConsoleViewEng consoleView;

    private ConsoleViewEng() {
    }

    public static ConsoleViewEng getConsole() {
        if (consoleView == null) {
            synchronized (ConsoleViewEng.class) {
                if (consoleView == null) {
                    consoleView = new ConsoleViewEng();
                }
            }
        }
        return consoleView;
    }

    public void enterFirstNameMessage() {
        System.out.println("Enter the name of the payer");
    }

    public void enterSecondNameMessage() {
        System.out.println("Enter the second name of the payer");
    }

    public void enterMiddleNameMessage() {
        System.out.println("Enter the middle name of the payer");
    }

    public void enterIDNumberMessage() {
        System.out.println("Enter ID number of the payer");
    }

    public void invalidNumberMessage() {
        System.out.println("Invalid number entered");
    }

    public void purposeOfPaymentMessage() {
        System.out.println("Enter the number to choose purpose of payment");
        System.out.println("\t Enter \"1\" - Income tax on main work");
        System.out.println("\t Enter \"2\" - Income tax on additional work");
        System.out.println("\t Enter \"3\" - Millitary tax");
        System.out.println("\t Enter \"4\" - Tax on income from targeted financial assistance");
        System.out.println("\t Enter \"5\" - Tax on income from charitable untargeted financial assistance");
        System.out.println("\t Enter \"6\" - Tax on income from royalties");
        System.out.println("\t Enter \"7\" - Gift tax");
        System.out.println("\t Enter \"8\" - Gift tax from non resident (money transfers)");
        System.out.println("\t Enter \"9\" - Tax on income from real estate for sale (for the second time " +
                "in a year or if you have owned less than three years)");
    }

    public void printPurposeMessage(int purpose) {
        switch (purpose) {
            case 1:
                System.out.println("Income tax on main work");
                break;
            case 2:
                System.out.println("Income tax on additional work");
                break;
            case 3:
                System.out.println("Millitary tax");
                break;
            case 4:
                System.out.println("Tax on income from targeted financial assistance");
                break;
            case 5:
                System.out.println("Tax on income from charitable untargeted financial assistance");
                break;
            case 6:
                System.out.println("Tax on income from royalties");
                break;
            case 7:
                System.out.println("Gift tax");
                break;
            case 8:
                System.out.println("Gift tax from non resident (money transfers)");
                break;
            case 9:
                System.out.println("Tax on income from real estate for sale (for the second time " +
                        "in a year or if you have owned less than three years)");
                break;
        }
    }

    public void amountOfIncomeMessage() {
        System.out.println("Enter the amount of income that is taxed");
    }

    public void dateOfPaymentMessage() {
        System.out.println("Enter the date of payment in format \"dd.mm.yy\"");
    }

    public void invalidDateInputMessage() {
        System.out.println("Invalid date entered");
    }

    public void printPayments(ArrayList<Payment> filteredPayments) {
        double totalAmount = 0;
        for (Payment payment : filteredPayments) {
            totalAmount += payment.getAmountOfPayment();
            System.out.println("Date: " + payment.getDateOfPayment());
            System.out.println("Person name: " + payment.getPayer().getFullName() + ", ID: " + payment.getPayer().getIDNumber());
            System.out.print("Tax purpose: ");
            consoleView.printPurposeMessage(payment.getTax().getPurposeOfPayment());
            System.out.println("Amount of payment: " + payment.getAmountOfPayment() + "\n");
        }

        System.out.println("Number of payments: " + filteredPayments.size());
        System.out.println("Total payment amount: " + totalAmount + "\n\n");
    }

    public void printDateFiltersMessage() {
        System.out.println("Enter the filter by date");
        System.out.println("\t\"1\" - All payments");
        System.out.println("\t\"2\" - Last year");
        System.out.println("\t\"3\" - Last month");
        System.out.println("\t\"4\" - Last week");
    }

    public void printValueFiltersMessage() {
        System.out.println("Enter the filter by the amount of payment");
        System.out.println("\t\"1\" - First biggest");
        System.out.println("\t\"2\" - First lowest");
    }

    public void printAllPayers(HashMap<Long, String> payers) {
        for (Map.Entry<Long, String> entry : payers.entrySet()){
            System.out.println("Payer name: " + entry.getValue() +
                    "\nID number: " + entry.getKey() + "\n");
        }
    }

}
