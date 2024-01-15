package linkedlist;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// tags: easy, goldman_sachs, qualcomm

/*
* Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
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

// own code
 class RemoveDuplicatesFromSortedList {

     public ListNode deleteDuplicates(ListNode head) {
         if(head == null) {
             return head;
         }

         int val = head.val;
         ListNode cur = head.next;
         ListNode prev = head;

         while(cur!=null) {
             if(cur.val == val) {
                 prev.next = cur.next;
             }else{
                 prev = cur;
             }

             // System.out.println(val);
             val = cur.val;
             cur = cur.next;
         }

         return head;
     }
 }


//
//class RemoveDuplicatesFromSortedList {
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode current = head;
//        while (current != null && current.next != null) {
//            if (current.next.val == current.val) {
//                current.next = current.next.next;
//            } else {
//                current = current.next;
//            }
//        }
//        return head;
//    }
//}
