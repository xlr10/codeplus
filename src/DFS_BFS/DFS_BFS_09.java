package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFS_BFS_09 {

//    static int N;
//    static int[] W;
    static int MAX = Integer.MIN_VALUE;
    static int N;
    //static int[] W ={100, 2, 1, 3, 100};
    static ArrayList<Integer> W;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        String[] tmp_str = br.readLine().split(" ");
//
//        W = new int[tmp_str.length];
//
//        for(int a=0;a<W.length;a++){
//            W[a]=Integer.valueOf(tmp_str[a]);
//        }

        MAX = 0;
        W = new ArrayList<>();
        for(String e: tmp_str){
            W.add(Integer.valueOf(e));
        }



        //100 (2) 1 3 100
        //100 (1) 3 100 -> 100
        //100 (3) 100 -> 100 + 300
        //100 100 -> 100 + 300 + 10000

        for(int a=1;a<W.size()-1;a++){
            dfs(a,0);
        }
        System.out.println(MAX);


    }
    public static void dfs(int depth, int sum){
        int tmp = W.get(depth);
        sum += W.get(depth-1) * W.get(depth+1);
        W.remove(depth);
//        System.out.println(W);
//        System.out.println(depth);

        if(W.size()==2){
            //System.out.println("sum: "+sum);
            MAX=Math.max(MAX,sum);
            W.add(depth,tmp);
            return;
        }


        for (int a = 1; a < W.size()-1;a++){
            dfs(a,sum);
        }
        W.add(depth,tmp);

    }
}

