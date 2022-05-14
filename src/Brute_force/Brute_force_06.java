package Brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Brute_force_06 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.valueOf(br.readLine());
        ArrayList<int[]> input = new ArrayList<>();

        //System.out.println("cnt: "+cnt);

        for(int a=0;a<cnt;a++){
            String[] tmp  = br.readLine().split(" ");
            int[] tmp_input = new int[4]; //m n x y

            for(int b=0;b<4;b++){
                tmp_input[b]=Integer.parseInt(tmp[b]);
            }
            input.add(tmp_input);
        }
        for(int[] e : input){
            for(int j : e){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        //예를 들어, M = 10 이고 N = 12라고 하자. 첫 번째 해는 <1:1>로 표현되고, 11번째 해는 <1:11>로 표현된다. <3:1>은 13번째 해를 나타내고, <10:12>는 마지막인 60번째 해를 나타낸다.
        // 1,1 2,2 3,3 4,4 5,5 6,6 7,7 8,8 9,9 10,10 1,11
        for(int[] now_input : input){
            //int[] now_input = input.get(1);
            int m = now_input[0];
            int n = now_input[1];
            int target_x = now_input[2];
            int target_y = now_input[3];

            int x=1;
            int y=1;

            int tmp=1;
            while (true){
                if(x==target_x && y==target_y){
                    //System.out.println(tmp);
                    System.out.println(tmp+"     x:y = "+ x+":"+y);
                    break;
                }
                if(x==m && y==n){
                    //System.out.println("-1");
                    System.out.println("-1     x:y = "+ x+":"+y+"    tmp"+tmp   );
                    break;
                }

                if(x<m){
                    x++;
                }else{
                    x=1;
                }

                if(y<n){
                    y++;
                }else{
                    y=1;
                }
                tmp++;
            }
        }
    }
}
