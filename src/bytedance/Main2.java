package bytedance;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {//注意while处理多个case
            int n=in.nextInt();
            String input = in.nextLine();
            String[] str = new String[n];
            for(int i=0;i<n;i++){
                str[i]=in.nextLine();
            }
            quchong(str);
        }
    }

    public static void quchong(String[] str) {
        for(String res:str){
            char tempchar;
            String pattern1= "";
            String pattern2= "";
            for(int i=0;i<res.length();i++){
                tempchar = res.charAt(i);
                if(pattern2==""){
                    if(pattern1.length()==1){
                        if(pattern1.charAt(0)==tempchar){
                            pattern1+=tempchar;
                        }else{
                            pattern1=tempchar+"";
                        }
                    }else if(pattern1.length()==2){
                        if(pattern1.charAt(0)==tempchar){
                            res=res.substring(0, i)+res.substring(i+1);
                            i--;
                            continue;
                        }else{
                            pattern2=tempchar+"";
                        }
                    }else{
                        pattern1=tempchar+"";
                    }
                }else{
                    if(pattern2.length()==1){
                        if(pattern2.charAt(0)==tempchar){
                            res=res.substring(0, i)+res.substring(i+1);
                            i--;
                            continue;
                        }else{
                            pattern1=tempchar+"";
                            pattern2="";
                            continue;
                        }
                    }
                }

            }
            System.out.println(res);
        }
    }
}