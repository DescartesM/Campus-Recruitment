package bytedance;

import java.util.*;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []coin={1,4,16,64};
        int all=1024;
        int t=0;
        int result = 0;

        int value=n;
        int temp=1024-value;
        int sum;
        for(int i=0;i<=temp/coin[3];i++)
            for(int j=0;j<=temp/coin[2];j++)
                for(int k=0;k<=temp/coin[1];k++)
                    for(int l=0;l<=temp/coin[0];l++)
                    {
                        int count=temp-(i*coin[3]+j*coin[2]+k*coin[1]+l*coin[0]);
                        sum=i*coin[3]+j*coin[2]+k*coin[1]+l*coin[0];
                        int num=i+j+k+l;
                        if(sum==temp&&count>=0)
                        {
                            if(t==0)
                                result=num;
                            t++;
                            if(t>0)
                                result=result<num?result:num;
                        }

                    }
        System.out.println(result);
    }

}
