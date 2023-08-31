package string;

// https://leetcode.com/problems/valid-palindrome/description
// TAGS: two_pointer, easy

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
* */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;

        while(left <= right) {
            if((s.charAt(left) < 97 || s.charAt(left) > 122) && !Character.isDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if((s.charAt(right) < 97 || s.charAt(right) > 122) && !Character.isDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
