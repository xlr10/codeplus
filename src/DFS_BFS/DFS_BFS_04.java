package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFS_BFS_04 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp_str;
        int[] num;  // = {1, 2, 3, 5, 8, 13, 21, 34};
        int select_num = 6;

        while(!(tmp_str=br.readLine()).equals("0")){
            //System.out.println(tmp_str);

            num = new int[Integer.valueOf(tmp_str.split(" ")[0])];

            for(int a=1;a<tmp_str.split(" ").length;a++){
                num[a-1] = Integer.valueOf(tmp_str.split(" ")[a]);
            }
//            for(int e: num){
//                System.out.print(e);
//            }
//            System.out.println();

            dfs(num, new int[select_num], 0, new boolean[num.length],0,select_num);
            System.out.println();
        }

    }
    public static void dfs(int[] num,int[] output, int start, boolean[] chk, int depth, int select_num){
        if(depth == select_num){
            for(int e: output) System.out.print(num[e-1]+" ");
            System.out.println();
            return;
        }else{
            for(int a=start;a<num.length;a++){
                if(chk[a]) continue;
                chk[a] = true;
                output[depth] = a+1;
                dfs(num,output,a,chk,depth+1, select_num);
                chk[a] = false;
            }
        }

    }
}

