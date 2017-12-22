package config;

import mvc.view.ConsoleView;
import mvc.view.ConsoleViewEng;
import mvc.view.ConsoleViewUkr;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Lazy(value = false)
@Configuration
public class JavaContext {

    @Bean("consoleViewEng")
    public ConsoleView getConsoleViewEng(){
        return ConsoleViewEng.getConsole();
    }

    @Scope(scopeName = "singleton")
    @Bean("consoleViewUkr")
    public ConsoleView getConsoleViewUkr(){
        System.out.println("prototype");
        return ConsoleViewUkr.getConsole();
    }
}
