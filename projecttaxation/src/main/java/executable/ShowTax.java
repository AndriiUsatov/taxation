package executable;

import mvc.controller.LangController;
import mvc.controller.PaymentSaver;
import mvc.controller.ShowController;
import mvc.models.Payment;
import mvc.view.ConsoleView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ShowTax {
    ConsoleView view;
    ShowController showController;
    ArrayList<Payment> filteredPayments;

    public void start() throws IOException, ParserConfigurationException, SAXException {
        view = LangController.getLang();
        showController = new ShowController(view);

        PaymentSaver saver = new PaymentSaver(showController.inputID());
        saver.readFromFile();
        filteredPayments = showController.filterByDate(saver.getPayments());
        filteredPayments = showController.sortByValueOfPayment(filteredPayments);
        view.printPayments(filteredPayments);


    }
}
