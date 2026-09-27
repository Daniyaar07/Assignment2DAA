public class DynamicArray {
    private int[] data;
    private int size;
    public DynamicArray(){
        data = new int[10];
        size = 0;
    }
    public int size(){
        return size;
    }
    public void add(int num){
        data[size] = num;
        size++;
    }
    public int get(int index){
        return data[index];
    }
    public boolean contains(int num){
        for (int i = 0; i< size; i++){
            if(data[i] == num){
                return true;
            }
        }
        return false;
    }
}
