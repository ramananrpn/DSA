package linkedlist;

// https://leetcode.com/problems/palindrome-linked-list/

// TAGS : easy

/*
* Given the head of a singly linked list, return true if it is a palindrome.

Example 1:

Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false


Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
* */
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

// Time complexity   - O(n)
// Space Complexity  - O(n)

 class Recursive {
     ListNode cur = null;
     public boolean isPalindrome(ListNode head) {
         // initialising for first time
         if(cur == null){
             cur = head;
         }

         if(head == null){
             return true;
         }

         if(isPalindrome(head.next)){
             if(head.val == cur.val){
                 cur = cur.next;
                 return true;
             }
         }

         return false;
     }
 }

// ------------------------------- //

// Time complexity   - O(n)
// Space Complexity  - O(1)
class TwoPointer {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

//         slow will point to mid of linkedList
        while( fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;
        ListNode cur = slow;

//         Reversing the second half
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        ListNode p1 = head;
        ListNode p2 = prev;

//         comparing first half and second half
        while(p1!=null && p2!=null){
            if(p1.val!=p2.val) return false;

            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}

