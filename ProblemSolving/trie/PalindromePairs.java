package trie;

// https://leetcode.com/problems/palindrome-pairs/description/

/*
You are given a 0-indexed array of unique strings words.

A palindrome pair is a pair of integers (i, j) such that:

0 <= i, j < words.length,
i != j, and
words[i] + words[j] (the concatenation of the two strings) is a
palindrome
.
Return an array of all the palindrome pairs of words.

You must write an algorithm with O(sum of words[i].length) runtime complexity.

Example 1:

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]
Example 2:

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
Example 3:

Input: words = ["a",""]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["a","a"]
*/

// TAGS: trie, array, string, hash_map, consider_interview_hard

/*
Input : ["abcd","dcba","lls","s","sssll"]
Output : [[1,0],[0,1],[3,2],[2,4]]

Input : ["bat","tab","cat"]
Output : [[1,0],[0,1]]

["a",""]
[[1,0],[0,1]]

["a","b","c","ab","ac","aa"]
[[1,3],[3,0],[2,4],[4,0],[0,5],[5,0]]

["asa","", "bab"]
[[1,0],[0,1],[1,2],[2,1]]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// WIthout TRIE Using HASHING 
public class PalindromePairs {
  public List<List<Integer>> palindromePairs(String[] words) {
    Map<String , Integer> map = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();

    for(int i = 0 ; i < words.length ; i++) {
      map.put(words[i], i);
    }

    for (int i = 0 ; i < words.length ; i++) {
      if(map.containsKey("") && isPalindrome(words[i]) && map.get("") != i) {
        result.add(Arrays.asList(map.get(""), i));
        result.add(Arrays.asList(i, map.get("")));
      }

      for(int j = 0 ; j < words[i].length() ; j++) {
        String s1 = words[i].substring(0, j);
        String s2 = words[i].substring(j);

        if(isPalindrome(s1)) {
          String reverse = new StringBuilder(s2).reverse().toString();
          if(map.containsKey(reverse) && map.get(reverse) != i) {
            result.add(Arrays.asList(map.get(reverse), i));
          }
        }

        if(s1 != "" && isPalindrome(s2)) {
          String reverse = new StringBuilder(s1).reverse().toString();
          if(map.containsKey(reverse) && map.get(reverse) != i) {
            result.add(Arrays.asList(i, map.get(reverse)));
          }
        }
      }
    }
    return result;
  }

  private boolean isPalindrome(String s) {
    for(int i = 0 , j = s.length()-1; i<=j ; i++, j--) {
      if(s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

}

// ---------------
