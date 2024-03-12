package string;
/*
// https://leetcode.com/problems/longest-common-prefix/description/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters
*
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        if(str.length() == 0) return "";

        for(int i = 1 ; i< strs.length ; i++) {
            for(int j = 0 ; j < str.length(); j++) {
                if(j == strs[i].length() || str.charAt(j) != strs[i].charAt(j)) {
                    str = str.substring(0, j);
                    break;
                }
            }
        }

        return str;

    }
}
