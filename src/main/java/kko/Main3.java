package kko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 집갯수 n , infectedHouse가 제공됨 매일 arr기준 x-1, x+1감염됨
 * n = 6, arr 3,5 일때  1,2,3(감염),4,5(감염),6 -> 1,2(감염),3(감염),4(감염),5(감염),6(감염) -> 1,2,3,4,5,6 전체감염 되면서 감염의 경우의 수를 구하는 문제
 * 처음제공된 arr을 제외하고 경우의수 탐색 1page -> 2,4,6감염 [2,4,6],[2,6,4],[4,2,6],[6,4,2],[4,6,2],[6,2,4]
 * 2page -> 1감염 [2,4,6,1],[2,6,4,1],[4,2,6,1],[6,4,2,1],[4,6,2,1],[6,2,4,1]   결과 총 6
 */
public class Main3 {
    static int answer = 1;
    static int count = 0;

    public static void main(String[] args) {
        //test n=4, arr = {1}, n=6, arr = {3,5},

        int n = 6;
        Integer[] arr = {1,6};
        List<Integer> infectedHouses = Arrays.asList(arr);
        System.out.println(solution(n, infectedHouses));
    }
    public static int solution(int n, List<Integer> infectedHouses) {

        int infectedCount = infectedHouses.size();
        boolean[] visited = new boolean[n+1];
        for(int i=0; i<infectedHouses.size(); i++) {
            visited[infectedHouses.get(i)] = true;
        }

        List<Integer> newInfectedList = new ArrayList<>();
        newInfectedList.addAll(infectedHouses);
        boolean startFlag = true;

        while(infectedCount < n) {
            Integer[] newInfectedArr = newInfectedList.toArray(new Integer[newInfectedList.size()]);
            count = 0;
            if(!startFlag) {
                permutation(newInfectedArr, 0, newInfectedArr.length, newInfectedArr.length);
            }
            answer = (answer == 0 ? 1: answer) * count;
            startFlag = false;
            newInfectedList.clear();

            for(int i=0; i<newInfectedArr.length; i++) {
                int index = newInfectedArr[i]; // 3,5
                if(index-1 > 0) {
                    if (!visited[index - 1]) {
                        infectedCount++;
                        visited[index - 1] = true;
                        newInfectedList.add(index - 1);
                    }
                }
                if(index+1 <= visited.length-1) {
                    if(!visited[index+1]) {
                        infectedCount++;
                        visited[index+1] = true;
                        newInfectedList.add(index+1);
                    }
                }
            }

//            System.out.println("newInfectedList:" + newInfectedList);
        }
        if(infectedCount == n) {
            Integer[] newInfectedArr = newInfectedList.toArray(new Integer[newInfectedList.size()]);
            count = 0;
            if(!startFlag) {
                permutation(newInfectedArr, 0, newInfectedArr.length, newInfectedArr.length);
            }
            answer = (answer == 0 ? 1: answer) * count;
        }
        return answer;

    }

    public static void permutation(Integer[] arr, int depth, int n, int r) {
        if (depth == r) {
            count++;
            print(arr, r);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
    public static void swap(Integer[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    // 배열 출력
    public static void print(Integer[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
