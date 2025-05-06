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

// ----------------------------------------------------------------------
// Horizontal scanning
// O(n)

class LongestCommonPrefixHorizontalScanning {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for(int i = 1 ; i < strs.length; i++ ) {
            while(!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}

// ----------------------------------------------------------------------
// Divide and Conquer
// O(log n)
class LongestCommonPrefixDivideAndConquer {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return findCommonPrefix(strs, 0, strs.length - 1);
    }

    private String findCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }

        int mid = (left + right) / 2;
        String lcpLeft = findCommonPrefix(strs, left, mid);
        String lcpRight = findCommonPrefix(strs, mid + 1, right);
        return commonPrefix(lcpLeft, lcpRight);
    }

    private String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, minLength);
    }
}
