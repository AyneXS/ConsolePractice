/**
 * Created by N-Aynex on 06.02.19.
 */
import java.util.ArrayList;

public final class ArrayCopy extends ConsoleGUI {
    private String[] result;
    private String stringArray;

    public void init(){
        super.init();
        setIntro("This is a string array copier.\n" +
                "Enter an option from the menu below and then enter the array.");
        ArrayList<String> menu = getMenu();
        menu.add("Enter an array and the number of copies");
        setMenu(menu);
    }

    public void doAction(int choice){
        String initialArray = getUserInput();
        int copies = getNumberOfCopies(initialArray);
        String[] copyArray = new String[copies];
        //cutting the number from the end
        stringArray = initialArray.substring(0, initialArray.length()-String.valueOf(copies).length());

        for (int i=0; i<copies; i++){
            copyArray[i] = stringArray;
        }
        result = copyArray;
    }

    private int getNumberOfCopies(String ua) {
        StringBuilder sb = new StringBuilder();
        for (int i = ua.length()-1; i>=0; i--) {
            char c = ua.charAt(i);
            if (Character.isDigit(c)) {
                sb.insert(0, c);
            } else {
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public void printResult(){
        System.out.println(stringArray);
        for (int i=0; i<result.length; i++){
            System.out.println(i+1 + " " + result[i]);
        }
        System.out.println();

    }
}
