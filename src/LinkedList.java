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
    public LinkedList(){
        head = null;
        size = 0;
    }
    public int size(){
        return size;
    }
}
