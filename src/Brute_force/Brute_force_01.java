package Brute_force;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;


public class Brute_force_01 {  //rename Main

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println(">>>>>print input");

        String tmp = "";
        ArrayList<Integer> arr= new ArrayList<>();
        int arr_sum = 0;
        while((tmp=br.readLine()) != null){
            arr.add(Integer.valueOf(tmp));
            arr_sum+=Integer.valueOf(tmp);
        }

        int tmp_sum =0;
        for(int a=0;a<arr.size();a++){
            for(int b=0;b< arr.size();b++){
                if(a==b){
                    continue;
                }else {
                    tmp_sum = arr.get(a) + arr.get(b);
                    if((arr_sum - tmp_sum)==100){
                        arr.remove(a);
                        arr.remove(b-1);

                        Collections.sort(arr);
                        for(int e : arr)
                            System.out.println(e);
                        return;
                    }
                }
            }
        }
    }
}
