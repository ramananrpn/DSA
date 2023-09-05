package string;

// https://leetcode.com/problems/length-of-last-word/

/*
* Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.
Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
* */

// TAGS : easy
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] str = s.toCharArray();
        int count = 0;

        for(int i = str.length - 1 ; i>=0 ; i --) {
            if(str[i] == ' ') {
                if(count > 0) {
                    break;
                }
                continue;
            }
            count++;
        }
        return count;
    }
}

//--------------------------------------------------------

// own solution
class LengthOfLastWordWithWhile {
    public int lengthOfLastWord(String s) {
        int len = s.length()-1;

        int count = 0;

        char[] ch = s.toCharArray();

        while(len >= 0 && ch[len] == ' '){
            len--;
        }

        while(len>= 0 && ch[len] != ' ') {
            len--;
            count++;
        }

        return count;
    }
}