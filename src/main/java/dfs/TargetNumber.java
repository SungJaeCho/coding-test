package dfs;

import java.util.Arrays;

public class TargetNumber {

    static int target = 4;
    static int answer = 0;
    public static void main(String[] args) {
        int[] numbers = {4,1,2,1};
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, 1);
        dfs(numbers, 0, -1);
        return answer;
    }

    public static void dfs(int[] numbers, int node, int multiple) {
        //끝지점 도달시
        numbers[node] *= multiple;
        if(node == numbers.length-1) {
            System.out.println(Arrays.toString(numbers));
            int sum = 0;
            for(int num : numbers) {
                sum += num;
            }
            if(target == sum) {
                answer++;
            }
            return;
        }
        dfs(numbers, node+1, 1);
        dfs(numbers, node+1, -1);
    }
}
