package BNR_TR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BNR_TR_02 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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
        Arrays.sort(n_arr);


        for(int e : m_arr){
            int start = 0;
            int end = n_arr.length;
            int mid=0;
            int lower =0;
            int higher=0;

            while(start < end){
                mid = (start+end)/2;
                if(e <= n_arr[mid]){
                    end = mid;
                }
                if(e > n_arr[mid]){
                    start = mid+1;
                }
            }
            //System.out.println("start: "+start);
            //System.out.println("lower: "+end);
            lower = start;

            start = 0;
            end = n_arr.length;
            mid=0;

            while(start < end){
                mid = (start+end)/2;
                if(e < n_arr[mid]){
                    end = mid;
                }
                if(e >= n_arr[mid]){
                    start = mid+1;
                }
            }
            //System.out.println("start: "+start);
            higher=start;
//            System.out.println("lower: "+lower);
//            System.out.println("higher: "+higher);
//            System.out.println();
            //System.out.println((higher-lower+1));

            sb.append((higher-lower)+" ");

            //System.out.println("t: "+e);
        }
        System.out.println(sb);




    }

    
}

