package lgu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    private static Map<String, Integer> result = new HashMap<>();

     public static void main(String[] args) {
         String[] maps = {"..........", "AAACC.....", ".AAA.....Z", "..AAAA..C.", "...BBBBB. .", "....BBB...", "...ZBBB...", "ZZZZAAAC..", ".....CCCC.", "QQ......C.", ".........."};
         System.out.println(Arrays.toString(solution(maps)));
         String s = "";
         char c = 'A';
         char c2 = 'B';
         s = String.valueOf(c+c2);
 //        System.out.println(s);
     }

     public static int[] solution(String[] maps) {
         int[] answer = {0,0};

         for(int i=0; i<maps.length; i++) {
             for(int j=0; j<maps[i].length(); j++) {
                 find(i, j, maps);
             }
         }
 //        System.out.println(result);
         String[] strArr = result.keySet().toArray(new String[0]);
 //        System.out.println(Arrays.toString(strArr));
         int[] mostArr = new int[26];
         for(String str : strArr) {
             for(int i=0; i < str.length(); i++) {
                 int index = str.charAt(i) -65;
                 mostArr[index] = mostArr[index] + 1;
             }
         }
 //        System.out.println(Arrays.toString(mostArr));
         int mostNum = 0;
         for(int num : mostArr) {
             if(num > mostNum) {
                 mostNum = num;
             }
         }
         answer[0] = strArr.length;
         answer[1] = mostNum;

         return answer;
     }

     public static void find(int x, int y, String[] maps) {
         if(maps[x].charAt(y) == '.') {
             return;
         }
         char target = maps[x].charAt(y);
         //기준방향 왼쪽
         if(y-1 >= 0 && '.' != maps[x].charAt(y-1) && target != maps[x].charAt(y-1)) {
             result.put(sort(target, maps[x].charAt(y-1)) , 1);
         }
         //오른쪽
         if (y + 1 <= maps[x].length() - 1 && '.' != maps[x].charAt(y+1) && target != maps[x].charAt(y+1)) {
             result.put(sort(target, maps[x].charAt(y+1)) , 1);
         }
         //위
         if (x - 1 >= 0 && '.' != maps[x - 1].charAt(y) && target != maps[x - 1].charAt(y)) {
             result.put(sort(target, maps[x - 1].charAt(y)) , 1);
         }
         //아래
         if (x + 1 <= maps.length-1 && '.' != maps[x + 1].charAt(y) && target != maps[x + 1].charAt(y)) {
             result.put(sort(target, maps[x + 1].charAt(y)) , 1);
         }
     }

     public static String sort(char a, char b) {
         String resultStr = "";
         if(a < b) {
             resultStr = String.valueOf(a) + String.valueOf(b);
         } else {
             resultStr = String.valueOf(b) + String.valueOf(a);
         }
         return resultStr;
     }
}
