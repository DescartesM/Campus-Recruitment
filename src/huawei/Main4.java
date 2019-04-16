package huawei;

import java.util.*;

public class Main4 {
    static class Fruit{
        public int x;
        public int y;
        public boolean dead;

        public Fruit(int x, int y, boolean dead) {
            this.x = x;
            this.y = y;
            this.dead = dead;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int xlen = 40;
        int ylen = 50;
        ArrayList<Fruit> fruits = new ArrayList<>();
        int[][] mymap = new int[xlen][ylen];
        for (int i=0;i<n;i++){
            int tempx = sc.nextInt();
            int tempy = sc.nextInt();
            mymap[tempx][tempy] = i+1;
            Fruit fruit = new Fruit(tempx, tempy, false);
            fruits.add(fruit);
        }
        ArrayList<ArrayList<Fruit>> qian = new ArrayList<>();
        //zuoxia
        for (int i=0;i<xlen+ylen-1;i++){
            ArrayList<Fruit> temp = new ArrayList<>();
            if (i< ylen){
                int index_x = 0;
                int index_y = i;
                while (index_x<xlen && 0<=index_y ){
                    if (mymap[index_x][index_y] != 0)
                        temp.add(fruits.get(mymap[index_x][index_y]-1));
                    index_x++;
                    index_y--;
                }
                if (!temp.isEmpty())
                    qian.add(temp);
            }
            else {
                int index_x = i - ylen +1;
                int index_y = ylen-1;
                while (index_x<xlen && 0<=index_y ){
                    if (mymap[index_x][index_y] != 0)
                        temp.add(fruits.get(mymap[index_x][index_y]-1));
                    index_x++;
                    index_y--;
                }
                if (!temp.isEmpty())
                    qian.add(temp);
            }

        }
        //youxia
        for (int i=0;i<xlen+ylen-1;i++){
            ArrayList<Fruit> temp = new ArrayList<>();
            if (i< xlen){
                int index_x = xlen-1-i;
                int index_y = 0;
                while (index_x<xlen && index_y<ylen){
                    if (mymap[index_x][index_y] != 0)
                        temp.add(fruits.get(mymap[index_x][index_y]-1));
                    index_x++;
                    index_y++;
                }
                if (!temp.isEmpty())
                    qian.add(temp);
            }
            else {
                int index_x = 0;
                int index_y = i - xlen +1;
                while (index_x<xlen && index_y<ylen){
                    if (mymap[index_x][index_y] != 0)
                        temp.add(fruits.get(mymap[index_x][index_y]-1));
                    index_x++;
                    index_y++;
                }
                if (!temp.isEmpty())
                    qian.add(temp);
            }

        }
        //up_to_down
        for (int i=0;i<ylen;i++){
            ArrayList<Fruit> temp = new ArrayList<>();
            for (int j=0;j<xlen;j++){
                if (mymap[j][i] != 0)
                    temp.add(fruits.get(mymap[j][i]-1));
            }
            if (!temp.isEmpty())
                qian.add(temp);
        }
        //left_to_right
        for (int i=0;i<xlen;i++){
            ArrayList<Fruit> temp = new ArrayList<>();
            for (int j=0;j<ylen;j++){
                if (mymap[i][j] != 0)
                    temp.add(fruits.get(mymap[i][j]-1));
            }
            if (!temp.isEmpty())
                qian.add(temp);
        }

        int ans = 0;
        int count = 0;
        while (count != n){
            ans++;
            int mymax = 0;
            int mymaxidx = 0;
            for (int i= 0;i<qian.size();i++){
                if (mymax < qian.get(i).size()){
                    mymax = qian.get(i).size();
                    mymaxidx = i;
                }
            }
            count += mymax;
            for (int i= 0;i<qian.get(mymaxidx).size();i++){
                qian.get(mymaxidx).get(i).dead = true;
            }
            for (int i= 0;i<qian.size();i++){
                for (int j= 0;j<qian.get(i).size();j++){
                    if ( qian.get(i).get(j).dead){
                        qian.get(i).remove(j);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
