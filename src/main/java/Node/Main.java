package Node;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.add(2, 25);

        LinkedList.ListIterator i = numbers.listIterator();
        i.next();
        i.remove();
    }
}
