package permutation_combination.foundation;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/
// tags: medium, amazon, apple, combination

// COMBINATION FORMULA : n! / (r!(n -r)!)

/*
* Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.
Example 1:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Example 2:
Input: n = 1, k = 1
Output: [[1]]
* */
// --------------   BACKTRACKING --------------------
// prefered
 class CombinationsUsingBacktracking {
   List<List<Integer>> output = new ArrayList();
   int n;
   int k;

     public List<List<Integer>> combine(int n, int k) {
     this.n = n;
     this.k = k;
     backtrack(1, new ArrayList<Integer>());
     return output;
   }

   public void backtrack(int first, ArrayList<Integer> curr) {
     // if the combination is done
     if (curr.size() == k) {
       output.add(new ArrayList<>(curr));
         return;
     }

     for (int i = first; i <= n ; ++i) {
       // add i into the current combination
       curr.add(i);

       // use next integers to complete the combination
       backtrack(i + 1, curr);

       // backtrack
       curr.remove(curr.size()-1);
     }
   }
 }



// ----------------------- Inclusion and Exclusion ------------------------

// https://medium.com/enjoy-algorithm/find-all-possible-combinations-of-k-numbers-from-1-to-n-88f8e3fad33c
// https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
class CombinationsUsingInclusionAndExclusion {
    List<List<Integer>> output = new ArrayList();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        includeAndExclude(1, new ArrayList<Integer>());
        return output;
    }

    private void includeAndExclude(int num, ArrayList<Integer> list) {
        if(list.size() == k){
            output.add(new ArrayList<>(list));
            return;
        }

        if(num > n ) {
            return;
        }

        // exclude current element
        includeAndExclude(num + 1, list);

        // include current element
        list.add(num);
        includeAndExclude(num + 1, list);

        // removing last added element
        list.remove(list.size()-1);
    }
}
