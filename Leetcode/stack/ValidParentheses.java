package stack;

// https://leetcode.com/problems/valid-parentheses/
// tags: easy, google, intuit, paypal, linkedin++, apple, intuit, microsoft , facebook, cisco, amazon

/*
* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([)]"
Output: false

Example 5:
Input: s = "{[]}"
Output: true
*/

import java.util.HashMap;
import java.util.Stack;


// own code
class ValidParenthesesUsingStack {
     public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();

         for(char ch : s.toCharArray()) {
             if(ch == '(' || ch == '[' || ch == '{'){
                 stack.push(ch);
             }
             else {
                 if(stack.isEmpty()){
                     return false;
                 }

                 switch(ch) {
                     case ')' : {
                         if(stack.pop() != '('){
                             return false;
                         }
                         break;
                     }
                     case ']' : {
                         if(stack.pop() != '['){
                             return false;
                         }
                         break;
                     }
                     case '}' : {
                         if(stack.pop() != '{'){
                             return false;
                         }
                         break;
                     }
                 }
             }
         }

         return stack.isEmpty() ? true : false;
     }
 }

 // --------------------------------------------------------------------------

class ValidParenthesesUsingMapAndStack {

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public ValidParenthesesUsingMapAndStack() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}