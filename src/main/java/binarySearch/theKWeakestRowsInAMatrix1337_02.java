package binarySearch;

import java.util.*;

public class theKWeakestRowsInAMatrix1337_02 {

    public static void main(String[] args) {
//        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
//        int k = 3;
        int[][] mat = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k = 2;
        System.out.println(Arrays.toString(kWeakestRows(mat,k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int y = mat.length, x = mat[0].length, kix = 0;
        int[] vis = new int[y], ans = new int[k];
        for (int j = 0; j <= x; j++)
            for (int i = 0; i < y; i++) {
                if (vis[i] == 0 && (j == x || mat[i][j] == 0)) {
                    ans[kix++] = i;
                    vis[i]++;
                }
                if (kix == k) return ans;
            }
        return ans;
    }

}
