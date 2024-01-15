package string;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// TAGS: medium, sliding_window, hash_set, google, amazon, facebook

/*
* Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
* */

// Brute Force
class BruteForceLongestString {
     public int lengthOfLongestSubstring(String s) {
         HashMap<Character ,Integer> map = new HashMap<>();
         int max =0 ;
         for(int i =0 ; i< s.length() ; i++){
             int count = 0;
             for(int j=i ; j < s.length() ;j++){
                 if(map.containsKey(s.charAt(j))){
                     map.clear();
                     break;
                 }
                 else{
                     map.put(s.charAt(j) , 1);
                     count++;
                 }
             }
             if(count>max){
                 max = count;
             }
         }
         return max;
     }
 }

/* -------------------  */

// Optimised Sliding Window
class SlidingWindowLongestString {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] string = s.toCharArray();
        int left = 0, right = 0, ans = 0;
        while(right < s.length()){
            if(map.containsKey(string[right])){
                left = Math.max(map.get(string[right]), left);
            }
            map.put(string[right], right +1);
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}

/* -------------------  */

// Using HashSet
 class UsingHashSetLongestString {
     public int lengthOfLongestSubstring(String s) {
         int max = 0, front = 0, back = 0;
     HashSet<Character> chars = new HashSet<>();

     while (back < s.length()) {
         char c = s.charAt(back++);
         while (chars.contains(c)) {
             chars.remove(s.charAt(front++));
         }
         chars.add(c);
         max = Math.max(max, back - front);
     }

     return max;
     }
 }

 /* -------------------  */

// Fastest 1 ms Solution
 class Fastest {
     public int lengthOfLongestSubstring(String s) {
         if(s == null || s.length() == 0) return 0;

         char[] chars = s.toCharArray(); //because accesing chars[x] is much faster than s.charAt(x);
         int result=0, start=0, end=0;
         for(int i=1; i < chars.length; i++) {
             for(int j=start; j <= end; j++) {
                 if(chars[i] == chars[j]) {
                     if(end-start+1 > result) result = end-start+1;
                     start = j+1;
                     break;
                 }
             }
             end=i;
         }
         return result > end-start+1 ? result : end-start+1;
     }
 }