package BNR_TR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BNR_TR_01 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] n_arr = new int[n];

        String[] tmp = br.readLine().split(" ");

        for(int a=0;a<n;a++){
            n_arr[a]=Integer.valueOf(tmp[a]);
        }

        int m = Integer.valueOf(br.readLine());
        int[] m_arr = new int[m];
        tmp = br.readLine().split(" ");

        for(int a=0;a<m;a++){
            m_arr[a]=Integer.valueOf(tmp[a]);
        }

//        System.out.println(n);
//        for(int e : n_arr){
//            System.out.print(e+" ");
//        }
//        System.out.println();
//        System.out.println(m);
//        for(int e : m_arr){
//            System.out.print(e+" ");
//        }
//        System.out.println();

        Arrays.sort(n_arr);

        StringBuilder sb = new StringBuilder();

        for(int e : m_arr){
            //System.out.println("now t:"+e);

            int start = 0;
            int end = n_arr.length-1;
            int mid = 0;
            int rtn=0;

            while(start <= end){
                mid = (start+end) / 2;
                if(e < n_arr[mid]){
                    end = mid-1;
                }else if(e > n_arr[mid]){
                    start=mid+1;
                }else{
                    rtn=1;
                    break;
                }
            }
            //System.out.println(rtn);
            sb.append(rtn).append('\n');
        }
        System.out.println(sb);


    }

    
}

