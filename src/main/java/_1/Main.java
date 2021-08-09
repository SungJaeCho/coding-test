package _1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /* 학생이름 저장 및 검색
     * - 학생정보들을 저장하고, 학생이름으로 검색하면 학번을 출력하는 프로그램
     * - 학생이름이 있는경우 학번, 없는경우 학생이름이라고 출력
     * */
    public static void main(String[] args) {
        Student st1 = new Student("손오공","1682");
        Student st2 = new Student("저팔계","2112");
        Student st3 = new Student("사오정","6231");

        List<Student> list = new ArrayList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("계속 검색을 하고싶으시면 y, 종료하고 싶으시면 n");
            String input = scan.next();
            if(input.equals("y")) {
                System.out.println("검색을 시작합니다.");
                String name = scan.next();
                boolean flag = false;

                for(Student student : list) {
                    if(student.getName().equals(name)) {
                        System.out.println("해당하는 학생의 한번은 :" +student.getNo() + " 입니다.");
                        flag = true;
                    }
                }
                if(!flag) {
                    System.out.println("해당하는 학생이름이 없습니다.");
                }
            }
            else if(input.equals("n")) {
                break;
            }

        }

        System.out.println("프로그램이 종료되었습니다.");
    }

}
