package microsoft;

public class Main3 {
    public static int func(int input1, int input2,int[][] input3,int[][] input4, int[] input5, int input6) {
        // throw new UnsupportedOperationException("maxCircles(int input1,int input2,int input3)");
        double dead = input6;
        int count =0;
        Point[] flowers = new Point[input1];
        Point[] honeystation = new Point[input2];
        boolean[]visited = new boolean[input1];
        Point pos = new Point(input5[0], input5[1],-1);
        Point start = new Point(input5[0], input5[1],-1);
        //hua
        for (int i=0;i<input1;i++){
            flowers[i] = new Point(input3[i][0], input3[i][1],i);
        }
        //honeystation
        for (int i=0;i<input2;i++){
            honeystation[i] = new Point(input4[i][0], input4[i][1],1);
        }
        while (dead >= 0.0 && count<input1){
            double cost = 0;
            Point temppos;
            temppos = calcmindistance1(pos, flowers,visited);
            visited[temppos.val] = true;
            cost = dis(pos, temppos);
            dead -= cost;
            if (dead < 0)
                break;
            pos = calcmindistance2(temppos, honeystation);
            cost = dis(pos, temppos);
            dead -= cost;
            if (dead - dis(pos,start) < 0) break;
            count++;
        }
        return count;
    }
    static class Point{
        public int x;
        public int y;
        public int val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public static Point calcmindistance1(Point p, Point[] list, boolean[]visited){
        double tempmmin = Integer.MAX_VALUE;
        int minindex = -1;
        double temp;
        for (int i=0;i<list.length;i++){
            temp = dis(p, list[i]);
            if (temp < tempmmin && !visited[i]){
                minindex =i;
                tempmmin = temp;
            }
        }
        return list[minindex];
    }
    public static Point calcmindistance2(Point p, Point[] list){
        double tempmmin = Integer.MAX_VALUE;
        int minindex = -1;
        double temp;
        for (int i=0;i<list.length;i++){
            temp = dis(p, list[i]);
            if (temp < tempmmin){
                minindex =i;
                tempmmin = temp;
            }
        }
        return list[minindex];
    }
    public static double dis(Point p1, Point p2){
        double x = p1.x -p2.x;
        double y = p1.y -p2.y;
        return Math.sqrt(x*x + y*y);
    }
    public static void main(String[] args) {
        int a=2;
        int b=2;
        int[][] c = {{3,3},{4,6}};
        int[][] d = {{5,5},{6,1}};
        int[] e = {1,4};
        int f =13;
        int ans = func(a,b,c,d,e,f);

        System.out.println("");
    }
}
