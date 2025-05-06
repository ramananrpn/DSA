package bit_manipulation.xor;

// https://leetcode.com/problems/single-number/
// tags: easy, xor


public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result ^= num;
        }

        return result;
    }
}

// Let’s do it step by step:
//
//XOR with 4:
//result = 0 ^ 4 = 4
//Now, result = 4
//
//XOR with 1:
//result = 4 ^ 1 = 5
//Now, result = 5
//
//XOR with 2:
//result = 5 ^ 2 = 7
//Now, result = 7
//
//XOR with 1:
//result = 7 ^ 1 = 6
//Now, result = 6
//
//XOR with 2:
//result = 6 ^ 2 = 4
//Now, result = 4

