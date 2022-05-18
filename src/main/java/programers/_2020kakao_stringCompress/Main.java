package programers._2020kakao_stringCompress;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "xababcdcdababcdcd";
        System.out.println(stringCompress(s));
    }

    public static int stringCompress(String s) {
        int zipLv = 1;
        int answer = s.length();

        for(int i=1; i<s.length()/2+1; i++) { //제공되는 문자열의 절반만 확인하면됨
            int count = 1;
            zipLv = i; // 압축레벨
            String subStr = s.substring(0,i); // 첫 기본세팅
            String complateStr = "";
            for(int j=i; j+zipLv <= s.length();) {
                String tempStr = s.substring(j, j+zipLv);
                if(subStr.equals(tempStr)) {
                    count++;
                } else {
                    if(count > 1) {
                        complateStr += count + subStr;
                    } else {
                        complateStr += subStr;
                    }
                    subStr = tempStr;
                    count = 1;
                }
                j += zipLv;
                if(j+zipLv > s.length()) { //다음포문이 돌지않는데 넣어야 할 값이 있는 경우
                    if(count > 1) {
                        complateStr += count + subStr;
                    } else {
                        complateStr += subStr;
                    }
                    complateStr += s.substring(j);
                }
            }
            answer = Math.min(answer, complateStr.length());
        }
        return answer;
    }

}
