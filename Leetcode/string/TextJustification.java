package string;

// https://leetcode.com/problems/text-justification/
// Tags: hard, google++, linkedin, twilio, reddit, amazon, facebook, microsoft, intuit++, apple, netflix

/*
* Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

* Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

* Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.

* Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
* */

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int wordRunner = 0;

        while(wordRunner < words.length) {
            String currentLine = words[wordRunner] + " ";
            int charCount = currentLine.length();
            int wordCount = words[wordRunner].length();
            wordRunner++;

            // appending elements to line
            while(wordRunner < words.length && (charCount + words[wordRunner].length() <= maxWidth)){
                currentLine += words[wordRunner] + " ";

                wordCount += words[wordRunner].length();
                charCount = currentLine.length();

                wordRunner++;
            }

            // removing last add extra space
            currentLine = currentLine.substring(0, charCount-1);


            // checking is not last line
            // all elements will be added if it's a last line, so wordRunner would be >= words length
            if(wordRunner < words.length) {
                currentLine = addSpaces(currentLine, maxWidth, wordCount, false);
            } else {
                currentLine = addSpaces(currentLine, maxWidth, wordCount, true);
            }

            // adding to result
            result.add(currentLine);
        }

        return result;
    }

    private String addSpaces(String currentLine, int maxWidth, int wordCount, boolean isLastLine) {
        if(isLastLine) {
            int emptySlots = maxWidth - currentLine.length();

            while(emptySlots != 0) {
                currentLine += " ";
                emptySlots--;
            }
        }
        else{
            // splitting words in current line
            String[] words = currentLine.split(" ");

            int wordsCount = words.length;

            if(wordsCount == 1) {
                return addSpaces(currentLine, maxWidth, wordCount, true);
            }

            // space remaining
            int remainingSpace = maxWidth - wordCount;

            // no space needed for last element, so -1 [aa bb cc]
            int wordsCountForDividingSpace = wordsCount - 1;


            // finding extra spaces to be added
            int extraSpaceForEachWord = remainingSpace / (wordsCountForDividingSpace);
            int unevenAdditionalSpace = remainingSpace % (wordsCountForDividingSpace);

            // refreshing currentLine
            currentLine = "";


            // adding words with needed extraspaces to currentline
            int wordIndex = wordsCount;
            for(String word : words) {
                int extraSpace = extraSpaceForEachWord;
                currentLine += word;

                // if last word, so spaces needed
                if(wordIndex == 1) {
                    break;
                }

                // adding spaces
                while(extraSpace !=0 ) {
                    currentLine += " ";
                    extraSpace--;
                }

                // adding remaining uneven spaces from left (from first word)
                if(unevenAdditionalSpace != 0) {
                    currentLine += " ";
                    unevenAdditionalSpace--;
                }

                wordIndex--;
            }
        }

        return currentLine;
    }
}
