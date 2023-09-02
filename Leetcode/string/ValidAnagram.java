package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-anagram/description
// TAGS: easy, hashmap, collections

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
* */

class ValidAnagramUsingHashMap {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> count = new HashMap<>();

        // Count the of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // Decrement the characters in string t if present
        // remove element once reached 0
        // return false if not present
        for (char x : t.toCharArray()) {
            if (count.containsKey(x)) {
                if (count.get(x) == 1) count.remove(x);
                else count.put(x, count.getOrDefault(x, 0) - 1);
            } else {
                return false;
            }
        }
        return count.isEmpty();
    }
}

// ------------------------------------------------

 class ValidAnagramUsingCollection {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}
