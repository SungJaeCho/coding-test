package twoPoint;

public class ReversePrefixOfWord2000 {
    public static void main(String[] args) {
        String word = "ab";
        char ch = 'b';
        System.out.println(reversePrefix(word,ch));
    }
    public static String reversePrefix(String word, char ch) {
        int index = 0;
        if(word.length() == 1) {
            return word;
        }

        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        StringBuilder targetStr = new StringBuilder(word.substring(0,index+1));

        for(int left=0,right=targetStr.length()-1; left < right; left++,right--) {
            char temp = targetStr.charAt(left);
            targetStr.setCharAt(left, targetStr.charAt(right));
            targetStr.setCharAt(right, temp);
        }
        word = targetStr.toString() + word.substring(index+1, word.length());
        return word;
    }
}
