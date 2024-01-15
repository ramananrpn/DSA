package linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/sort-list/

// TAGS : medium, merge_sort, facebook, adobe

/*
* Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:

Input: head = []
Output: []
*/

// MERGE SORT
// 10ms
class SortListUsingRecursiveMergeSort {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;

        first = sortList(first);
        second = sortList(second);

        return merge(first, second);

    }

    private ListNode merge(ListNode n1, ListNode n2){
        if(n1 == null) return n2;
        if(n2 == null) return n1;
        ListNode result = null;

        if(n1.val > n2.val){
            result = n2;
            result.next = merge(n1, n2.next);
        }
        else{
            result = n1;
            result.next = merge(n1.next, n2);
        }


        return result;
    }
}

/* ------------------------------------------------------------------  */

// MERGE SORT
// More Fast 9ms
class SortListUsingRecursiveMergeSortFast {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;

        first = sortList(first);
        second = sortList(second);

        return merge(first, second);
    }

    private ListNode merge(ListNode n1, ListNode n2){
        if(n1 == null) return n2;
        if(n2 == null) return n1;
        ListNode result = null;

        if(n1.val > n2.val){
            result = n2;
            result.next = mergeLists(n1, n2.next);
        }
        else{
            result = n1;
            result.next = mergeLists(n1.next, n2);
        }


        return result;
    }

    private ListNode mergeLists(ListNode head1, ListNode head2)
    {
        ListNode newHead=null;
        ListNode tail=null;

        while(head1!=null || head2!=null)
        {
            if(head1!=null && (head2==null || head1.val<head2.val))
            {
                if(newHead==null)
                {
                    newHead=head1;
                    tail=head1;
                    head1=head1.next;
                    tail.next=null;
                }
                else
                {
                    tail.next=head1;
                    tail=head1;
                    head1=head1.next;
                    tail.next=null;
                }
            }

            else
            {
                if(newHead==null)
                {
                    newHead=head2;
                    tail=head2;
                    head2=head2.next;
                    tail.next=null;
                }
                else
                {
                    tail.next=head2;
                    tail=head2;
                    head2=head2.next;
                    tail.next=null;
                }
            }
        }

        return newHead;
    }
}

/* ----------------------------------------------------- */

class SortListBruteForce {
    public ListNode sortList(ListNode head) {
        List<Integer> array = new ArrayList<Integer>();
        ListNode cur = head;

        while(cur!=null) {
            array.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(array);

        cur = head;

        for(Integer n : array){
            cur.val = n;
            cur = cur.next;
        }
        return head;
    }
}
