package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_BFS_12 {

    static int N;
    static int M;
    static ArrayList<Pos> select_pos;
//    static int[][] arr={
//            {2, 0, 0, 0, 1, 1, 0},
//            {0, 0, 1, 0, 1, 2, 0},
//            {0, 1, 1, 0, 1, 0, 0},
//            {0, 1, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 1, 1},
//            {0, 1, 0, 0, 0, 0, 0},
//            {0, 1, 0, 0, 0, 0, 0}
//    };
    static int[][] arr;
    static int[][] tmp_arr;
    static int[][] visit;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp_str = br.readLine();
        N = Integer.valueOf(tmp_str.split(" ")[0]);
        M = Integer.valueOf(tmp_str.split(" ")[1]);
        arr=new int[N][M];

        for(int a=0;a<N;a++){
            tmp_str = br.readLine();
            for(int b=0;b<M;b++){
                arr[a][b] = Integer.valueOf(tmp_str.split(" ")[b]);
            }
        }

        int select_num = 3;
        select_pos = new ArrayList<>();


        for(int a=0;a<N;a++){
            for(int b=0;b<M;b++){
                if(arr[a][b]==0){
                    select_pos.add(new Pos(a,b));
                }
            }
        }

        visit = new int[N][M];
        MAX = Integer.MIN_VALUE;

        select(select_pos.size(), new int[select_num],0, new boolean[select_pos.size()],0,select_num);

        System.out.println(MAX);





        //spread_virus(new int[3]);
        //print();

//        System.out.println("@@@@@@@@@@@@@@");
//        for(int a=0;a<N;a++){
//            for(int b=0;b<M;b++){
//                System.out.print(arr[a][b]);
//            }
//            System.out.println();
//        }
    }
    public static void print(){
        System.out.println("------------------");
        for(int a=0;a<N;a++){
            for(int b=0;b<M;b++){
                System.out.print(tmp_arr[a][b]);
            }
            System.out.println();
        }
    }
    //바이러스 퍼지는 함수
    public static void spread_virus(int[] pos){
        //call by value?
        ////int[][] tmp_arr = arr;
        //2차는 깊은 복사 메서드로 안됨 -> for
        //tmp_arr=arr.clone();
        tmp_arr=new int[N][M];
        for(int a=0;a<N;a++){
            for(int b=0;b<M;b++){
                tmp_arr[a][b]=arr[a][b];
            }
        }

        //print();

        //받은 좌표에 벽세우고
        for(int a=0;a<3;a++){
            tmp_arr[select_pos.get(pos[a]).x][select_pos.get(pos[a]).y]=1;
            //System.out.println(select_pos.get(pos[a]).x+", "+select_pos.get(pos[a]).y);
        }
        //여기서 dfs -> bfs?
        for(int a=0;a<N;a++){
            for(int b=0;b<M;b++){
                if(tmp_arr[a][b]==2){
                    tmp_arr[a][b]=0;
                    dfs(a,b);
                    //bfs(a,b);
                }
            }
        }
        //print();
        //System.out.println(count(tmp_arr));

        MAX = Math.max(count(tmp_arr),MAX);
//        if(count(tmp_arr) < 10){
//            System.out.println(count(tmp_arr));
//            print();
//        }


//
//        //받은 좌표에 벽 복구하고
//        for(int a=0;a<3;a++){
//            tmp_arr[select_pos.get(pos[a]).x][select_pos.get(pos[a]).y]=0;
//        }
    }
    static int[] dx ={1,-1,0,0};
    static int[] dy ={0,0,1,-1};
    public static void bfs(int x,int y){
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x,y));

        while(!q.isEmpty()){
            Pos tmp = q.poll();
            x=tmp.x;
            y=tmp.y;

            for(int a=0;a<4;a++){
                int nx = x+dx[a];
                int ny = y+dy[a];

                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(visit[x][y]==0){
                        visit[nx][ny]= visit[x][y]+1;
                        if(tmp_arr[nx][ny]!=1){
                            tmp_arr[nx][ny]=2;
                            q.add(new Pos(nx,ny));
                        }

                    }
                }
            }

        }
    }

    public static void dfs(int x,int y){

        if(x>=0 && x<N && y>=0 && y<M){
            if(tmp_arr[x][y]!=0){
                return;
            }

            if(tmp_arr[x][y]!=1){
                tmp_arr[x][y]=2;
                dfs(x+1,y);
                dfs(x-1,y);
                dfs(x,y+1);
                dfs(x,y-1);
            }

        }
    }

    //0인칸 세는함수
    public static int count(int[][] tmp){
        int num=0;
        for(int a=0;a<N;a++){
            for(int b=0;b<M;b++){
                if(tmp[a][b]==0) num++;
            }
        }
        return num;
    }

    //3개 뽑는함수
    //최대 8*8 중 3개 뽑기
    static int cnt=0;
    public static void select(int num,int[] output, int start, boolean[] chk, int depth, int select_num){
        if(depth == select_num){
//            for(int e : output) System.out.print(e+" ");
//            System.out.println();
            cnt++;

            //3개 뽑고
            //output[0~2]
            //해당 좌표로 바이러스 퍼지고
            spread_virus(output);
            //0갯수 세고
            //max에 넣고

            return;
        }else{
            for(int a=start;a<num;a++){
                if(chk[a]) continue;
                chk[a]=true;
                output[depth]=a;
                select(num, output, a+1,chk,depth+1,select_num);
                chk[a]=false;
            }
        }
    }
    static class Pos{
        int x;
        int y;
        Pos(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}

