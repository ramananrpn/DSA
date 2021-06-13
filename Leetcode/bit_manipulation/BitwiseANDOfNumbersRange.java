package bit_manipulation;
// https://leetcode.com/problems/bitwise-and-of-numbers-range/
// solution : https://gist.github.com/ramananrpn/69e2f91fcf85274e134af7f0f30976eb

// tags: adobe, amazon, easy, brian-kernighans-algorithm, bit_shift

/*
* Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0

Constraints:
0 <= left <= right <= 231 - 1
*/

// ---------------- BIT SHIFT ------------------

 class BitwiseANDOfNumbersRangeUsingBitShift {
     public int rangeBitwiseAnd(int left, int right) {
         // hint:
         // find the common prefix of binary for given range and that will will be result
         // for that right shifting the range values by 1 every time until left >= range
         // the bit of shitft count 2^shift is the ans
         int shift = 0;
         // find the common 1-bits
         while (left < right) {
           left >>= 1;
           right >>= 1;
           ++shift;
         }
         return left << shift;
     }
 }

// ---------------- Brian Kernighan's Algorithm ------------------
// https://www.techiedelight.com/brian-kernighans-algorithm-count-set-bits-integer/

class BitwiseANDOfNumbersRangeUsingBrianKernighanAlgorithm {
    public int rangeBitwiseAnd(int left, int right) {

        while (left < right) {
            // turning off right most bit
            right = right & (right-1);
        }

        return left & right;
    }
}


