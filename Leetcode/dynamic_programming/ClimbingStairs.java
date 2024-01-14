package dynamic_programming;

/*
* You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

* */

// TAGS : easy, dynamic_programming, fibonacci

/*
https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/
https://leetcode.com/problems/climbing-stairs/description/
https://leetcode.com/problems/climbing-stairs/solutions/2810612/4-ways-to-solve-with-detailed-diagrams-no-memoization-beats-100-time-memory/
https://leetcode.com/problems/climbing-stairs/solutions/3708750/4-method-s-beat-s-100-c-java-python-beginner-friendly/
* */

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if (n == 2) return 2;

        int prev1 = 1;
        int prev = 2;

        for(int i = 3; i<=n ; i++) {
            // avoided temp var
            prev =  prev + prev1;
            prev1 = prev - prev1;
        }
        return prev;
    }
}
