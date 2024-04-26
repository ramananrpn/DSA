package linkedlist;

// https://leetcode.com/problems/merge-two-sorted-lists/

/*
* ou are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*
*
* TAGS : easy



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
* */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head = null;
        ListNode cur = head;
        while(list1 != null && list2!=null) {
            ListNode node;
            if(list1.val <= list2.val) {
                node = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                node = new ListNode(list2.val);
                list2 = list2.next;
            }

            if(head == null) {
                head = node;
                cur = head;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        if(list1 != null) {
            cur.next = list1;
        }
        if(list2 != null) {
            cur.next = list2;
        }

        return head;

//        /*
//        ListNode head = new ListNode(-1);
//        ListNode cur = head;
//        while(list1 != null && list2 != null) {
//            if(list1.val <= list2.val) {
//                cur.next = list1;
//                list1 = list1.next;
//            } else {
//                cur.next = list2;
//                list2 = list2.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = (list1 != null) ? list1 : list2;
//
//        return head.next;
//        */
    }
}
