package bytedance;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<n;i++){
            String str = sc.nextLine();
            String res = "";
            char[] input = str.toCharArray();
            boolean[] flag = new boolean[input.length];
            int count = 0;
            int groupcount = 0;
            int jiange = 0;
            for (int j=1;j<input.length;j++){
                if (input[j] == input[j-1])
                    count++;
                else {
                    count = 0;
                    if (groupcount==1){
                        jiange++;
                    }
                }
                if (count == 1){
                    groupcount++;
                }
                if (count == 2){
                    count --;
                    flag[j] = true;
                }

                if (groupcount==2 && jiange ==1){
                    jiange = 0;
                    groupcount = 0;
                    flag[j] = true;
                }

            }
            for (int j=0;j<input.length;j++){
                if (!flag[j]){
                    res += input[j];
                }
            }
            System.out.println(res);
    }
    }
}
