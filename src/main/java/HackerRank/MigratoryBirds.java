package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MigratoryBirds {
    public static void main(String[] args) {
        Integer[] arr = {1 ,4 ,3 ,4 ,5 ,4 ,5 ,5 ,5 ,3,4,3,3};
        List<Integer> list = Arrays.asList(arr);
        list.sort(Comparator.naturalOrder());
//        System.out.println(list);
        System.out.println(migratoryBirds(list));
        System.out.println(migratoryBirds2(list));

    }

    public static int migratoryBirds(List<Integer> arr) {
        Integer[] resultArr = {0,0,0,0,0,0}; // 1~5까지
        for(int i=0; i<arr.size(); i++) {
            resultArr[arr.get(i)] = resultArr[arr.get(i)] + 1;
        }
        int mostBird = 0;
        int index = 1;
        for(int i=1; i<resultArr.length; i++) {
            if(mostBird < resultArr[i]) {
                mostBird = resultArr[i];
                index = i;
            }
        }
        return index;
    }

    static int migratoryBirds2(List<Integer> arr) {
        int[] types = new int[5];
        for(int i=0; i<arr.size(); i++){
            switch(arr.get(i)){
                case 1:
                    types[0]++;
                    break;
                case 2:
                    types[1]++;
                    break;
                case 3:
                    types[2]++;
                    break;
                case 4:
                    types[3]++;
                    break;
                case 5:
                    types[4]++;
                    break;
            }
        }
        System.out.println(Arrays.toString(types));
        int max = types[0];
        int index = 1;
        for(int j = 1; j<types.length;j++){
            if(max < types[j]){
                max = types[j];
                index = j+1;
            }
        }
        return index;

    }
}
