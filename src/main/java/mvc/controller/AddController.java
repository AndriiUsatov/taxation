package mvc.controller;

import mvc.models.persons.Person;
import mvc.models.persons.PrivateIndividual;
import mvc.models.taxes.Tax;
import mvc.models.taxes.TaxesOfIndividuals;
import mvc.view.ConsoleView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddController {
    static ConsoleView view;

    public AddController(ConsoleView view) {
        this.view = view;
    }

    public Person setPerson() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        view.enterFirstNameMessage();
        String firstName = reader.readLine();
        view.enterSecondNameMessage();
        String secondName = reader.readLine();
        view.enterMiddleNameMessage();
        String middleName = reader.readLine();

        String idNumber = "";

        while (true) {
            view.enterIDNumberMessage();
            try {
                idNumber = reader.readLine();
                Long.valueOf(idNumber);
                if (!(idNumber.length() == 10))
                    throw new NumberFormatException();

            } catch (NumberFormatException e) {
                view.invalidNumberMessage();
            }
            if (String.valueOf(idNumber).length() == 10)
                break;
        }
        Person tmpPerson = new PrivateIndividual(firstName, secondName, middleName, idNumber);
        return tmpPerson;
    }

    public Tax setTax() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int purposeOpPayment = 0;

        while (true) {
            view.purposeOfPaymentMessage();
            try {
                purposeOpPayment = Integer.parseInt(reader.readLine());
                if (purposeOpPayment < 1 || purposeOpPayment > 9)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                view.invalidNumberMessage();
            }

            if (purposeOpPayment >= 1 && purposeOpPayment <= 9)
                break;
        }
        double income = 0;
        while (true) {
            view.amountOfIncomeMessage();
            try {
                income = Double.valueOf(reader.readLine());
            } catch (NumberFormatException e) {
                view.invalidNumberMessage();
            }
            if (income > 0)
                break;
        }

        Tax tmpTax = new TaxesOfIndividuals(purposeOpPayment, income);
        return tmpTax;
    }

    public Date setDateOfPayment() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        Date dateOfPayment = null;
        while (true) {
            view.dateOfPaymentMessage();
            try {
                dateOfPayment = dateFormat.parse(reader.readLine());
                if (dateOfPayment.getTime() > new Date().getTime()) {
                    dateOfPayment = null;
                    throw new ParseException("Wrong date", 1);
                }

            } catch (ParseException e) {
                view.invalidDateInputMessage();
            }
            if (dateOfPayment != null)
                break;
        }
        return dateOfPayment;
    }


}
