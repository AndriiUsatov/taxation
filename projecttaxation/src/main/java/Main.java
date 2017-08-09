import executable.AddTax;
import executable.ShowPayers;
import executable.ShowTax;
import mvc.controller.PayersReader;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean work = true;
            while (work) {
                System.out.println("Enter what you want to do:");
                System.out.println("\t Enter \"1\" to view the taxes");
                System.out.println("\t Enter \"2\" to add tax");
                System.out.println("\t Enter \"3\" to view all taxpayers");
                System.out.println("\t Enter \"exit\" to exit");
                String input = reader.readLine();
                switch (input) {
                    case "1":
                        new ShowTax().start();
                        break;
                    case "2":
                        new AddTax().start();
                        break;
                    case "3":
                        new ShowPayers().start();
                        break;
                    case "exit":
                        work = false;
                        break;
                    default:
                        System.out.println("Entered wrong character(s), please enter again");
                }
            }
        }
    }
}
