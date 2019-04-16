package microsoft;

import java.util.*;

public class Main {
    public static int count =0;
    public static int func(int input1, int input2,int input3) {
        // throw new UnsupportedOperationException("maxCircles(int input1,int input2,int input3)");
        int[][] mymap = new int[input1+1][input1+1];
        for (int i = 1; i < input1 + 1; i++) {
            for (int j = 1; j < input1 + 1; j++) {
                if (j % i == 0 && i != j) {
                    mymap[i][j] = mymap[j][i] = 1;
                }
            }
        }
        dfs(mymap, input3, input2, input2);
        return count-1;
    }
    public static int  dfs(int[][] mymap, int deadtime, int pos, int start){
        int size = mymap.length;
        if(deadtime >= 0 && pos==start){
            count++;
        }
        if(deadtime == 0)
            return 0;
        for(int i=1;i<size;i++){
            if(mymap[pos][i] == 1){
                int temp = dfs(mymap, deadtime-1, i,start);
                // if (temp==1)
            }
        }
        return  0;
    }
    public static void main(String[] args) {

        int n = func(3,2,4);

        System.out.println(n);
    }
}
