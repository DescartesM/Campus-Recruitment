package tencent2019;

import java.util.*;

public class Main {
    private static long mod = 1000000007;
    private static long comb2(int m,int n) {
        long[][] dp = new long[m+1][n+1];
        for(int i=0;i<=m;i++) {
            dp[i][0] = 1;
        }

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n&&j<=i;j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        /*
        for (int i=0;i<n;i++){
            sc.nextInt();
        }*/
        long ans = comb2(n, s)%mod;
        // ans = ans * 2*(n-s);
        System.out.println(ans);

    }
}
