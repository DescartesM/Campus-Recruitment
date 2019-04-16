package webank;

import java.util.*;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        if (n*k%m == 0){
            System.out.println(n*k/m);
            return;
        }
        else {
            System.out.println(n*k/m +1 );
            return;
        }
    }
}