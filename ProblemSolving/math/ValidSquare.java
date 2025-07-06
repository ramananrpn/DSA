package math;

// https://leetcode.com/problems/valid-square/description/
/*
Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.

The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.

A valid square has four equal sides with positive length and four equal angles (90-degree angles).



Example 1:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: true
Example 2:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
Output: false
Example 3:

Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
Output: true


Constraints:

p1.length == p2.length == p3.length == p4.length == 2
-104 <= xi, yi <= 104
 */

// tags: medium, math, geometry

/*
🔍 First, What is Euclidean Distance?

Given two 2D points A(x1, y1) and B(x2, y2):

👉 The actual distance is:

distance  = √((x2−x1)² + (y2−y1)²)

This is what you learn in school as the distance between two points on a plane.

⸻

🚨 Why NOT use Math.sqrt(...) directly?

Because in many coding problems (like detecting a square), you’re only interested in comparing distances, not the actual length.

⸻

✅ So instead, we use squared distance:

distance  = √((x2−x1)² + (y2−y1)²)
(distance)² = (x2 - x1)² + (y2 - y1)²

You skip the square root — but the relative values stay the same.

💡 Why this is better:

1. Performance:

sqrt() is a relatively expensive mathematical operation.
In competitive programming or large-scale systems, skipping it improves speed.


3. You only care about equality:

In the Valid Square problem, we want:
	•	Are all four sides equal?
	•	Are both diagonals equal?

That’s it.

We don’t need actual lengths — just equal or not equal.

So comparing squared values is enough.

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// O(1)
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] d = new int[]{
                findSquareDistance(p1, p2),
                findSquareDistance(p1, p3),
                findSquareDistance(p1, p4),
                findSquareDistance(p2, p3),
                findSquareDistance(p2, p4),
                findSquareDistance(p3, p4)
        };

        // Count frequency of each distance
        Map<Integer, Integer> freq = new HashMap<>();
        for (int val : d) {
            if (val == 0) return false; // overlapping points — invalid
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }

        // Valid square must have exactly 2 unique distances
        if (freq.size() != 2) return false;

        // One of the distances should appear 4 times (sides), the other 2 times (diagonals)
        return freq.containsValue(4) && freq.containsValue(2);
    }

    private int findSquareDistance(int[] a, int[] b) {

        //  distance  = √((x2−x1)² + (y2−y1)²)
        //  (distance)² = (x2 - x1)² + (y2 - y1)²
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return (dx * dx) + (dy * dy);
    }
}

// Approach 2 with sorting
// O(1)
class ValidSquareWithSorting {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] d = new int[]{
                findSquareDistance(p1, p2),
                findSquareDistance(p1, p3),
                findSquareDistance(p1, p4),
                findSquareDistance(p2, p3),
                findSquareDistance(p2, p4),
                findSquareDistance(p3, p4)
        };

        Arrays.sort(d); // smallest = side, largest = diagonal

        // Check for zero length (overlapping points)
        if (d[0] == 0) return false;

        // Check: 4 equal sides + 2 equal diagonals
        return d[0] == d[1] &&
                d[1] == d[2] &&
                d[2] == d[3] && // 4 sides equal
                d[4] == d[5];   // 2 diagonals equal
    }

    private int findSquareDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}
