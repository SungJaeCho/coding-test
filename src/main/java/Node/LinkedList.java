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
    //처음에 추가
    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if(head.next == null) {
            tail = head;
        }
    }
    //끝에 추가
    public void addLast(Object input) {
        Node newNode = new Node(input);
        if(size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    //특정위치 찾기
    Node node(int index) {
        Node x = head;
        for(int i=0; i<index; i++)
            x = x.next;
        return x;
    }
    //노드추가
    public void add(int k, Object input) {
        if(k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k-1); //추가하려는 노드의 앞노드
            Node temp2 = temp1.next; //추가하려는 노드의 뒷노드
            Node newNode = new Node(input);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;
            if(newNode.next == null) {
                tail = newNode;
            }
        }
    }
    //출력
    public String toString() {
        if(head == null) {
            return "[]";
        }
        Node temp = head;
        String str = "[";
        while(temp.next != null) {
            str += temp.data + ",";
            temp = temp.next;
        }
        str += temp.data;
        return str + "]";
    }
    //처음노드 삭제
    public Object removeFirst() {
        Node temp = head;
        head = head.next;
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }
    //중간노드 삭제
    public Object remove(int k) {
        if(k == 0) {
            return removeFirst();
        }
        Node temp = node(k-1);    //삭제대상 앞 노드
        Node todoDeleted = temp.next;   //삭제대상 노드
        temp.next = temp.next.next;     //삭제대상 앞노드의 연결을 삭제대상 다음것으로 지정
        Object returnData = todoDeleted.data;
        if(todoDeleted == tail) { //삭제대상 노드가 tail이면
            tail = temp;
        }
        todoDeleted = null;
        size--;
        return returnData;
    }
    //마지막노드 삭제
    public Object removeLast() {
        //링크드리스트의 최대 단점 항상 연결을 해야하기때문에
        //가장 마지막거 지울때 시간을 가장 많이 잡아먹음
        return remove(size-1);
    }
    //리스트 사이즈
    public int size() {
        return size;
    }
    //값 가져오기
    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }
    //탐색
    public Object indexOf(Object data) {
        Node temp = head;
        int index = 0;
        while(temp.data != data) {
            temp = temp.next;
            index++;
            if(temp == null) {
                return -1;
            }
        }
        return index;
    }
    //Iterator Next
    public ListIterator listIterator() {
        return new ListIterator();
    }
    class ListIterator {
        private Node next;
        private Node lastReturned;
        private int nextIndex;
        ListIterator() {
            next = head;
        }
        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }
        public boolean hasNext() {
            return nextIndex < size();
        }
        public void add(Object input) {
            Node newNode = new Node(input);

            if(lastReturned == null){
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }


            lastReturned = newNode;
            nextIndex++;
            size++;
        }
        public void remove() {
            // 선택된 엘레먼트가 없을때
            if(nextIndex == 0) {
                throw new IllegalStateException();
            }
            LinkedList.this.remove(nextIndex-1);
            nextIndex--;
        }
    }
}
