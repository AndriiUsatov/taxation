package mvc.view;

import mvc.models.Payment;

import java.util.ArrayList;
import java.util.HashMap;

public interface ConsoleView {
    public void enterFirstNameMessage();

    public void enterSecondNameMessage();

    public void enterMiddleNameMessage();

    public void enterIDNumberMessage();

    public void invalidNumberMessage();

    public void purposeOfPaymentMessage();

    public void amountOfIncomeMessage();

    public void dateOfPaymentMessage();

    public void invalidDateInputMessage();

    public void printPurposeMessage(int purpose);

    public void printPayments(ArrayList<Payment> payments);

    public void printDateFiltersMessage();

    public void printValueFiltersMessage();

    public void printAllPayers(HashMap<Long, String> payers);
}
