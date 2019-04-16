package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main2 {
    public static int func(int input1, int input2, int[][] input3) {
        Deque<Integer>myque = new LinkedList<>();
        for (int i=0;i<input1;i++){
            myque.offer(i+1);
        }
        int sum = 0;
        for (int i=0;i<input2;i++){
            int type = input3[i][0];
            int index = input3[i][1];
            switch (type){
                case 1:{
                    myque.poll();
                    break;
                }
                case 2:{
                    ArrayList<Integer>tempsave = new ArrayList<>();
                    for(int j=0;j<myque.size();j++){
                        int temp = myque.poll();
                        if (index == temp){
                            break;
                        }
                        tempsave.add(temp);
                    }
                    for(int j=tempsave.size()-1;j>-1;j--){
                        myque.addFirst(tempsave.get(j));
                    }
                    break;
                }
                case 3:{
                    ArrayList<Integer>tempsave = new ArrayList<>();
                    for(int j=0;j<myque.size();j++){
                        int temp = myque.poll();
                        tempsave.add(temp);
                        if (index == temp){
                            sum += (j+1);
                            break;
                        }

                    }
                    for(int j=tempsave.size()-1;j>-1;j--){
                        myque.addFirst(tempsave.get(j));
                    }
                    break;
                }

            }

        }
        return sum;
    }

    public static void main(String[] args) {
        int[][]a = {{1,0},{3,3},{2,2}};
        int n = func(5, 3, a);

        System.out.println(n);
    }
}
