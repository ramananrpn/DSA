package trie;

/* https://leetcode.com/problems/prefix-and-suffix-search/ */

/*
Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.

Implement the WordFilter class:

WordFilter(string[] words) Initializes the object with the words in the dictionary.
f(string prefix, string suffix) Returns the index of the word in the dictionary, which has the prefix prefix and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.

Example 1:

Input
["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
Output
[null, 0]

Explanation
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".

Constraints:

1 <= words.length <= 15000
1 <= words[i].length <= 10
1 <= prefix.length, suffix.length <= 10

* */
class WordFilter {
    TrieNode root;

    class TrieNode{
        int index;
        TrieNode[] child = new TrieNode[27]; // 27 as we insert additional character '{' - 123 (char after 'z')

        public void insert(String words, int index){
            TrieNode runner = root;
            for(Character ch : words.toCharArray()){
                if(runner.child[ch - 'a'] == null){
                    runner.child[ch - 'a'] = new TrieNode();
                }
                runner = runner.child[ch-'a'];
                runner.index = index;
            }
        }

        public int find(String query){
            TrieNode runner = root;
            for(Character ch : query.toCharArray()) {
                if(runner.child[ch - 'a'] == null){
                    return -1;
                }
                runner = runner.child[ch - 'a'];
            }
            return runner.index;
        }
    }

    public WordFilter(String[] words) {
        root = buildTrieTree(words);
    }

    public int f(String prefix, String suffix) {
        String query = suffix + "{" + prefix;
        return root.find(query);
    }

    private TrieNode buildTrieTree(String[] words){
        root = new TrieNode();
        // apple -> apple{apple, pple{apple, ple{apple, le{apple, e{apple,{apple
        for(int i = 0 ; i < words.length ; i++){
            for(int j = 0 ; j<words[0].length(); j++){
                root.insert(words[i].substring(j, words[i].length()) + '{' + words[i], i);
            }
        }
        return root;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */


