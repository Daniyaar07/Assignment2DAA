public class Tests {
    public static void main(String[] args){
        System.out.println("Dynamic Array:");
        DynamicArray array = new DynamicArray();
        array.add(10);
        array.add(20);
        array.add(30);
        array.add(1 ,15);
        System.out.println(array.get(1));
        System.out.println(array.contains(20));
        System.out.println(array.remove(1));
        System.out.println(array.size());

        System.out.println();

        System.out.println("LinkedList:");
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1 , 15);
        System.out.println(list.get(1));
        System.out.println(list.contains(20));
        System.out.println(list.remove(1));
        System.out.println(list.size());

        System.out.println();

        System.out.println("Min Heap:");
        MinHeap heap = new MinHeap();
        heap.insert(20);
        heap.insert(5);
        heap.insert(15);
        heap.insert(2);

        System.out.println(heap.peekMin());
        System.out.println(heap.extractMin());
        System.out.println(heap.size());
    }
}
