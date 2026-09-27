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
    }
}
