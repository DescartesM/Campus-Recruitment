package bytedance;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] Li = new int[n];
        PriorityQueue<Float> myheap = new PriorityQueue<>((i1, i2) -> (int) (i2 - i1));
        for (int i=0;i<n;i++){
            Li[i] = sc.nextInt();
            myheap.offer((float) Li[i]);
        }

        while (myheap.size() < m){
            float temp = myheap.peek();
            myheap.poll();
            myheap.offer(temp / 2);
            myheap.offer(temp / 2);
        }
        float result = 0;
        float[] res = new float[m];
        for (int i = 0; i < m; ++i)
        {
            res[i] = (myheap.poll());
        }
        Arrays.sort(res);
        System.out.printf("%.2f",res[0]) ;
    }

}
