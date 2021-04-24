package string;

/*
* https://leetcode.com/problems/first-unique-character-in-a-string/
*/

//Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.
//        Example 1:
//        Input: s = "leetcode"
//        Output: 0
//
//        Example 2:
//        Input: s = "loveleetcode"
//        Output: 2
//
//        Example 3:
//
//        Input: s = "aabb"
//        Output: -1
//
//        Constraints:
//        1 <= s.length <= 105
//        s consists of only lowercase English letters.

import java.util.HashMap;
class FirstUniqueChar {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = s.length()-1; i>=0; i--) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }
            else{
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        int index = -1;
        for(int i = s.length()-1; i>=0; i--){
            if(map.get(s.charAt(i))==1){
                index = i;
            }
        }
        return index;
    }
}