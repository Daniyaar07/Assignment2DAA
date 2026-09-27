public class MinHeap {
    private int[] data;
    private int size;
    public MinHeap(){
        data = new int[10];
        size = 0;
    }
    public int size(){
        return size;
    }
    public void insert(int num){
        if(size == data.length){
            int[] newData = new int[data.length * 2];
            for (int i = 0; i< data.length; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size] = num;
        int index = size;
        while(index > 0){
            int parent = (index - 1) / 2;
            if(data[index] < data[parent]){
                int temp = data[index];
                data[index] = data[parent];
                data[parent] = temp;
                index = parent;
            }
            else{
                break;
            }
        }
        size++;
    }
    public int peekMin(){
        if (size == 0){
            throw new IllegalStateException("Heap is empty");
        }
        return data[0];
    }
    public int extractMin(){
        if (size == 0){
            throw new IllegalStateException("Heap is empty");
        }
        int min = data[0];
        data[0] = data[size - 1];
        size --;
        int index = 0;
        while (true){
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smallest = index;
            if (left < size && data[left] < data[smallest]){
                smallest = left;
            }
            if (right < size && data[right] < data[smallest]){
                smallest = right;
            }
            if(smallest == index){
                break;
            }
            int temp = data[index];
            data[index] = data[smallest];
            data[smallest] = temp;
            index = smallest;
        }
        return min;
    }
    public boolean isValidHeap(){
        for (int i = 0; i< size; i++){
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if(left < size && data[i] > data[left]){
                return false;
            }
            if(right<size && data[i] > data[right]){
                return false;
            }
        }
        return true;
    }
}
