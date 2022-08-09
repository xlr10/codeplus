package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_BFS_13 {

    static int N;
    static int K;
    static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp_str = br.readLine();

        String asd = "123s";
        //asd.up
        System.out.println(asd.toUpperCase());
//        System.out.println(asd.);
        //asd.substring()
        double dsa =0.025;
        System.out.println(Math.ceil(dsa));
        //
        System.out.println(Math.ceil((double)(334-180)/6));
        HashMap<String,String> gm = new HashMap<>();
        //gm.en
        //gm.ge
        //gm.en
        //Map.Entry
        //gm.con
        //System.out.println(dsa.intValue());
//        Integer aasd = 1;
        //a/asd.d



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
        String answer ="NO";

        for(int a=0;a<=arr.get(0).size()-K;a++){ //1000
            ArrayList<Integer> target     = new ArrayList<>();
            ArrayList<Integer> rev_target = new ArrayList<>();

            for(int b=0;b<K;b++)                target.add(arr.get(0).get(a+b));
            for(int b=target.size()-1;b>=0;b--) rev_target.add(target.get(b));
//            System.out.println(target);
//            System.out.println(rev_target);

            //int arr_cnt =0;
            boolean arr_chk = false;
            for(int b=1;b<arr.size();b++){ //100

                //여기서 1제외 프로그램 검증
                for(int c=0;c<=arr.get(b).size()-K;c++){ //1000
                    boolean flag = true;

                    for(int e=0;e<K;e++){ //1000
                        //System.out.println(arr.get(b).get(c+e) +"  "+ target.get(e));
                        if(arr.get(b).get(c+e) != target.get(e)){
                            flag=false;
                            //arr_chk=false;
                            break;
                        }
                    }
                    if(flag){
                        //arr_cnt++;
                        arr_chk=true;
                        continue;
                    }

                    flag=true;
                    for(int e=0;e<K;e++){
                        if(arr.get(b).get(c+e) != rev_target.get(e)){
                            flag=false;
                            //arr_chk=false;
                            break;
                        }
                    }
                    if(flag){
                        //arr_cnt++;
                        arr_chk=true;
                        continue;
                    }
//                    arr_chk=false;
//                    break;

                }
                if(!arr_chk) break;
            }

            //if(arr_cnt == arr.size()-1){
            if(arr_chk){
                answer = "YES";
                break;
            }
        }
        System.out.println(answer);
    }

//    static boolean check(int []number, int []compare) {
//        boolean flag = true;
//        int compareSize = compare.length;
//        int startPos = 0;
//
//        if(number.length < compare.length) {
//            return false;
//        }
//
//        for(int i=0;i<number.length;i++) {
//            int start = i;
//            if(start + compareSize <= number.length) {
//                startPos = 0;
//                flag = true;
//                for(int j=start ;j<start+compareSize;j++) {
//                    if(number[j] != compare[startPos]) {
//                        flag = false;
//                        break;
//                    }
//                    startPos++;
//                }
//                if(flag == true) {
//                    return true;
//                }
//
//            }
//
//        }
//
//
//        return flag;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        int M;
//        int numberList[][] = new int[N][];
//        int compare[] = new int[K];
//
//        for(int i=0;i<N;i++) {
//            st = new StringTokenizer(br.readLine());
//            M = Integer.parseInt(st.nextToken());
//            st = new StringTokenizer(br.readLine());
//            numberList[i] = new int[M];
//            for(int j=0;j<M;j++) {
//                numberList[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        System.out.println(N);
//        System.out.println(K);
//
//        for(int[] a : numberList){
//            for(int b : a) System.out.print(b+" ");
//            System.out.println();
//        }
//
//        String result = "no";
//        int start = 0;
//        boolean flag = true;
//
//        for(int i=0;i<numberList[0].length;i++) {
//            if(i+K > numberList[0].length) break;
//            start = 0;
//            flag = true;
//
//            for(int j=i;j<i+K;j++) {
//                compare[start] = numberList[0][j];
//                start++;
//            }
//
//            for(int k=1;k<N;k++) {
//                if(check(numberList[k], compare)==true) continue;
//                int reverseList[] = new int[K];
//                int end = K;
//                for(int z=0;z<K;z++) {
//                    reverseList[z] = compare[end-1];
//                    end--;
//                }
//                if(check(numberList[k], reverseList)==true) continue;
//
//                flag = false;
//                result = "NO";
//                break;
//            }
//
//            if(flag==true) {
//                result = "YES";
//
//                break;
//            }
//
//
//        }
//
//        System.out.println(result);
//    }

}

