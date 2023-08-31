package string;
// https://leetcode.com/problems/is-subsequence/description

// TAGs: two_pointers, easy

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
* */

public class IsSubsequence {
    // own solution
     public boolean isSubsequenceOwnSolution(String s, String t) {
         int len1 = s.length();
         int len2 = t.length();

         if(len1 == 0) {
             return true;
         }

         if(len2 < len1) {
             return false;
         }

         while(len2 > 0 && len1 > 0) {
             if(t.charAt(len2-1) == s.charAt(len1-1)) {
                 if(--len1 == 0) {
                     return true;
                 }
             }
             len2--;
         }
         return false;
     }

//     -----------------------------------------------

    public boolean isSubsequence(String s, String t) {
        int run1 = 0;
        int run2 = 0;

        while(run1 < s.length() && run2 < t.length()) {
            if(s.charAt(run1) == t.charAt(run2)) {
                run1++;
            }
            run2++;
        }
        return run1 == s.length();
    }
}
