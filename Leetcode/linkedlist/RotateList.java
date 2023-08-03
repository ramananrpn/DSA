package linkedlist;

/*
https://leetcode.com/problems/rotate-list/description/

Given the head of a linked list, rotate the list to the right by k places.
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]

// TAGS : linked_list, Adobe, Amazon, Hulu, LinkedIn, Microsoft
*/
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null){
            return head;
        }

        // finding the length
        int len = 0;

        for(ListNode cur = head; cur != null ; cur = cur.next) {
            len++;
        }

        // 2 % 5 = 2 | 5 % 2 = 1
        // finding k because with slow and fast pointer
        // fast to move till k initially
        // then move slow and fast till fast reaches last node
        // so that there will be k diference btw slow and fast
        // and slow.next have to be head fast.next should point to inital head
        k = k % len;

        ListNode slow = head, fast = head;

        // moving fast e till k initially
        while(k-- > 0) {
            fast = fast.next;
        }

        // moving slow and fast till fast reaches last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // now consider with eg: 1 -> 2 -> 3 -> 4 -> 5 -> null
        // fast will be at 5 and slow will be at 3. (there will be k diference)
        // slow.next should be head after rotating
        // fast.next have to be merged with initail head
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
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
