package tencent2018;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] picture = new char[n][m];
        for (int i=0;i<n;i++) {
            String str = sc.nextLine();
            picture[i] = str.toCharArray();
        }
        if (n == 1){
            boolean yellowflag = false;
            boolean blueflag = false;
            int res = 0;
            for (int i=0;i<m;i++){
                if (yellowflag){
                    if (picture[0][i] == 'X' || picture[0][i] == 'B'){
                        yellowflag = false;
                        res++;
                    }
                }
                if (picture[0][i] == 'Y' || picture[0][i] == 'G'){
                    yellowflag = true;
                }
            }
            for (int i=0;i<m;i++){
                if (blueflag){
                    if (picture[0][i] == 'X' || picture[0][i] == 'Y'){
                        blueflag = false;
                        res++;
                    }
                }
                if (picture[0][i] == 'B' || picture[0][i] == 'G'){
                    blueflag = true;
                }
            }
            if (yellowflag) res++;
            if (blueflag) res++;
            System.out.println(res);
            return;
        }
        if (m == 1){
            boolean yellowflag = false;
            boolean blueflag = false;
            int res = 0;
            for (int i=0;i<n;i++){
                if (yellowflag){
                    if (picture[i][0] == 'X' || picture[i][0] == 'B'){
                        yellowflag = false;
                        res++;
                    }
                }
                if (picture[i][0] == 'Y' || picture[i][0] == 'G'){
                    yellowflag = true;
                }
            }
            for (int i=0;i<n;i++){
                if (blueflag){
                    if (picture[i][0] == 'X' || picture[i][0] == 'Y'){
                        blueflag = false;
                        res++;
                    }
                }
                if (picture[i][0] == 'B' || picture[i][0] == 'G'){
                    blueflag = true;
                }
            }
            if (yellowflag) res++;
            if (blueflag) res++;
            System.out.println(res);
            return;
        }
        int times = n+m-1;
        int res = 0;
        for (int time = 0;time<times;time++){
            boolean yellowflag = false;
            boolean blueflag = false;
            if (time >= times/2){
                int len = times - time;
                int start = time - times/2;
                for (int i = 0;i<len;i++){
                    // is interrupted
                    if (yellowflag){
                        if (picture[i][start+i] == 'X' || picture[i][start+i] == 'B'){
                            yellowflag = false;
                            res++;
                        }
                    }
                    if (picture[i][start+i] == 'Y' || picture[i][start+i] == 'G'){
                        yellowflag = true;
                    }

                }
                for (int i = 0;i<len;i++){
                    if (blueflag){
                        if (picture[i][m-start-i-1] == 'X' || picture[i][m-start-i-1] == 'Y'){
                            blueflag = false;
                            res++;
                        }
                    }
                    if (picture[i][m-start-i-1] == 'B' || picture[i][m-start-i-1] == 'G'){
                        blueflag = true;
                    }
                }
                if (yellowflag) res++;
                if (blueflag) res++;

            }
            else{
                int len = time+1;
                int start = time;
                for (int i = 0;i<len;i++){
                    if (yellowflag){
                        if (picture[n-start-1+i][i] == 'X' || picture[n-start-1+i][i] == 'B'){
                            yellowflag = false;
                            res++;
                        }
                    }
                    if (picture[n-start-1+i][i] == 'Y' || picture[n-start-1+i][i] == 'G'){
                        yellowflag = true;
                    }
                }
                for (int i = 0;i<len;i++){
                    if (blueflag){
                        if (picture[n-start-1+i][m-i-1] == 'X' || picture[n-start-1+i][m-i-1] == 'Y'){
                            blueflag = false;
                            res++;
                        }
                    }
                    if (picture[n-start-1+i][m-i-1] == 'B' || picture[n-start-1+i][m-i-1] == 'G'){
                        blueflag = true;
                    }
                }
                if (yellowflag) res++;
                if (blueflag) res++;
            }
        }
        System.out.println(res);
    }
}
