package mvc.controller;

import mvc.view.ConsoleView;
import mvc.view.ConsoleViewEng;
import mvc.view.ConsoleViewUkr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LangController {
    public static ConsoleView getLang() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose the language:");
        System.out.println("\t Enter 1 for English");
        System.out.println("\t Enter another character(s) for Ukrainian");
        if (reader.readLine().equals("1"))
            return ConsoleViewEng.getConsole();
        return ConsoleViewUkr.getConsole();
    }
}
