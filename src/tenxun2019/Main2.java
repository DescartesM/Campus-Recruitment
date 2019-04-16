package tenxun2019;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] highs = new int[n];
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        int res = 0;
        for (int i=0;i<n;i++){
            highs[i] = sc.nextInt();
        }
        for (int i=2;i<n;i++){
            //dp[i] = min();
        }
        System.out.println(res);
    }
}
