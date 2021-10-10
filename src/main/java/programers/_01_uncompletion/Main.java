package programers._01_uncompletion;

public class Main {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        boolean check;
        for(int i=0; i<participant.length; i++) {
            check = false;
            for(int j=0; j<completion.length; j++) {
                if(participant[i].equals(completion[j])) {
                    participant[i] = "";
                    completion[j] = "";
                    check = true;
                    continue;
                }
            }
            if(!check) {
                answer = participant[i];
            }
        }

//        for(int i=0; i< participant.length; i++) {
//            answer += participant[i];
//        }

        return answer;
    }
}
