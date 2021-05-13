package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* https://leetcode.com/problems/letter-combinations-of-a-phone-number/ */

/* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']. */

// BFS
// USING QUEUE
 class BFS {
     public List<String> letterCombinations(String digits) {
         List<String> result = new ArrayList<>();

         if(digits.length() == 0){
             return result;
         }

         String[] numPad = { "", "", "abc",  "def", "ghi",
                 "jkl", "mno", "pqrs", "tuv", "wxyz" };

          Queue<String> queue = new LinkedList<>();
          queue.add("");

          while(!queue.isEmpty()){
              String s = queue.poll();

              if(s.length() == digits.length()) {
                  result.add(s);
              }
              else{
                  String numLetters = numPad[digits.charAt(s.length()) - '0'];
                  for(int i = 0 ; i < numLetters.length() ; i++){
                      queue.add(s + numLetters.charAt(i));
                  }
              }
          }
         return result;
     }
 }

/* -------------------------------------------------------------- */

 // DFS
// RECURSIVE
 class DFS {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0){
            return result;
        }

        String[] numPad = { "", "", "abc",  "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz" };


        findCombination(numPad, digits, 0, "", result);

        return result;
    }

    private void findCombination(String[] numPad, String digits, int index, String val, List<String> result){
        if(index == digits.length()){
            result.add(val);
            return;
        }

        String numLetters = numPad[digits.charAt(index) - '0'];

        for(int i = 0 ; i < numLetters.length(); i++){
            val = val + numLetters.charAt(i);
            findCombination(numPad, digits, index+1, val, result);
            val = val.substring(0, val.length()-1);
        }
    }
}
