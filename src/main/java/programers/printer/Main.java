package programers.printer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] priorities = {2,1,3,2};
//        int[] priorities = {1, 1, 9, 1, 1, 1}; //[1, 1, 9, 1, 1, 1] , 0 -> 5
//        int[] priorities = {1, 1, 9, 8, 9, 7}; //[1, 1, 9, 1, 1, 1] , 0 -> 5
        int location = 2;
        System.out.println("solution : "+solution(priorities,location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Member> queue = new LinkedList<>();
        for(int i=0; i< priorities.length; i++) {
            queue.add(new Member(i, priorities[i]));
        }

        while (!queue.isEmpty()) {
            int current = queue.peek().getValue();

            boolean flag = false;
            for(Member member : queue) {
                // 현재값보다 큰게 있을경우
                if(member.getValue() > current) {
                    flag = true;
                    break;
                }
            }
            // flag true면 젤 뒤로 보냄
            if(flag) {
                queue.offer(queue.peek());
                queue.poll();
            }
            // 지금거보다 큰게 없을경우
            else {
                answer++;
                int index = queue.peek().getIndex();
                queue.poll();
                if(index == location){
                    return answer;
                }
            }
        }
        return answer;
    }

    static class Member {
        private Integer index;
        private Integer value;

        public Member(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }

        public Integer getIndex() {
            return index;
        }

        public Integer getValue() {
            return value;
        }
    }
}
