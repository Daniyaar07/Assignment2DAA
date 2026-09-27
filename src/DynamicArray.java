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
        if(size == data.length){
            int[] newData = new int[data.length *2];
            for(int i =0; i < data.length; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size] = num;
        size++;
    }
    public int get(int index){
        if(index < 0 || index>= size){
            throw new IndexOutOfBoundsException();
        }
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
    public void add(int index , int num){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(size == data.length){
            int[] newData = new int[data.length * 2];
            for(int i = 0; i< data.length; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
        for(int i = size; i >index; i--){
            data[i] = data[i - 1];
        }
        data[index] = num;
        size++;
    }
    public int remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        int removedNum = data[index];
        for (int i = index; i <size- 1; i++){
            data[i]= data[i + 1];
        }
        size --;
        return removedNum;
    }
}
