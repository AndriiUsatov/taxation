package mvc.view;


import mvc.models.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConsoleViewUkr implements ConsoleView {
    private static ConsoleViewUkr consoleView;

    private ConsoleViewUkr() {
    }

    public static ConsoleViewUkr getConsole() {
        if (consoleView == null) {
            synchronized (ConsoleViewUkr.class) {
                if (consoleView == null) {
                    consoleView = new ConsoleViewUkr();
                }
            }
        }
        return consoleView;
    }

    public void enterFirstNameMessage() {
        System.out.println("Введіть ім'я платника");
    }


    public void enterSecondNameMessage() {
        System.out.println("Введіть прізвище платника");
    }

    public void enterMiddleNameMessage() {
        System.out.println("Введіть по батькові платника");
    }

    public void enterIDNumberMessage() {
        System.out.println("Введіть ідентифікаційний номер платника податку");
    }

    public void invalidNumberMessage() {
        System.out.println("Невірно введений номер");
    }

    public void purposeOfPaymentMessage() {
        System.out.println("Введіть число щоб обрати призначення платежу");
        System.out.println("\t Введіть \"1\" - Податок на прибуток з основного місця роботи");
        System.out.println("\t Введіть \"2\" - Податок на прибуток з додаткового місця роботи");
        System.out.println("\t Введіть \"3\" - Війсковий сбір");
        System.out.println("\t Введіть \"4\" - Податок на прибуток з цільової матеріальної допомоги");
        System.out.println("\t Введіть \"5\" - Податок на прибуток з нецільвої благодійної матеріальної допомоги");
        System.out.println("\t Введіть \"6\" - Податок на прибуток з авторської винагороди");
        System.out.println("\t Введіть \"7\" - Податок з подарунку будь-якого майна від осіб, що не є членами " +
                "сім'ї першого ступеня споріднення");
        System.out.println("\t Введіть \"8\" - Податок з подарунку від нерезидента (грошовий переказ)");
        System.out.println("\t Введіть \"9\" - Податок на прибуток з продажу нерухомого майна (в випадках продажу більше ніж" +
                " один раз на рік, або за умови володіння менше ніж протягом 3-х років");
    }

    public void printPurposeMessage(int purpose) {
        switch (purpose) {
            case 1:
                System.out.println("Податок на прибуток з основного місця роботи");
                break;
            case 2:
                System.out.println("Податок на прибуток з додаткового місця роботи");
                break;
            case 3:
                System.out.println("Війсковий сбір");
                break;
            case 4:
                System.out.println("Податок на прибуток з цільової матеріальної допомоги");
                break;
            case 5:
                System.out.println("Податок на прибуток з нецільвої благодійної матеріальної допомоги");
                break;
            case 6:
                System.out.println("Податок на прибуток з авторської винагороди");
                break;
            case 7:
                System.out.println("Податок з подарунку будь-якого майна від осіб, що не є членами " +
                        "сім'ї першого ступеня споріднення");
                break;
            case 8:
                System.out.println("Податок з подарунку від нерезидента (грошовий переказ)");
                break;
            case 9:
                System.out.println("Податок на прибуток з продажу нерухомого майна (в випадках продажу більше ніж " +
                        "один раз на рік, або за умови володіння менше ніж протягом 3-х років");
                break;
        }
    }

    public void amountOfIncomeMessage() {
        System.out.println("Введіть суму доходу яка оподатковується");
    }

    public void dateOfPaymentMessage() {
        System.out.println("Введіть дату платежу в форматі \"dd.mm.yy\"");
    }

    public void invalidDateInputMessage() {
        System.out.println("Не вірно введена дата");
    }

    public void printPayments(ArrayList<Payment> filteredPayments) {
        int totalAmount = 0;
        for (Payment payment : filteredPayments) {
            totalAmount += payment.getAmountOfPayment();
            System.out.println("Дата: " + payment.getDateOfPayment());
            System.out.println("Ім'я платника: " + payment.getPayer().getFullName() + ", Ідентифікаційний номер: " + payment.getPayer().getIDNumber());
            System.out.print("Призначення податку: ");
            consoleView.printPurposeMessage(payment.getTax().getPurposeOfPayment());
            System.out.println("Сума платежу: " + payment.getAmountOfPayment() + "\n");
        }

        System.out.println("Загальна кількість сплачених податків: " + filteredPayments.size());
        System.out.println("Загальна сума сплачених податків: " + totalAmount + "\n\n");
    }

    public void printDateFiltersMessage() {
        System.out.println("Введіть номер філтру за датою");
        System.out.println("\t\"1\" - За весь час");
        System.out.println("\t\"2\" - За останній рік");
        System.out.println("\t\"3\" - За останній місяць");
        System.out.println("\t\"4\" - За останній тиждень");
    }
    public void printValueFiltersMessage(){
        System.out.println("Введіть фільтр податків за сумою");
        System.out.println("\t\"1\" - Спочатку найбільші");
        System.out.println("\t\"2\" - Спочатку найменші");
    }

    public void printAllPayers(HashMap<Long, String> payers) {
        for (Map.Entry<Long, String> entry : payers.entrySet()){
            System.out.println("ПІБ платника податків: " + entry.getValue() +
                    "\nІдентифікаційний номер: " + entry.getKey() + "\n");
        }
    }
}
