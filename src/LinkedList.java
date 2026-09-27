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
        for (int i = 0; i< index; i++){
            node = node.next;
        }
        return node.num;
    }
}
