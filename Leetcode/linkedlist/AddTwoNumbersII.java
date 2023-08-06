package linkedlist;

import java.util.Stack;
// 445. Add Two Numbers II
/*
ou are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.


Example 1:
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/

/*
https://leetcode.com/problems/add-two-numbers-ii/description/

Tags: linked_list, medium, stack
*/

//----------------------- Reversing the linked list---------------------------------------
class AddTwoNumbersIIUsingReversing {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        ListNode result = null;
        while(l1!=null || l2 != null || carry != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;

            // 7(sum)(newNode) -> null (result)
            // 7 (<result>) -> null
            // 0(sum)(newNode) -> 7 -> null (result)
            ListNode newNode = new ListNode(sum);
            newNode.next = result;
            result = newNode;

            // move l1 and l2
            if(l1!=null) {
                l1 = l1.next;
            }
            if(l2!=null) {
                l2 = l2.next;
            }
        }

        return result;
    }


    // reverse the list
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        //null    7   ->   2   -> 4 -> 3 -> null
        //prev   cur      temp

        //       7->prev(null)  ->   2       ->    4    -> 3 -> null
        //         cur <> prev    temp<>cur       temp

        //       7->(null)  ->    2-> prev(7->null)   ->    4        ->   3 -> null
        //                        cur <> prev             temp<>cur       temp

        //       2-> 7->null   ->    4->2->7->null        ->   3          -> null
        //                            cur <> prev             temp<>cur       temp

        // finally 3 -> 4 -> 2 -> 7 -> null
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}

//-----------------------Using Stack----------------------------------------------

// Using
class AddTwoNumbersIIUsingStack {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode result = null;
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int val1 = !s1.isEmpty() ? s1.pop() : 0;
            int val2 = !s2.isEmpty() ? s2.pop() : 0;

            int sum = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;

            ListNode newNode = new ListNode(sum);
            newNode.next = result;
            result = newNode;
        }

        return result;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
