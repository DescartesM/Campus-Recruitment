package tencent2018;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int res = 0;
        for (int i=n-1;i>0;i-=2){
            res += (a[i] - a[i-1]);
        }
        if (n/2 == 1)
            res += a[0];
        System.out.println(res);
    }
}
