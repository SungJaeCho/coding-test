package programers._lv2FunctionalDevelopment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        int[] result = solution(progresses,speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int day = 1;
        Queue<Integer> queue = new LinkedList<>();
        for(int progress : progresses) {
            queue.add(progress);
        }
        while (!queue.isEmpty()) {
            int count = 0;
            for(int i=0; i< speeds.length; i++) {
                if(speeds[i] == 0) {
                    continue;
                }
                if(queue.peek() + (speeds[i] * day) >= 100) {
                    count++;
                    queue.poll();
                    speeds[i] = 0;
                } else {
                    day++;
                    break;
                }
            }
            if(count > 0) {
                result.add(count);
            }
        }
        System.out.println(result);
        return result.stream().mapToInt(i->i).toArray();
    }
}
