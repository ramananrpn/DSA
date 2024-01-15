package math;

// https://leetcode.com/problems/multiply-strings/
// tags: medium, facebook, apple, amazon, google, karatsuba_algorithm

import java.util.Arrays;

/*Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"


Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
*/
class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // boundary case for zero
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        // Product of two number of length n and m will be atmax of length n+m.
        // Product of digit at idx1 and idx2 will have effect only on idx1 + idx2 + 1(digit idx) and idx1 +                      idx2(remainder).
        // 23 * 15 -> 5 * 3 = 15 -> result[1(num1index) + 1(num2index) + 1] = 5
        //                          result[1(num1index) + 1(num2index)] = 1 (remainder) added for next digtit
        int[] result = new int[m+n];

        // traversing from reverse ass basic multiplication
        for(int i = m - 1 ; i >= 0 ; i--) {

            for(int j = n - 1 ; j >=0 ; j-- ) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // add the previous remainder/carry
                product += result[i+j+1];

                // storing remainder at right place
                result[i+j+1] = product % 10;

                // storing carry (quotient) to previous place for adding
                result[i+j] += product / 10;
            }

            System.out.println(Arrays.toString(result));

        }

        String resultString = "";

        // result may contain prepending zero's
        boolean prependingZero = true;

        for(int value : result) {
            // to avoid prepending zero's skipping those until non-zero val found
            if (value!=0){
                prependingZero = false;
            }

            if (!prependingZero) {
                resultString += value;
            }
        }
        return resultString;
    }
}

// https://www.geeksforgeeks.org/java-program-to-implement-the-karatsuba-multiplication-algorithm/