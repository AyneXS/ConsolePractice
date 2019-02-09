/**
 * Created by N-Aynex on 06.02.19.
 */

import java.io.BufferedReader;
import java.util.ArrayList;

public class TempConverter extends ConsoleGUI {
    private String result;
    private double userInput;

    public void setUserInput(double input){
        this.userInput = input;
    }

    public double getUserInput(){
        return userInput;
    }

    @Override
    protected void init(){
        super.init();
        setIntro("This is a Celsius to Fahrenheit converter.\n" +
                "Enter an option from the menu below and then enter the temperature.");
        ArrayList<String> menu = getMenu();
        menu.add("Celsius to Fahrenheit");
        menu.add("Fahrenheit to Celsius");
        setMenu(menu);
    }

    @Override
    protected void startInput(BufferedReader in) {
    double input = 0.0;
    boolean exitLoop = false;
        do {
            try {
                input = Double.parseDouble(in.readLine());
                exitLoop=true;

            } catch (Exception e) {
                System.out.println("Not a valid input parameter. Enter another one.");
            }
        } while (exitLoop==false);
        setUserInput(input);
    }

    @Override
    protected void doAction(int choice){
        switch (choice){
            case 1: result = Double.toString(convertCtF(getUserInput())) + "°F"; break;
            case 2: result = Double.toString(convertFtC(getUserInput())) + "°C"; break;
            case 3: exit(); break;
            default: System.out.println("Enter a valid option"); break;
        }
    }

    private double convertFtC(double userInput) {
        double temp = userInput;
        return ((temp - 32) * 5/9);
    }

    private double convertCtF(double userInput) {
        double temp = userInput;
        return ((temp * 9/5) + 32);
    }

    @Override
    protected void printResult(){
        System.out.println(result+"\n");
    }
}
