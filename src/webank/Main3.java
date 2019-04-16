package webank;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Deque<Integer> path = new LinkedList<>();
        Deque<Integer> circle = new LinkedList<>();
        for (int i=0;i<n;i++){
            circle.add(i+1);
        }
        int count = 0;
        String res = "";
        while (circle.size() > 1){
            int temp = circle.poll();
            count++;
            if (count == m){
                count =0;
                path.add(temp);
                continue;
            }
            circle.add(temp);
        }
        res = circle.poll().toString();
        int len = path.size()-1;
        for (int i=0;i<len;i++){
            System.out.print(path.poll().toString()+' ');
        }
        if (!path.isEmpty()){
            System.out.println(path.poll().toString());
        }

        System.out.println(res);
    }
}
