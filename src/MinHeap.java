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
}
