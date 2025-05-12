# **XOR**
### You can swap the values in two variables without using the temp variable (The conventional way of swapping)

XOR (Exclusive OR) - Explanation:
XOR (Exclusive OR) is a bitwise operation that compares corresponding bits of two numbers and returns 1 if the bits are different, and 0 if the bits are the same.

Here’s how the XOR operation works at the bit level:

1 XOR 1 = 0: When both bits are the same (1 and 1), the result is 0.

0 XOR 0 = 0: When both bits are the same (0 and 0), the result is 0.

1 XOR 0 = 1: When the bits are different (1 and 0), the result is 1.

0 XOR 1 = 1: When the bits are different (0 and 1), the result is 1.

Both methodology has 3 LOC but we aren't initializing an extra thereafter unused variable.

Conventional way:

int temp = x;

x = y;

y = temp;

but using XOR operator it is as simple as

x = x^y;

y = x^y;

x = x^y;

XOR (^) Operator
Returns 1 only when the bits are different.
Think: “Is exactly one switch ON?”

🧠 Truth Table:
A	B	A ^ B
0	0	0
0	1	1
1	0	1
1	1	0

🔧 Example:
A = 5 = 0101
B = 3 = 0011
A ^ B =     0110 → 6

 # ------------------------------ #