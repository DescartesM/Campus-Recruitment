package tenxun2019;

import java.util.*;
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cost = new int[n];
        int[] attack_value = new int[n];
        for (int i=0;i<n;i++){
            attack_value[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i=0;i<n;i++){
            cost[i] = sc.nextInt();
            sum += cost[i];
        }
        // init cost
        int[] dp = new int[sum+1];
        int[] dpval = new int[sum+1];
        if (cost[0] == 1)
            dp[1] = 1;
        else dp[2] = 1;
        for (int i= cost[0];i<sum+1;i++){
            dpval[i] = attack_value[0];
        }
        for (int i=cost[0]+1;i<=sum;i++){
            //if (dpval[index] >= attack_value[index]){
                //pay or not which max;
            }
        }
}