package string;

// https://leetcode.com/problems/integer-to-english-words/description/
// https://leetcode.ca/2016-08-29-273-Integer-to-English-Words/

/*
Convert a non-negative integer num to its English words representation.



Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"


Constraints:

0 <= num <= 231 - 1
 */

// TAGS: hard, math, string, consider_interview_medium

public class IntegerToEnglishWords {
    private static final String[] BELOW_20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] BELOW_100 = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };


    private static final String[] THOUSANDS = {
            "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if(num == 0) return "Zero";


        int index = 0;
        StringBuilder result = new StringBuilder();

        while (num > 0) {
            if(num % 1000 != 0) {
                result.insert(0, helper(num % 1000) + " " + THOUSANDS[index] + " ");
            }

            num = num / 1000;
            index++;
        }

        return result.toString().trim();
    }

    private String helper(int num) {
        if (num < 20 ) {
            return BELOW_20[num];
        } else if (num < 100) {
            return (BELOW_100[num / 10] + " " + helper(num % 10)).trim();
        } else {
            return (BELOW_20[num / 100] + " Hundred " + helper(num % 100)).trim();
        }
    }
}
