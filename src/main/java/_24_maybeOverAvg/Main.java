package _24_maybeOverAvg;

public class Main {
    public static void main(String[] args) {
        int in[] = {7, 100, 95, 90, 80, 70, 60, 50}; //0번째는 학생수 나머지는 점수들
        int sum = 0;

        for(int i=1; i<in.length; i++) {
            sum += in[i];
        }
        double avg = (double)sum / in[0]; //정확하게 나오게 하려면 double로 형변환 필요

        System.out.println(avg);

        int cnt = 0;
        for(int i=1; i<in.length; i++) {
            if(in[i] > avg) {
                cnt++;
            }
        }

        System.out.println( (double)cnt/in[0] * 100);

    }
}
