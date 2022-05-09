package Brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Brute_force_03 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> input = new ArrayList<>();

        for(String e : br.readLine().split(" ")){
            input.add(Integer.parseInt(e));
        }

        //15 28 19

        int[] num = new int[3];

        //num 012 1씩 증가
        //조건에따라 1로 초기화
        //이후 입력값들과 비교

        int cnt = 0;

        while (true){
            cnt++;
            num[0]++;
            num[1]++;
            num[2]++;

            if(num[0] > 15){ //E
                num[0]=1;
            }
            if(num[1] > 28){ //S
                num[1]=1;
            }
            if(num[2] > 19){ //M
                num[2]=1;
            }
            //System.out.println(num[0]+" "+num[1]+" "+num[2]);

            if((num[0]==input.get(0)) && (num[1]==input.get(1)) && (num[2]==input.get(2))){
                System.out.println(cnt);
                return;
            }
        }
    }
}
