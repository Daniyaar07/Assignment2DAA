import java.util.Random;
public class Benchmark {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        for (int i = 0; i < sizes.length; i++) {
            int n = sizes[i];
            DynamicArray array = new DynamicArray();
            LinkedList list = new LinkedList();
            Random random = new Random(42);
            for (int j = 0; j < n; j++) {
                int num = random.nextInt(10000);
                array.add(num);
                list.add(0, num);
            }
            int[] indexes = new int[10000];
            for (int j = 0; j < indexes.length; j++) {
                indexes[j] = random.nextInt(n);
            }
            long arrayTotal = 0;
            long listTotal = 0;
            array.resetAccesses();
            list.resetAccesses();
            for (int run = 0; run < 5; run++) {
                long start = System.nanoTime();
                for (int j = 0; j < indexes.length; j++) {
                    array.get(indexes[j]);
                }
                long end = System.nanoTime();
                arrayTotal = arrayTotal + (end - start);
                start = System.nanoTime();
                for (int j = 0; j < indexes.length; j++) {
                    list.get(indexes[j]);
                }
                end = System.nanoTime();
                listTotal = listTotal + (end - start);
            }
            long arrayAverage = arrayTotal / 5;
            long listAverage = listTotal / 5;
            long arrayAverageAccesses = array.getAccesses() / 5;
            long listAverageAccesses = list.getAccesses() / 5;

            System.out.println("n = " + n);
            System.out.println("DynamicArray:");
            System.out.println("Average time: " + arrayAverage);
            System.out.println("Accesses: " + arrayAverageAccesses);

            System.out.println("Linked List:");
            System.out.println("Average time: " + listAverage);
            System.out.println("Accesses: " + listAverageAccesses);

            System.out.println();
        }
        System.out.println("Workload 2 - Search");
        for (int i = 0; i < sizes.length; i++) {
            int n = sizes[i];
            DynamicArray array = new DynamicArray();
            LinkedList list = new LinkedList();
            Random random = new Random(42);
            for (int j = 0; j < n; j++) {
                int num = random.nextInt(10000);
                array.add(num);
                list.add(0, num);
            }
            int[] searchValues = new int[1000];
            for (int j = 0; j < searchValues.length; j++) {
                searchValues[j] = random.nextInt(10000);
            }
            long arrayTotal = 0;
            long listTotal = 0;
            array.resetComparisons();
            list.resetComparisons();
            for (int run = 0; run < 5; run++) {
                long start = System.nanoTime();
                for (int j = 0; j < searchValues.length; j++) {
                    array.contains(searchValues[j]);
                }
                long end = System.nanoTime();
                arrayTotal = arrayTotal + (end - start);
                start = System.nanoTime();
                for (int j = 0; j < searchValues.length; j++) {
                    list.contains(searchValues[j]);
                }
                end = System.nanoTime();
                listTotal = listTotal + (end - start);
            }
            long arrayAverage = arrayTotal / 5;
            long listAverage = listTotal / 5;
            long arrayComparisons = array.getComparisons() / 5;
            long listComparisons = list.getComparisons() / 5;

            System.out.println("n = " + n);
            System.out.println("DynamicArray:");
            System.out.println("Average time: " + arrayAverage);
            System.out.println("Comparisons: " + arrayComparisons);

            System.out.println("Linked List:");
            System.out.println("Average time: " + listAverage);
            System.out.println("Comparisons: " + listComparisons);
            }
        System.out.println("Workload 3");

        for(int i = 0; i < sizes.length; i++){
            int n = sizes[i];

            long arrayInsertBeginningTotal = 0;
            long listInsertBeginningTotal = 0;

            long arrayRemoveBeginningTotal = 0;
            long listRemoveBeginningTotal = 0;

            long arrayInsertMiddleTotal = 0;
            long listInsertMiddleTotal = 0;

            long arrayRemoveMiddleTotal = 0;
            long listRemoveMiddleTotal = 0;

            long arrayInsertBeginningMovements = 0;
            long listInsertBeginningAccesses = 0;

            long arrayRemoveBeginningMovements = 0;
            long listRemoveBeginningAccesses = 0;

            long arrayInsertMiddleMovements = 0;
            long listInsertMiddleAccesses = 0;

            long arrayRemoveMiddleMovements = 0;
            long listRemoveMiddleAccesses = 0;

            for (int run = 0; run < 5; run++) {
                DynamicArray array = new DynamicArray();
                LinkedList list = new LinkedList();

                for (int j = 0; j < n; j++) {
                    array.add(j);
                    list.add(0, j);
                }
                array.resetMovements();
                list.resetAccesses();
                long start = System.nanoTime();
                for (int j = 0; j < 1000; j++) {
                    array.add(0, j);
                }
                long end = System.nanoTime();
                arrayInsertBeginningTotal = arrayInsertBeginningTotal + (end - start);

                arrayInsertBeginningMovements = arrayInsertBeginningMovements + array.getMovements();

                start = System.nanoTime();
                for (int j = 0; j < 1000; j++) {
                    list.add(0, j);
                }
                end = System.nanoTime();
                listInsertBeginningTotal = listInsertBeginningTotal + (end - start);

                listInsertBeginningAccesses = listInsertBeginningAccesses + list.getAccesses();


                DynamicArray arrayRemove = new DynamicArray();
                LinkedList listRemove = new LinkedList();

                for (int j = 0; j < n + 1000; j++) {
                    arrayRemove.add(j);
                    listRemove.add(0, j);
                }
                arrayRemove.resetMovements();
                listRemove.resetAccesses();

                start = System.nanoTime();
                for (int j = 0; j < 1000; j++) {
                    arrayRemove.remove(0);
                }
                end = System.nanoTime();
                arrayRemoveBeginningTotal = arrayRemoveBeginningTotal + (end - start);

                arrayRemoveBeginningMovements = arrayRemoveBeginningMovements + arrayRemove.getMovements();

                start = System.nanoTime();
                for (int j = 0; j < 1000; j++) {
                    listRemove.remove(0);
                }
                end = System.nanoTime();
                listRemoveBeginningTotal = listRemoveBeginningTotal + (end - start);

                listRemoveBeginningAccesses =  listRemoveBeginningAccesses + listRemove.getAccesses();

                DynamicArray arrayMiddle = new DynamicArray();
                LinkedList listMiddle = new LinkedList();

                for (int j = 0; j < n; j++) {
                    arrayMiddle.add(j);
                    listMiddle.add(0, j);
                }
                int middle = n / 2;
                arrayMiddle.resetMovements();
                listMiddle.resetAccesses();

                start = System.nanoTime();
                for (int j = 0; j < 1000; j++) {
                    arrayMiddle.add(middle, j);
                }
                end = System.nanoTime();
                arrayInsertMiddleTotal = arrayInsertMiddleTotal + (end - start);

                arrayInsertMiddleMovements = arrayInsertMiddleMovements + arrayMiddle.getMovements();

                start = System.nanoTime();
                for (int j = 0; j < 1000; j++) {
                    listMiddle.add(middle, j);
                }
                end = System.nanoTime();
                listInsertMiddleTotal = listInsertMiddleTotal + (end - start);

                listInsertMiddleAccesses =  listInsertMiddleAccesses + listMiddle.getAccesses();

                DynamicArray arrayMiddleRemove = new DynamicArray();
                LinkedList listMiddleRemove = new LinkedList();

                for (int j = 0; j < n + 1000; j++) {
                    arrayMiddleRemove.add(j);
                    listMiddleRemove.add(0, j);
                }
                arrayMiddleRemove.resetMovements();
                listMiddleRemove.resetAccesses();

                start = System.nanoTime();
                for (int j = 0; j < 1000; j++) {
                    arrayMiddleRemove.remove(middle);
                }
                end = System.nanoTime();
                arrayRemoveMiddleTotal = arrayRemoveMiddleTotal + (end - start);

                arrayRemoveMiddleMovements = arrayRemoveMiddleMovements + arrayMiddleRemove.getMovements();

                start = System.nanoTime();
                for (int j = 0; j < 1000; j++) {
                    listMiddleRemove.remove(middle);
                }
                end = System.nanoTime();
                listRemoveMiddleTotal = listRemoveMiddleTotal + (end - start);

                listRemoveMiddleAccesses = listRemoveMiddleAccesses + listMiddleRemove.getAccesses();
            }
            System.out.println("n = " + n);

            System.out.println("DynamicArray insert beginning:");
            System.out.println("Average time: " + arrayInsertBeginningTotal / 5);
            System.out.println("Movements: " + arrayInsertBeginningMovements / 5);

            System.out.println("LinkedList insert beginning:");
            System.out.println("Average time: " + listInsertBeginningTotal / 5);
            System.out.println("Accesses: " + listInsertBeginningAccesses / 5);

            System.out.println("DynamicArray remove beginning:");
            System.out.println("Average time: " + arrayRemoveBeginningTotal / 5);
            System.out.println("Movements: " + arrayRemoveBeginningMovements / 5);

            System.out.println("LinkedList remove beginning:");
            System.out.println("Average time: " + listRemoveBeginningTotal / 5);
            System.out.println("Accesses: " + listRemoveBeginningAccesses / 5);

            System.out.println("DynamicArray insert middle:");
            System.out.println("Average time: " + arrayInsertMiddleTotal / 5);
            System.out.println("Movements: " + arrayInsertMiddleMovements / 5);

            System.out.println("LinkedList insert middle:");
            System.out.println("Average time: " + listInsertMiddleTotal / 5);
            System.out.println("Accesses: " + listInsertMiddleAccesses / 5);

            System.out.println("DynamicArray remove middle:");
            System.out.println("Average time: " + arrayRemoveMiddleTotal / 5);
            System.out.println("Movements: " + arrayRemoveMiddleMovements / 5);

            System.out.println("LinkedList remove middle:");
            System.out.println("Average time: " + listRemoveMiddleTotal / 5);
            System.out.println("Accesses: " + listRemoveMiddleAccesses / 5);

            System.out.println();

        }
        System.out.println("Workload 4");
        for(int i= 0; i< sizes.length; i++){
            int n = sizes[i];
            long insertTotal = 0;
            long extractTotal = 0;

            long insertComparisonsTotal =0;
            long extractComparisonsTotal = 0;
            boolean sorted = true;

            for(int run =0; run < 5; run++){
                MinHeap heap = new MinHeap();
                Random random = new Random(42);
                int[] values = new int[n];

                for(int j =0; j < n; j++){
                    values[j] = random.nextInt(100000);
                }
                heap.resetComparisons();
                long start = System.nanoTime();
                for(int j = 0; j < n; j++){
                    heap.insert(values[j]);
                }
                long end =System.nanoTime();
                insertTotal = insertTotal + (end - start);

                insertComparisonsTotal = insertComparisonsTotal + heap.getComparisons();

                heap.resetComparisons();
                start = System.nanoTime();
                int previous = Integer.MIN_VALUE;
                for(int j = 0; j < n; j++){
                    int current = heap.extractMin();
                    if (current < previous){
                        sorted = false;
                    }
                    previous = current;
                }
                end = System.nanoTime();
                extractTotal = extractTotal + (end -start);
                extractComparisonsTotal = extractComparisonsTotal + heap.getComparisons();
            }
            System.out.println("n = " + n);

            System.out.println("Insertion:");
            System.out.println("Average time: " + insertTotal / 5);
            System.out.println("Comparisons: " + insertComparisonsTotal / 5);

            System.out.println("Extraction:");
            System.out.println("Average time: " + extractTotal / 5);
            System.out.println("Comparisons: " + extractComparisonsTotal / 5);

            System.out.println("Non-decreasing order: " + sorted);

            System.out.println();
        }
    }
}