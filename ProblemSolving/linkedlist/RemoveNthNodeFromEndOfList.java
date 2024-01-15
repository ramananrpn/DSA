package linkedlist;

/* https://leetcode.com/problems/remove-nth-node-from-end-of-list/ */

// TAGS : medium

/*
* Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?
Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
*
* */

// Definition for singly-linked list.
class ListNode {
  int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// O(L)

class OnePass {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i = 0; i <= n ; i++){
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}

// ----------------------------------------------------------------------- //

// O(2L)
 class TwoPass {
     public ListNode removeNthFromEnd(ListNode head, int n) {

         ListNode cur = head;
         int len = 0;
         while(cur!=null){
             len++;
             cur=cur.next;
         }
         n = len - n;
         if(n--==0){
             return head.next;
         }
         ListNode prev = head;
         cur = head.next;
         while(cur!=null){
             if(n--==0){
                 prev.next = cur.next;
                 break;
             }
             prev = cur;
             cur=cur.next;
         }
         return head;
     }
 }
