/**
 * Created by N-Aynex on 08.02.19.
 */
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Armstrong extends ConsoleGUI {
    private int[][] powers = new int[9][9];
    private long duration;
    private ArrayList<Integer> armstrongs = new ArrayList<Integer>();

    @Override
    protected void init(){
        super.init();
        setIntro("This is a program for finding Armstrong numbers.\n" +
                "Enter an option from the menu below.");
        ArrayList<String> menu = getMenu();
        menu.add("Show Armstrong numbers");
        setMenu(menu);
    }

    @Override
    protected void startInput(BufferedReader in) {
    }

    @Override
    protected void doAction(int choice) {
        long startTime, endTime;
        initPowers();
        //assembling possible numbers
        for (int i=1; i<=9; i++){           //powers loop
            findNumbers(0, 0, 0, i, i);
        }

    }

    private void findNumbers(int number, int sum, int pos, int currPow, int pow) { //number, power's sum, start position, digit power, power
        int init_number = number;
        int init_sum = sum;
        int temp_number, temp_sum;
        for (int i=pos; i<=9; i++){
            temp_number = init_number;
            temp_sum = init_sum;
            temp_number += i * Math.pow(10, currPow-1);
            if (i==0) {
                temp_sum += 0;
            } else temp_sum += powers[pow-1][i-1];
            if (currPow==1){
                char[] digits = (String.valueOf(temp_sum)).toCharArray();
                Arrays.sort(digits);
                int sorted_sum = Integer.parseInt(String.valueOf(digits)); //sorting digits
                if (sorted_sum==temp_number && sorted_sum>0 && (temp_number>1 || pow==1)){
                    armstrongs.add(temp_sum);
                }
            } else {
                findNumbers(temp_number, temp_sum, i, currPow-1, pow);
            }
        }

    }

    private void initPowers() {
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                powers[i][j] = (int)(Math.pow(j+1, i+1));
            }
        }
    }

    @Override
    protected void printResult() {
        Collections.sort(armstrongs);
        System.out.println(armstrongs);
    }
}
