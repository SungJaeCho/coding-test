package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class theKWeakestRowsInAMatrix1337 {
    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows(mat,k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] arr = new int[mat.length];

        for(int i=0; i<mat.length; i++) {
            int s = 0;
            for(int j = 0; j<mat[i].length; j++) {
                if(mat[i][j] == 1) s++;
            }
            arr[i] = s;
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

}
