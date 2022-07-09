package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFS_BFS_03 {

    static int N;
    static int[][] input;
    static ArrayList<Integer> list;
    static boolean[] chk = new boolean[30];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        input = new int[N][N];
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;

        for(int a=0;a<N;a++){
            int b=0;
            for(String e : br.readLine().split(" ")){
                input[a][b] = Integer.valueOf(e);
                b++;
            }
        }

//        System.out.println("N: "+N);
//        for(int[] a: input){
//            for(int b : a){
//                System.out.print(b);
//            }
//            System.out.println();
//        }

        dfs(0,0,N/2);
        System.out.println(min);

    }

    static public void dfs(int depth,int start, int select_num){
        if(depth == select_num){
            //System.out.println(list);
            ArrayList<Integer> tmp_arr = new ArrayList<Integer>(list);
            int tmp_sum_team_a=0;
            for(int a=0;a<list.size();a++){
                //for(int b=0;)
                int now = list.get(a);
                tmp_arr.remove(a);
                for(int e : tmp_arr){
                    //System.out.println("a,e : "+a+","+e);
                    tmp_sum_team_a+=input[now][e];
                }
                tmp_arr.add(a,now);
            }
            //System.out.println("team a :" +tmp_sum_team_a);

            ArrayList<Integer> tmp_arr_b =  new ArrayList<>();
            for(int a=0;a<N;a++)    tmp_arr_b.add(a);
            for(int a=0;a<list.size();a++)  tmp_arr_b.remove(list.get(a));

            //System.out.println(tmp_arr_b);

            tmp_arr = tmp_arr_b;
            int tmp_sum_team_b=0;
            for(int a=0;a<tmp_arr_b.size();a++){
                //for(int b=0;)
                int now = tmp_arr_b.get(a);
                tmp_arr.remove(a);
                for(int e : tmp_arr){
                    tmp_sum_team_b+=input[now][e];
                }
                tmp_arr.add(a,now);
            }
            //System.out.println("team b :" +tmp_sum_team_b);
//
            min =Math.min(min,Math.abs(tmp_sum_team_a-tmp_sum_team_b));
//            System.out.println(min);



            return;
        }else{
            for(int a=start;a<N; a++){
                if(chk[a]) continue;
                chk[a] = true;
                list.add(a);
                dfs(depth+1,a,select_num);
                list.remove(list.size()-1);
                chk[a] = false;
            }
        }

    }
}

