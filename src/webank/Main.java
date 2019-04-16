package webank;

import java.util.*;

public class Main {
    static class Point{
        public int x;
        public int y;
        public double radius;

        public Point(int x, int y, double radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }
    }
    private static double distance(Point point1, Point point2) {
        return Math.sqrt((point1.x - point2.x)*(point1.x - point2.x) + (point1.y - point2.y)*(point1.y - point2.y));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        for (int i=0;i<n;i++){
            int tempx = sc.nextInt();
            int tempy = sc.nextInt();
            Point tempp = new Point(tempx, tempy, 0.0);
            points.add(tempp);
        }
        double[][] mymap = new double[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                mymap[i][j] = distance(points.get(i),points.get(j));
            }
        }
        boolean[] visisted = new boolean[n];

        for (int yjn =0 ;yjn<n;yjn++){
            //find min
            double tempmin = 10000;
            int indexi=0,indexj=0;
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if ( mymap[i][j] < tempmin && i!= j){
                        tempmin = mymap[i][j];
                        indexi = i;
                        indexj = j;
                    }
                }
            }
            if (!visisted[indexi] && !visisted[indexj]){
                points.get(indexi).radius = tempmin/2.0;
                points.get(indexj).radius = tempmin/2.0;
                for (int i=0;i<n;i++){
                    mymap[i][indexj] += mymap[i][indexj] - points.get(indexj).radius;
                    mymap[indexi][i] += mymap[indexi][i] - points.get(indexi).radius;
                }
                visisted[indexi] = true;
                visisted[indexj] = true;
                mymap[indexi][indexj] = mymap[indexj][indexi] = 10000;
            }
            else if (!visisted[indexj] && visisted[indexi]){
                points.get(indexj).radius = tempmin - points.get(indexi).radius;
                for (int i=0;i<n;i++){
                    mymap[i][indexj] += mymap[i][indexj] - points.get(indexj).radius;
                    //mymap[indexi][i] += mymap[indexi][i] - points.get(indexi).radius;
                }
                visisted[indexj] = true;
                mymap[indexi][indexj] = mymap[indexj][indexi] = 10000;
            }
            else if (visisted[indexj] && !visisted[indexi]){
                points.get(indexi).radius = tempmin - points.get(indexj).radius;
                for (int i=0;i<n;i++){
                    //mymap[i][indexj] += mymap[i][indexj] - points.get(indexj).radius;
                    mymap[indexi][i] += mymap[indexi][i] - points.get(indexi).radius;
                }
                visisted[indexi] = true;
                mymap[indexi][indexj] = mymap[indexj][indexi] = 10000;
            }
            else {
                ;
            }
        }
        for (int i=0;i<n-1;i++){
            System.out.printf("%.3f",points.get(i).radius);
            System.out.print(" ");
        }
        System.out.printf("%.3f",points.get(n-1).radius);
    }


}
