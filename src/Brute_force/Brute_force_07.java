package Brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Brute_force_07 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.valueOf(br.readLine());

        //System.out.println(target);
        //123456789101112131415 -> 21

        //0~9   = 9
        //10~99 = 9*(10^1) *2    ->9*(10^n) * (n+1)
        //100~999 = 9*(10^2) *3
        //1000~9999  x%10^n    (n>=0)
        //15 -> (15-9)*2 +9
        //120 -> (120-99)*3 + 90*2 + 9*1
        //120/100 = 1

        //자리수 판별 10^n 나눔 == 1 n+1이 자리수    120/10^2 -> 3자리
        //n 만큼 반복 -> 누적 -> (120-누적)(n+1) + 누적

        if(target<10){
            System.out.println(target);
            return;
        }

        int n=0;
        for(;;n++){
            if(target/((int)Math.pow(10,n)) <10){
                break;
            }
        }
        //System.out.println(n);

        int sum=0;
        int sum_digit=0;
        for(int a=0;a<n;a++){
            sum+= 9*((int)Math.pow(10,a))*(a+1);
            sum_digit+=9*((int)Math.pow(10,a));
            //System.out.println(sum);
        }
        System.out.println((target-sum_digit)*(n+1) + sum);





    }
}
