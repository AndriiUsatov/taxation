package executable;


import mvc.controller.AddController;
import mvc.controller.LangController;
import mvc.controller.PaymentSaver;
import mvc.models.Payment;
import mvc.view.ConsoleView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;


public class AddTax {
    ConsoleView view;
    Payment payment;
    AddController addController;

    public void start() throws IOException {
        view = LangController.getLang();
        addController = new AddController(view);

        payment = new Payment(addController.setPerson(), addController.setTax(), addController.setDateOfPayment());

        PaymentSaver saver = new PaymentSaver(payment);

        try {
            saver.save();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }





    }
}
