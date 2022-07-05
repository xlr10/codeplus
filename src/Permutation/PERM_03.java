package Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PERM_03 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        //System.out.println(n);

        input = new int[n][2];

        for(int a=0;a<n;a++){
            String[] tmp = br.readLine().split(" ");
            input[a][0] = Integer.parseInt(tmp[0]);
            input[a][1] = Integer.parseInt(tmp[1]);
        }

//        for(int[] a : input){
//            for(int b : a){
//                System.out.print(b+" ");
//            }
//            System.out.println();
//        }


        max=0;
        int[] num = new int[n];
        for(int a=1;a<=n;a++){
            select_num(num, new int[a], new boolean[num.length],0,a);
        }
        System.out.println(max);


    }

    static int max = 0;
    static int n;
    static int[][] input;

    public static boolean chk (int[] tmp){
        int tmp_day=0;
        for(int e : tmp){
            //System.out.println(">>>> "+e);  //178
            if(tmp_day > n || (input[e-1][0] + (e-1)) > n){
                //System.out.println("out_ false");
                return false;
            }
            if(tmp_day <= e-1){
                //System.out.println("------ "+input[e-1][0]);
                tmp_day = input[e-1][0] + (e-1);
            }else{
                //System.out.println("tmp_ false");
                return false;
            }
        }
        return true;
    }
    public static void select_num(int[] num, int[] output, boolean[] chk, int depth, int select_num){
        if(depth == select_num){
            if(chk(output)){
                int tmp_sum=0;
                for(int e : output){
                    tmp_sum+=input[e-1][1];
                }
                if(max<tmp_sum) {
                    max = tmp_sum;
                }
            }
            return;
        }else{
            for(int a=0;a<num.length;a++){
                if(chk[a]) continue;
                chk[a] = true;
                output[depth] = a+1;
                select_num(num, output, chk, depth+1, select_num);
                chk[a] = false;
            }
        }
    }
}

