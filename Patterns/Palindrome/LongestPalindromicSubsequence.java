package Palindrome;

// #2

// https://leetcode.com/problems/longest-palindromic-subsequence/description/
// solution : https://www.geeksforgeeks.org/dsa/longest-palindromic-subsequence-dp-12/

/*
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".


Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
 */

// Solution brute force
/*
 - If characters are matching, increment the value low and decrement the value high by 1 and recur to find the LPS of new substring. And return the value result + 2.
 - Else make two recursive calls for (low + 1, hi) and (lo, hi-1).  And return the max of 2 calls.
 */
public class LongestPalindromicSubsequence {
    // Time complexity 2^n
    // Time Limit Exceeded for large inputs
        // s = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"
    public int longestPalindromeSubseq(String s) {
        return findLps(s, 0, s.length() - 1);
    }

    private int findLps(String s, int i, int j) {
        if(i>=j) return i==j ? 1 : 0;

        if(s.charAt(i) == s.charAt(j)) {
            // adding 2 for counting the chars at i and j since they could form plaindrome string
            // then moving i to next char & j to previous char
            return findLps(s, i+1, j-1) + 2;
        }

        else {
            return Math.max(findLps(s, i+1, j), findLps(s, i, j-1));
        }
    }
}

// ---------------- Memoization approach --------------------
// TopDown Dynamic Programming
// Time complexity: O(n^2)
class LongestPalindromicSubsequenceMemoization {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        Integer[][] memo = new Integer[n][n];
        return findLps(s, 0, n - 1, memo);
    }

    private int findLps(String s, int i, int j, Integer[][] memo) {
        if(i>=j) return i==j ? 1 : 0;

        if(memo[i][j] != null) return memo[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            memo[i][j] = findLps(s, i+1, j-1, memo) + 2;
        } else {
            memo[i][j] = Math.max(findLps(s, i+1, j, memo), findLps(s, i, j-1, memo));
        }

        return memo[i][j];
    }
}

// ----------------- Iterative DP approach --------------------
// BottomUp Dynamic Programming
// Time complexity: O(n^2)
class LongestPalindromicSubsequenceDP {
    // Tabulation (DP -> Bottom Up)
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // last iteration i = 0 and j = n -1 -> 8
        return dp[0][n - 1];
    }
}