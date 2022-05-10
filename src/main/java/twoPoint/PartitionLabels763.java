package twoPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels763 {
    public static void main(String[] args) {
        String s = "cabbsea";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        //모든 알파벳의 마지막위치 기록
        int[] end = new int[26];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int index = c-97; // 대문자한정 c-65
            end[index] = i;
        }

        System.out.println(Arrays.toString(end));

        List<Integer> result = new ArrayList<>();
        int size = 0;
        int max = 0;

        for(int i=0; i<s.length(); i++) {
            int last = s.charAt(i) - 97; // 지금문자열위치 찾기 'a'일 경우 97-97이므로 end[0]참조하게 함
            max = Math.max(end[last], max); // 기존에 저장된 마지막위치와 현재 문자열의 마지막위치를 비교하여 더 멀리 있는 위치를 찾음

            if(max == i) {
                result.add(size+1);
                size = 0;
            } else if(max > i) {
                size++;
            }
        }

        return result;
    }
}
