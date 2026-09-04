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

    /**
     * Reverse the word of a string
     * example: str = "Welcome to Java" output = "Java to Welcome"
     */
    public static void reverseWordFromString(){
        String str = "Welcome to Java";
        String[] wordSplit = str.split(" ");
        String rev = "";
        for(int i=wordSplit.length-1 ; i>=0 ;i--){
          rev+= wordSplit[i]+ " ";
        }
        System.out.println("Reverse of word of a string: "+rev); //ava to Welcome
    }
    
    /**
     * Reverse only character of each word by maintain white space
     * example: str = "Welcome to Java" output = "emocleW ot avaJ"
     */
    public static void reverseWordCharacterWCPWithWhitespace(){
          String str = "Welcome to Java";
          String[] wordSplit = str.split(" ");
          String rev = "";
          for(int i=0 ;i<wordSplit.length; i++){
              String word = wordSplit[i];
              for(int j = word.length() -1 ; j >=0 ; j--){
                rev+=word.charAt(j);
              }
            rev+=" ";
          }
      System.out.println("Reverse only character of each word by maintain white space : " +rev); //emocleW ot avaJ
    }

    /**
     * Reverse word and character of each word by maintain white space
     * example: str = "Welcome to Java" output = "avaJ ot emocleW"
     */
    public static void reverseWordAndCharWordWithWhiteSpace(){
        String str = "Welcome to Java";
        String[] wordSplit = str.split(" ");
        String rev = "";
        for(int i =wordSplit.length-1;i>=0;i--){
            rev+= new StringBuilder(wordSplit[i]).reverse().toString()+ " ";
        }
      System.out.println("Reverse word with character : "+rev); // avaJ ot emocleW
    }

    /**
     * Reverse the word of a string but keep special character remain same
     * example: str = "Welcome*to*Java" output = "Java*to*Welcome"
     */
    public static void reverseWordButKeepSpecialCharacterRemainSame(){
      String str = "Welcome*to*Java";
      String[] s = str.split("\\*");
      String rev = "";
      for(int i=s.length-1; i>=0;i--){
        rev += s[i] +" ";
      }
      rev = rev.trim();
      rev = rev.replace(' ', '*');
      System.out.println(rev); //Java*to*Welcome
    }

    /**
     * Reverse only character of each word by maintain white space
     * example: str = "Welcome*to*Java" output = "emocleW*ot*avaJ"
     */
    public static void reverseOnlyCharacterOfWordKeepingSpecialchr(){
        String str = "Welcome*to*Java";
        String[] s = str.split("\\*");
        String rev = "";
      for(int i=0;i < s.length;i++){
        rev += new StringBuilder(s[i]).reverse().toString() + " ";
      }
      rev=rev.trim();
      rev=rev.replace(' ','*');
      System.out.print("Reverse character : "+rev); //emocleW*ot*avaJ
    }
    
}
