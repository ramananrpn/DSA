package string;

import java.util.Arrays;
import java.util.HashMap;

/* https://leetcode.com/problems/permutation-in-string/ */


/*
* Given two strings s1 and s2, return true if s2 contains the permutation of s1.

In other words, one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
* */


class PermutationInStringWithHashMap {
     public boolean checkInclusion(String s1, String s2) {
         HashMap<Character, Integer> map = new HashMap<>();
         for(char ch : s1.toCharArray()){
             map.put(ch, map.getOrDefault(ch, 0)+1);
         }

         for(int i = 0 ; i<= s2.length() - s1.length() ; i++){
             int j = 0;
             HashMap<Character, Integer> map1 = new HashMap<>();
             map1.putAll(map);
             while(j < s1.length()){
                 if(map1.containsKey(s2.charAt(i+j))){
                     if(map1.get(s2.charAt(i+j)) == 1){
                         map1.remove(s2.charAt(i+j));
                     }
                     else{
                         map1.put(s2.charAt(i+j), map1.get(s2.charAt(i+j))-1);
                     }
                 }
                 j++;
             }

             if(map1.isEmpty()){
                 return true;
             }

         }
         return false;

     }
 }

// ----------------------------------------------------------

class PermutationInStringWithSlidingWindow {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];

        if(s1.length() > s2.length()) return false;

        for(int i = 0 ; i< s1.length(); i++){
            s1Array[s1.charAt(i) - 'a']++;
            s2Array[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(s1Array, s2Array)) return true;

        for(int i = s1.length() ; i < s2.length() ; i++ ) {
            s2Array[s2.charAt(i)- 'a']++;
            s2Array[s2.charAt(i - s1.length()) - 'a']--;
            if(Arrays.equals(s1Array, s2Array)) return true;
        }
        return false;
    }
}
