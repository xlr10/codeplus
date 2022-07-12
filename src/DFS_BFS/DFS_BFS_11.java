package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_BFS_11 {

    static int N;
    static int r1,c1, r2,c2;
    static int[][] arr;
    static int[][] visit;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp_str = br.readLine();

        N= Integer.valueOf(tmp_str);
        //System.out.println("N: "+N);

        tmp_str=br.readLine();

        r1 = Integer.valueOf(tmp_str.split(" ")[0]);
        c1 = Integer.valueOf(tmp_str.split(" ")[1]);
        r2 = Integer.valueOf(tmp_str.split(" ")[2]);
        c2 = Integer.valueOf(tmp_str.split(" ")[3]);

//        System.out.println("r1: "+r1);
//        System.out.println("c1: "+c1);
//        System.out.println("r2: "+r2);
//        System.out.println("c2: "+c2);

//        N =7;
//        r1 =6;
//        c1 =6;
//        r2 =0;
//        c2 =1;

        arr = new int[N][N];
        visit = new int[N][N];

        System.out.println(bfs(r1,c1));

//        for(int a=0;a<N;a++){
//            for(int b=0;b<N;b++){
//                System.out.print(visit[a][b]+" ");
//            }
//            System.out.println();
//        }
    }

    //(r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)
    static int[] dx ={-2,-2,0,0,2,2};
    static int[] dy ={-1,1,-2,2,-1,1};
    public static int bfs(int x, int y){
        Queue<Pos> q =new LinkedList<>();

        q.add(new Pos(x,y));


        while (!q.isEmpty()){
            Pos tmp = q.poll();
            x=tmp.x;
            y=tmp.y;

            for(int a=0;a<6;a++){
                int nx = tmp.x+dx[a];
                int ny = tmp.y+dy[a];

                if(nx>=0 && nx<N && ny>=0 && ny<N){
                    if(visit[nx][ny]==0){
                        visit[nx][ny] = visit[x][y] +1;
                        q.add(new Pos(nx,ny));
                        //System.out.println("nx ny: "+nx+","+ny);
                    }
                }
            }
        }
        return visit[r2][c2] ==0? -1:visit[r2][c2];
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

