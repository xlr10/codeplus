package Brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Brute_force_02 {
    static int cnt=0;
    static String[][] bg = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = "";

        int n = Integer.parseInt(br.readLine());
        bg = new String[n][n];
        int x=0;

        while((tmp=br.readLine()) != null){
            int y=0;
            for(String e : tmp.split("")){
                //System.out.print(e+ " ");
                bg[x][y++]=e;
            }
            //System.out.println();
            x++;
        }
        //C C Y Y P P P <- 판별가능?
//        String[] aa ={"C","C","Y","Y","P","P","P","C","Y"};
//
//        int bb_cnt = 0;
//        int tmp_cnt=1;
//        String c_tmp=aa[0];
//        for(int a =1 ;a<aa.length;a++){
//            //연속된 문자의 갯수 최대값
//            if(!aa[a].equals(aa[a-1])){
//                if(tmp_cnt>bb_cnt){
//                    bb_cnt=tmp_cnt;
//                }
//                tmp_cnt=1;
//            }else{
//                //c_tmp=aa[a];
//                tmp_cnt++;
//            }
//        }
//        System.out.println(">>>>"+bb_cnt);



        for(int a=0;a<n;a++){
            for(int b=0; b<n;b++){
                if(a==(n-1) && b==(n-1)){
                    continue;
                }else if(a==(n-1)){
                    swap(a,b,n,0,1);
                }else if(b==(n-1)){
                    swap(a,b,n,1,0);
                }else{
                    swap(a,b,n,1,0);
                    swap(a,b,n,0,1);
                }
            }
        }
        //System.out.println("max cnt: "+cnt);

        System.out.println(cnt);
    }
    public static void swap( int a, int b, int n,int a_x, int b_x){
        //swap
        String ori_a = bg[a+a_x][b+b_x];
        String ori_b = bg[a][b];

        bg[a+a_x][b+b_x] = ori_b;
        bg[a][b] = ori_a;

        //2-loop
        //모든경우생각해서 실패?
        //불필요한것 제거해야?
        //열탐색
        for(int i=0;i<n;i++){
            int tmp_cnt=1;
            for(int j =1 ;j<n;j++){
                if(!bg[i][j-1].equals(bg[i][j])){
                    //System.out.println(bg[i][j-1]+", "+bg[i][j]);
                    //break;
                    //중간에 떨어지고 나중에 이어질때
                    //C C Y Y P P P <- 판별가능?
                    //continue;
                    if(cnt<tmp_cnt){
                        cnt=tmp_cnt;
                    }
                    //여기서 다시 초기화 안해서 2번째 제출시 틀림
                    tmp_cnt=1;
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
                    //break;
                    //continue;
                    if(cnt<tmp_cnt){
                        cnt=tmp_cnt;
                    }
                    //여기서 다시 초기화 안해서 2번째 제출시 틀림
                    tmp_cnt=1;
                }else{
                    tmp_cnt++;
                }
            }
            //System.out.println("tmp_cnt: "+ tmp_cnt);
            if(cnt<tmp_cnt){
                cnt=tmp_cnt;
            }
        }
        bg[a+a_x][b+b_x] = ori_a;
        bg[a][b] = ori_b;
    }
}
