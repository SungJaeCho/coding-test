package kko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main01 {
    public static void main(String[] args) {
        int x = 8;
        Integer[] arr01 = {1,2,20,8,8,1,2,5,8,0};
        Integer[] index01 = {100,2,1,3,4};
        List<Integer> arr = Arrays.asList(arr01);
        List<Integer> indexes = Arrays.asList(index01);
        solution(x, arr, indexes);
    }

    public static List<Integer> solution(int x, List<Integer> arr, List<Integer> indexes) {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> xIndexes = new ArrayList<>();

        // x의 인덱스만구함
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i) == x) {
                xIndexes.add(i+1);
            }
        }
        for(int i=0; i<indexes.size(); i++) {
            if(indexes.get(i) > xIndexes.size()) {
                resultList.add(-1);
            } else {
                resultList.add(xIndexes.get(indexes.get(i)-1));
            }
        }
        System.out.println(xIndexes);
        System.out.println(resultList);

        return resultList;
    }
}
