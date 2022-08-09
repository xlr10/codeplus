package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

public class DFS_BFS_15 {

    static int N;

    public static void main(String[] args) throws IOException {
        //int[] n ={1,2,3,4,5,6,7,8,9};
        //int[][] n ={{80,20},{50,40},{30,10}};
        int[] n ={1,1,2,3,3,2,2};
        solution(n);
        System.out.println("asd");

    }

    public static int solution(int[] tasks) {
        int answer = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int e: tasks){
            if(hm.containsKey(e)){
                hm.put(e,hm.get(e)+1);
            }else{
                hm.put(e,1);
            }
        }


        if(hm.containsValue(1)){
            return -1;
        }else{
            List<Map.Entry<Integer,Integer>> list = new ArrayList<>(hm.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            int n=0;
            for(Map.Entry<Integer,Integer> e : hm.entrySet()){
                //e.getKey()
                //e.getValue()
                if(e.getValue()==3 || e.getValue()==2){
                    n++;
                }else{
                    //if()
                }
            }

        }

        return answer;
    }

//    public static int solution(int k, int[][] dungeons) {
//        int answer = -1;
//
//        System.out.println(dungeons.length);
//        int n =dungeons.length;
//        dfs(n, new int[n], new boolean[n], 0, n, dungeons, k);
//
//        //System.out.println(">>> "+max);
//        answer = max;
//
//        return answer;
//    }
//
//    static int max = Integer.MIN_VALUE;
//    //static int now_k;
//
//    public static void dfs(int num,int[] output, boolean[] chk, int depth, int select_num ,int[][] dungeons, int k){
//        if(depth == select_num){
////            for(int e:output){
////                System.out.print(e);
////            }
////            System.out.println();
//
//            int n=0;
//
//            for(int e: output){
//                //System.out.print(e);
//
//                if(dungeons[e][0] <= k){
//                    k-=dungeons[e][1];
//                    n++;
//                }
//            }
//            //System.out.println(n);
//            max = Math.max(max,n);
//
//
//            return;
//        }else{
//            for(int a=0;a<num;a++){
//                if(chk[a]) continue;
//                chk[a] = true;
//                output[depth]=a;
//                dfs(num,output,chk,depth+1,select_num, dungeons, k);
//                chk[a] = false;
//            }
//        }
//    }

//    public static int solution(int[] levels) {
//        int answer = 0;
//
//        Arrays.sort(levels);
//
//        System.out.println(levels.length * 0.25);
//        System.out.println(levels.length - (levels.length/4));
//        int idx = levels.length - (levels.length/4);
//        //System.out.println(levels[idx]);
//
//        return answer;
//    }

//    public static int solution(String s) {
//        int answer = 0;
//        int max = -1;
//
//        for(int a=0;a<s.length()-2;a++){
//            String tmp = s.substring(a,a+3);
//            //System.out.println(tmp);
//
//            if(tmp.substring(0,1).equals(tmp.substring(1,2))){
//                if(tmp.substring(1,2).equals(tmp.substring(2,3))){
//                    max = Math.max(max, Integer.valueOf(tmp));
//                }
//            }
//        }
//        //System.out.println(max);
//        answer = max;
//        return answer;
//    }

}

