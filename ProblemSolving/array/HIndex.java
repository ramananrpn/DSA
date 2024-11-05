package array;

// https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150

/*
* Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.



Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,3,1]
Output: 1
* */

// TAGS: medium, bubble_sort, sorting

class HIndexBubbleSort {
  public int hIndex(int[] citations) {
    int n = citations.length;
    int[] citationCounts = new int[n + 1]; // Array to count papers by citation frequency.

    // Count papers with citation frequency.
    for (int i = 0; i < n; i++) {
      if (citations[i] >= n) {
        citationCounts[n]++; // Any citation >= n falls into this bucket.
      } else {
        citationCounts[citations[i]]++;
      }
    }

    int count = 0;

    // Traverse from high citation count to low to find the h-index.
    for (int i = n; i >= 0; i--) {
      count += citationCounts[i]; // Total papers with at least `i` citations.

      System.out.println(i + " " + count);

      if (count >= i) { // Found the h-index.
        return i;
      }
    }

    return 0; // If no valid h-index is found.
  }
}


// ----------------------------


// O (nlogn) - because of sorting  sorting O(logn)
public class HIndex {
  public int hIndex(int[] citations) {
    int n = citations.length;
    int[] citationCounts = new int[n + 1]; // Array to count papers by citation frequency.

    // Count papers with citation frequency.
    for (int i = 0; i < n; i++) {
      if (citations[i] >= n) {
        citationCounts[n]++; // Any citation >= n falls into this bucket.
      } else {
        citationCounts[citations[i]]++;
      }
    }

    int count = 0;

    // Traverse from high citation count to low to find the h-index.
    for (int i = n; i >= 0; i--) {
      count += citationCounts[i]; // Total papers with at least `i` citations.

      System.out.println(i + " " + count);

      if (count >= i) { // Found the h-index.
        return i;
      }
    }

    return 0; // If no valid h-index is found.
  }
}