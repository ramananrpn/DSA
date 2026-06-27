package string;

// https://leetcode.com/problems/reverse-words-in-a-string-iii/

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
*/

// TAGS : easy, two_pointer


public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        int startIndex = 0;

        char[] str = s.toCharArray();

        // traversing till space and reversing the word using swap
        for (int runner = 0; runner <= str.length; runner++) {
            if(runner == str.length || str[runner] == ' ') {
                int rev = runner - 1;
                while(startIndex < rev) {
                    char temp = str[startIndex];
                    str[startIndex] = str[rev];
                    str[rev] = temp;
                    startIndex++;
                    rev--;
                }
                startIndex = runner + 1;
            }
        }

        return new String(str);
    }
}




// ----------------------------

class ReverseWordsInAStringIIIWithSB {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(new StringBuilder(words[i]).reverse());

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
