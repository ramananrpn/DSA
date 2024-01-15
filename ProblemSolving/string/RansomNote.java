package string;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
* */

import java.util.HashMap;

public class RansomNote {
    public boolean canConstructUsingHashMap(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i)) > 0) {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

//    ----------------------------

    // fastest
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCounts = new int[26]; // Assuming lowercase English letters

        for (char c : magazine.toCharArray()) {
            charCounts[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if ( !(charCounts[c - 'a'] > 0 ) ) {
                return false;
            }
            charCounts[c - 'a']--;
        }

        return true;
    }
}
