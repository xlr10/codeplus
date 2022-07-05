package Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class PERM_04 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int select_num = Integer.parseInt(br.readLine());
        input_sym = br.readLine().split(" ");
        //input_sym = "< >".split(" ");
        //System.out.println(input_sym);

        select_num = 9;

        output = new ArrayList<>();
        select_num("", new boolean[select_num+1], 0, select_num+1);

        Collections.sort(output);
        System.out.println(output.get(output.size()-1));
        System.out.println(output.get(0));

    }
    public static String[] input_sym;
    public static ArrayList<String> output;

    public static boolean chk (String a, String b, String sym){
        if(sym.equals(">")){
            if(Integer.valueOf(a) > Integer.valueOf(b)) return true;
            else    return false;
        }else{
            if(Integer.valueOf(a) < Integer.valueOf(b)) return true;
            else    return false;
        }
    }
    public static void select_num(String str, boolean[] chk, int depth, int select_num){
        if(depth == input_sym.length+1){
            //System.out.println(str);
            output.add(str);
            return;
        }else{
            for(int a=0;a<select_num;a++){
                if(chk[a]) continue;
                if(depth==0 || chk(String.valueOf(str.charAt(str.length()-1)), String.valueOf(a), input_sym[depth-1])){
                    chk[a] = true;
                    select_num(str+a, chk, depth+1, select_num);
                    chk[a] = false;
                }



            }
        }
    }
}

