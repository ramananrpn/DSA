# **XOR**
### You can swap the values in two variables without using the temp variable (The conventional way of swapping)

Both methodology has 3 LOC but we aren't initializing an extra thereafter unused variable.

Conventional way:

int temp = x;

x = y;

y = temp;

but using XOR operator it is as simple as

x = x^y;

y = x^y;

x = x^y;
