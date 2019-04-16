package netease;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0;i<n;i++){
            queue.offer(i+1);
        }
        while (queue.size() != 1){

            int temp = queue.poll();
            if (count == m-1){
                count =0;
                continue;
            }
            count++;
            queue.offer(temp);
        }
        int res = queue.poll();
        System.out.print(res);
    }
}
