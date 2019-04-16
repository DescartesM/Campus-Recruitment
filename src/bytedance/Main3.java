package bytedance;

import java.util.*;


public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[][] arr = new int[m][0];
        for (int j = 0; j < m; j++) {
            int n = in.nextInt();
            arr[j] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[j][i] = in.nextInt();
            }
        }

        for (int[] a : arr) {
            int n = a.length;
            int[] score = new int[n];


            while (true) {
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    int left = (i + n - 1) % n;
                    int right = (i + n + 1) % n;
                    if (score[i] > 0) {
                        continue;
                    }
                    if (a[left] >= a[i] && a[right] >= a[i]) {
                        flag = true;
                        score[i] = 1;
                    } else if (score[left] != 0 && a[left] < a[i] && a[right] >= a[i]) {
                        flag = true;
                        score[i] = score[left] + 1;
                    }else if (score[right] != 0 && a[right] < a[i] && a[left] >= a[i]) {
                        flag = true;
                        score[i] = score[right] + 1;
                    } else if (score[left] != 0 && score[right] != 0 && a[i] > a[left] && a[i] > a[left])  {
                        flag = true;
                        score[i] = Math.max(score[right], score[left]) + 1;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += score[i];
            }
            System.out.println(sum);
        }
    }

}