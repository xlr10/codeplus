package Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class PERM_01 {

    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String n = br.readLine();
//        int num[] = new int[Integer.parseInt(n)];
//
//        System.out.println(n);
//
//        int a=0;
//        for(String e : br.readLine().split(" ")){
//            num[a++] = Integer.parseInt(e);
//        }
//
//        for(int e : num){
//            System.out.print(e+" ");
//        }
//        System.out.println();
//
//        pre_permutation(num);


        //복기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //System.out.println(br.readLine());
        String line=null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }

        System.out.println(">>>>");

        int[] num = {1,2,3,4};
        int select_num = 3;

        System.out.println("select_ORDERBY_DISTINCT");
        select_ORDERBY_DISTINCT(num, new int[select_num], new boolean[num.length], 0, select_num);
        System.out.println("cnt : " + select_ORDERBY_DISTINCT_cnt);

        System.out.println("select_ORDERBY_unDISTINCT");
        select_ORDERBY_unDISTINCT(num, new int[select_num], new boolean[num.length], 0, select_num);
        System.out.println("cnt : " + select_ORDERBY_unDISTINCT_cnt);

        System.out.println("select_unORDERBY_DISTINCT");
        select_unORDERBY_DISTINCT(num, 0, new boolean[num.length], 0, select_num);
        System.out.println("cnt : " + select_unORDERBY_DISTINCT_cnt);

        System.out.println("select_unORDERBY_unDISTINCT");
        select_unORDERBY_unDISTINCT(num, 0, new int[select_num], new boolean[num.length], 0, select_num);
        System.out.println("cnt : " + select_unORDERBY_unDISTINCT_cnt);
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

