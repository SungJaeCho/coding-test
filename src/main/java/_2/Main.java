package _2;

import java.util.Arrays;
import java.util.Scanner;

//최빈수 구하기
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] inputNum = new int[10];
        for(int i=0; i<10; i++) {
            inputNum[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(inputNum));

        int[] mode = new int [10];
        // index -> 출현한 수
        // index 값 -> index(출현한수)가 몇번나왔는지 저장하는 용도
        // mode[3] = 5, => 3번 숫자가 , 5번 출현했다.
        //[1,2,2,3,1,4,2,2,4,3,5,3,2]
        for(int i=0; i<10; i++) {
            mode[inputNum[i]]++;
        }

        int modeNum = 0; //최빈수
        int modeCnt = 0; //최빈수 횟수
        for(int i=0; i<10; i++) {
            if(modeCnt < mode[i]) {
                modeCnt = mode[i];
                modeNum = i;
            }
        }

        System.out.println("최빈수는 "+modeNum+" 이고 횟수는 "+modeCnt+" 입니다.");
    }
}
