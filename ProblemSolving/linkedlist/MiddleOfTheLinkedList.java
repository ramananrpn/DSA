package linkedlist;

// https://leetcode.com/problems/middle-of-the-linked-list/

/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
*/


//TAGS: easy, linked_list, two_pointers

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

class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slowRunner = head;
        ListNode fastRunner = head;

        while(fastRunner != null && fastRunner.next!=null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        return slowRunner;
    }
}

/* --------------------- */


// OWN CODE
//public class MiddleOfTheLinkedList {
//    public ListNode middleNode(ListNode head) {
//         ListNode slowRunner = head;
//         ListNode fastRunner = head;
//
//         ListNode result = null;
//
//         while(fastRunner != null) {
//             if (fastRunner.next == null) {
//                 result =  slowRunner;
//                 break;
//             }
//
//             if(fastRunner.next.next == null) {
//                 result =  slowRunner.next;
//                 break;
//             }
//
//             fastRunner = fastRunner.next.next;
//             slowRunner = slowRunner.next;
//         }
//
//         return result;
//     }
//}
