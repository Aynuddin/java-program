import java.util.Arrays;

public class SortingCode {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        waveSort(arr);
        System.out.println(Arrays.toString(arr));
        // sorting array in ascending order
        int arr1[] = {5, 2, 8, 1, 3};
        sortingArrayBYAsending(arr1);

        sortingBYDescending(arr1);
    }

    /**
     * Given an sorted array arr[] of integers. Sort the array into a wave-like array (In Place). 
     * In other words, arrange the elements into a sequence 
     * such that : arr[0] ≥ arr[1] ≤ arr[2] ≥ arr[3] ≤ arr[4] ≥ ... and so on. 
     * If there are multiple solutions, find the lexicographically smallest one.
     */

    public static void waveSort(int[] arr) {
        // code here
        for(int i=0; i<arr.length-1; i+=2){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }

    /**
     * Sort the array in ascending order without bubble sort because we are not looking for
     * adjacent element like a[i] > a[i+1]
     * example: arr = [5, 4, 3, 2, 1] output = [1, 2, 3, 4, 5]
     * @param arr
     */
    public static void sortingArrayBYAsending(int [] arr){
       for(int i=0; i<arr.length-1;i++){
        for(int j=i+1; j<arr.length;j++){
            if(arr[i] > arr[j]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
       }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Sort the array in descending order with bubble sort because 
     * we are looking for adjacent element like a[i] < a[i+1]
     * example: arr = [1, 2, 3, 4, 5] output = [5, 4, 3, 2, 1]
     * @param arr
     */

    public static void sortingBYDescending(int [] arr){
        for(int i=0; i<arr.length-1;i++){
            for(int j=0; j<arr.length-1;j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }   
    
}
