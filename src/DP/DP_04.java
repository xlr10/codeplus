package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DP_04 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
//        int n = Integer.valueOf(in);
//        int p[]= new int[n+1];
//
//        String[] str_p = br.readLine().split(" ");
//
//        for(int a=1;a<=n;a++){
//            p[a]=Integer.valueOf(str_p[a-1]);
//            //System.out.println(p[a]);
//        }
//        //x4 = max(p1+x3  p2+x2  p3+x1  p4+x0)
//        //x3 = max(p1+x2  p2+x1  p3+x0)
//        //x2 = max(p1+x1  p2+x0)
//        //x1 = max(p1+x0)
//        //x0 = 0
//        //int x = 0;
//        //System.out.println(Collections.max(arr));
//
//
//        int[] arr =new int[n+1];
//        arr[1]=p[0];
//        for(int a=1;a<=n;a++){
//            ArrayList<Integer> x =new ArrayList<>();
//            for(int b=1;b<=a;b++){
//                x.add(p[b] + arr[a-b]);
//                System.out.println("b:"+b +"  "+(p[b] + arr[a-b]));
//                //arr[a] =
//                //p[0 1]
//            }
//            arr[a] = Collections.max(x);//max
//        }
//
//        System.out.println(arr[n]);


        //System.out.println(in);
        int nodeNum   = Integer.valueOf(in.split(" ")[0]);
        int lineNum   = Integer.valueOf(in.split(" ")[1]);
        int startNode = Integer.valueOf(in.split(" ")[2]);

        G g =new G(nodeNum);
        for(int a=0;a<lineNum;a++){
            String tmp = br.readLine();
            //System.out.println(tmp);
            int from = Integer.valueOf(tmp.split(" ")[0]) -1;
            int to   = Integer.valueOf(tmp.split(" ")[1]) -1;
            g.add(from,to);
        }
        g.DFS(startNode-1);
        g.BFS(startNode-1);



    }
    static class G{
        int n;
        LinkedList<Integer>[] arr;
        G(int n){
            this.n=n;
            arr= new LinkedList[n];
            for(int a=0;a<arr.length;a++){
                arr[a]= new LinkedList<>();
            }
        }

        public void add(int a, int b){
            arr[a].add(b);
            arr[b].add(a);
        }

        public void DFSUtil(int nowNode, boolean[] visit){
            System.out.print((nowNode+1)+" ");
            visit[nowNode]=true;

            Collections.sort(arr[nowNode]);
            Iterator<Integer> iter = arr[nowNode].iterator();

            while (iter.hasNext()){
                int next = iter.next();
                if(!visit[next]){
                    DFSUtil(next,visit);
                }

            }
        }

        public void BFSUtil(int nowNode, boolean[] visit){

            Deque<Integer> q =new LinkedList<>();
            q.add(nowNode);
            visit[nowNode]=true;

            System.out.print((nowNode+1)+" ");

            while (!(q.isEmpty())){

                int now = q.poll();
                Collections.sort(arr[now]);

                //System.out.println(">> "+now);

                for(int a=0;a<arr[now].size();a++){
                    if(!visit[arr[now].get(a)]){
                        visit[arr[now].get(a)]=true;
                        q.add(arr[now].get(a));
                        System.out.print((arr[now].get(a)+1)+" ");
                    }
                }
            }



        }

        public void DFS(int startNode){
            boolean[] visit=new boolean[this.n];
            DFSUtil(startNode,visit);
            System.out.println();
        }

        public void BFS(int startNode){
            boolean[] visit=new boolean[this.n];
            BFSUtil(startNode,visit);
        }
    }
}

