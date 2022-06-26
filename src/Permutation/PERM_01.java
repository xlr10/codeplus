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

