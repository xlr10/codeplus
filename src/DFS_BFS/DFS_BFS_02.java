package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFS_BFS_02 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        tmp = new int[n];
        tmp_sym = new int[4];

        String[] tmp_str = br.readLine().split(" ");

        for(int i =0; i<n;i++){
            tmp[i] = Integer.valueOf(tmp_str[i]);
        }
        tmp_str = br.readLine().split(" ");
        for(int i=0;i<4;i++){
            tmp_sym[i]= Integer.valueOf(tmp_str[i]);
        }



        backtraking(1,tmp[0]);
        System.out.println(max);
        System.out.println(min);

    }
    public static void backtraking(int depth, int num){
        if(depth == n){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        for(int i=0;i<4;i++){
            if(tmp_sym[i]>0){

                tmp_sym[i]--;

                switch (i){
                    case 0: backtraking(depth+1, num + tmp[depth]); break;
                    case 1: backtraking(depth+1, num - tmp[depth]); break;
                    case 2: backtraking(depth+1, num * tmp[depth]); break;
                    case 3: backtraking(depth+1, num / tmp[depth]); break;
                }
                tmp_sym[i]++;
            }
        }
    }

    static int[] tmp;
    static int[] tmp_sym;
    static int n;

    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
}

