package mvc.controller;

import mvc.models.Payment;
import mvc.view.ConsoleView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShowController {
    BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    ConsoleView view;

    public ShowController(ConsoleView view) {
        this.view = view;
    }

    public String inputID() throws IOException {
        String id = "";
        while (true) {
            view.enterIDNumberMessage();
            try {
                id = inputReader.readLine();
                Long.valueOf(id);
                if (!(id.length() == 10))
                    throw new NumberFormatException();

            } catch (NumberFormatException e) {
                view.invalidNumberMessage();
            }
            if (id.length() == 10)
                break;
        }
        return id;
    }

    public ArrayList<Payment> filterByDate(ArrayList<Payment> payments) throws IOException {
        ArrayList<Payment> result = new ArrayList<>();
        int filter = 0;
        while (true) {
            view.printDateFiltersMessage();
            try {
                filter = Integer.valueOf(inputReader.readLine());
                if (filter < 1 || filter > 4)
                    throw new NumberFormatException();

            } catch (NumberFormatException e) {
                view.invalidNumberMessage();
            }
            if (filter >= 1 && filter <= 4)
                break;
        }

        Date filterDate = null;
        GregorianCalendar calendar = new GregorianCalendar();
        switch (filter) {
            case 2:
                calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
                break;
            case 3:
                calendar.set(calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
                break;
            case 4:
                calendar.set(calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 7);
                break;
        }
        filterDate = calendar.getTime();
        for (Payment payment : payments) {
            if (filterDate.getTime() > payment.getDateOfPayment().getTime())
                result.add(payment);
        }

        return result;
    }

    public ArrayList<Payment> sortByValueOfPayment(ArrayList<Payment> payments) throws IOException {
        ArrayList<Payment> result = new ArrayList<>();
        int filter = 0;

        while (true) {
            view.printValueFiltersMessage();
            try {
                filter = Integer.valueOf(inputReader.readLine());
                if (filter != 1 && filter != 2)
                    throw new NumberFormatException();

            } catch (NumberFormatException e) {
                view.invalidNumberMessage();
            }
            if (filter == 1 || filter == 2)
                break;
        }
        TreeSet<Payment> tmpPayments = new TreeSet<>();
        for (Payment p : payments) {
            tmpPayments.add(p);
        }
        switch (filter) {
            case 1:
                for (Payment p1 : tmpPayments) {
                    result.add(0,p1);
                }
                break;
            case 2:
                for (Payment p1 : tmpPayments) {
                    result.add(p1);
                }
                break;
        }
        return result;
    }
}

