/**
 * Created by N-Aynex on 06.02.19.
 */

import java.util.ArrayList;

public final class TempConverter extends ConsoleGUI {
    private String result;

    public void init(){
        super.init();
        setIntro("This is a Celsius to Fahrenheit converter.\n" +
                "Enter an option from the menu below and then enter the temperature.");
        ArrayList<String> menu = getMenu();
        menu.add("Celsius to Fahrenheit");
        menu.add("Fahrenheit to Celsius");
        setMenu(menu);
    }

    public void doAction(int choice){
        switch (choice){
            case 1: result = Double.toString(convertCtF(getUserInput())) + "°F"; break;
            case 2: result = Double.toString(convertFtC(getUserInput())) + "°C"; break;
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

    public void printResult(){
        System.out.println(result+"\n");
    }
}
