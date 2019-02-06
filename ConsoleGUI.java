/**
 * Created by N-Aynex on 06.02.19.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class ConsoleGUI {
    private String intro;
    private ArrayList<String> menu = new ArrayList<String>();
    private String userInput;

    public void setIntro(String intro){
        this.intro = intro;
    }

    public void setMenu(ArrayList<String> menu){
        this.menu = menu;
    }

    public ArrayList<String> getMenu(){
        return menu;
    }

    public void setUserInput(String input){
        this.userInput = input;
    }

    public String getUserInput(){
        return userInput;
    }

    public void init(){
        menu.add("Exit");
    };

    public void startConsole(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(intro);

        while (true) {
            for (String moption: menu){
                System.out.println(menu.indexOf(moption) + " " + moption);
            }
            System.out.println("Enter the number of the wished option: ");
            int choice = -1;

            do {
            try {
                do {
                    choice = Integer.parseInt(in.readLine());
                    if (!(choice >= 0 && choice <= menu.size()-1)){
                        System.out.println("Please enter a valid menu option:");
                    }
                } while (!(choice >= 0 && choice <= menu.size()-1));
            } catch (Exception e){
                System.out.println("Please enter a valid number:");
            }
            } while (!(choice >= 0 && choice <= menu.size()-1));

            System.out.println(menu.get(choice));

            if (choice == menu.indexOf("Exit")) exit();

            try {
                setUserInput(in.readLine());
                doAction(choice);
                printResult();
            } catch (Exception e) {
                System.out.println("Not a valid input parameter.\n");
            }

        }
    }

    public abstract void printResult();
    public abstract void doAction(int choice);

    public void exit(){
        System.exit(0);
    };

}
