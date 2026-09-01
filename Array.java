import java.util.*;

public class Array {

    public static void main(String[] args) {
        int arr [] = {16, 17, 4, 3, 5, 2};
        // array leaders
        ArrayList<Integer> leaders = leaders(arr);
        System.out.println(leaders);

        // left rotate by 2
        rotateArr(arr, 2);
        // reverse group of element from an array
        int [] arr1 = {1,2,3,4,5}; // for sort ch ecking
        boolean isSorted = isSortedArray(arr1);
        System.out.println(isSorted);

        // reverse an array
        reverseArray(arr);

        // rearrange arr with postive and negative 
        rearrange(new ArrayList<>(Arrays.asList(1,2,3,-4,-2,3,-3)));

    }

    /**
     * You are given an array arr of positive integers.
     * Your task is to find all the leaders in the array. 
     * An element is considered a leader if it is greater than or equal to all elements to its right.
     * The rightmost element is always a leader.
     * Example arr={5,3,6,4,2,1} then output = [4,2,1]
     * @param arr
     * @return
     */
    public static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        boolean isFound = false;
        for(int i= 0; i<arr.length -1;i++){
            int num = arr[i];
            for(int j= i+1 ; j < arr.length ; j++){
                if(num >= arr[j]){
                    isFound = true;
                }else{
                    isFound = false;
                    break;
                }
               
            }
             if(isFound){
                list.add(num);
            }
        }
        list.add(arr[arr.length - 1]);
      return list;
    }

    /**
     * Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. 
     * Do the mentioned change in the array in place.
     * Example arr = [1,2,3,4,5] d=2, output = [3,4,5,1,2]
     * @param arr
     * @param d
     */

    public static void rotateArr(int arr[], int d) {
        // code here
        int n = arr.length;
        d = d % n;
        rotate(arr,0,d-1);
        rotate(arr,d,n-1);
        rotate(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void  rotate(int arr[], int left ,int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Given an array check whether it is sorted or not if sorted return true else false
     * @param arr
     * @return
     */
    public static boolean isSortedArray(int [] arr){

        for(int i=0 ; i< arr.length -1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
      return true;
    }

    /**
     * Given an integer array arr[] and an integer k, reverse every consecutive group of k elements. If fewer than k elements remain at the end, reverse all of them.

    Examples:

    Input: arr[] = [1, 2, 3, 4, 5], k = 3
    Output: [3, 2, 1, 5, 4]
    Explanation: First group consists of elements 1, 2, 3. Second group consists of 4, 5.
    Input: arr[] = [5, 6, 8, 9], k = 5
    Output: [9, 8, 6, 5]
    Explnation: Since k is greater than the number of remaining elements, the entire array is reversed.
     * 
     * @param arr
     * @param k
     */

    public static  void reverseInGroups(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(n < k){
            reverse(arr,0,n-1);
            System.out.print(Arrays.toString(arr));
        }else{
            for(int i =0; i<n;i+=k){
                int right = Math.min(i + k - 1, n - 1);
                reverse(arr,i,right);
            }
            System.out.print(Arrays.toString(arr));
        }
        
    }
    
    public static void reverse(int [] arr, int left,int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Reverse an array without chaning element order first element in last position and 2nd first is in 
     * second last position and so on
     * @param arr
     */
    public static void reverseArray(int arr[]) {
        // code here
        int n = arr.length;
        if(n>1){
           reverse(arr,0,n-1);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Main aim is to rearrange the arraylist in alernate position, if one postive then next element negative
     * Given an unsorted array arr containing both positive and negative numbers. 
     * Your task is to rearrange the array and convert it into an array of alternate positive and negative numbers 
     * without changing the relative order.
     * Input: arr[] = [9, 4, -2, -1, 5, 0, -5, -3, 2]
       Output: [9, -2, 4, -1, 5, -5, 0, -3, 2]
     * @param arr
     */

    public static void rearrange(ArrayList<Integer> arr) {
        // code here
        List<Integer> plist = new LinkedList<>();
        List<Integer> nlist = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int n = arr.size();
        int left = 0 ;
        while(left < n){
            
            if(arr.get(left) >= 0){
                plist.add(arr.get(left));
            }else{
                nlist.add(arr.get(left));
            }
           left++; 
        }
        int i = 0;
        int j = 0;

        while (i < plist.size() || j < nlist.size()) {

            if (i < plist.size()) {
                result.add(plist.get(i));
                i++;
            }

            if (j < nlist.size()) {
                result.add(nlist.get(j));
                j++;
            }
        }

        for (int k = 0; k < result.size(); k++) {
            arr.set(k, result.get(k));
        }

        System.out.println(arr);
    }

    /**
     * find the maximum profit from multiple transactions
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        // code here
        
        int maxProfit = 0;
        
        for(int i=1 ; i<prices.length ;i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
       return maxProfit; 
    }

    /**
     * Find the maximum profit for single transactions
     * @param prices
     * @return
     */
    public int singleMaxProfit(int[] prices) {
        // Code here
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    /**
     * from the given array find the sub arrays of element
     * Example : arr =[1,2,3] output : [[1],[1,2],[1,2,3],[2],[2,3],[3]]
     * @param arr
     * @return
     */
    public List<List<Integer>> getSubArrays(int[] arr) {
        // code here
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0 ;i<arr.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            result.add(new ArrayList<>(list));
            for(int j=i+1;j<arr.length;j++){
                list.add(arr[j]);
                result.add(new ArrayList<>(list));
            }
        }
        return result;
    }

    /**
     * Given an array of integers, find the most occurring element in the array. 
     * Example: arr = [1, 2, 3, 1, 2, 1] output = 1
     * @param arr
     * @return
     */

    public static int mostOccurringElement(int[] arr) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        int maxCount = 0;
        int mostOccurring = 0;
        for(Map.Entry<Integer,Integer> kv : map.entrySet()){
            if(kv.getValue() > maxCount){
                maxCount = kv.getValue();
                mostOccurring = kv.getKey();
            }
        }
        return mostOccurring;
    }
}
