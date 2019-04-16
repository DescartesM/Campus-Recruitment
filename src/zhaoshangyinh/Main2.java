package zhaoshangyinh;

import java.util.*;


public class Main2 {
    class appletree implements Comparator{
        public int index;
        public int apple;
        @Override
        public int compare(Object o1, Object o2) {
            return (int)o1-(int)o2;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int negcount = 0;
        appletree[] appletrees = new appletree[n];
        for (int i=0;i<n;i++){
            appletrees[i].index = in.nextInt();
            if (appletrees[i].index < 0)
                negcount++;
            appletrees[i].apple = in.nextInt();
        }

        Arrays.sort(appletrees);

    }
}
