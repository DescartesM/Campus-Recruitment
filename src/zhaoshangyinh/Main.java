package zhaoshangyinh;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        Integer[] height = new Integer[n];
        int mymin = Integer.MAX_VALUE;
        int mymax = -1;
        for (int i=0;i<n;i++){
            height[i] = in.nextInt();
            if (height[i] > mymax)
                mymax = height[i];
            if (height[i]< mymin)
                mymin = height[i];
        }
        int[] presum = new int[mymax - mymin+1];
        Comparator<Integer> cmp = (i1, i2) -> i2-i1;
        Arrays.sort(height,cmp);
        for (int i=0;i<n;i++){
            int index = mymax - height[i];
            presum[index]++;
        }
        for (int i=1;i<presum.length;i++){
            presum[i] += presum[i-1];
        }
        int[] dp = new int[mymax - mymin+1];
        dp[0] = 1;
        for (int i=1;i<presum.length;i++){
            dp[i] = presum[i]+dp[i-1];
        }
        int count = 1;
        while (dp[presum.length-2] >= k*count){
            for (int i=0;i<presum.length-1;i++){
                if (dp[i] <= k*count && dp[i+1] >k*count){
                    count++;
                    continue;
                }
            }
        }
        System.out.println(count-1);
    }
}
