package webank;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int yjn = 0;
        for (int i=2;i<=n;i++){
            yjn = (yjn+m)%i;
            System.out.print(yjn);
        }
        System.out.println(yjn);
    }
}
