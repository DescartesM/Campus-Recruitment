package tencent2019;

import java.util.Scanner;

public class Main5 {
    public static long mod = 1000000009;
    public static long res = 0;
    public static boolean ishigher(int[] buildhigh, boolean[] isused, int high){
        for (int i=0;i<buildhigh.length;i++){
            if (isused[i] && high <= buildhigh[i])
                return false;
        }
        return true;
    }
    public static void dfs(int pre, int key, int[] buildhigh, int[] buildcolor, boolean[] isused, int yjn){
        if (key == 0){
            isused[yjn] = false;
            res = (res+1)%mod;
            return;
        }

        for (int i= 1;i<buildhigh.length;i++){
            if (!isused[i] && buildhigh[i] > buildhigh[pre] && buildcolor[pre] != buildcolor[i]){
                isused[i] = true;
                dfs(i, key-1, buildhigh, buildcolor, isused, i);
            }
            if (!isused[i] && buildhigh[i] <= buildhigh[pre]){
                isused[i] = true;

                dfs(i, key, buildhigh, buildcolor, isused, i);
            }
            if(!isused[i] && buildcolor[i] == buildcolor[i]){
                isused[i] = true;
                dfs(i, key, buildhigh, buildcolor, isused, i);
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] buildhigh = new int[n+1];
        int[] buildcolor = new int[n+1];
        boolean[] isused = new boolean[n+1];
        for (int i=1;i<n+1;i++){
            buildhigh[i] = i;
        }
        for (int i=1;i<n+1;i++){
            buildcolor[i] = sc.nextInt();
        }
        dfs(0, l, buildhigh, buildcolor, isused, 0);
        System.out.println(res);

    }
}
