package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/

/*
* Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
* */


 class MinimumSlidingWindow {
     public List<Integer> findAnagrams(String s, String p) {
         List<Integer> result = new ArrayList<>();

         if(s.length() < p.length()) return result;

         int[] sArray = new int[26];
         int[] pArray = new int[26];


         for(int i = 0; i<p.length() ; i++){
             pArray[p.charAt(i) - 'a']++;
             sArray[s.charAt(i) - 'a']++;
         }
         if(Arrays.equals(sArray, pArray)) result.add(0);

         for(int i = p.length(); i < s.length(); i++) {
             sArray[s.charAt(i) - 'a']++;
             sArray[s.charAt(i - p.length()) - 'a']--;
             if(Arrays.equals(sArray, pArray)) result.add(i-p.length()+1);
         }

         return result;
     }
 }

 /* -------------------------------------------------*/

// O(n)
// https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92015/ShortestConcise-JAVA-O(n)-Sliding-Window-Solution

class OptimisedSlidingWindow {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()) return result;

        int[] data = new int[26];


        int left = 0, right = 0;
        int count = 0;
        for(char ch : p.toCharArray()){
            data[ch-'a']++;
        }

        while(right < s.length()){
            if(data[s.charAt(right) - 'a'] > 0){
                data[s.charAt(right)-'a']--;
                right++;
                count++;
            }
            else{
                data[s.charAt(left) - 'a']++;
                left++;
                count--;
            }
            if(count == p.length()){
                result.add(left);
            }
        }

        return result;
    }
}
