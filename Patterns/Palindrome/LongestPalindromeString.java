package Palindrome;

/* https://leetcode.com/problems/longest-palindromic-substring/ */

// #3

/* QUESTION
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 */

// tags: medium, palindrome

/* ****** ANSWER ******

/*    Brute Force */
/*
	•	Outer + inner loops → O(n²)
	•	Each palindrome check → O(n)
👉 Total worst-case time complexity = O(n³)
 */

 class BruteForce {

     public String longestPalindrome(String s) {
         if(s.length()==1) return s;

         String max = "";
         for(int i = 0 ; i < s.length()-1; i++){
             for(int j = s.length()-1; j>=i ; j--){
                 int start = i, end = j;
                 for(; end >= start ;start++, end--) {
                     if(s.charAt(start) != s.charAt(end)) {
                         break;
                     }
                 }
                 if(start>end && s.substring(i, j+1).length() > max.length()) {
                         max = s.substring(i, j+1);
                 }
             }
         }
         return max;
     }

     // another brute force same logic
     // Brute Force
     public String longestPalindrome1(String s) {
         String max = "";
         for(int i = 0 ; i < s.length() ; i++) {
             for(int j = s.length() - 1 ; j>= i ; j--) {
                 int start = i;
                 int end = j;
                 while(start <= end && s.charAt(start) == s.charAt(end))  {
                     start++; end--;
                 }
                 // palindrome found
                 if(start > end) {
                     int len = j - i + 1; // length of substring
                     max = max.length() > len ? max : s.substring(i, j+1);
                     break;
                 }
             }
         }
         return max;
     }

 }

/*     Expanding Through Center

 Time complexity: O(n^2) - since each call to extendPalindrome() method takes O(n) time
 Space Complexity: O(1)
 * The key observation is that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center and there are only 2n - 1 such centers.
2n - 1 = n + (n - 1).
 * The reason is that there could 'n' centers considering the length of palindrome string is odd and there could be 'n - 1' centers considering the length of palindrome string is even.
*/

class ExpandingThoughCenter {
    int start, maxLength;

    public String longestPalindrome(String s) {
//         returning emtly string if input is empty
        if(s.length() == 0 || s == null) return "";

        for(int i = 0 ; i < s.length() ; i++) {
            expandFromCenter(s, i, i);
            expandFromCenter(s, i, i+1);
        }
        return s.substring(start, start + maxLength);
    }

    private void expandFromCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; right++;
        }
        if (maxLength < right-left-1) { // right-left -> (length of palindrom +1 ) & reducing 1
            start = left + 1;
            maxLength = right-left -1;
        }
    }
}


/* Manchester Algorithm
***** YET TO PRACTICE ****
https://leetcode.com/problems/longest-palindromic-substring/discuss/279551/java-solution%3A-Manacher's-Algorithm
*/

/* DP
***** YET TO PRACTICE ****
https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
*/

