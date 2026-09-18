import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class StringCode {
    public static void main(String[] args) {

        String str = "madam";
        // check palindrome
        //boolean isPaindrome = isPalindrome(str);
        //System.out.println(isPaindrome);

        // find the non repeating character
        //char ch = nonRepeatingChar(str);
        //System.out.println(ch);   
        printOnlyVowelsFromString(); 
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

    public static void printOnlyVowelsFromString(){
        String str = "Welcome*to*java";
        String vowels = "";
        for(char ch : str.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                vowels += ch;
            }
        }
        System.out.println("Only vowels from the string: " + vowels);
    }

    public static void printOnlyConsonantsFromString(){
        String str = "Welcome*to*java";
        String consonants = "";
        for(char ch : str.toCharArray()){
            if((ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') && !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')){
                consonants += ch;
            }
        }
        System.out.println("Only consonants from the string: " + consonants);
    }

    /**
     * Find the last non-repeating character in a string
     * Example: str = "Welcome*to*java" output = 'm'
     */
    public static void printlastnonrepeatingChar(){
        String str = "Welcome*to*java";
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char ch : str.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        char lastNonRepeatingChar = '$';
        for(Map.Entry<Character,Integer> kv : map.entrySet()){
            if(kv.getValue() == 1){
                lastNonRepeatingChar = kv.getKey();
            }
        }
        System.out.println("Last non-repeating character: " + lastNonRepeatingChar);
    }

    /**
     * Find the last non-repeating character in a string
     * Example: str = "automation" output = 'n'
     */
    public static void printLastNonRepeatingCharInString(){
        String str = "automation";
        // find last non-repeating character
        Map<Character,Integer> map = new LinkedHashMap<>();
        Set<Character> set = new LinkedHashSet<>();
        for(char ch : str.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        for(Map.Entry<Character,Integer> kv : map.entrySet()){
            if(kv.getValue() == 1){
        
                set.clear();
    
                set.add(kv.getKey());
            }
        }
        System.out.println("Last non repeating character is : "+set.toString());

    }

    /**
     * Print only vowels from the given string
     * Example: str = "automation" output = "auoai"
     * @param str
     */
    public static void printOnlyVowel(String str){
        char ch [] = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if("aeiouAEIOU".indexOf(ch[i]) != -1){
                sb.append(ch[i]);
            }
        }
        System.out.println("Vowels from string : "+sb.toString());
    }

    /**
     * Print only consonants from the given string
     * Example: str = "automation" output = "tmtn"
     * @param str
     */
    public static void printOnlyConsonant(String str){
        char ch [] = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(ch[i] == ' '){
                continue;
            }
            if("aeiouAEIOU".indexOf(ch[i]) == -1){
                sb.append(ch[i]);
            }
        }
        System.out.println("Consonant from string : "+sb.toString());
    }

    /**
     * Reverse only middle word from the given string
     * Example: str = "java:online_compiler" output = "java enilno compiler"
     */
    public static void onlyReverseMiddleWord(){
        String str = "java:online_compiler";
        String splitStr [] = str.split("[^a-zA-Z]+");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< splitStr.length;i++){
            System.out.println(splitStr[i]);
            if(splitStr[i].equals("online")){
                String rev = new StringBuilder(splitStr[i]).reverse().toString();
                sb.append(rev);
                sb.append(" ");
            }else{
                sb.append(splitStr[i]);
                sb.append(" ");
            }
        }
        System.out.println("Only reverse middle word from string : "+sb.toString());
    }

    /**
     * Reverse only middle word from the given string without using reverse() method
     * Example: str = "java:online_compiler" output = "java enilno compiler"
     */
    public static void onlyReverseMiddleWordWithoutUsingReverseMethod(){
        String str = "java:online_compiler";
        String splitStr [] = str.split("[^a-zA-Z]+");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< splitStr.length;i++){
            System.out.println(splitStr[i]);
            if(splitStr[i].equals("online")){
                int left =0;
                char c [] = splitStr[i].toCharArray();
                int right = c.length -1;
                while(left < right){
                    char ch = c[left];
                    c[left] = c[right];
                    c[right] = ch;
                    left++;
                    right--;
                }
                sb.append(c);
                sb.append(" ");
            }else{
                sb.append(splitStr[i]);
                sb.append(" ");
            }
        }
        System.out.println("Only reverse middle word from string : "+sb.toString());
    }

    /** 
     * Reverse the given string without using reverse() method
     * Example: str = "java:online_compiler" output = "relipm
     */
    public static void reverseStringWithoutUsingReverseMethod(){
        String str = "onlinecompiler";
        char c [] = str.toCharArray();
        int left = 0;
        int right = c.length -1;
        while(left < right){
            char ch = c[left];
            c[left] = c[right];
            c[right] = ch;
            left++;
            right--;
        }
        System.out.println("Reverse string without using reverse method : "+new String(c));
    }

    /**
     * Compress the given string by replacing consecutive repeated characters with the character and its count
     * Example: str = "aaabbccd" output = "a3b2c2d1"
     */
    public static void characterCompressLogic(){
        String str = "aaabbccd";
        int count =1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<str.length(); i++){
            if(str.charAt(i) != str.charAt(i-1)){
                sb.append(str.charAt(i-1));
                sb.append(count);
                count =1;
            }else{
                count++;
            }
        }
        sb.append(str.charAt(str.length()-1));
        sb.append(count);
        System.out.println("Compressed string : "+sb.toString());
    }

    /**
     * Decompress the given string by expanding characters with their counts
     * Example: str = "a3b2c2d1" output = "aaabbccd"
     */
    public static void characterDecompress(){
        String str = "a3b2c2d3";//"aaabbccd";
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<str.length();i=i+2){
            char ch = str.charAt(i);
            int digit = ch -'0';
            for(int j=0;j<digit;j++){
                sb.append(str.charAt(i-1));
            }
        }
        System.out.println("Decompress String : "+sb.toString());
    }

    /**
     * Find the second maximum number from the given string
     * Example: str = "ayn3b2c6d5" output = 5
     */
    public static void findSecondMaxNumberFromString(){
        String str = "ayn3b2c6d5";//"aaabbccd";
        int firstMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch -'0' >= 0 && ch -'0' <=9){
                int digit = ch-'0';
                if(digit > firstMax){
                    secMax = firstMax;
                    firstMax = digit;
                }else if (digit > secMax && firstMax != digit){
                    secMax = digit;
                }
            }
        }
        System.out.println("Second Max digit from String String : "+secMax);
    }


    /**
     * Find the second minimum number from the given string
     * Example: str = "ayn3b2c6d5" output = 3
     */
    public static void findSecondMinNumberFromString(){
        String str = "ayn3b4c6d5";//"aaabbccd";
        int firstMin = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch -'0' >= 0 && ch -'0' <=9){
                int digit = ch-'0';
                if(digit < firstMin){
                    secMin = firstMin;
                    firstMin = digit;
                }else if (digit < secMin && firstMin != digit){
                    secMin = digit;
                }
            }
        }
        System.out.println("Second Min digit from String String : "+secMin);
    }
}
