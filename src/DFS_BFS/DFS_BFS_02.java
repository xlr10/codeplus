package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFS_BFS_02 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n = Integer.valueOf(br.readLine());



        //System.out.println(n);
        //System.out.println(a);
        //System.out.println(b);

        //System.out.println((int)a.charAt(0) - 65);

        max =0;
        cnt=0;
        list = new ArrayList<>();
        visit = new boolean[20];

        //perm(0,2);
        //perm(0,4);
        //System.out.println(cnt);
        //System.out.println(max);
        int[] num = {1,2,3,4};
        int select_num = 6;

        select(num, new int[select_num], new boolean[num.length],0, select_num);

    }
    static int[] tmp={1, 2, 3, 4, 5, 6};
    static int[] tmp_sym ={2, 1, 1, 1};
    static int[] sym ={0,0,0,0};

    static String[] a;

    static boolean[] visit;
    static ArrayList<Integer> list;
    static int max=0;

    static int cnt;

    public static void select(int[] num, int[] output, boolean[] chk, int depth, int select_num){
        if(depth == select_num){
            for(int i=0;i<output.length;i++){
                sym[output[i]-1]++;
                //System.out.print(output[i]);
            }
            //System.out.print(" : ");
            for(int e: sym) System.out.print(e +",");
            System.out.println();
            //System.out.println();

            if(sym[0]==tmp_sym[0] && sym[1]==tmp_sym[1] && sym[2]==tmp_sym[2] && sym[3]==tmp_sym[3]){
                for(int e: tmp_sym) System.out.print(e +",");
                System.out.print(" : ");
                for(int e: sym) System.out.print(e +",");
            }

            for(int i=0;i<4;i++) sym[i]=0;



            return;
        }else{
            for(int i=0;i<num.length;i++){
                if(chk[i]) continue;
                //chk[i] = true;
                output[depth]=i+1;
                select(num,output,chk, depth+1, select_num);
                //chk[i] = false;
            }
        }
    }

    public static void perm(int depth,  int select_num){

        if(depth == select_num){
            System.out.println(list);
            return;
        }
        for(int i=0;i<select_num;i++){
            if(visit[i]) continue;
            visit[i]=true;
            list.add(i);
            perm(depth+1,select_num);
            list.remove(list.size()-1);
            visit[i]=false;
        }


    }
}

