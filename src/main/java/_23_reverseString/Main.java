package _23_reverseString;
//문자 뒤집기
public class Main {
    public static void main(String[] args) {
        String str = "ADEFHO";
        one(str);
        two(str);
    }
    public static void one(String str) {
        int len = str.length();
        String result = "";
        for(int i=len-1; i>=0; i--){
            result = result + str.charAt(i);
        }
        System.out.println(result);
    }

    public static void two(String n) {
        //"ADEFH"의 문자열 0번째와 4번째를 바꾸고 1번과 3번의 위치를 바꿈 포문을 n/2만큼만 돌면됨
        char[] str = n.toCharArray();
        char tmp;
        int len = str.length;

        for(int i=0; i<len/2; i++) {
            tmp = str[i]; //백업
            str[i] = str[len-i-1];
            str[len-i-1] = tmp;
        }

        n = new String(str);
        System.out.println(n);
    }
}
