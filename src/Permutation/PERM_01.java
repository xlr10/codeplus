package Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class PERM_01 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int intput_cnt =Integer.parseInt(br.readLine());
        int[] intput_num = new int[intput_cnt];

        for(int a=0;a<intput_cnt;a++){
            intput_num[a]= Integer.parseInt(br.readLine());
        }

        int[] num = {1,2,3};

        for(int select_num : intput_num){
            target = select_num;
            cnt=0;
            for(int a=0;a<=select_num;a++){
                select_num(num, 0, new int[select_num], 0, a);
            }
            System.out.println(cnt);
        }
//        System.out.println(">>>>");
//
//        int[] num = {1,2,3,4};
//        int select_num = 3;
//
//        System.out.println("select_ORDERBY_DISTINCT");
//        select_ORDERBY_DISTINCT(num, new int[select_num], new boolean[num.length], 0, select_num);
//        System.out.println("cnt : " + select_ORDERBY_DISTINCT_cnt);
//
//        System.out.println("select_ORDERBY_unDISTINCT");
//        select_ORDERBY_unDISTINCT(num, new int[select_num], new boolean[num.length], 0, select_num);
//        System.out.println("cnt : " + select_ORDERBY_unDISTINCT_cnt);
//
//        System.out.println("select_unORDERBY_DISTINCT");
//        select_unORDERBY_DISTINCT(num, 0, new boolean[num.length], 0, select_num);
//        System.out.println("cnt : " + select_unORDERBY_DISTINCT_cnt);
//
//        System.out.println("select_unORDERBY_unDISTINCT");
//        select_unORDERBY_unDISTINCT(num, 0, new int[select_num], new boolean[num.length], 0, select_num);
//        System.out.println("cnt : " + select_unORDERBY_unDISTINCT_cnt);
    }
    static int target = 0;
    static int cnt = 0;

    public static void select_num(int[] num, int start, int[] output, int depth, int select_num){
        if(depth == select_num){
            int sum =0;
            for(int e : output){
                if(e!=0) sum+=e;
            }
            if(sum == target) cnt++;
            return;
        }else{
            for(int a=start; a<num.length;a++){
                output[depth]=a+1;
                select_num(num,start,output,depth+1,select_num);
            }
        }
    }


    public static int select_ORDERBY_DISTINCT_cnt     = 0;
    public static int select_ORDERBY_unDISTINCT_cnt   = 0;
    public static int select_unORDERBY_DISTINCT_cnt   = 0;
    public static int select_unORDERBY_unDISTINCT_cnt = 0;

    public static void select_ORDERBY_DISTINCT(int[] num, int[] output, boolean[] chk , int depth, int select_num){
        if(depth == select_num){
            for(int e : output) System.out.print(e);
            System.out.println();
            select_ORDERBY_DISTINCT_cnt++;
            return;
        }else{
            for(int a=0;a<num.length;a++){
                if(chk[a]) continue;
                chk[a]=true;
                output[depth]=a+1;
                select_ORDERBY_DISTINCT(num, output, chk, depth+1, select_num);
                chk[a]=false;
            }
        }
    }
    public static void select_ORDERBY_unDISTINCT(int[] num, int[] output, boolean[] chk , int depth, int select_num){
        if(depth == select_num){
            for(int e : output) System.out.print(e);
            System.out.println();
            select_ORDERBY_unDISTINCT_cnt++;
            return;
        }else{
            for(int a=0;a<num.length;a++){
                //if(chk[a]) continue;
                chk[a]=true;
                output[depth]=a+1;
                select_ORDERBY_unDISTINCT(num, output, chk, depth+1, select_num);
                chk[a]=false;
            }
        }
    }
    public static void select_unORDERBY_DISTINCT(int[] num, int start, boolean[] chk, int depth, int select_num){
        if(depth == select_num){
            for(int a=0;a<num.length;a++){
                if(chk[a]) System.out.print(num[a]);
            }
            System.out.println();
            select_unORDERBY_DISTINCT_cnt++;
            return;
        }else{
            for(int a=start; a<num.length;a++){
                if(chk[a]) continue;
                chk[a]=true;
                select_unORDERBY_DISTINCT(num, a+1, chk, depth+1, select_num);
                chk[a]=false;
            }
        }
    }
    public static void select_unORDERBY_unDISTINCT(int[] num, int start, int[] output, boolean[] chk, int depth, int select_num){
        if(depth == select_num){
            for(int e : output) System.out.print(e);
            System.out.println();
            select_unORDERBY_unDISTINCT_cnt++;
            return;
        }else{
            for(int a=start;a<num.length;a++){
                //if(chk[a])  continue;
                chk[a] = true;
                output[depth]=a+1;
                select_unORDERBY_unDISTINCT(num, start, output, chk, depth+1, select_num);
                chk[a] = false;
            }
        }
    }
}

