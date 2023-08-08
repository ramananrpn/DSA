package hashmap;

import java.util.HashMap;

// 205. Isomorphic Strings

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true


Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */

/*
https://leetcode.com/problems/isomorphic-strings/description/

Tags: hashmap, strings, easy
 */

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> mapS = new HashMap<>();

        for(int i = 0 ; i < t.length() ; i++) {
            if(mapS.containsKey(s.charAt(i))) {
                if(mapS.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
            else {
                // containsValue
                if(mapS.containsValue(t.charAt(i))) {
                    return false;
                }
            }
            mapS.put(s.charAt(i), t.charAt(i));
        }

        return true;
    }
}
