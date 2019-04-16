package tencent2019;


import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] counter = new int[m+1];
        for (int i=0;i<m+1;i++){
            counter[i] = 1;
        }
        int[] seq = new int[n];
        for (int i=0;i<n;i++){
            seq[i] = sc.nextInt();
        }
        int window = n+1;
        int begin = 0;
        int end = 0;
        int c=m;
        int head =0;
        while(end<n)
        {
            if((counter[seq[end++]]--)==1)
                m--;
            while(m==0)
            {
                if(end-begin<window) window=end-begin;
                if(counter[seq[begin++]]++==0) m++;
            }
        }
        System.out.println(((window==n+1)?-1:window));

    }
}

