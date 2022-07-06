package Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PERM_05 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n == k){
            System.out.println(0);
        }

//        System.out.println(n);
//        System.out.println(k);

        System.out.println(bfs(n,k));
    }
    //최소 최단 == bfs
    static int MAX_LENG = 10000000;
    static int[] visited = new int[MAX_LENG];
    //public static int bfs(int now, int k){
//        Queue q = new ArrayDeque();
//
//        q.add(now);
//
//        int n = 0;
//        output[now] =1;
//
//        while(!q.isEmpty()){
//            if(now == k){
//                return output[n] -1;
//            }
//            if(output[n+1] == 0 && n+1 < 100000){
//
//            }
//        }
//
//        return -1;
//    }


    public static int bfs(int node, int target){
        Queue<Integer> q = new LinkedList();
        q.add(node);

        int n =0;
        visited[node] = 1;

        if(node == target){
            return 0;
        }

        while(!q.isEmpty()){
            n = q.remove();
//            System.out.println(">>>>> N : "+n);

            if(n == target){
                //System.out.println("find");
                return visited[n]-1;
            }

            if(n-1 >= 0 && visited[n-1]==0){
                q.add(n-1);
                visited[n-1]=visited[n]+1;
//                System.out.println("n-1: "+ (n-1));
            }
            if(n+1 <= MAX_LENG && visited[n+1]==0){
                q.add(n+1);
                visited[n+1]=visited[n]+1;
//                System.out.println("n+1: "+ (n+1));
            }
            if(n*2 <= MAX_LENG && visited[n*2]==0){
                q.add(n*2);
                visited[n*2]=visited[n]+1;
//                System.out.println("n*2: "+ (n*2));
            }
        }

        return -1;
    }

}

