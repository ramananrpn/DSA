package string;


import java.util.HashMap;

// https://leetcode.com/problems/longest-palindrome/

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.


Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

*/

/*
Let’s take all pairs we can:
	•	c: 4 → can use all 4 (2 pairs)
	•	d: 2 → can use all 2 (1 pair)
	•	a: 1 → one leftover
	•	b: 1 → one leftover

So total pairs = 6 letters (ccccdd)

And we can place one leftover letter (a or b) in the center → +1

✅ Total = 6 + 1 = 7
 */

// TAGS: easy, hash-map, string, palindrome, greedy

public class LongestPalindrome {
     public int longestPalindrome(String s) {
         HashMap<Character, Integer> map = new HashMap<>();

         // Step 1: Count frequency
         for(char ch : s.toCharArray()) {
             map.put(ch, map.getOrDefault(ch, 0) + 1);
         }

         int length = 0;
         boolean hasOdd = false;

         // Step 2: Use even counts fully, odd counts partially
         for (Character ch : map.keySet()) {
             int count = map.get(ch);

             // even
             if(count % 2 == 0) {
                 length += count; // even can be fully used
             } else {
                 length += count - 1; // add only even part (if 3 -> add 2)
                 hasOdd = true;
             }
         }

         // Step 3: Add 1 if any odd count existed
         // add +1 if any odd element present to join in center say: aabcc
         if (hasOdd) {
             length++;
         }

         return length;
     }
}

// ------------------------------------------------------------

//  int[128] is faster, simpler, and uses less memory than HashMap.
// 1 ms

class LongestPalindromeOptimized {

    public static int longestPalindrome(String s) {
        int n = s.length();
        boolean alp[] = new boolean[128];  // ASCII characters only
        int ans = 0;
        for(char c : s.toCharArray()){
            if(alp[c]){         // already seen once (pair formed)
                alp[c] = false;
                ans += 2;       // we formed a pair => add 2
            }
            else{
                alp[c] = true;  // mark character as seen (waiting for pair)
            }
        }
        return ans == n ? ans : ans + 1;  // add one center char if possible
    }
}


