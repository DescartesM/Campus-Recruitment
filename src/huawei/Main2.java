package huawei;

import java.util.*;

public class Main2 {
    private static boolean judge(int[] charcount) {
        for (int i=0;i<charcount.length;i++){
            if (charcount[i] != 0)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] c = str.toCharArray();
        HashMap<Character,Integer> charmap = new HashMap<>();
        for (int i=0;i<c.length;i++){
            if (charmap.containsKey(c[i])){
                charmap.put(c[i], charmap.get(c[i])+1);
            }
            else charmap.put(c[i], 1);
        }
        int[] charcount = new int[26];
        int times = 0;
        for (int i=0;i<charcount.length;i++){
            int bigcount = 0, littlecount = 0;
            char yjn = (char) ('a'+i);
            if (charmap.containsKey((char) ('a'+i))){
                littlecount = charmap.get((char) ('a'+i));
            }
            else littlecount = 0;
            if (charmap.containsKey((char) ('A'+i))){
                bigcount = charmap.get((char) ('A'+i));
            }
            else bigcount = 0;
            charcount[i] = Math.min(bigcount, littlecount);
        }
        ArrayList<String> res = new ArrayList<>();
        while (judge(charcount)){
            String temp ="";
            boolean lianxuflag = false;
            for (int i=0;i<charcount.length;i++){
                if (lianxuflag && charcount[i] == 0)
                    break;
                if (charcount[i] > 0){
                    lianxuflag = true;
                    temp += (char) ('A'+i);
                    temp += (char) ('a'+i);
                    charcount[i]--;
                }
            }
            res.add(temp);
        }
        Collections.sort(res, new Comparator<String>() {
            public int compare(String user1, String user2) {
                if (user1.charAt(0) == user2.charAt(0)){
                    return user2.length() - user1.length();
                }
                else return user1.charAt(0) - user2.charAt(0);

            }
        });
        for (int i=0;i<res.size();i++)
             System.out.println(res.get(i));
    }



}
