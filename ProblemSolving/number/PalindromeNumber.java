package number;

// https://leetcode.com/problems/palindrome-number/

// tags: easy, math

/*
* Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Example 4:

Input: x = -101
Output: false
*/
class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        int reverse = 0, copy = x;

        while(copy > 0){
            int digit = copy % 10;
            reverse = reverse * 10 + digit;
            copy = copy/10;
        }
        return reverse == x;
    }
}


class PalindromeNumberUsingTwoPointer {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        String num = String.valueOf(x);
        int left = 0, right = num.length()-1;

        while(left <= right){
            if(num.charAt(left++) != num.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}