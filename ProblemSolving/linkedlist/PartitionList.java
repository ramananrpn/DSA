package linkedlist;

// https://leetcode.com/problems/partition-list/description/

/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]

Constraints:

The number of nodes in the list is in the range [0, 200].
* */

// tags: medium, linked_list, consider_interview_medium

class PartitionList {
  public ListNode partition(ListNode head, int x) {
    // Initialize two dummy nodes
    ListNode before = new ListNode(0);
    ListNode after = new ListNode(0);

    // Pointers for traversing and building the two lists
    ListNode beforeHead = before;
    ListNode afterHead = after;

    // Traverse the original list
    while (head != null) {
      if (head.val < x) {
        before.next = head;  // Add node to the 'before' list
        before = before.next;
      } else {
        after.next = head;  // Add node to the 'after' list
        after = after.next;
      }
      head = head.next;
    }

    // Connect the 'before' list with the 'after' list
    after.next = null;       // End the 'after' list
    before.next = afterHead.next;  // Link end of 'before' list to start of 'after' list

    return beforeHead.next;  // Return the head of the new list
  }
}

