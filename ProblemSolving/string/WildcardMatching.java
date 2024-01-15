package string;

/* https://leetcode.com/problems/wildcard-matching/ */

/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).


Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input: s = "adceb", p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input: s = "acdcb", p = "a*c?b"
Output: false


Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
*/

/* GREEDY */
class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();

        // base case if both lengths are 0 or pattern has only "*"
        if((sLength == 0 && pLength == 0) || p.equals("*")) return true;

        int sIndex, pIndex;
        int sRunner = 0;
        int pRunner = 0 ;
        sIndex = pIndex = -1;

        while(sRunner < sLength){
            if(pRunner < pLength && ((s.charAt(sRunner) == p.charAt(pRunner)) || p.charAt(pRunner)=='?')){
                sRunner++;
                pRunner++;
            }
            else if(pRunner < pLength && p.charAt(pRunner)=='*'){
                sIndex = sRunner;
                pIndex = pRunner;
                pRunner++;
            }
            else if(pIndex != -1){
                sRunner = sIndex+1;
                pRunner = pIndex+1;
                sIndex++;
            }
            else {
                return false;
            }
        }

        while(pRunner < pLength && p.charAt(pRunner) == '*'){
            pRunner++;
        }

        return pRunner == pLength;
    }

    // TIME COMPLEXITY - O(m+n), m -> length of string, n -> length of pattern
    // https://www.geeksforgeeks.org/dynamic-programming-wildcard-pattern-matching-linear-time-constant-space/

    /* DP Approach
    https://www.geeksforgeeks.org/wildcard-pattern-matching/
    Time complexity: O(m x n)
    * */
}