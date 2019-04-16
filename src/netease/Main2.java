package netease;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0;i<n;i++){
            arr[i] = in.nextInt();
        }
        Comparator<Integer> cmp = (i1, i2) -> i2-i1;
        Arrays.sort(arr,cmp);
        long[] dianzhuang = new long[s];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<n;i++){
            list.add(arr[i]);
        }
        while (!list.isEmpty()){
            long tempmin = Long.MAX_VALUE;
            int index = -1;
            for (int j = 0;j<s;j++){
                if (dianzhuang[j] < tempmin){
                    tempmin =  dianzhuang[j];
                    index = j;
                }
            }
            dianzhuang[index] += list.get(0);
            Collections.sort(list);
        }

        long tempres = 0;
        for (int j = 0;j<s;j++){
            if (dianzhuang[j] > tempres){
                tempres =  dianzhuang[j];
            }
        }
        System.out.println(tempres);
    }
}
