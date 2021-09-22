package coupang;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {

        int n = 7;
//        int[][] arr = {{1,2,1},{3,5,1},{4,6,0},{4,7,0}};
        int[][] arr = {{5,6,0},{1,3,1},{1,5,0},{7,6,0},{3,7,1},{2,5,0}};
        System.out.println(Arrays.toString(new String[n]));

        System.out.println(solution(n, arr));

    }

    public static String solution(int n, int[][] delivery) {
        String ans = "";
        String[] rst = new String[n];
        Arrays.fill(rst, "?");

        for(int i=0; i<delivery.length; i++){
            if(delivery[i][2] == 1) {
                rst[delivery[i][0]-1] = "O";
                rst[delivery[i][1]-1] = "O";
                for(int j=0; j<delivery.length; j++){
                    if("O".equals(rst[delivery[j][0]-1]) && "?".equals(rst[delivery[j][1]-1])){
                        rst[delivery[j][1]-1] = "X";
                    } else if("O".equals(rst[delivery[j][1]-1]) && "?".equals(rst[delivery[j][0]-1])){
                        rst[delivery[j][0]-1] = "X";
                    }
                }
            } else if(delivery[i][2] == 0) {
                //확인 "", O, X, ?
                if("O".equals(rst[delivery[i][0]-1])){
                    rst[delivery[i][1]-1] = "X";
                }
                else if("?".equals(rst[delivery[i][0]-1])) {
                    if("O".equals(rst[delivery[i][1]-1])){
                        rst[delivery[i][0]-1] = "X";
                    }/* else if ("?".equals(rst[delivery[i][1]-1])){
                        rst[delivery[i][0]-1] = "X";
                        rst[delivery[i][1]-1] = "X";
                    }*/
                }
            }
        }

        for(String str : rst) {
            ans += str;
        }
        return ans;
    }
}
