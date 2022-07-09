package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFS_BFS_01 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        a=new String[n];

        for(int i=0;i<n;i++){
            a[i] = br.readLine();
            //System.out.println(a[i]);
        }


        //System.out.println(n);
        //System.out.println(a);
        //System.out.println(b);

        //System.out.println((int)a.charAt(0) - 65);

        max =0;
        cnt=0;
        list = new ArrayList<>();
        visit = new boolean[20];

        perm(0,10);
        //perm(0,5);
        //System.out.println(cnt);
        System.out.println(max);

    }
    static int n;
    static String[] a;

    static boolean[] visit;
    static ArrayList<Integer> list;
    static int max=0;

    static int cnt;

    public static void perm(int depth, int select_num){
        if(depth == select_num){
            //System.out.println(list);
            //cnt++;
            int sum_a =0;
            int sum_b =0;
            //System.out.println(list);

            for(int j=0;j<n;j++){
                sum_a=0;
                for(int i=0;i<a[j].length();i++){
                    //System.out.println(a.charAt(i));
                    sum_a += list.get((int)a[j].charAt(i)-65) * Math.pow(10,a[j].length()-1-i);
                    cnt++;
                }
                sum_b+=sum_a;
            }


            //System.out.println(sum_a + sum_b);
            if(max < sum_b){
                max = sum_b;
            }
            return;
        }
        for(int a=select_num ; a>0; a--){
            if(visit[a]) continue;
            visit[a] = true;
            list.add(a-1);
            perm(depth+1, select_num);
            list.remove(list.size()-1);
            visit[a] = false;

        }
    }
}

