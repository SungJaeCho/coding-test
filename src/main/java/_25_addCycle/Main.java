package _25_addCycle;

//26
// 2+6=8 > 68 || 6+8=14 > 84 || 8+4=12 > 42 || 4+2=6 26
// result 4
public class Main {
    public static void main(String[] args) {
        int n = 5;
        int res = n; //초기값
        int tmp = 0;

        int cnt = 0;

        do { //무조건 한번 돌려야하기때문에 do while 사용
            tmp = res / 10 + res % 10; // 8 = 2 + 6
            res = res % 10 * 10 + tmp % 10; // 68 = 6 + 8
            cnt++;
        } while (n != res);

        System.out.println(cnt);
    }
}
