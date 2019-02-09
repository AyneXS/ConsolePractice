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
    private ArrayList<Integer> armstrongs;

    protected void setDuration(long duration){
        this.duration = duration;
    }
    protected long getDuration(){
        return duration;
    }

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
        startTime = System.currentTimeMillis();
        armstrongs = new ArrayList<Integer>();
        initPowers();
        //assembling possible numbers
        for (int i=1; i<=9; i++){           //powers loop
            char[] num = new char[i];
            findNumbers(num, 0, 0, i);
        }
        endTime = System.currentTimeMillis();
        setDuration(endTime-startTime);
    }

    private void findNumbers(char[] number, int sum, int pos, int currPow) { //number, power's sum, start position, digit power
        int init_sum = sum;
        int pow = number.length;
        int temp_sum;
        for (int i=pos; i<=9; i++){
            temp_sum = init_sum;
            number[currPow-1] = Character.forDigit(i, 10);
            if (i==0) {
                temp_sum += 0;  //0 in any power is 0
            } else temp_sum += powers[pow-1][i-1];
            if (currPow==1){
                if (allDigitsInSum(number, temp_sum)){
                    armstrongs.add(temp_sum);
                }
            } else {
                findNumbers(number, temp_sum, i, currPow-1);
            }
        }

    }

    private boolean allDigitsInSum(char[] number, int sum) {
        char[] sumDigits = String.valueOf(sum).toCharArray();
        char[] temp_num = Arrays.copyOf(number, number.length);
        boolean wellDone = false;
        if (sumDigits.length!=temp_num.length) return wellDone;
        Arrays.sort(sumDigits);
        Arrays.sort(temp_num);
        for (int i=0; i<temp_num.length; i++){
            if (temp_num[i]==sumDigits[i]){
                wellDone = true;
            } else {
                wellDone=false;
                break;
            }
        }
        return wellDone;
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
        System.out.printf("Running time: %d ms\n\n", getDuration());
    }
}
