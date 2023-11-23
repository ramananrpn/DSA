package doubly_linked_list;

import java.util.HashMap;
import java.util.Map;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.



Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4


Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105

https://leetcode.com/problems/lru-cache/description/

https://www.geeksforgeeks.org/lru-cache-implementation/#lru-cache-implementation-using-doubly-linked-list-and-hashing

TAGS : doubly_linked_list, hashmap, design
* */

// own solution
 class LRUCache {
     class DoublyLinkedList {
         int key;
         int value;
         DoublyLinkedList prev;
         DoublyLinkedList next;

         public DoublyLinkedList(int key, int value) {
             this.key = key;
             this.value = value;
         }
     }
     private int capacity;
     private Map<Integer, DoublyLinkedList> map;
     DoublyLinkedList head;
     DoublyLinkedList tail;


     public LRUCache(int capacity) {
         this.capacity = capacity;
         map = new HashMap<>();
         head = new DoublyLinkedList(-1, -1);
         tail = new DoublyLinkedList(-1, -1);
         head.next = tail;
         tail.prev = head;
     }

     public int get(int key) {
         if(map.containsKey(key)) {
             DoublyLinkedList node = map.get(key);
             moveToFront(node);
             return head.next.value;
         }
         return -1;
     }

     public void put(int key, int value) {
         if(map.containsKey(key)) {
             DoublyLinkedList node = map.get(key);
             node.value = value;
             moveToFront(node);
         }
         else {
             if(map.size() == capacity) {
                 int lastKey = removeLast();
                 map.remove(lastKey);
             }
             DoublyLinkedList newNode = moveToFront(new DoublyLinkedList(key, value));
             map.put(key, newNode);
         }
     }

     private DoublyLinkedList moveToFront(DoublyLinkedList node) {
         if(node.next != null) {
             node.next.prev = node.prev;
         }
         if(node.prev != null) {
             node.prev.next = node.next;
         }

         head.next.prev = node;
         node.next = head.next;
         node.prev = head;
         head.next = node;
         return node;
     }

     private int removeLast() {
         DoublyLinkedList last = tail.prev;
         tail.prev.prev.next = tail;
         tail.prev = tail.prev.prev;
         return last.key;
     }
 }


// ----------------------------------------------

class LRUCache1 {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    HashMap<Integer, Node> m = new HashMap<>();

    public LRUCache1(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newnode) {
        Node temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;
    }

    private void deleteNode(Node delnode) {
        Node prevv = delnode.prev;
        Node nextt = delnode.next;

        prevv.next = nextt;
        nextt.prev = prevv;
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            Node resNode = m.get(key);
            int ans = resNode.val;

            m.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            m.put(key, head.next);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node curr = m.get(key);
            m.remove(key);
            deleteNode(curr);
        }

        if (m.size() == cap) {
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value));
        m.put(key, head.next);
    }
}
