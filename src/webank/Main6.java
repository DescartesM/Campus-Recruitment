package webank;

import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] input = new int[T];
        for (int i=0;i<T;i++){
            input[i] = sc.nextInt();
        }
        for (int i=0;i<T;i++){
            int yjn = input[i];
            int count = 0;
            while (yjn != 1 && count < 1000){
                if (yjn%2 == 0){
                    yjn = yjn/2;
                    count++;
                }
                else{
                        yjn = (yjn*3)+1;
                        count++;
                    }
                }
            System.out.println(count);

        }
    }
}
