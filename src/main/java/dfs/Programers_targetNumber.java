package dfs;

import java.util.Arrays;

public class Programers_targetNumber {
    static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,1,1,1,1}, 2));
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    public static void dfs(int[] numbers, int depth, int target, int sum) {
        System.out.println(depth + " : " + target + " : " + sum);
        if(depth == numbers.length) {
            if(target == sum) answer++;
            return;
        }
        dfs(numbers, depth+1, target, sum + numbers[depth]);
        dfs(numbers, depth+1, target, sum - numbers[depth]);
    }

}
