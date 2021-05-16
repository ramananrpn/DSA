package string;

// https://leetcode.com/problems/minimum-window-substring/

//TAGS : sliding_window

/*
* Given two strings s and t of lengths m and n respectively, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of English letters.
* */


class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        String result = "";

        for(char ch : t.toCharArray()){
            map[ch]++;
        }
        int count = 0, left = 0, right = 0, min = Integer.MAX_VALUE, head = 0;

        while(right < s.length()){
            if(map[s.charAt(right)] > 0) {
                count++;
            }
            map[s.charAt(right)]--;
            right++;
            while(count == t.length() ) {
                if( min > right-left){
                    min = right - left;
                    result = s.substring(left, right);
                }
                if(map[s.charAt(left)] == 0) {
                    count--;
                }
                map[s.charAt(left)]++;
                left++;
            }
        }
        return result;
    }
}