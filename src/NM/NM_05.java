package NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class NM_05 {
    static int cnt=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //int target = Integer.valueOf(br.readLine());
        String tmp = br.readLine();
        int n = Integer.parseInt(tmp.split(" ")[0]);
        int m = Integer.parseInt(tmp.split(" ")[1]);

        //System.out.println(n);
        //System.out.println(m);
        tmp=br.readLine();
        //System.out.println(tmp);

        //1~n 까지 중복없이 m개 뽑기

        int[] num = new int[n];
        int[] num_mapp = new int[n];
        boolean[] chk = new boolean[n];

        int i=0;
        for(String e : tmp.split(" ")){
            num_mapp[i++] = Integer.parseInt(e);
        }

        //Collections.sort(num_mapp);

        //int[] 등 static 배열 정렬
        Arrays.sort(num_mapp);

        System.out.println(comb(n,m,num,num_mapp,chk,0).toString());
    }
    public static StringBuilder comb(int n, int m ,int[] num,int[] num_mapp, boolean[] chk, int index){
        if(index==m){
            StringBuilder sb = new StringBuilder();
            for(int a=0;a<m;a++){
                if(num[a]!=0){
                    if(a!=m-1){
                        sb.append(num[a]+" ");
                        //sb.append(num_mapp[a]+" ");
                    }else {
                        sb.append(num[a]);
                        //sb.append(num_mapp[a]);
                    }
                }
            }
            sb.append("\n");
            return sb;
        }else {
            StringBuilder sb = new StringBuilder();
            for(int a=0;a<n;a++){
                if(chk[a]) continue;
                chk[a]=true;
                //num[index]=a+1;
                num[index]=num_mapp[a];
                sb.append(comb(n,m,num,num_mapp,chk,index+1));
                chk[a]=false;
            }
            return sb;
        }
    }
}

