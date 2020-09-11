import java.util.Arrays;

public class arrayboyo {
    int[] arr = new int[20];
    int usr_Size;
    public arrayboyo(){

    }


    public static void main(String[] args) {

    }


    public void FillArray() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public String Contains(int element) {
        String a = "";
        boolean yeah = false;
        for (int value : arr) {
            if (value == element) {
                yeah = true;
                System.out.println("Found it!");

            }
        }
        return a;
    }



    public int[] RemoveIndex(int index) {

        //create new array that equals one less than the older array
        int[] new_array = new int[arr.length -1];
        // copy the objects inside the array over except for the "index" element
        for (int i = 0; i < arr.length; i++) {
            int k = 0;
            k++;
            if( i == index){
                i++;
            }
            new_array[k] = arr[i];
        }
        arr = new_array;

       return arr;
    }

}


//addin
//int [] arr = new int[20]
//int size;
// if size == arr.length();
//int[] new_arraay =new int[ array.length() * 2];
// copy all elements from arr to new_array
//arr = new_array;
//add new elements to new arry

//removin



