package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_03 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int n = Integer.valueOf(in);

        // 1 1
        // 2 3 %2 == 1*2 +1
        // 3 5   == 3*2 -1
        // 4 9 1 111*2 1111 =11
        // 5 17? 1 1111*2  111*3   111*2 111111 1+8+6+6 = 21

        //n=2*(n-1)-1  (n>2)
        //n=1000;

        if(n==1){
            System.out.println(n);
        }else{
            long sum=0;
            long a1=1;

            for(int a=2; a<=n;a++){
                if(a%2==0){
                    //*2 +1
                    sum=a1*2 +1;
                }else{
                    //*2 -1
                    sum=a1*2 -1;
                }

                a1=sum%10007;
                //System.out.println("a:"+a+"  "+sum+" : "+a1);
            }
            System.out.println(sum%10007);
            //System.out.println(sum);
        }
    }
}

