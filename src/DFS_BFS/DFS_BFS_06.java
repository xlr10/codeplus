package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_BFS_06 {

    static int n;
    static int cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        arr=new int[n];
        //list = new ArrayList<>();
        hm = new HashMap<>();
        String tmp_str = br.readLine();

        for(int a=0;a<n;a++){
            arr[a] = Integer.valueOf(tmp_str.split(" ")[a]);
        }
//        for(int e: arr) System.out.print(e+" ");
//        System.out.println();

        back(0,0);
        List<Map.Entry<Integer,Integer>> l_e = new ArrayList<>(hm.entrySet());
        Collections.sort(l_e, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        int a=0;
        int tagert =0;
        for(Map.Entry<Integer,Integer> e : l_e){
            //System.out.println(e.getKey());
            if(e.getKey()!=a){
                tagert =a;
                break;
            }
            a++;
        }
        if(a== l_e.size()) tagert=a;
        System.out.println(tagert);

//        ArrayList<Integer> tmp_list = new ArrayList<>();
//        for(int a =0;a< list.size();a++){
//            if(!tmp_list.contains(list.get(a))) tmp_list.add(list.get(a));
//        }
//
//        Collections.sort(tmp_list);
//        //System.out.println(tmp_list);
//
//        int target =0;
//        int a;
//        for(a=0;a< tmp_list.size();a++){
//            if(tmp_list.get(a) != a){
//                target =a;
//                break;
//            }
//        }
//        if(a == tmp_list.size()) target=a;
//        System.out.println(target);
    }
    //static ArrayList<Integer> list;
    static HashMap <Integer,Integer> hm;
    public static void back(int depth, int sum){
        if(depth == n){
            //System.out.println("sum: "+sum);
            //list.add(sum);
            hm.put(sum,0);
            return;
        }
        back(depth+1, sum + arr[depth]);
        back(depth+1, sum);
    }

}

