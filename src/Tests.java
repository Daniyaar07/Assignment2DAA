import java.util.PriorityQueue;

public class Tests {
    public static void main(String[] args){
        System.out.println("Dynamic Array");
        DynamicArray array = new DynamicArray();

        System.out.println("Empty DynamicArray size:");
        System.out.println(array.size());

        array.add(10);
        System.out.println("One element:");
        System.out.println(array.get(0));

        array.add(20);
        array.add(30);
        System.out.println("Multiple elements:");
        System.out.println(array.get(0));
        System.out.println(array.get(1));
        System.out.println(array.get(2));

        array.add(1, 15);
        System.out.println("Add by index:");
        System.out.println(array.get(1));

        System.out.println("Contains 20:");
        System.out.println(array.contains(20));

        System.out.println("Removed:");
        System.out.println(array.remove(1));

        System.out.println("Boundary indices:");
        System.out.println(array.get(0));
        System.out.println(array.get(array.size()- 1));

        array.add(20);
        System.out.println("Duplicate:");
        System.out.println(array.contains(20));

        try{
            array.get(100);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Invalid index:");
        }
        DynamicArray bigArray = new DynamicArray();
        for(int i = 0; i < 100000; i++){
            bigArray.add(i);
        }
        System.out.println("Large input:");
        System.out.println(bigArray.size());

        System.out.println();
        System.out.println("LinkedList");

        LinkedList list = new LinkedList();
        System.out.println("Empty size");
        System.out.println(list.size());

        list.add(10);

        System.out.println("One element:");
        System.out.println(list.get(0));

        list.add(20);
        list.add(30);
        System.out.println("Multiple elements");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        list.add(1 , 15);
        System.out.println("Add by index");
        System.out.println(list.get(1));

        System.out.println("Contains 20:");
        System.out.println(list.contains(20));

        System.out.println("Removed:");
        System.out.println(list.remove(1));

        System.out.println("Boundary indices");
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()- 1));

        list.add(20);
        System.out.println("Duplicate:");
        System.out.println(list.contains(20));

        try{
            list.get(100);
        }
        catch (IndexOutOfBoundsException e ){
            System.out.println("Invalid index");
        }
        LinkedList bigList = new LinkedList();
        for(int i = 0; i<10000; i++){
            bigList.add(i);
        }
        System.out.println("Large input:");
        System.out.println(bigList.size());

        System.out.println();
        System.out.println("Min Heap");

        MinHeap heap = new MinHeap();
        heap.insert(10);
        System.out.println("One element:");
        System.out.println(heap.peekMin());

        heap.insert(20);
        heap.insert(5);
        heap.insert(15);
        heap.insert(2);
        System.out.println("Minimum:");
        System.out.println(heap.peekMin());

        System.out.println("Heap after insertion:");
        System.out.println(heap.isValidHeap());

        heap.insert(5);
        System.out.println("Duplicate:");
        System.out.println(heap.peekMin());

        heap.extractMin();
        System.out.println("Heap after extraction:");
        System.out.println(heap.isValidHeap());

        MinHeap orderHeap = new MinHeap();
        orderHeap.insert(20);
        orderHeap.insert(5);
        orderHeap.insert(15);
        orderHeap.insert(2);
        orderHeap.insert(5);

        System.out.println("Non-decreasing order:");
        while(orderHeap.size() >0 ){
            System.out.println(orderHeap.extractMin());
        }
        MinHeap bigHeap = new MinHeap();
        for (int i = 10000; i>0; i--){
            bigHeap.insert(i);
        }
        System.out.println("Large input:");
        System.out.println(bigHeap.size());

        System.out.println();
        System.out.println("Java PriorityQueue:");
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(20);
        queue.add(5);
        queue.add(15);
        queue.add(2);
        queue.add(5);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
