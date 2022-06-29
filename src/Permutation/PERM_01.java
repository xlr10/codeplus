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


        int[] num= {1,2,3,4};
        int select_cnt = 3;

        System.out.println("===================================");
        System.out.println("select_ORDERBY_unDISTINCT");
        select_ORDERBY_unDISTINCT(num,new int[select_cnt], new boolean[num.length], 0, select_cnt);

        System.out.println("===================================");
        System.out.println("select_ORDERBY_unDISTINCT");
        select_ORDERBY_unDISTINCT(num,new int[select_cnt], new boolean[num.length], 0, select_cnt);

        System.out.println("===================================");
        System.out.println("select_unORDERBY_DISTINCT");
        select_unORDERBY_DISTINCT(num,0, new boolean[num.length], 0, select_cnt);

        System.out.println("===================================");
        System.out.println("select_unORDERBY_unDISTINCT");
        select_unORDERBY_unDISTINCT(num, new int[select_cnt],0, new boolean[num.length], 0, select_cnt);

    }
    //순열 = 선택 후(1과 3을 선택) 정렬(1과 3을 한쌍으로 취급)   ->   (1,3) != (3,1)
    static void select_ORDERBY_DISTINCT(int[] num, int[] output, boolean[] chk, int depth, int select_num){
        if(depth == select_num){
            for(int e: output) System.out.print(e);
            System.out.println();
            return;
        }else{
            for(int a=0;a<num.length;a++){
                if(chk[a]) continue;
                chk[a]=true;
                output[depth]=a+1;
                select_ORDERBY_DISTINCT(num,output, chk,depth+1,select_num);
                chk[a]=false;
            }
        }
    }

    //중복순열 = 선택 후 정렬 _중복허용
    static void select_ORDERBY_unDISTINCT(int[] num, int[] output, boolean[] chk, int depth, int select_num){
        if(depth == select_num){
            for(int e: output) System.out.print(e);
            System.out.println();
            return;
        }else{
            for(int a=0;a<num.length;a++){
                //if(chk[a]) continue;
                chk[a]=true;
                output[depth]=a+1;
                select_ORDERBY_unDISTINCT(num,output, chk,depth+1,select_num);
                chk[a]=false;
            }
        }
    }

    //조합 = 선택 후 비정렬(1과 3을 맵에 넣음?)     ->   (1,3) == (3,1)
    static void select_unORDERBY_DISTINCT(int[] num, int start, boolean[] chk, int depth, int select_num){
        if(depth == select_num){
            for(int a=0;a<num.length;a++){
                if(chk[a]) System.out.print(num[a]);
            }
            System.out.println();
            return;
        }else{
            for(int a=start;a<num.length;a++){
                if(chk[a]) continue;
                chk[a]=true;
                select_unORDERBY_DISTINCT(num,a+1, chk,depth+1,select_num);
                chk[a]=false;
            }
        }
    }

    //조합 = 선택 후 비정렬 _중복허용
    static void select_unORDERBY_unDISTINCT(int[] num, int[] output, int start, boolean[] chk, int depth, int select_num){
        if(depth == select_num){
            for(int e : output) System.out.print(e);
            System.out.println();
            return;
        }else{
            for(int a=start;a<num.length;a++){
                //if(chk[a]) continue;
                chk[a]=true;
                output[depth]=num[a];
                select_unORDERBY_unDISTINCT(num,output, a, chk,depth+1,select_num);
                chk[a]=false;
            }
        }
    }

    static public void pre_permutation(int[] num){
        //7 6 5| 1 2 3 <- 첫번째
        //7 5 6| 3 2 1 <- 마지막
        //1. < < < 여기찾기 > .. > 바뀌는  부분   <<< 에서 >>>
        //2. >>>로 끝나면 마지막 순열임

        //12345 12354 12435 12453 12534 12543
        //13245 13254 13425 13452 13524 13542
        //14235 14253 14325 14352 14523 14532

        //스왑은 1번
        //이후 내부 정렬


    }
}

