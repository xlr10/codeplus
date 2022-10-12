package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DP_05 {


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String in = br.readLine();
//
//        int stNum = Integer.valueOf(in.split(" ")[0]);
//        int caseNum = Integer.valueOf(in.split(" ")[1]);
//
//
//        Graph g =new Graph(stNum);
//
//        for(int i=0;i<caseNum;i++){
//            String tmp = br.readLine();
//            int a = Integer.valueOf(tmp.split(" ")[0]) -1;
//            int b = Integer.valueOf(tmp.split(" ")[1]) -1;
//            //System.out.println((a+1)+" "+(b+1));
//            g.add(a,b);
//        }
//        g.topologicalSort();


        Solution s = new Solution();
        int[] t={14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println(s.solution(t));

    }
    static class Solution {
        public int solution(int sticker[]) {
            int answer = 0;


            int i=0;
            int j=0;

            for(int a=0;a<sticker.length;a++){
                if(a%2==0){
                    i+=sticker[a];
                }else{
                    j+=sticker[a];
                }
            }
            answer = Math.max(i,j);


            return answer;
        }
    }






    static class Graph{
        int size;
        LinkedList<LinkedList<Integer>> arr;
        int[] tb;
        boolean[] chk;

        Graph(int n){
            size=n;
            arr = new LinkedList<>();
            tb  = new int[n];
            chk = new boolean[n];

            for(int a=0;a<n;a++){
                arr.add(new LinkedList<>());
            }
        }

        void add(int a,int b){
            arr.get(a).add(b);
            tb[b]++;
        }

        void topologicalSort(){
            //1. 진입차수테이블
            //2. 진입차수 0 -> 큐
            //3. 큐에서 꺼내고 진입차수테이블 갱신
            //4. 갱신수 테이블에 0을 큐에 add
            //5. while(q.isEmpty()){ 3. 4.}

            Deque<Integer> q =new LinkedList<>();
            //caculTable();

            for(int a=0;a<tb.length;a++){
                //System.out.println(">>>>>"+e);
                if(tb[a]==0){
                    q.add(a);
                    chk[a]=true;
                }
            }

            while(!q.isEmpty()){
                int now = q.poll();
                //arr.get(now).clear();
                for(int e: arr.get(now)){
                    if(tb[e]!=0){
                        tb[e]--;
                        if(tb[e]==0 && !chk[e]){
                            q.add(e);
                            chk[e]=true;
                        }
                    }
                }


                System.out.print((now+1)+" ");
                //갱신
                //caculTable();

//                for(int a=0;a<tb.length;a++){
//                    //System.out.println(">>>>>"+e);
//                    if(tb[a]==0 && !chk[a]){
//                        q.add(a);
//                        chk[a]=true;
//                    }
//                }


            }
            System.out.println();

        }

        void caculTable(){
            for(int a=0;a<tb.length;a++)
                tb[a]=0;

            for(int a=0;a<arr.size();a++){
                for(int b=0;b<arr.get(a).size();b++){
                    tb[arr.get(a).get(b)]++;
                }
            }



            for(int e:tb){
                System.out.print(" " +e);
            }
            System.out.println();
        }
    }
    
}

