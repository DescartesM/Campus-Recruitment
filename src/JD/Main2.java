package JD;

import java.util.*;

public class Main2 {
    public static int kmp(String str, String dest,int[] next, int[] poscount){//str文本串  dest 模式串
        int res = 0;
        for(int i = 0, j = 0; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == dest.length()){
                res++;
                for(int yjn = i-j+1;yjn<=i;yjn++){
                    poscount[yjn]++;
                }
                j = 0;
            }
        }
        return res;
    }
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1,j = 0; i < dest.length(); i++){
            while(j > 0 && dest.charAt(j) != dest.charAt(i)){
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] str = new String[m];
        String t = "";
        for (int i=0;i<m;i++){
            str[i] = scanner.nextLine();
        }
        t = scanner.nextLine();
        int[] poscount = new int[t.length()];
        int count = 0;

        for (int i=0;i<m;i++){
            int[] next = kmpnext(str[i]);
            count += kmp(t,str[i],next,poscount);
        }
        int tempval = 0;
        int tempmax = 0;
        boolean flag = false;
        for (int i=0;i<poscount.length;i++){
            if (poscount[i] != 1){
                flag = true;
            }
            if (flag && poscount[i] == 1){
                flag = false;
                tempval += tempmax-1;
                tempmax = 0;
            }
            if (tempmax < poscount[i]){
                tempmax = poscount[i];
            }

        }
        System.out.println(count - tempval);
    }
}
