package math;

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.



Example 1:

Input: nums = [3,0,1]

Output: 2

Explanation:

n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]

Output: 2

Explanation:

n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]

Output: 8

Explanation:

n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

 */




/*
Since numbers are from 0 → n and exactly one is missing:

Expected sum:
0 + 1 + 2 + ... + n = n(n+1)/2

missing = expected - actual

 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int expected = n * (n + 1) / 2;

        int actual = 0;

        for (int num : nums) {
            actual += num;
        }

        return expected - actual;
    }
}


// ------- BIT Manipulation ----
/*
Same → 0
Different → 1


A B A^B
0 0  0
0 1  1
1 0  1
1 1  0

-------
5 = 101
3 = 011

101
011
---
110 - 6
 */

// Solution

class MissingNumberWithXOR {
    /*
    Expected: 0 1 2 3
    Actual  : 3 0 1

    XOR all:
    0^1^2^3^3^0^1

    Cancel:
    0^0
    1^1
    3^3

    Left:
    2
    */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        // include all expected numbers using index
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        // cancel present numbers , so only missing nu,ber remains
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}
