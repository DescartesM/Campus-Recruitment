package baidu;

import java.util.*;

public class Main {
    public static int func(int numOfGS, int[] distOfGS, int[] allowedGasoline, int distance, int initialGasoline){
        int count = 0;
        int hasGas = initialGasoline;
        int pos = 0;
        while(distance > 0){
            int index = -1;
            for (int i=numOfGS-1;i>-1;i--){
                if ((distOfGS[i]-pos)<= hasGas)
                {
                    index = i;
                    break;
                }
            }
            if (index == -1)
            {
                return  -1;
            }
            if (pos < distOfGS[numOfGS-1]){
                hasGas -= (distOfGS[index]-pos);
                distance -= (distOfGS[index]-pos);
                pos = distOfGS[index];
                hasGas += allowedGasoline[index];
                count++;
            }
            else {
                distance -= hasGas;
                if (distance > 0)
                    return -1;
            }

        }
        return count;
    }
    public static void main(String[] args) {
        int a = 3;
        int[] b = {5,7,10};
        int[] c = {2,3,5};
        int d = 15;
        int e = 5;
        int ans = func(a,b,c,d,e);
        System.out.println(ans);
    }
}
