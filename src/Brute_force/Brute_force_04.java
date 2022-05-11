package Brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brute_force_04 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        int btn_cnt = Integer.valueOf(br.readLine());
        String []err_btn = null;

        if(btn_cnt==0){
            //고장 버튼수 없을때 처리
            System.out.println(target.length());
            return;
        }else{
            err_btn = br.readLine().split(" ");
        }


        System.out.println("target: "+target);
        System.out.println("btn_cnt: "+btn_cnt);
        System.out.print("    >>>");
        for(String e : err_btn){
            System.out.print(e+ " ");
        }
        System.out.println();


        //최소
        //초기값 100
        //고장난 버튼수 -> 고장난 버튼리스트
        //입력 457
        //-> 100에 4 5 9 --
        //최소

        //모든경우
        //각 경우 카운트 ex 4 5 9 -- 면 5번
        //그중 최소인 경우 저장후 완료시 프린트

        //+ - 도 고장나는 경우

        //배열에서 고장난 버튼 빼기 이후 루프돌면서 모든 경우만들기?

        //String[] btn ={"0","1","2","3","4","5","6","7","8","9","+","-"};
        String[] btn ={"0","1","2","3","4","5","6","7","8","9"};
        //err btn 제거
        for(String e :err_btn){
            for(int a=0;a<btn.length;a++){
                if(btn[a].equals(e)){
                    btn[a]="err";
                }
            }
        }





    }
}
