import java.util.LinkedHashMap;
import java.util.Map;

public class StringCode {
    public static void main(String[] args) {

        String str = "madam";
        // check palindrome
        boolean isPaindrome =isPalindrome(str);
        System.out.println(isPaindrome);

        // find the non repeating character
        char ch = nonRepeatingChar(str);
        System.out.println(ch);    
    }
    /**
     * check whether plaindrome or not and if plaindrome return true else false
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        // code here
       int left =0;
       int right = s.length()-1;
       while(left < right){
           if(s.charAt(left) != s.charAt(right)){
               return false;
           }
       }
       return true;
    }

    /**
     * find the non repeating character from an string
     * @param s
     * @return
     */
    public static char nonRepeatingChar(String s) {
        // code here
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        for(Map.Entry<Character,Integer> kv : map.entrySet()){
            if(kv.getValue() == 1){
                return kv.getKey();
            }
        }
        return '$';
    }

    /**
     * Remove space between the string
     * @param s
     * @return
     */
    public static String removeSpaces(String s) {
        // code here
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' '){
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * isSubSequence check whether the string is subsequence or not
     * Example: s1 = "abc" s2 = "ahbgdc" return true because "abc" are in same order in s2
     * @param s1
     * @param s2
     * @return
     */

    public static boolean isSubSequence(String s1, String s2) {
        // code here
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s1.length();
    }   

    /**
     * From a given find the most occurring character in the string
     * Example: s = "abca" output = 'a'
     * @param s
     * @return
     */
    public static char mostOccurringChar(String s) {
        // code here
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        int maxCount = 0;
        char mostOccurring = '$';
        for(Map.Entry<Character,Integer> kv : map.entrySet()){
            if(kv.getValue() > maxCount){
                maxCount = kv.getValue();
                mostOccurring = kv.getKey();
            }
        }
        return mostOccurring;
    }

    /**
     * Given a string s and a character c. 
     * The task is to remove all the occurrences of the character in the string.
     * Example: s = "abca" c = 'a' output = "bc" // note: no new modified string should be return
     * @param s
     * @param c
     */
    public static void removeCharacter(StringBuilder s, char c) {
        // code here
        String remain="";
        //char ch[] = s.toString().toCharArray();
        for(int i= 0;i<s.length();i++){
            if(s.charAt(i) == c){
                continue;
            }
            remain+=s.charAt(i);
        }
        s.setLength(0);
        s.append(remain);
    }

    /**
     * Given a string s, toggle the case of each character in the string.
     * Example: s = "AbC" output = "aBc"
     * @param s
     * @return
     */
    public static String toggleCase(String s) {
        // code here
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch >= 'a' &&  ch<= 'z'){
                sb.append((char) (ch - 32));
            }else if(ch >= 'A' &&  ch<= 'Z'){
                sb.append((char)(ch + 32));
            }
        }
    
       return sb.toString();
    }

    /**
     * Given two strings s1 and s2, check whether the two strings are same or not.
     * Example: s1 = "abc" s2 = "abc" output = true
     * @param s1
     * @param s2
     * @return
     */
    public static boolean areStringsSame(String s1, String s2) {
        // code here
        int i=0;
        int j=0;
        boolean isSame=false;
        if(s1.length() != s2.length()){
            return isSame;
        }
        while((i<s1.length()) &&  (j < s2.length())){
            if(s1.charAt(i) == s2.charAt(j)){
                isSame=true;
            }
            i++;
            j++;
        }
        return isSame;
    }

}
