package kko;

import java.util.*;

public class Main02 {
    public static void main(String[] args) {
        int x = 8;
        Integer[] arr01 = {1,4,2,4};
        Integer[] index01 = {3,5};

//        Integer[] arr01 = {2,10,5,4,8};
//        Integer[] index01 = {3,1,7,8};
        List<Integer> arr = Arrays.asList(arr01);
        List<Integer> indexes = Arrays.asList(index01);
        solution2(arr, indexes);

    }

    public static List<Integer> solution2(List<Integer> teamK, List<Integer> teamB) {
        List<Integer> resultList = new ArrayList<>();

        Collections.sort(teamK);
        System.out.println(teamK);

        for (int num : teamB) {
            System.out.println(search(teamK, num, 0, teamK.size()-1));
        }
        System.out.println(resultList);

        return resultList;
    }

    public static int search(List<Integer> arr, int target, int low, int high) {

        while(low <= high) {
            int mid = (low+high)/2;

            if(low == high) {
                if(arr.get(high) > target) {
                    return mid;
                } else {
                    return mid+1;
                }
            }

            if(target >= arr.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if(low > high){
            return low;
        }
        return 0;
    }

    public static List<Integer> solution(List<Integer> teamK, List<Integer> teamB) {
        List<Integer> resultList = new ArrayList<>();

        Collections.sort(teamK);
        System.out.println(teamK);

        for(int num : teamB) {
            for(int i=0; i<teamK.size(); i++) {
                if(num < teamK.get(i)) {
                    resultList.add(i);
                    break;
                }
                if(i+1 == teamK.size()) {
                    resultList.add(i+1);
                }

            }
        }
        System.out.println(resultList);

        return resultList;
    }
}
