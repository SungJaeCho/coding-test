package coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        solution(12);

    }
    public static long[] solution(long n) {
        long[] ans = {};
        List<Long> prime = new ArrayList<>();
        //소수 구하기
        for(long i=2; i<n; i++) {
            if(n%i == 0) {
                if(i%2 != 0){
                    prime.add(i);
                }
            }
        }
        for(Long a : prime){
            System.out.println(a);
        }
        return ans;
    }


}
