package shenxinfu;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static boolean isHex(char c){
        if (c>= '0' && c<='9'){
            return true;
        }
        else if (c>= 'A' && c<='F'){
            return true;
        }
        else return false;
    }
    public static String convertHexToString(String hex){

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for( int i=0; i<hex.length()-1; i+=2 ){

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char)decimal);

            temp.append(decimal);
        }

        return sb.toString();
    }
    public static String digui(String str){
        for (int j=0;j<str.length() - 2;j++){
            if (str.charAt(j) == '%' && isHex(str.charAt(j+1))&& isHex(str.charAt(j+1))) {
                String temp = str.substring(j+1,j+3);
                temp = convertHexToString(temp);
                String newstr = str.substring(0,j) + temp + str.substring(j+3,str.length());
                return digui(newstr);
            }

        }
        return str;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0;i<n;i++) {
            String res = "";
            String str = sc.nextLine();
            res =  digui(str);
            System.out.println(res);
        }
    }
}
