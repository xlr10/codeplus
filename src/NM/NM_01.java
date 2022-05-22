package NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NM_01 {
    static int cnt=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //int target = Integer.valueOf(br.readLine());
        String tmp = br.readLine();
        int n = Integer.parseInt(tmp.split(" ")[0]);
        int m = Integer.parseInt(tmp.split(" ")[1]);

        System.out.println(n);
        System.out.println(m);

        //1~n 까지 중복없이 m개 뽑기

        int[] num = new int[n];
        boolean[] chk = new boolean[n];

        comb(num,chk,m,0,n);
    }
    //접근방법
    // i 는 뽑은 수(현재 인덱스)
    //종료조건 : 뽑은수==m (뽑고자 하는수)
    //종료가 아니면 : 루프
    //  루프는 num 배열안에서
    //  현재 인덱스가 true 면 다음 루프 (continue)
    //              아니면 num 채우고 다음 재귀 후 현재 인덱스 true 풀기
    public static void comb(int[] num, boolean[] chk, int m,int i, int n){
        //현재 뽑은 수 == i
        if(i==m){
            //for print
            for(int e : num){
                //n개 중에 m개를 뽑는것이므로 m<=n일수 있어서 0인것 제외
                if(e!=0) System.out.print(e+" ");
            }
            System.out.println();
            return;
        }else{
            //왜 루프? == 루프->num 배열 탐색 그래서 0~n-1까지 순회
            for(int a=i;a<n;a++){
                //이전 재귀에서 값넣은 인덱스면 넘기기
                if(chk[a])  continue;

                //지금 위치 true == 이후 재귀에서 값 다시 안넣게
                chk[a]=true;

                //뽑은 수 저장
                num[i]=a+1;

                //다음 재귀
                comb(num,chk,m,i+1,n);

                //현재 위치가 2이고 배열이 1 2 x 일때, x의 재귀 종료후 2를 3으로 바꾸기 위해 현재위치 잠금해제
                chk[a]=false;
            }
//            if(!제hk[i]){
//                chk[i]=true;
//            }
//            for(int a=1;a<=n;a++){
//                comb(num,chk,m,i+1,n);
//            }
//            chk[i]=false;
        }
    }
}



//package NM;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class NM_01 {
//    static int cnt=0;
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        //int target = Integer.valueOf(br.readLine());
//        String tmp = br.readLine();
//        int n = Integer.parseInt(tmp.split(" ")[0]);
//        int m = Integer.parseInt(tmp.split(" ")[1]);
//
//        int[] num = new int[n];
//        boolean[] chk = new boolean[n];
//
//        System.out.println(n);
//        System.out.println(m);
//
//        comb(0,n,m,num,chk);
//
//    }
//    public static void comb(int index, int n, int m, int[] num, boolean[] chk){
//        if(index==m){
//            //
//            for(int e: num){
//                if(e!=0)    System.out.print(e+" ");
//            }
//            System.out.println();
//            return;
//        }else{
//            for(int a=0;a<n;a++){
//                if(chk[a]) continue;
//                chk[a]=true;
//                num[index]=a+1;
//                comb(index+1,n,m,num,chk);
//                chk[a]=false;
//            }
//        }
//    }
//}
