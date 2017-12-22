import executable.AddTax;
import executable.Service;
import executable.ShowPayers;
import executable.ShowTax;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

public class Main {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

    public static void main(String[] args) throws Exception{
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
                        context.getBean(ShowTax.class).start();
                        break;
                    case "2":
                        context.getBean(AddTax.class).start();
                        break;
                    case "3":
                        context.getBean(ShowPayers.class).start();
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
