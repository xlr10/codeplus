package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_02 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int n = Integer.valueOf(in);

        // 1 1
        // 2 2
        // 3 3
        // 4 5
        // 5 8
        // 6 13/ 7 21/ 8 34/ 9 55
        // n = n-1 + n-2  (n>2)
        //n=1000;

        if(n<=2){
            System.out.println(n);
        }else{
            long sum=0;
            long a1=2;
            long a2=1;

            for(int a=3; a<=n;a++){
                sum=a1 + a2;
                a2=a1;
                a1=sum%1007;
            }
            System.out.println(sum);
            //System.out.println(sum);
        }
    }
}

