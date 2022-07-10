package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFS_BFS_05 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //int[] num = new int[25];
        s= Integer.valueOf(br.readLine().split(" ")[1]);
        String[] tmp_str = br.readLine().split(" ");
        int[] num = new int[tmp_str.length];

        int i=0;
        for(String e : tmp_str){
            num[i++] = Integer.valueOf(e);
        }
//        for(int e: num) System.out.print(e);
//        System.out.println();
        cnt=0;
        for(int select_num=1;select_num<num.length;select_num++){
            dfs(num, new int[select_num], 0, new boolean[num.length], 0, select_num);

        }
        System.out.println(cnt);



        //back(num,0,0);

//        if(s==0) cnt--;
//        System.out.println(cnt);

    }
    static int cnt;
    static int s;

    public static void back(int[] num, int depth, int sum){
        if(depth == num.length){
            //System.out.println(sum);
            if(sum == s)     cnt++;
            return;
        }
        back(num,depth+1,sum+num[depth]);
        back(num,depth+1,sum);

    }

    public static void dfs(int[] num, int[] output, int start, boolean[] chk, int depth , int select_num){
        if(depth == select_num){
            int sum=0;
            for(int e : output){
                sum+=num[e-1];
                //System.out.print(e);
            }
            if(sum == s){
                //System.out.println(" sum: "+sum);
                cnt++;
            }

            //System.out.println();
            //cnt++;
            return;
        }else{
            for(int a=start;a<num.length;a++){
                if(chk[a]) continue;
                chk[a] = true;
                output[depth] = a+1;
                dfs(num,output,a, chk, depth+1, select_num);
                chk[a] = false;
            }
        }
    }
}

