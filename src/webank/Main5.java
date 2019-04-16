package webank;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] input = new int[T];
        int[] ans1 = {1,2,4,8,16,5,10,3,6,12,24,48,96,192,384,786};
        int[] ans2 = {1,2,4,8,16,5,10,20,40,80,120,240,480,960};
        int[] ans3 = {1,2,4,8,16,32,64,128,256,512};
        int[] ans4 = {1,2,4,8,16,32,64,21,42,84,168,336,672};
        for (int i=0;i<T;i++){
            input[i] = sc.nextInt();
        }
        for (int i=0;i<T;i++){
            boolean flag = false;
            for (int j=0;j<ans1.length;j++){
                if (input[i] == ans1[j]){
                    System.out.println(j);
                    flag = true;
                    break;
                }

            }
            if (!flag){
                for (int j=0;j<ans2.length;j++){
                    if (input[i] == ans2[j]){
                        System.out.println(j);
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag){
                for (int j=0;j<ans3.length;j++){
                    if (input[i] == ans3[j]){
                        System.out.println(j);
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag){
                for (int j=0;j<ans4.length;j++){
                    if (input[i] == ans4[j]){
                        System.out.println(j);
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag)
                System.out.println(-1);
        }
    }
}
