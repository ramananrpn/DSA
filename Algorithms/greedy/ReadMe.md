🧠 What is a Greedy Algorithm?

A Greedy Algorithm is an approach where you:

Make the best choice at each step, without worrying about the future.

	•	“Best choice” = the one that seems best at the moment.
	•	After making that choice, you never look back.

Think of it as short-sighted optimization: you take what looks optimal now, hoping it leads to the global optimal solution.

⸻

🔑 Key Idea
1.	Solve a problem step by step.
2.	At each step, choose the option that looks best right now (locally optimal).
3.	Repeat until you solve the problem.
4.	Hope or prove that local choices lead to a global optimum.

⸻

🏃 Example 1: Coin Change (Simple Version)
•	Suppose you have coins: [25, 10, 5, 1] cents
•	You want to make 41 cents with minimum coins

Greedy approach:
1.	Take the largest coin ≤ remaining amount
2.	Subtract it from the total
3.	Repeat

Step by step:
Amount = 41
Take 25 → remaining = 16
Take 10 → remaining = 6
Take 5 → remaining = 1
Take 1 → remaining = 0
Coins used = [25, 10, 5, 1] → 4 coins

✅ Works perfectly for US coins.

Notice: At each step we chose the largest coin possible — that’s greedy.

⸻

⚠️ When Greedy Fails

Greedy does not always guarantee optimal. Example:
•	Coins: [9, 6, 1], target = 11
•	Greedy: take 9 → remaining = 2 → take two 1s → 3 coins
•	But optimal = 6 + 5*1? Actually check → yes, greedy may fail sometimes.
•	Greedy works only for problems with “Greedy Choice Property”.

💡 Easy Way to Remember

Greedy = “Take what looks best NOW”
•	Don’t overthink the future
•	Don’t backtrack


🏆 Characteristics of Greedy Algorithms
1.	Greedy Choice Property
•	Choosing locally optimal steps leads to global optimum.
2.	Optimal Substructure
•	Solution of problem can be constructed from solutions of smaller subproblems.

🏁 Common Greedy Problems
•	Activity Selection → schedule max non-overlapping activities
•	Huffman Coding → compress data optimally
•	Minimum Spanning Tree → Kruskal’s or Prim’s algorithm
•	Fractional Knapsack → take items partially to maximize value

⸻

💡 Greedy vs Dynamic Programming

| Feature | Greedy | Dynamic Programming (DP) |
|---------|--------|--------------------------|
| **Approach** | Take the **best choice at the current step** (locally optimal) | Solve **all subproblems** and combine their results (considers past/future) |
| **Backtracking** | Usually **none** | Often required (depends on problem) |
| **Optimality** | Only works if the problem has **Greedy Choice Property** | Guaranteed if problem has **Optimal Substructure** |
| **Speed** | Usually faster, simpler | Usually slower, more complex |
| **Memory** | Low, minimal data structures | High, stores subproblem solutions (memoization or DP table) |
| **Problem Examples** | Coin Change (US coins), Activity Selection, Fractional Knapsack | Longest Palindromic Subsequence, 0/1 Knapsack, Matrix Chain Multiplication |
| **Decision Strategy** | “What looks best right now?” | “What combination of previous choices gives the best overall solution?” |

---

### Key Notes:

1. **Greedy** = Short-sighted, simple, fast. Works only if the local best choice leads to global best.
2. **DP** = Considers all possibilities, stores results, guarantees optimal solution.
3. Some problems **can be solved by both**, but greedy is simpler if the greedy property exists.