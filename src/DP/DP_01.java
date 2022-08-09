package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_01 {


    public static void main(String[] args) throws IOException {
//        X가 3으로 나누어 떨어지면, 3으로 나눈다.
//        X가 2로 나누어 떨어지면, 2로 나눈다.
//        1을 뺀다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int n = Integer.valueOf(in);

        int[] memo = new int[n+1];

        //System.out.println(n);

        System.out.println(dp(n, memo));
        //System.out.println("cnt "+cnt);
    }
    //static int cnt =0;

    public static int dp(int n, int[] memo){
        System.out.println("n: "+n);
        if(n == 1){
            return 0;
        }
        if(memo[n]==0){
            memo[n] = dp(n - 1, memo) + 1;
            if (n % 3 == 0) {
                memo[n] = Math.min(dp(n / 3, memo) +1, dp(n - 1, memo) +1) ;
            }
            if (n % 2 == 0) {
                memo[n] = Math.min(dp(n / 2, memo) +1, dp(n - 1, memo) +1) ;
            }

        }
        return memo[n];
    }

}

