/**
 * Created by N-Aynex on 06.02.19.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class ConsoleGUI {
    private String intro;
    private ArrayList<String> menu;
    private String userInput;
    private String result;

    public void setIntro(String intro){
        this.intro = intro;
    }

    public void setMenu(ArrayList<String> menu){
        this.menu = menu;
    }

    public void setUserInput(String input){
        this.userInput = input;
    }

    public String getUserInput(){
        return userInput;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public abstract void init();

    public void startConsole(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(intro);

        while (true) {
            for (String moption: menu){
                System.out.println((menu.indexOf(moption) + 1) + " " + moption);
            }
            System.out.println("Enter the number of the wished option: ");
            int choice = 0;

            do {
            try {
                do {
                    choice = Integer.parseInt(in.readLine());
                    if (!(choice > 0 && choice <= menu.size())){
                        System.out.println("Please enter a valid menu option:");
                    }
                } while (!(choice > 0 && choice <= menu.size()));
            } catch (Exception e){
                System.out.println("Please enter a valid number:");
            }
            } while (!(choice > 0 && choice <= menu.size()));

            System.out.println(menu.get(choice-1));

            if (choice == menu.indexOf("Exit")+1) exit();

            try {
                setUserInput(in.readLine());
                doAction(choice);
                System.out.println(result+"\n");
            } catch (Exception e) {
                System.out.println("Not a valid input parameter.\n");
            }

        }
    }

    public abstract void doAction(int choice);

    public void exit(){
        System.exit(0);
    };

}
