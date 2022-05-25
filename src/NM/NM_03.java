package NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NM_03 {
    static int cnt=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //int target = Integer.valueOf(br.readLine());
        String tmp = br.readLine();
        int n = Integer.parseInt(tmp.split(" ")[0]);
        int m = Integer.parseInt(tmp.split(" ")[1]);

        //System.out.println(n);
        //System.out.println(m);

        //1~n 까지 중복없이 m개 뽑기

        int[] num = new int[n];
        boolean[] chk = new boolean[n];

        System.out.println(comb(num,chk,m,0,n).toString());
    }
    //접근방법
    // i 는 뽑은 수(현재 인덱스)
    //종료조건 : 뽑은수==m (뽑고자 하는수)
    //종료가 아니면 : 루프
    //  루프는 num 배열안에서
    //  현재 인덱스가 true 면 다음 루프 (continue)
    //              아니면 num 채우고 다음 재귀 후 현재 인덱스 true 풀기
    public static StringBuilder comb(int[] num, boolean[] chk, int m,int i, int n){
        //현재 뽑은 수 == i
        if(i==m){
            //for print
            //String tmp ="";
            StringBuilder sb = new StringBuilder();
            for(int a=0;a<m;a++){
                //n개 중에 m개를 뽑는것이므로 m<=n일수 있어서 0인것 제외
                if(num[a]!=0){
                    //System.out.print(e+" ");
                    //tmp+=e+" ";
                    if(a==(m-1)){
                        sb.append(num[a]);
                    }else{
                        sb.append(num[a]+" ");
                    }
                }
            }
            sb.append("\n");
            //System.out.println(tmp.substring(0,tmp.length()-1));
            //System.out.println(sb.toString());
            return sb;
        }else{
            //왜 루프? == 루프->num 배열 탐색 그래서 0~n-1까지 순회
            //시간초과
            //넘기기? // 메모이제이션으로 했던거 안하기 ss
            //string builder 사용
            StringBuilder sb = new StringBuilder();
            for(int a=0;a<n;a++){
                //이전 재귀에서 값넣은 인덱스면 넘기기
                //if(chk[a])  continue;

                //지금 위치 true == 이후 재귀에서 값 다시 안넣게
                //chk[a]=true;

                //뽑은 수 저장
                num[i]=a+1;

                //다음 재귀
                sb.append(comb(num,chk,m,i+1,n));
                //chk[a]=false;
            }
            return sb;
        }
    }
}

