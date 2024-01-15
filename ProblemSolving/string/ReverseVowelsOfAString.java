package string;

// https://leetcode.com/problems/reverse-vowels-of-a-string/

// TAGS : easy, amazon, facebook, two_pointers

/*
* Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
* */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Fastest 2ms
class ReverseVowelsOfAString {
    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        else if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ) return true;
        return false;
    }

    public String reverseVowels(String s) {
        // comparing with list is costly so used simple char comparision
        // List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        char[] str = s.toCharArray();
        int left = 0, right = str.length-1;

        while(left < right){
            if(isVowel(str[right]) && isVowel(str[left])){
                // swapping only if chars are different
                if (str[right] != str[left]){
                    char temp = str[left];
                    str[left] = str[right];
                    str[right] = temp;
                }
                left++;
                right--;
            }
            else if(isVowel(str[right])){
                left++;
            }
            else if(isVowel(str[left])){
                right--;
            }
            else{
                left++;
                right--;
            }
        }
        return String.valueOf(str);
    }
}

/* ----------------- */


// costly operation
// >10ms
class UsingList {
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        char[] str = s.toCharArray();
        int left = 0, right = str.length-1;

        while(left < right){
            if(vowels.contains(str[right]) && vowels.contains(str[left])){
                // swapping only if chars are different
                if (str[right] != str[left]){
                    char temp = str[left];
                    str[left] = str[right];
                    str[right] = temp;
                }
                left++;
                right--;
            }
            else if(vowels.contains(str[right])){
                left++;
            }
            else if(vowels.contains(str[left])){
                right--;
            }
            else{
                left++;
                right--;
            }
        }
        return String.valueOf(str);
    }
}
