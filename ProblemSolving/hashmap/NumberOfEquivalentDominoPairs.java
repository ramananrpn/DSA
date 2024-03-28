package hashmap;

import java.util.HashMap;

// https://leetcode.com/problems/number-of-equivalent-domino-pairs/
/*
* Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
Example 2:

Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
Output: 3

Constraints:

1 <= dominoes.length <= 4 * 104
dominoes[i].length == 2
1 <= dominoes[i][j] <= 9
* */

// Tags : hashmap, easy


// OWN SOLUTION
public class NumberOfEquivalentDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
         if(dominoes == null || dominoes.length == 0) return 0;

         int count = 0;
         HashMap<String, Integer> map = new HashMap<>();

         for(int i = 0 ; i < dominoes.length ; i++) {
             String eq = "" + dominoes[i][0] + dominoes[i][1];

             count += map.getOrDefault(eq, 0);
             map.put(eq, map.getOrDefault(eq, 0) + 1);

             String rev = "" + dominoes[i][1] + dominoes[i][0];
             if(!rev.equals(eq)) {
                  map.put(rev, map.getOrDefault(rev, 0) + 1);
             }
         }
         return count;
    }
}


// ------------------------- Optimal ----------------------

class NumberOfEquivalentDominoPairsOptimised {
    public int numEquivDominoPairs(int[][] dominoes) {
        if(dominoes == null || dominoes.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

            for (int[] arr : dominoes) {
            // constructing unique by comparing values like using always greater value as *10
            int key = arr[0] < arr[1] ?  (arr[1]*10) + arr[0] :  (arr[0]*10) + arr[1];

            // add count
            count += map.getOrDefault(key, 0);

            // put in map
            map.put(key, map.getOrDefault(key, 0) + 1);

        }

        return count;
    }
}

