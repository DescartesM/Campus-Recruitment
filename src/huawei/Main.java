package huawei;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int trans(String str) {
        return Integer.valueOf(str);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] c = str.toCharArray();
        ArrayList<Boolean> negative = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        int sum = 0;
        String temp = "";
        for (int i=0;i<c.length;i++){
            if (c[i]== '-'){
                negative.add(false);
                nums.add(trans(temp));
                temp = "";
            }
            else if (c[i]== '+'){
                negative.add(true);
                nums.add(trans(temp));
                temp = "";
            }
            else {
                temp += c[i];
            }
        }
        nums.add(trans(temp));
        sum+=nums.get(0);
        for (int i=1;i<nums.size();i++){
            if (negative.get(i-1)){
                sum += nums.get(i);
            }
            else sum -= nums.get(i);
        }
        System.out.println(sum);
    }


}
