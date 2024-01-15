package trie;

/* https://leetcode.com/problems/substring-with-concatenation-of-all-words/ */

/*
* You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.
Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]


Constraints:

1 <= s.length <= 104
s consists of lower-case English letters.
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] consists of lower-case English letters.
*
* */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    int value;
    TrieNode[] children = new TrieNode[26];
}

class WithTrie {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();

        int wordLength = words[0].length();
        TrieNode root = buildTrieTree(words);
        for(int i = 0 ; i <= s.length() - (wordLength*words.length); i++){
            if(isSubString(root, s, i, i+wordLength*words.length)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSubString(TrieNode root, String s, int start, int end) {

        if(start == end)
            return true;

        TrieNode node = root;
        for( ; start < end; start++){
            node = node.children[s.charAt(start) - 'a'];
            if(node == null){
                return false;
            }
            if(node.value > 0) {
                node.value--;
                if(isSubString(root, s, start+1, end)){
                    node.value++;
                    return true;
                }
                node.value++;
            }
        }
        return false;
    }

    private TrieNode buildTrieTree(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode runner = root;
            for(int i = 0 ; i< word.length(); i++){
                if(runner.children[word.charAt(i) - 'a'] == null){
                    runner.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                runner = runner.children[word.charAt(i) - 'a'];
            }
            runner.value++;
        }
        return root;
    }
}

/* -------------------------------------------------------------------------------------------------*/

class WithHashMap {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();

//         Length of a word in words array
        int wordLength = words[0].length();

//         Adding words to hashMap
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        for(String word : words){
            wordsMap.put(word,  wordsMap.getOrDefault(word, 0)+1);
        }
        for(int i = 0 ; i <= s.length() - (wordLength*words.length); i++){
            int part = 0;
            int runner = i;
//             copying the words map to new hashMap
            Map<String, Integer> partMap = new HashMap<String, Integer>();
            partMap.putAll(wordsMap);

            while(++part <= words.length && runner < s.length()) {
                String partWord = s.substring(runner, runner+wordLength);

                if(partMap.containsKey(partWord)){
                    if(partMap.get(partWord) == 1)
                        partMap.remove(partWord);
                    else
                        partMap.put(partWord, partMap.get(partWord) - 1);
                }
                runner += wordLength;
            }
//             checking if new Map is empty which means all provided words are present in select index
            if(partMap.isEmpty()){
                result.add(i);
            }
        }
        return result;
    }
}
