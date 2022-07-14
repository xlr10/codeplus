package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFS_BFS_14 {

    static int N;
    static ArrayList<String> arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp_str = br.readLine();

        N = Integer.valueOf(tmp_str);

        arr = new ArrayList<>();

        for(int a=0;a<N;a++){
            arr.add(br.readLine());
        }

        //for(String e :arr) System.out.println(e);

        ArrayList<String> tmp_arr = new ArrayList<>();

        for(int a=0;a<arr.get(0).length();a++){
            char c = arr.get(0).charAt(a);
            boolean flag =true;
            for(int b=1;b<N;b++){
                if(c!=arr.get(b).charAt(a)){
                    flag=false;
                }
            }
            if(flag){
                tmp_arr.add(String.valueOf(c));
            }else{
                tmp_arr.add("?");
            }
        }
        //System.out.println(tmp_arr);
        tmp_str="";
        for(String e : tmp_arr) tmp_str+=e;
        System.out.println(tmp_str);
    }

}

