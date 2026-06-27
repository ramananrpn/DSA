package two_pointer.easy;
import java.util.Set;

/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.



Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 */



// fastest
// Since vowels are fixed (only 5 chars), avoid Set overhead:
public class ReverseVowelsOfAString {

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);

        return c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u';
    }

    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        int i = 0, j = arr.length - 1;

        while (i < j) {

            while (i < j && !isVowel(arr[i])) i++;
            while (i < j && !isVowel(arr[j])) j--;

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return new String(arr);
    }
}


// ------------

class ReverseVowelsOfAStringWithSet {
    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of(
                'a', 'e', 'i', 'o', 'u'
        );

        char[] arr = s.toCharArray();

        int i = 0, j = arr.length - 1;

        while (i < j) {

            while (i < j &&
                    !vowels.contains(Character.toLowerCase(arr[i]))) {
                i++;
            }

            while (i < j &&
                    !vowels.contains(Character.toLowerCase(arr[j]))) {
                j--;
            }

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return new String(arr);
    }
}