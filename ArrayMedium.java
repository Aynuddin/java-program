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
        stockBuyAndSellForMultipleTransaction();
        stockBuyAndSellForSingleTrans();
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

    /**
     * Stock Buy and Sell – Multiple Transaction Allowed
     * Given an integer array prices[], 
     * where prices[i] is the price of a given stock on the ith day. 
     * Each day you may decide to either buy or sell the stock at price[i], 
     * you can even buy and sell the stock on the same day, return the maximum profit that you can get 
     */

    public static void stockBuyAndSellForMultipleTransaction(){
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices [i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        System.out.println("Maximum profit from multiple transactions: " + maxProfit);
    }

    /**
     * Stock Buy and Sell – Single Transaction Allowed
     * Given an integer array prices[], 
     * where prices[i] is the price of a given stock on the ith day. 
     * You may complete at most one transaction (i.e., buy one and sell one share of the stock), return the maximum profit that you can get 
     */

    public static void stockBuyAndSellForSingleTrans(){
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            if(profit > maxProfit){
                maxProfit = profit;
            }
            
        }
        System.out.println("Maximum profit from single transaction: " + maxProfit);
    }

    /**
     * Given an unsorted array arr containing both positive and negative numbers. 
     * Your task is to rearrange the array and
     * convert it into an array of alternate positive and negative numbers without changing the relative order.
     * Example: Input: arr[] = {1, 2, 3, -4, -1, 4} Output: arr[] = {-4, 1, -1, 2, 3, 4}
     */
    
}
