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

        int[] num = new int[n];
        boolean[] chk = new boolean[n];

        System.out.println(n);
        System.out.println(m);

        comb(0,n,m,num,chk);

    }
    public static void comb(int index, int n, int m, int[] num, boolean[] chk){
        if(index==m){
            //
            for(int e: num){
                if(e!=0)    System.out.print(e+" ");
            }
            System.out.println();
            return;
        }else{
            for(int a=0;a<n;a++){
                if(chk[a]) continue;
                chk[a]=true;
                num[index]=a+1;
                comb(index+1,n,m,num,chk);
                chk[a]=false;
            }
        }
    }
}
