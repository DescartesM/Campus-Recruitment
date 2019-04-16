package tenxun2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Integer[] coin_value = new Integer[n];
        boolean hasone = false;
        for (int i=0;i<n;i++){
            coin_value[i] = sc.nextInt();
            if (coin_value[i] == 1)
                hasone = true;
        }
        if (!hasone){
            System.out.println(-1);
            return;
        }
        Comparator<Integer> cmp = (i1, i2) -> i2 - i1;
        Arrays.sort(coin_value,cmp);
        int count = 0;
        int index = 0;
        for (int i=0;i<n;i++){
            if (coin_value[i]< m){
                index = i;
                break;
            }
        }
        count = 1;
        while (index<n-1){

            int a = coin_value[index]/coin_value[index+1];
            int b = coin_value[index]%coin_value[index+1];
            if (b == 0){
                count += (a-1);
            }
            else count += a;
            index++;
        }
        System.out.println(count);
    }
}
