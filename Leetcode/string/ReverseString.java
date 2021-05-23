package string;

// https://leetcode.com/problems/reverse-string/

// TAGS : easy, two_pointers

/*
* Write a function that reverses a string. The input string is given as an array of characters s.

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.
* */

class ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length -1;

        while(left < right){
            if(s[left] != s[right]){
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
            }
            left++;
            right--;
        }
    }
}

/* --------------- */

// same time-ccomplexity

// class ReverseString {
//    public void reverseString(char[] s) {
//        int length = s.length;
//        for(int i = 0; i < length / 2; i++) {
//            char head = s[i];
//            char tail = s[length - 1 - i];
//            if(head == tail) continue;
//            else {
//                s[i] = tail;
//                s[length - 1 - i] = head;
//            }
//        }
//    }
//}

/* ------------- */

// same time-complexity
//https://leetcode.com/problems/reverse-string/discuss/670472/Simplest-2-line-Java-solution

class ReverseStringUsingXOR {
    public void reverseString(char[] s) {
        for (int i = 0, len = s.length, end = len - 1; i < len / 2; i++)
            s[i] ^= (char) (s[end-i] ^ (s[end-i] = s[i]));
    }
}


