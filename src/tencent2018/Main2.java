package tencent2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static int mod = 1000000007;
    public static long getzuhe(int m, int n){
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
        int K = sc.nextInt();
        sc.nextLine();
        int A = sc.nextInt();
        int X = sc.nextInt();
        int B = sc.nextInt();
        int Y = sc.nextInt();
        ArrayList<Integer> mylist = new ArrayList<>();
        for (int i=0;i<=X;i++)
            for (int j=0;j<=Y;j++){
                if (i*A + j*B == K){
                    mylist.add(i);
                    mylist.add(j);
                }
            }
        long ans = 0;
        for (int index=0;index< mylist.size();index+=2){
            long res1,res2;
            res1 = getzuhe(X, mylist.get(index));
            res2 = getzuhe(Y, mylist.get(index+1));
            long t = (res1*res2);
            t %= mod;
            ans+= t;
            ans %= mod;
        }

        System.out.println(ans);
    }
}

