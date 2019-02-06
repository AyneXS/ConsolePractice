import java.util.ArrayList;

/**
 * Created by N-Aynex on 06.02.19.
 */
public final class TempConverter extends ConsoleGUI {
    public TempConverter(){
    };

    public void init(){
        setIntro("This is a Celsius to Fahrenheit converter.\n" +
                "Enter an option from the menu below and then enter the temperature.");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Celsius to Fahrenheit");
        menu.add("Fahrenheit to Celsius");
        menu.add("Exit");
        setMenu(menu);
    }
    public void doAction(int choice){
        switch (choice){
            case 1: setResult(Double.toString(convertCtF(getUserInput())) + "°F"); break;
            case 2: setResult(Double.toString(convertFtC(getUserInput())) + "°C"); break;
            case 3: exit(); break;
            default: System.out.println("Enter a valid option"); break;
        }
    }

    private double convertFtC(String userInput) {
        double temp = Double.parseDouble(userInput);
        return ((temp - 32) * 5/9);
    }

    private double convertCtF(String userInput) {
        double temp = Double.parseDouble(userInput);
        return ((temp * 9/5) + 32);
    }
}
