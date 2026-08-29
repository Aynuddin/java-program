import java.util.*;
class Basic{
    public static void main(String [] args){

        int [] arr = {3,4,2,9,8};
        // largest element
        int lnum = largestnum(arr);
        System.out.println(lnum);
        // find min and max
        List<Integer> maxmin = getMinMax(arr);
        System.out.println(maxmin);
        // find the k rotate times array in clock wise
        rotateByK(arr);
        // sum of an array
        int totalSum = arraySum(arr);
        System.out.println(totalSum);

        // print the alternates array of element
        ArrayList<Integer> al = getAlternates(arr);
        System.out.println(al);

        // check if element are plaindrome of an array elements then show true else false
        boolean status = isPalinArray(arr);
        System.out.println(status);

        // from given an unsorted array find the num of elements count <= x
        int x = 9;
        int count = countOfElements(x, al);
        System.out.println(count);


    }
    /**
     * Given an array find the largest element int [] 
     * @param arr
     * @return
     */

    public static int largestnum(int [] arr){
        int max = Integer.MIN_VALUE;
        for(int n : arr){
            if(n > max){
                max = n;
            }
        }
        return max;
    }

    /**
     * Given an array find the minimum and maximum number of an array int[] arr
     * @param arr
     * @return
     */
    public static ArrayList<Integer> getMinMax(int[] arr) {
        // code Here
        ArrayList<Integer> list = new ArrayList<>();
        int max = arr[0];
        int min = arr[0];
        for(int n : arr){
            
            if(n < min){
                min = n;
            }else if(n > max){
                max=n;
            }
        }
        list.add(min);
        list.add(max);
      return list;
    }

    /**
     * Given an array elements find the rotation of k times of element (clock wise)
     * Input: arr[] = [1, 2, 3, 4, 5]
     * Output: [5, 1, 2, 3, 4]
     * @param arr
     */
    public static void rotateByK(int[] arr) {
        // code here
        int n = arr.length;
        int k = 1;
        rotate(arr,0,n-1);
        rotate(arr,0,k-1);
        rotate(arr,k,n-1);
        //System.out.println(Arrays.toString(arr).join("")); // why use join("")
        // use join() to remove square bracket [] from output and comma (,) between the elment
        // example [1,2,3,4,5] to 1 2 3 4 5 like this 
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void rotate(int arr[] , int left,int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static int arraySum(int arr[]) {
        // code here
        int sum = 0;
        for(int n : arr){
            sum+=n;
        }
      return sum;
    }

    /**
     * You are given an array arr[], 
     * the task is to return a list elements of arr in alternate order (starting from index 0).
     * Example
     * Input: arr[] = [1, 2, 3, 4]
     * Output: 1 3
     */
    // from an array print the alternates element like
    // example 1,2,3 then print 1 and 3 skip 2
    public static ArrayList<Integer> getAlternates(int arr[]) {
        // Code Here
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0 ; i<arr.length; i=i+2){
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * Given an array arr[] of positive integers. 
     * Return true if all the array elements are palindrome otherwise, return false.
     * @param arr
     * @return
     */

    public static boolean isPalinArray(int[] arr) {
        // code here.
        boolean result = false;
        for(int i=0 ; i< arr.length; i++){
            result = reverse(arr[i]);
        }
        return result;
    }
    
    public static boolean reverse(int a){
        String str = String.valueOf(a);
        String rev="";
        for(int i = str.length() -1; i>=0;i--){
            rev+=str.charAt(i);
        }
        if(str.equals(rev)){
            return true;
        }
        return false;
    }

    /**
     * Given an unsorted array arr[]. Find the count of elements less than or equal to the given element x.
     * @param x
     * @param arr
     * @return
     */

    public static int countOfElements(int x, List<Integer> arr) {
        // code here
        int count =0;
        for(int i =0; i < arr.size();i++){
            if(arr.get(i) <= x){
                count++;
            }
        }
        return count;
    }

}