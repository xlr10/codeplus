package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_01 {


    public static void main(String[] args) throws IOException {
//        X가 3으로 나누어 떨어지면, 3으로 나눈다.
//        X가 2로 나누어 떨어지면, 2로 나눈다.
//        1을 뺀다.
        // cnt_n = Min(Min(R_n-1, R_n/3), Min(R_n-1, R_n/2))

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int n = Integer.valueOf(in);

        int[] memo = new int[n+1];

        //System.out.println(n);

        //System.out.println(dp(n, memo));
        //System.out.println("cnt "+cnt);
        //System.out.println(dp_ex(n, memo));

        for(int a=2; a< memo.length;a++){
            memo[a] = memo[a-1]+1;
            if(a%3 == 0){
                memo[a] = Math.min(memo[a/3]+1, memo[a]);
            }
            if(a%2 == 0){
                memo[a] = Math.min(memo[a/2]+1, memo[a]);
            }
        }

        System.out.println(memo[n]);
    }
    //static int cnt =0;

    public static int dp_ex(int n, int[] memo){
        if(n<=1){
            return 0;
        }
        if(memo[n]==0){
            memo[n]=dp_ex(n-1,memo);
            if(n%3 == 0){
                memo[n]= Math.min(memo[n], dp_ex(n/3,memo)) +1;
            }
            if(n%2 == 0){
                memo[n]= Math.min(memo[n], dp_ex(n/2,memo)) +1;
            }
        }
        return memo[n];

    }

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

