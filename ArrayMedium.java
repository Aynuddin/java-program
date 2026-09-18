import java.util.*;
public class ArrayMedium {

    public static void main(String[] args) {
        List<Integer> leaders = findLeadersOfArray();
        System.out.println("Leaders of the array are: " + leaders);
        int arr[] = {1, 2, 3, 4, 5};
        leftRotateArr(arr, 2);
        rightRotateArr(arr, 2);
        firstMissingNumber();
        findSmallestAndLargestNumberFromNegativeArray();
        findSmallestAndLargestNumberPositiveArray();
    }

    public static List<Integer> findLeadersOfArray(){
        List<Integer> leaders = new ArrayList<>();
        int[] arr = {16, 17, 4, 3, 5, 2};
        boolean isLeader = false;
            for(int i = 0; i< arr.length -1; i++){
                int leaderElement = arr[i];
               for(int j = i+1; j< arr.length; j++){
                   if(leaderElement > arr[j]){
                       isLeader = true;
                   } else {
                       isLeader = false;
                       break;
                   }
            }
            if(isLeader){
                leaders.add(leaderElement);
            }
        }
        leaders.add(arr[arr.length - 1]);
        return leaders;
    }

    /**
     * This method rotates the given array by d positions to the left.(anticlockwise direction)
     * @param arr
     * @param d
     */

    public static void leftRotateArr(int arr[], int d) {
        int n = arr.length;
        d = d % n;
        rotateByKtimes(arr,0,d-1);
        rotateByKtimes(arr,d,n-1);
        rotateByKtimes(arr,0,n-1);
        System.out.println("Array after left rotation by " + d + " positions: " + Arrays.toString(arr)); 
    }

    /**
     * This method rotates the given array by d positions to the right.(clockwise direction)
     * @param arr
     * @param d
     */
    public static void rightRotateArr(int arr[], int d) {
        int n = arr.length;
        d = d % n;
        rotateByKtimes(arr,0,n-1);
        rotateByKtimes(arr,0,d-1);
        rotateByKtimes(arr,d,n-1);
        System.out.println("Array after right rotation by " + d + " positions: " + Arrays.toString(arr)); 
    }

    
    public static void rotateByKtimes(int [] arr, int left,int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void firstMissingNumber(){
        int arr[] = {1,3,0,-1,2};
        int n = arr.length;
        // Implementation for finding the first missing positive number
        for(int i=1; i<=n; i++){
            if(!contains(arr, i)){
                System.out.println("The first missing positive number is: " + i);
                return;
            }
        }
    }
    public static boolean contains(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    public static void findSmallestAndLargestNumberFromNegativeArray(){
        int arr[] = {1, -3, 0, -1, 2};
        int smallest = arr[0];
        int largest = arr[0];
        for(int n : arr){
            if(n < 0){
                if(n < smallest){
                    smallest = n;
                }  
            }else{
                if(n > largest){
                    largest = n;
                }
            }
        }
        System.out.println("Smallest number from array : "+smallest);
        System.out.println("Largest number from array : "+largest);
        
    }
    public static void findSmallestAndLargestNumberPositiveArray(){
        int arr[] = {1, 3, 0, 4, 2};
        int smallest = arr[0];
        int largest = arr[0];
        for(int n : arr){
            if(n < smallest){
                smallest = n;
            }else if(n > largest){
                largest = n;
            }
        }
        System.out.println("Smallest number from array : "+smallest);
        System.out.println("Largest number from array : "+largest);
        
    }

    /**
     * This method sorts the given array in descending order.
     * if > then ascending order
     * if < then descending order
     */
    public static void sortingArry(){
        int arr[] = {1, 3, 0, 4, 2};
        for(int i=0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j]=temp;
                }
            }
        }  
       System.out.println("Sorting array : "+Arrays.toString(arr)); // 4,3,2,1,0
    }
    
}
