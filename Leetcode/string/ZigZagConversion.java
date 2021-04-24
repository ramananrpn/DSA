package string;

/* https://leetcode.com/problems/zigzag-conversion/ */

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */


class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        String display = "";
        int incrementor = 2 * numRows -2; // value to reach elements in row 0

        for(int row = 0 ; row < numRows ; row++) {
            for(int pointor = row ; pointor < s.length() ; pointor = pointor + incrementor) {
                display += s.charAt(pointor);
                // Adding elements for mid row in zag
                if (row!= 0 && row!= numRows-1 && pointor + incrementor - (row*2) < s.length()){
                    display += s.charAt(pointor + incrementor - (row*2));
                }
            }
        }
        return display;
    }
}

// TIME- COMPLEXITY - O(n), n = len(s) Each index is visited once.