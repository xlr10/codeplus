package Brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Brute_force_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println(">>>>>print input");

        String tmp = "";

        //ArrayList<ArrayList<String>> bg = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        String[][] bg = new String[n][n];
        int x=0;

        while((tmp=br.readLine()) != null){
            //System.out.println(tmp);
            int y=0;
            for(String e : tmp.split("")){
                bg[x][y++]=e;
            }
            x++;
        }

//        for(String[] e : bg){
//            for(String f: e){
//                System.out.print(f+" ");
//            }
//            System.out.println();
//        }
//
        int cnt=0;

        for(int a=0;a<n;a++){
            for(int b=0; b<n;b++){

                if(a==(n-1) || b==(n-1)){   //border
                    continue;
                }else{          //swap here
                    //1. swap
                    //2. 2-loop

                    //swap
                    String ori_a = bg[a][b+1];
                    String ori_b = bg[a+1][b];

                    bg[a][b+1] = ori_b;
                    bg[a+1][b] = ori_a;

                    //2-loop
                    //모든경우생각해서 실패?
                    //불필요한것 제거해야?
                    //열탐색
                    for(int i=0;i<n;i++){
                        int tmp_cnt=1;
                        for(int j =1 ;j<n;j++){
                            if(!bg[i][j-1].equals(bg[i][j])){
                                //System.out.println(bg[i][j-1]+", "+bg[i][j]);
                                break;
                            }else{
                                tmp_cnt++;
                            }
                        }
                        //System.out.println("tmp_cnt: "+ tmp_cnt);
                        if(cnt<tmp_cnt){
                            cnt=tmp_cnt;

                        }
                    }
                    //행탐색
                    for(int i=0;i<n;i++){
                        int tmp_cnt=1;
                        for(int j =1 ;j<n;j++){
                            if(!bg[j-1][i].equals(bg[j][i])){
                                //System.out.println(bg[i][j-1]+", "+bg[i][j]);
                                break;
                            }else{
                                tmp_cnt++;
                            }
                        }
                        //System.out.println("tmp_cnt: "+ tmp_cnt);
                        if(cnt<tmp_cnt){
                            cnt=tmp_cnt;

                        }
                    }
                    bg[a][b+1] = ori_a;
                    bg[a+1][b] = ori_b;
                }
            }
        }
        //System.out.println("max cnt: "+cnt);
        System.out.println(cnt);


        //모든 경우 탐색
        // 들어온곳 우하 변경
        // 1행 1열만포문돌면서 경우 이중 포문돌면서 카운트-==처음값과 같은경우
        //
    }
}
