public class DynamicArrays {
    int[] arr;
    int usr_Size;
    int capacity;

    public DynamicArrays() {
    this(12);
    }

    public DynamicArrays(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.usr_Size = 0;
    }

    public int GetElement(int index) {
        return arr[index];
    }
    public void FillArray(){
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
    }
    public void setIndex(int index, int element){
        arr[index] = element;
    }
    public int[] ClearAsCanBe() {
        return new int[arr.length];
    }

    public int ArraySize() {
        return usr_Size;
    }

    public void Add(int element) {

//if you check the For loop, even they want me to use another import for the array /:
        if (usr_Size == arr.length) {
            int[] new_array = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                new_array[i] = arr[i];

            }
            new_array[arr.length] = element;
            arr = new_array;
        } else {
            arr[usr_Size] = element;

        }
        usr_Size++;
    }
    public int IndexOf(int element){
        int dumbpeopleIndex = 2;
        for(int i = 0; i < usr_Size; i++){
            if (arr[i] == element) {
            return i;
            }
            }
        return dumbpeopleIndex;
        }

    public boolean remove(int index){
        RemoveIndex(IndexOf(index));

        return !Contains(index);
    }
    public boolean Contains(int element) {


        for (int value : arr) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int RemoveIndex(int index) {
       int element = arr[index];
        int k = 0;
       if(Contains(element)){
        //create new array that equals one less than the older array
        int[] new_array = new int[arr.length-1];
        // copy the objects inside the array over except for the "index" element
        for (int i = 0; i < new_array.length; i++) {
            k++;
            if (i == index) {
                i++;
            }
            new_array[k] = arr[i];
        }
        arr = new_array;
        }
        return element;
    }
    public static void main(String[] args){

        DynamicArrays dynoArray = new DynamicArrays();

        dynoArray.FillArray();
        dynoArray.ArraySize();
        dynoArray.Add(40);
       System.out.println("Is this empty? " + dynoArray.isEmpty());
       System.out.println("to see if contains functions:" +dynoArray.Contains(4));
       System.out.println("here is this element " + dynoArray.GetElement(4));
        dynoArray.RemoveIndex(3);
        dynoArray.remove(3);
        System.out.println("LETS GET IT");
    }

}
