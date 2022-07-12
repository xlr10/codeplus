package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class DFS_BFS_10 {

    static int max;
    static HashMap<String,Integer> hm;

    static int R;
    static int C;
    static String[][] arr;
//    static String[][] arr ={
//            {"H","F","D","F","F","B"},
//            {"A","J","H","G","D","H"},
//            {"D","G","A","G","E","H"}
//    };


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp_str = br.readLine();

        R=Integer.valueOf(tmp_str.split(" ")[0]);
        C=Integer.valueOf(tmp_str.split(" ")[1]);
        arr = new String[R][C];

        //System.out.println(R+" "+C);

        for(int a=0;a<R;a++){
            tmp_str=br.readLine();
            for(int b=0;b<C;b++){
                arr[a][b] = String.valueOf(tmp_str.charAt(b));
            }
        }

//        R=3;
//        C=6;

//        for(int a=0;a<R;a++){
//            for(int b=0;b<C;b++){
//                System.out.print(arr[a][b]);
//            }
//            System.out.println();
//        }

        max =0;
        hm=new HashMap<>();

        back(0,0, 0);
        System.out.println(max);

    }
    public static void back(int x, int y, int cnt){


        if(x>=0 && x<R && y>=0 && y<C){
            if(hm.containsKey(arr[x][y])){
                //System.out.println("cnt: "+cnt);
                max=Math.max(max,cnt);
                return;
            }
            hm.put(arr[x][y],0);

            cnt++;
            back(x+1,y,cnt);
            back(x-1,y,cnt);
            back(x,y+1,cnt);
            back(x,y-1,cnt);

            hm.remove(arr[x][y]);
        }

    }
}

