package _29_scale;

/*
1부터 8까지 차례대로 입력되면 ascending, 8부터 1까지 차례대로입력되면 descending, 둘다 아니라면 mixed를 출력하시오.

예제 입력: 1 2 3 4 5 6 7 8
출력 ascending
예제 입력: 8 7 6 5 4 3 2 1
출력 descending
예제 입력: 8 1 7 2 6 3 5 4
출력 mixed
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] input = new int[8];

        for(int i=0; i<input.length; i++) {
            input[i] = in.nextInt();
        }
        solution(input);
    }

    public static void solution(int[] input) {

        boolean asc = true;
        boolean desc = true;

        if(input[0] != 1) {
            asc = false;
        }
        if(input[0] != 8) {
            desc = false;
        }

        if(asc){
            for(int i=1; i<input.length-1; i++) {
                if(input[i] - input[i+1] != -1) {
                    asc = false;
                    break;
                }
            }
        }
        if(desc) {
            for(int i=1; i<input.length-1; i++) {
                if(input[i] - input[i+1] != 1) {
                    desc = false;
                    break;
                }
            }
        }

        if(asc) {
            System.out.println("ascending");
        } else if(desc) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}
