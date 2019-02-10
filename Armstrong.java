/**
 * Created by N-Aynex on 08.02.19.
 */
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Armstrong extends ConsoleGUI {
    private int power;
    private long[][] powers;
    private long duration, usedMemory;
    private ArrayList<Long> armstrongs;

    protected void setDuration(long duration){
        this.duration = duration;
    }
    protected long getDuration(){
        return duration;
    }
    protected void setUsedMemory(long memory){
        usedMemory = memory;
    }
    protected long getUsedMemory(){
        return usedMemory;
    }

    //@Override
    protected void init(int power){
        super.init();
        setIntro("This is a program for finding Armstrong numbers.\n" +
                "Enter an option from the menu below.");
        ArrayList<String> menu = getMenu();
        menu.add("Show Armstrong numbers");
        setMenu(menu);
        this.power = power;
    }

    @Override
    protected void startInput(BufferedReader in) {
    }

    @Override
    protected void doAction(int choice) {
        long startTime, endTime;
        long startMemory, endMemory;
        startTime = System.currentTimeMillis();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        armstrongs = new ArrayList<Long>();
        initPowers(power);
        //assembling possible numbers
        for (int i=1; i<=power; i++){           //powers loop
            char[] num = new char[i];
            findNumbers(num, 0, 0, i);
        }
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        endTime = System.currentTimeMillis();
        setDuration(endTime-startTime);
        setUsedMemory((endMemory-startMemory)/1024);
    }

    private void findNumbers(char[] number, long sum, int pos, int currPow) { //number, power's sum, start position, digit power
        long init_sum = sum;
        int pow = number.length;
        long temp_sum;
        for (int i=pos; i<=9; i++){
            temp_sum = init_sum;
            number[currPow-1] = Character.forDigit(i, 10);
            if (i!=0) { //0 in any power is 0
                temp_sum += powers[pow-1][i-1];
            }
            if (currPow==1){
                if (allDigitsInSum(number, temp_sum)){
                    armstrongs.add(temp_sum);
                }
            } else {
                findNumbers(number, temp_sum, i, currPow-1);
            }
        }

    }

    private boolean allDigitsInSum(char[] number, long sum) {
        char[] sumDigits = String.valueOf(sum).toCharArray();
        char[] temp_num = Arrays.copyOf(number, number.length);
        Arrays.sort(sumDigits);
        Arrays.sort(temp_num);
        return Arrays.equals(sumDigits, temp_num);
    }

    private void initPowers(int pow) {
        powers = new long[pow][pow];
        for (int i=0; i<pow; i++){
            for (int j=0; j<pow; j++){
                powers[i][j] = (long)(Math.pow(j+1, i+1));
            }
        }
    }

    @Override
    protected void printResult() {
        Collections.sort(armstrongs);
        System.out.println(armstrongs);
        System.out.printf("Running time: %d ms\n", getDuration());
        System.out.printf("Used memory: %d kbytes\n\n", getUsedMemory());
    }
}
