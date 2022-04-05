package twoPoint;

public class ReverseStringii541 {
    public static void main(String[] args) {
        String s = "abcdef";
        int k = 3;
        System.out.println(solution(s,k));
    }
    public static String solution(String s, int k) {
        char[] c = s.toCharArray();
        for(int i=0; i<s.length(); i+= 2*k){
            int start = i, end = Math.min(i + k-1, c.length-1); // c.length-1의경우 s의 길이보다 k의 숫자가 클경우대비
            while (start < end) {
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;
                end--;
            }
        }
        return String.valueOf(c);

    }
}
