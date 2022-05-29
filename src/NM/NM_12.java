package NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class NM_12 {

    static HashMap<String,Boolean> chk_map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
            if(chk_map.containsKey(sb.toString())){
                return null;
            }else{
                chk_map.put(sb.toString(),Boolean.TRUE);
                sb.append("\n");
                return sb;
            }

        }else {
            StringBuilder sb = new StringBuilder();
            for(int a=0;a<n;a++){
                //if(chk[a]) continue;
                //System.out.println(num[a] + ", " + num_mapp[a]);
                if(index>0){
                    if(num[index-1]>num_mapp[a]){
                        //System.out.println("     >>>>>"+num[a-1]+", "+num_mapp[a]);
                        continue;
                    }
                }
                chk[a]=true;
                num[index]=num_mapp[a];
                StringBuilder sb_tmp = comb(n,m,num,num_mapp,chk,index+1);
                if(sb_tmp!=null){
                    sb.append(sb_tmp);
                }
                chk[a]=false;
            }
            return sb;
        }
    }
}

