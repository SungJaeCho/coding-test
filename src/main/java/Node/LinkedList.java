package Node;

public class LinkedList {
    // 첫번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
    private int size = 0;
    private class Node {
        //데이터가 저장될 필드
        private Object data;
        //다음 노드를 가리키는 필드
        private Node next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        public String toString() {
            return String.valueOf(this.data);
        }
    }
    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if(head.next == null) {
            tail = head;
        }

    }
}
