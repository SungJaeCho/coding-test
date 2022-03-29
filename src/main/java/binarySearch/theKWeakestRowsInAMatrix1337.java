package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class theKWeakestRowsInAMatrix1337 {
    static List<Integer> list = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
//        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
//        int k = 3;
        int[][] mat = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k = 2;
        System.out.println(Arrays.toString(kWeakestRows(mat,k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] arr = new int[mat.length];
        list.clear();
        result.clear();

        for(int i=0; i<mat.length; i++) {
            int s = 0;
            for(int j = 0; j<mat[i].length; j++) {
                if(mat[i][j] == 1) s++;
            }
            arr[i] = s;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i<arr.length; i++) {
            sort(arr[i], i);
        }
        System.out.println(result);

        int[] resultArr = new int[k];
        for (int i=0; i<k; i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }

    public static void sort(int n, int index) {
        boolean chk = false;

        if(list.isEmpty()) {
            list.add(n);
            result.add(0);
        } else {
            for(int i=0; i<list.size(); i++) {
                if(n < list.get(i)) {
                    list.add(i,n);
                    result.add(i,index);
                    chk = true;
                    break;
                }
            }
            if(!chk) {
                list.add(n);
                result.add(list.size()-1);
            }
        }
    }

}
