package executable;


import mvc.controller.AddController;
import mvc.controller.LangController;
import mvc.controller.PaymentSaver;
import mvc.models.Payment;
import mvc.view.ConsoleView;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@Component
public class AddTax implements Service{
    private ConsoleView view;
    private Payment payment;
    private AddController addController;

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
