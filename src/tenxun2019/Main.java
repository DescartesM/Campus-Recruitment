package tenxun2019;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int[] point = new int[n];
        int[][] mymap = new int[n][n];
        int res = 0;
        int xmin = 1000001, xmax = -1000001;
        for (int i = 0; i < n; i++) {
            point[i] = sc.nextInt();
            if (point[i] < xmin)
                xmin = point[i];
            if (point[i] > xmax)
                xmax = point[i];
        }
        Arrays.sort(point);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                mymap[i][j] = Math.abs(point[i] - point[j]);
            }
        }
        if (a <= xmin){
            for (int i = 0; i < n-1; i++){
                res += Math.abs(point[i] - a);
            }
            System.out.println(res);
        }
        if (a >= xmax){
            for (int i = n-1; i >0; i--){
                res += Math.abs(point[i] - a);
            }
            System.out.println(res);
        }
        if (a > xmin && a < xmax){
            System.out.println(res);
        }
    }
}
