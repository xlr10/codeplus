package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFS_BFS_08 {

    static int N=6;
    static int M=2;
    static String[][] arr = {
            {".","#"},
            {".","#"},
            {".","#"},
            {"o","#"},
            {"o","#"},
            {"#","#"}
    };
    static int cnt=0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp_str = br.readLine();
//        N = Integer.valueOf(tmp_str.split(" ")[0]);
//        M = Integer.valueOf(tmp_str.split(" ")[1]);
//        arr = new String[N][M];
//
//        for(int a=0;a<N;a++){
//            tmp_str = br.readLine();
//            for(int b=0;b<M;b++){
//                arr[a][b] = String.valueOf(tmp_str.charAt(b));
//            }
//        }


        cnt=0;
        print_arr();

        back(0,0);
        System.out.println(cnt);

    }
    public static void print_arr(){
        for(String[] e : arr){
            for(String d : e ){
                System.out.print(d+" ");
            }
            System.out.println();
        }
    }
    public static boolean chk_out(){
        int o_cnt =0;
        for(String[] e : arr){
            for(String d : e ){
                if(d.equals("o")) o_cnt++;
            }
        }
        if(o_cnt==1 || cnt==10){
            cnt=-1;
            return true;
        }
        return false;
    }
    public static boolean move_o(int x, int y){
        for(int a=0;a<N;a++){
            for(int b=0;b<M;b++){
                if(arr[a][b].equals("o")){
                    //떨어진경우
                    if(a+x <0 || a+x>N || b+y <0 || b+y > M){
                        arr[a][b]=".";
                        //return true; //다른 o 도 움직여야하므로
                        continue;
                    }
                    //벽인경우
                    if(arr[a+x][b+y].equals("#")){
                       return false;
                    }
                    //이동한경우 일반적케이스
                    if(a!=(a+x) && b!=(b+y)){
                        arr[a+x][b+y]="o";
                        arr[a][b]=".";
                    }

                }
            }
        }
        return true;
    }
    public static void back(int x, int y){
        //받은 x,y로 o 이동함수
        //이동가능하면 cnt
        System.out.println("------------");
        System.out.println("x: "+x+" y: "+y);
        print_arr();

        if(move_o(x,y)){
            cnt++;
        }



        //탈출조건 == 둘중 하나가 떨어질떄 == 판별 함수
        if(chk_out()){
            System.out.println("out!");
            print_arr();
            return;
        }
        //벽이 아닐때
        if(x>=0 && x<N && y>=0 && y<M){
            if(!arr[x][y].equals("#")){
                //상하좌우로 모든 o 이동
                back(x,y+1);
                back(x,y-1);
                back(x+1,y);
                back(x-1,y);
            }
        }

    }
}

