package tenxun2019;

import java.util.*;

public class Main22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] mylist = new int[n];
        for (int i=0;i<n;i++){
            mylist[i] = (sc.nextInt());
        }
        Arrays.sort(mylist);
        for (int i=0;i<k;i++){
            int tempmin = -1;
            int index;
            for (index=0;index<mylist.length;index++){
                if (mylist[index] != 0){
                    tempmin = mylist[index];
                    break;
                }
            }
            if (mylist[mylist.length-1] == 0){
                for (int yjn =i;yjn <k;yjn++)
                    System.out.println(0);
                return;
            }
            for (int j=0;j<mylist.length;j++){
                if (mylist[j] != 0){
                    mylist[j] -= tempmin;
                }

            }
            System.out.println(tempmin);
        }

    }
}
