package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_BFS_07 {

    static int N;
    static int[] arr;
    static int[] sym;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        arr =new int[N];
        sym =new int[4];

//        N= 2;
//        arr= new int[N];
//        arr[0] =5;
//        arr[1] = 6;
//        sym = new int[4];
//        sym[0] =1;
//        sym[1] =1;
//        sym[2] =1;
//        sym[3] =1;



        String[] tmp_str = br.readLine().split(" ");

        for(int a=0;a<N;a++){
            arr[a] = Integer.valueOf(tmp_str[a]);
        }
//        for(int e : arr) System.out.print(e);
//        System.out.println();

        tmp_str = br.readLine().split(" ");

        for(int a=0;a<4;a++){
            sym[a] = Integer.valueOf(tmp_str[a]);
        }
//        for(int e : sym) System.out.print(e);
//        System.out.println();

        back(1,arr[0]);
        System.out.println(MAX);
        System.out.println(MIN);


    }
    public static void back(int depth, int sum){
        if(depth == N){
            //System.out.println(sum);
            MAX = Math.max(MAX,sum);
            MIN = Math.min(MIN,sum);
            return;
        }
        for(int a=0;a<4;a++){
            if(sym[a]>0){
                //System.out.println("a: "+a);
                sym[a]--;
                switch(a){
                    case 0: back(depth+1, sum+arr[depth]); break;
                    case 1: back(depth+1, sum-arr[depth]); break;
                    case 2: back(depth+1, sum*arr[depth]); break;
                    case 3: back(depth+1, sum/arr[depth]); break;
                }
                sym[a]++;
            }

        }

    }

}

