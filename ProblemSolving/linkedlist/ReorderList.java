package linkedlist;

/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.



Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

 */

// https://leetcode.com/problems/reorder-list/description/
// tags: medium, multi_pattern

/*
Patterns used
Linked List
├── Fast & Slow Pointer
├── Reverse Linked List
└── Merge Two Lists
 */
public class ReorderList {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null &&
                fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;

        while (second != null) {

            ListNode next = second.next;

            second.next = prev;

            prev = second;

            second = next;
        }

        second = prev;

        // Step 3: Merge
        ListNode first = head;

        while (second != null) {

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
