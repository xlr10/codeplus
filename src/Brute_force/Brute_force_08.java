package Brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brute_force_08 {
    static int cnt=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.valueOf(br.readLine());
        int[] input = new int[target];
        int[] num = {1,2,3};

        //1 2 3 으로 입력 값 조합(도합)
        for(int a=0;a<target;a++){
            input[a]=Integer.parseInt(br.readLine());
        }


//        //순열 반복문으로 구현
//        for(int a=0;a<3;a++){
//            String tmp = "";
//            tmp+=num[a];
//            for(int b=0;b<3;b++){
//                tmp+=num[b];
//                for(int c=0;c<3;c++){
//                    tmp+=num[c];
//                    System.out.println(tmp);
//                    tmp= tmp.substring(0,2);
//                }
//                tmp= tmp.substring(0,1);
//            }
//        }

        for(int e : input){
            cnt=0;
            loop(e,num,0,"",e);
            System.out.println(cnt);
        }
    }
    public static void loop(int input, int[] num,int sum, String n, int target){
        if(input==0){
            //System.out.println(n);
            return;
        }else{
            for(int a=0;a<3;a++){
                String tmp = n;
                n+=num[a];
                sum+=num[a];
                if(sum==target){
                    //System.out.println(n+" "+sum);
                    cnt++;
                }
                loop(input-1,num,sum, n,target);
                n=tmp;
                sum-=num[a];
            }
        }
    }
}
