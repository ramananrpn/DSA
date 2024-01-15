package string;

// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

// Tags : easy, sliding_window, quora

/*
* A string is good if there are no repeated characters.

Given a string s, return the number of good substrings of length three in s.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.

Example 1:
Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
The only good substring of length 3 is "xyz".

Example 2:
Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".


Constraints:
1 <= s.length <= 100
s consists of lowercase English letters.
* */


// ----------------------------- TWO POINTER SLIDING WINDOW -------------------------------
// own code
 class SubstringsOfSizeThreeWithDistinctCharactersWithTwoPointerSlidingWindow {
     public int countGoodSubstrings(String s) {
         int left = 0, right = 0;
         int count = 0;
         int result = 0;

         int[] lookup = new int[26];

         int len = s.length();

         while(right < len) {

             if(lookup[s.charAt(right) - 'a'] != 0) {
                 lookup[s.charAt(left) - 'a']--;
                 left++;
                 count--;
             }else{
                 lookup[s.charAt(right) - 'a']++;
                 count++;
                 right++;
             }


             if(count == 3) {
                 result++;

                 count--;
                 lookup[s.charAt(left) - 'a']--;
                 left++;
             }
         }

         return result;
     }

 }


// ----------------------------- ONE POINTER FASTEST SIMPLE -------------------------------
// own code
class SubstringsOfSizeThreeWithDistinctCharactersFastest {
    public int countGoodSubstrings(String s) {
        int result = 0;

        for(int i=1;i<s.length()-1;i++)
            if(isValid(s,i))
                result++;

        return result;
    }

    private boolean isValid(String s , int i){
        return s.charAt(i-1) != s.charAt(i) &&
                s.charAt(i+1) != s.charAt(i) &&
                s.charAt(i+1) != s.charAt(i-1);
    }
}