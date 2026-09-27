public class LinkedList {
    private class Node {
        int num;
        Node next;
        public Node(int num){
            this.num = num;
            next = null;
        }
    }
    private Node head;
    private int size;
    private long accesses;
    public LinkedList(){
        head = null;
        size = 0;
        accesses = 0;
    }
    public int size(){
        return size;
    }
    public void add(int num){
        Node newNode = new Node(num);
        if (head == null){
            head = newNode;
        }
        else{
            Node node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = newNode;
        }
        size ++;
    }
    public int get(int index){
        if (index < 0 || index>= size){
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        accesses++;
        for (int i = 0; i< index; i++){
            node = node.next;
            accesses++;
        }
        return node.num;
    }
    public boolean contains(int num) {
        Node node = head;
        while (node != null){
            if(node.num == num){
                return true;
            }
            node = node.next;
        }
        return false;
    }
    public void add(int index , int num){
        if(index < 0 || index >size ){
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(num);
        if (index == 0){
            newNode.next = head;
            head = newNode;
        }
        else{
            Node node = head;
            for(int i = 0; i< index - 1; i++){
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
        }
        size++;
    }
    public int remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        int removedNum;
        if (index == 0){
            removedNum = head.num;
            head = head.next;
        }
        else{
            Node node = head;
            for (int i= 0; i< index - 1; i++){
                node = node.next;
            }
            removedNum = node.next.num;
            node.next = node.next.next;
        }
        size --;
        return removedNum;
    }
    public long getAccesses(){
        return accesses;
    }
    public void resetAccesses(){
        accesses = 0;
    }
}
