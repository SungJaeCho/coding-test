package HackerRank;

public class StrageCount {
    public static void main(String[] args) {
        long t = 5L;
        System.out.println(solution(t));
    }
    public static long solution(long t) {
        long curr = 3;
        while(t > curr) {
            t -= curr;
            curr *= 2;
        }
        return curr - t + 1;
    }
}
