/**
 * Created by N-Aynex on 06.02.19.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayCopy extends ConsoleGUI {
    private String[][] result;
    private String[] userInput;
    private int copies;

    public void setUserInput(String[] input){
        this.userInput = input;
    }

    public String[] getUserInput(){
        return userInput;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    protected void init(){
        super.init();
        setIntro("This is a string array copier.\n" +
            "Enter an option from the menu below and then enter the array and the number of copies in the next line.");
        ArrayList<String> menu = getMenu();
        menu.add("Enter an array and the number of copies");
        setMenu(menu);
    }

    @Override
    protected void startInput(BufferedReader in) {
    String input = "";
    int copies = 0;
    boolean exitLoop = false;
        do {
            try {
                input = in.readLine();
                copies = Integer.parseInt(in.readLine());
                exitLoop = true;
            } catch (IOException e) {
                System.out.println("Not a valid input parameter. Try again.");
            }
        } while (exitLoop==false);
        setUserInput(input.split("\\s+"));
        setCopies(copies);
    }

    @Override
    protected void doAction(int choice){
        String[] initialArray = getUserInput();
        int copies = getCopies();
        String[][] copyArray = new String[copies][initialArray.length];

        for (int i=0; i<copies; i++){
            copyArray[i] = Arrays.copyOf(initialArray, initialArray.length);
        }
        result = copyArray;
    }

    @Override
    protected void printResult(){
        String[] ui = getUserInput();
        for (int i=0; i<ui.length; i++){
            System.out.print(ui[i]+ " ");
        }
        System.out.println();
        for (int i=0; i<result.length; i++){
            System.out.print(i+1 + " ");
            for (int j=0; j<result[j].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

}
