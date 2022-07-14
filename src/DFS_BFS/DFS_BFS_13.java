package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_BFS_13 {

    static int N;
    static int K;
    static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp_str = br.readLine();

        N = Integer.valueOf(tmp_str.split(" ")[0]);
        K = Integer.valueOf(tmp_str.split(" ")[1]);

        arr = new ArrayList<>();

        for(int a=0;a<N*2;a++){
            tmp_str = br.readLine();
            if(a%2!=0){
                String[] tmp_str_arr = tmp_str.split(" ");
                ArrayList<Integer> tmp_list = new ArrayList<>();
                for(int b=0;b<tmp_str_arr.length;b++){
                    tmp_list.add(Integer.valueOf(tmp_str_arr[b]));
                }
                arr.add(tmp_list);
            }
        }

//        for(int a=0;a<arr.size();a++){
//            for(int b=0;b<arr.get(a).size();b++){
//                System.out.print(arr.get(a).get(b)+" ");
//            }
//            System.out.println();
//        }



        //1번 프로그램에서 0~k가 대상 이후 +1 이동
        //loop
            //타겟, 리버스 타겟
            //1번제외 루프타면서
            //0~ len-K 까지 검증 == 검증함수

        for(int a=0;a<=arr.get(0).size()-K;a++){ //1000
            ArrayList<Integer> target = new ArrayList<>();
            ArrayList<Integer> rev_target = new ArrayList<>();

            for(int b=0;b<K;b++) target.add(arr.get(0).get(a+b));
            for(int b=target.size()-1;b>=0;b--) rev_target.add(target.get(b));

            int arr_cnt =0;
            for(int b=1;b<arr.size();b++){ //100

                //여기서 1제외 프로그램 검증
                for(int c=0;c<=arr.get(b).size()-K;c++){ //1000

                    int cnt=0;
                    for(int e=0;e<K;e++){ //1000

                        if(arr.get(b).get(c+e) == target.get(e)){
                            cnt++;
                        }
                        if(cnt>=K){
                            arr_cnt++;
                            break;
                        }
                    }

                    cnt=0;
                    for(int e=0;e<K;e++){

                        if(arr.get(b).get(c+e) == rev_target.get(e)){
                            cnt++;
                        }
                        if(cnt>=K){
                            arr_cnt++;
                            break;
                        }
                    }
                }
            }

            if(arr_cnt >= arr.size()-1){
                System.out.println("YES");
                break;
            }
        }
    }

}

