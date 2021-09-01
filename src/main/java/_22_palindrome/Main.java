package _22_palindrome;

public class Main {
    public static void main(String[] args) {
        String n = "12321321";
        int len = n.length();
        boolean result = true;
        for(int i=0; i<len/2; i++) {
            System.out.println(n.charAt(i) + ":" + n.charAt(len-i-1));
            if(n.charAt(i) != n.charAt(len-i-1)){
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}
