package netease;

import java.util.*;

public class Main3 {
    /*
    Deque<Character> mDeque = new ArrayDeque<>();
        ArrayList<Character>res = new ArrayList<>();
        for (int i=0;i<input.length;i++){
            mDeque.offer(input[i]);
        }
        while (!mDeque.isEmpty()){
            char temp = mDeque.poll();
            res.add(temp);
            //judge evn?
            if (mDeque.size()%2 == 0){
                mDeque = reverse(mDeque);
            }
            //move
            if (!mDeque.isEmpty()){
                char firstchar = mDeque.poll();
                mDeque.offer(firstchar);
            }
        }
        String ans = "";
        for (int i=0;i<input.length;i++){
            ans += res.get(i);
        }
    * */
    public static ArrayList<Character> reverse(ArrayList<Character> mDeque){
        ArrayList<Character> res = new ArrayList<>();
        int size = mDeque.size();
        for (int i=0;i<size;i++){
            char lastchar = mDeque.remove(mDeque.size() -1);
            res.add(lastchar);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] input = str.toCharArray();
        // ArrayList<Character> yjn = new ArrayList<>();

        ArrayList<Character> line = new ArrayList<>();
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++)
                line.add(input[i]);
        result.add(line.get(line.size()-1));
        int line_size = line.size() - 1;
        int result_size = 1;
        while (line_size > 0) {
            char new_char = line.get(line_size-1);
            char tmp = result.get(result_size-1);
            result.remove(result_size-1);
            result.add(0, tmp);
            if (result_size % 2 == 0)
                result = reverse(result);
            result.add(0, new_char);
            result_size++;
            line.remove(line_size-1);
            line_size--;
        }
        String result_str = "";
        for(int i=0;i<result_size;i++)
        {
            result_str=result_str+result.get(i);
        }
        System.out.println(result_str);
    }

}
