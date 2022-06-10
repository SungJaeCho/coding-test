package lgu;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int x = 3;
        int y = 7;
//        System.out.println("sol1 "+solution(n,x,y));
        System.out.println("sol2 "+solution2(n,x,y));
    }

    public static String solution(int n, long x, long y) {
        String mos = "0";

        // 모스수열 만들기
        for(int i=2; i<=n; i++) {
            String temp = "";
            for(int j=0; j<mos.length(); j++) {
                if(mos.charAt(j) == '0') {
                    temp += '1';
                } else {
                    temp += '0';
                }
            }
            mos += temp;
        }
        System.out.println("mos1: "+ mos);
        mos = mos.substring((int)x-1, (int)y);

        return mos;
    }

    public static String solution2(int n, long x, long y) {
        String mos = "0";

        // 모스수열 만들기
        for(int i=2; i<=n; i++) {
            String temp = "";
            String revTemp = "";
            int j = 0;
            int k = mos.length()-1;
            while(j <= k) {
                if(mos.charAt(j) == '0') {
                    temp += '1';
                } else if (mos.charAt(j) == '1') {
                    temp += '0';
                }
                if(j < k) {
                    if (mos.charAt(k) == '0') {
                        revTemp = "1" + revTemp;
                    } else if (mos.charAt(k) == '1') {
                        revTemp =  "0" + revTemp;
                    }
                }
                j++;
                k--;
            }

//            for(int j=0, k = mos.length()-1; j<k; j++, k--) {
//                if(mos.charAt(j) == '0') {
//                    temp += '1';
//                } else if(mos.charAt(j) == '1'){
//                    temp += '0';
//                }
//
//                if(mos.charAt(k) == '0') {
//                    revTemp = revTemp + "1" ;
//                } else if (mos.charAt(k) == '1'){
//                    revTemp = revTemp + "0";
//                }
//            }
            mos += temp + revTemp;
        }
        System.out.println("mos2: "+ mos);
        mos = mos.substring((int)x-1, (int)y);

        return mos;
    }
}
