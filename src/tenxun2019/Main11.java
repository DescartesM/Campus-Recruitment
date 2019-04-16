package tenxun2019;

import java.util.*;
public class Main11 {
    public static int mymin = Integer.MAX_VALUE;
    public static void dfs(ArrayList<Integer> myque, int deadtime, int k){
        if (deadtime < 0){
            return;
        }
        Collections.sort(myque);
        if (myque.get(myque.size()-1) < mymin){
            mymin = myque.get(myque.size()-1)+k-deadtime;
        }
        ArrayList<Integer> tt = new ArrayList<>();
        for (int i=0;i<myque.size();i++){
            int temp = myque.get(i);
            int a = temp/2;
            int b = temp - temp/2;
            tt.add(a);
            tt.add(b);
        }
        dfs(tt, deadtime-1, k);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer>  mylist = new ArrayList<>();
        ArrayList<Integer>  myque = new ArrayList<>();
        myque.add(n);
        dfs(myque, k, k);
        System.out.println(mymin);
    }
}
