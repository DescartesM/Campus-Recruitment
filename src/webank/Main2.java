package webank;

import java.util.*;

public class Main2 {
    public static int recursionBinarySearch(int[] arr,int key,int low,int high){
        // out of range, not found
        if( low > high){
            return -1;
        }

        int mid = (low + high) / 2;
        if(arr[mid-1]*arr[mid-2]>= key*2){
            return recursionBinarySearch(arr, key, low, mid - 1);
        }else if(arr[mid-1]*arr[mid]< key*2){
            return recursionBinarySearch(arr, key, mid + 1, high);
        }else {
            return mid;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] mymap = new int[10000];
        for (int i=0 ;i<10000;i++){
            mymap[i] = i;
        }
        int circle = recursionBinarySearch(mymap, n, 0, 8888);
        int presum = (circle-1)*(circle-2)/2;
        int resume = n - presum;
        boolean oddflag = false;
        if (circle%2 == 0){
            oddflag = true;
        }
        if (!oddflag){
            System.out.println(Integer.toString(resume) +'/'+Integer.toString(circle-resume));
        }
        else {
            System.out.println(Integer.toString(circle-resume) +'/'+Integer.toString(resume));
        }
    }
}

