package NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NM_02 {
    static int cnt=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp = br.readLine();
        int n = Integer.parseInt(tmp.split(" ")[0]);
        int m = Integer.parseInt(tmp.split(" ")[1]);

        int[] num = new int[n];
        boolean[] chk = new boolean[n];


        comb(n,m,num,chk,0);

    }
    public static void comb(int n, int m, int[] num, boolean[] chk, int i){
        if(i==m){
            //
            for(int e: num){
                if(e!=0)    System.out.print(e+" ");
            }
            System.out.println();
            return;
        }else{
            //for(int a=start;a<=n;a++){
            for(int a=i;a<n;a++){
                if(chk[a]) continue;
                if(i>0){
                    if(num[i-1] > (a+1)){
                        continue;
                    }
                }
                chk[a]=true;
                num[i]=a+1;
                comb(n,m,num,chk,i+1);
                chk[a]=false;
            }
        }
    }
}
