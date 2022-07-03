package Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PERM_02 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp = br.readLine();
        int select_num =Integer.parseInt(tmp.split(" ")[0]);
        int c =Integer.parseInt(tmp.split(" ")[1]);

        tmp = br.readLine();
        //for(String e : tmp.split(" ")) System.out.println(e);

        String[] input = tmp.split(" ");



        select_pwd(input,0,new boolean[input.length], 0,select_num);

        Collections.sort(output);

        for(String e: output){
            System.out.println(e);
        }

    }
    public static ArrayList<String> output = new ArrayList<>();

    public static boolean chk(String tmp){
        String[] mow = {"a", "e", "i", "o", "u"};

        int mow_cnt = 0;
        int not_mow_cnt =0;
        for(String e : mow ){
            if(tmp.contains(e)){
                mow_cnt++;
            }
        }
        not_mow_cnt = tmp.length() - mow_cnt;

        if((mow_cnt == 0) || (not_mow_cnt<2)) return false;
        return true;
    }

    public static void select_pwd(String[] pwd, int start, boolean[] chk, int depth, int select_num){
        if(depth == select_num){
            String tmp ="";
            for(int a=0;a<pwd.length;a++){
                if(chk[a]) tmp+=pwd[a]; //System.out.print(pwd[a]);
            }
            //string 정렬
            char[] c = tmp.toCharArray();
            Arrays.sort(c);
            tmp = new String(c);
            if(chk(tmp)) output.add(tmp);

            return;
        }else{
            for(int a=start ; a<pwd.length;a++){
                if (chk[a]) continue;
                chk[a]=true;
                select_pwd(pwd,a+1,chk,depth+1,select_num);
                chk[a]=false;
            }
        }
    }
}

