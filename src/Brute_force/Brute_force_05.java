package Brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Brute_force_05 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n*m 크기
        //배열값

        //ㄱ ㅁ ㅗ ㅣ ㄹ 모양
        //모든 칸에 넣어서
        //내부합이 최대인값구하기

        //루프 각모양 5회 == 5
        //루프 각모양 회전 *4회 ==4
        //루프 모든 칸 ..회전가능 == n^2 ...total == 20*n^2
            //모든칸 돌때 조건 - 경계 체크 . . 좌표로 배열에 저장하기 .. bfs 처럼

        String[] nm_tmp = br.readLine().split(" ");
        int n = Integer.valueOf(nm_tmp[0]);
        int m = Integer.valueOf(nm_tmp[1]);

//        System.out.println("n:"+n);
//        System.out.println("m:"+m);

        int[][] db = new int[n][m];

        for(int a=0; a<n; a++){
            String[] tmp = br.readLine().split(" ");
            for(int b=0; b<m; b++){
                db[a][b] = Integer.parseInt(tmp[b]);
            }
        }

//        for(int a=0; a<n; a++){
//            for(int b=0; b<m; b++){
//                System.out.print(db[a][b]+" ");
//            }
//            System.out.println();
//        }

        //ㄱ+반대 ㄴ+반 L+반 긴ㄱ+반
        ArrayList<int[][]> tet_01 = new ArrayList<>();
        tet_01.add(new int[][]{{0,0},{0,1},{0,2},{1,2}});
        tet_01.add(new int[][]{{0,0},{0,1},{0,2},{-1,2}});

        tet_01.add(new int[][]{{0,0},{1,0},{2,0},{2,-1}});
        tet_01.add(new int[][]{{0,0},{1,0},{2,0},{2,1}});

        tet_01.add(new int[][]{{-1,0},{0,0},{0,1},{0,2}});
        tet_01.add(new int[][]{{1,0},{0,0},{0,1},{0,2}});

        tet_01.add(new int[][]{{0,0},{1,0},{0,1},{2,0}});
        tet_01.add(new int[][]{{0,0},{1,0},{0,-1},{2,0}});

        //ㅁ
        ArrayList<int[][]> tet_02 = new ArrayList<>();
        tet_02.add(new int[][]{{0,0},{1,0},{0,1},{1,1}});

        //ㅏ
        ArrayList<int[][]> tet_03 = new ArrayList<>();
        tet_03.add(new int[][]{{0,0},{1,0},{2,0},{1,1}});
        tet_03.add(new int[][]{{0,0},{0,1},{0,2},{1,1}});
        tet_03.add(new int[][]{{0,0},{1,0},{1,-1},{2,0}}); //ㅓ
        tet_03.add(new int[][]{{0,0},{0,1},{0,2},{-1,1}}); //ㅗ

        //ㄹ
        ArrayList<int[][]> tet_04 = new ArrayList<>();
        tet_04.add(new int[][]{{0,0},{0,1},{1,1},{1,2}});
        tet_04.add(new int[][]{{-1,1},{0,1},{0,0},{1,0}});

        tet_04.add(new int[][]{{0,1},{0,0},{1,0},{1,-1}});
        tet_04.add(new int[][]{{0,0},{1,0},{1,1},{2,1}});

        //ㅡ+반
        ArrayList<int[][]> tet_05 = new ArrayList<>();
        tet_05.add(new int[][]{{0,0},{0,1},{0,2},{0,3}});
        tet_05.add(new int[][]{{0,0},{1,0},{2,0},{3,0}});

        ArrayList<ArrayList<int[][]>> tet = new ArrayList<>();
        tet.add(tet_01);
        tet.add(tet_02);
        tet.add(tet_03);
        tet.add(tet_04);
        tet.add(tet_05);

        //tet_0n 선택
        //회전
        int sum_max =0;

        for(ArrayList<int[][]> now_tet : tet){
            for(int tet_lot=0;tet_lot<now_tet.size();tet_lot++){
                for(int a=0; a<n; a++){
                    for(int b=0; b<m; b++){

                        //각 좌표 in
                        int tmp_x = 0;
                        int tmp_y = 0;
                        int tmp_sum=0;
                        for(int i=0;i<4;i++){
                            int[] xy = now_tet.get(tet_lot)[i];
                            tmp_x = a+xy[0];
                            tmp_y = b+xy[1];

                            if(tmp_x < 0 || tmp_x >= n || tmp_y < 0 || tmp_y >=m){
                                break;
                            }else{
                                tmp_sum+=db[tmp_x][tmp_y];
                            }
                        }
                        if(sum_max<tmp_sum){
                            sum_max=tmp_sum;
                            //System.out.println("sum_max: "+sum_max+"  ["+a+" "+b+"]"+"  tet_lot:"+tet_lot+"   tmp_xy:"+tmp_x+","+tmp_y);
                        }


                    }
                }
            }
        }
        System.out.println(sum_max);
    }
}
