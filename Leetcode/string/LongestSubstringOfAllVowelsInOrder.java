package string;

// https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/

// TAGS : revisit
/*
* A string is considered beautiful if it satisfies the following conditions:

Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least once in it.
The letters must be sorted in alphabetical order (i.e. all 'a's before 'e's, all 'e's before 'i's, etc.).
For example, strings "aeiou" and "aaaaaaeiiiioou" are considered beautiful, but "uaeio", "aeoiu", and "aaaeeeooo" are not beautiful.

Given a string word consisting of English vowels, return the length of the longest beautiful substring of word. If no such substring exists, return 0.

A substring is a contiguous sequence of characters in a string.

Example 1:

Input: word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
Output: 13
Explanation: The longest beautiful substring in word is "aaaaeiiiiouuu" of length 13.
Example 2:

Input: word = "aeeeiiiioooauuuaeiou"
Output: 5
Explanation: The longest beautiful substring in word is "aeiou" of length 5.
Example 3:

Input: word = "a"
Output: 0
Explanation: There is no beautiful substring, so return 0.


Constraints:

1 <= word.length <= 5 * 105
word consists of characters 'a', 'e', 'i', 'o', and 'u'.
* */

class LongestSubstringOfAllVowelsInOrder {
    public int longestBeautifulSubstring(String word) {
        int[] v = {'a', 'e', 'i', 'o', 'u'};
        int right= 0, left = 0, max = 0;
        int runner = 0;

        while(right < word.length()){
            if (runner == v.length && word.charAt(right)!=v[v.length-1]) {
                max = max < right - left ? right - left : max;
                left = right;
                runner = 0;
            }
            if(word.charAt(left) != v[0]){
                left++;
                right++;
            }
            else if(right!=0 && word.charAt(right) == word.charAt(right-1)){
                right++;
            }
            else if (word.charAt(right) == v[runner]){
                runner++;
                right++;
            }

            else {
                left = right;
                runner = 0;
            }
        }
        if (runner == v.length) {
            max = max < right - left ? right - left : max;
        }
        return max;
    }
}