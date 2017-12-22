package mvc.view;

import mvc.models.Payment;

import java.util.ArrayList;
import java.util.HashMap;

public interface ConsoleView {
    void enterFirstNameMessage();

    void enterSecondNameMessage();

    void enterMiddleNameMessage();

    void enterIDNumberMessage();

    void invalidNumberMessage();

    void purposeOfPaymentMessage();

    void amountOfIncomeMessage();

    void dateOfPaymentMessage();

    void invalidDateInputMessage();

    void printPurposeMessage(int purpose);

    void printPayments(ArrayList<Payment> payments);

    void printDateFiltersMessage();

    void printValueFiltersMessage();

    void printAllPayers(HashMap<Long, String> payers);
}
