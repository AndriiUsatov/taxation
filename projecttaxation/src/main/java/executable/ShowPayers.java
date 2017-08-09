package executable;

import mvc.controller.LangController;
import mvc.controller.PayersReader;
import mvc.view.ConsoleView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;

public class ShowPayers {
    ConsoleView view;

    public void start() throws IOException, ParserConfigurationException, SAXException {
        view = LangController.getLang();
        HashMap<Long, String> payers = new PayersReader().read();
        view.printAllPayers(payers);
    }
}
