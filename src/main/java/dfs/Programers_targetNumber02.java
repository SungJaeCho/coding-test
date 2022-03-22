package dfs;

public class Programers_targetNumber02 {
    static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,1,1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    public static void dfs(int[] numbers, int depth, int target, int sum) {
        System.out.println(" depth:" + depth + " sum: " + sum);
        if(depth == numbers.length) {
            System.out.println("체크");
            if(target == sum) answer++;
            return;
        }
        dfs(numbers, depth+1, target, sum + numbers[depth]);
        dfs(numbers, depth+1, target, sum - numbers[depth]);
    }

}
