package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
// Tags: hard, heap, priority_queue, data_stream, top_interview_question, amazon, facebook, google, twitter, apple, ebay, adobe, microsoft

/*
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0


Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.


Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
*/

// BruteForce
// own_code
 class FindMedianFromDataStreamUsingSorting {

     List<Integer> nums;
     int median = 0;
     /** initialize your data structure here. */
     public FindMedianFromDataStreamUsingSorting() {
         this.nums = new ArrayList<>();
     }

     public void addNum(int num) {
         this.nums.add(num);
         Collections.sort(nums);
     }

     public double findMedian() {
         int size = nums.size();
         int mid = size/2;
         if((size & 1) == 1){
             return (double) nums.get(mid);
         }else{
             return (nums.get(mid) + nums.get(mid - 1)) / 2.0;
         }
     }
 }


 // ------------------------------------- Using 2 Heap -------------------------------------

class FindMedianFromDataStreamUsingHeap {

    PriorityQueue<Integer> high;
    PriorityQueue<Integer> low;
    /** initialize your data structure here. */
    public FindMedianFromDataStreamUsingHeap() {
        low = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        high = new PriorityQueue<>(); // min-heap
    }

    public void addNum(int num) {
        low.add(num);

        int max = low.poll();

        high.add(max);

        if(low.size() < high.size()) {
            int min = high.poll();
            low.add(min);
        }

    }

    public double findMedian() {
        return low.size() > high.size() ? low.peek() : (low.peek() + high.peek())/2.0;
    }
}


// HEAPS EXPLANATION
/*
Approach 3: Two Heaps
Intuition

The above two approaches gave us some valuable insights on how to tackle this problem. Concretely, one can infer two things:

If we could maintain direct access to median elements at all times, then finding the median would take a constant amount of time.
If we could find a reasonably fast way of adding numbers to our containers, additional penalties incurred could be lessened.
But perhaps the most important insight, which is not readily observable, is the fact that we only need a consistent way to access the median elements. Keeping the entire input sorted is not a requirement.

Well, if only there were a data structure which could handle our needs.

As it turns out there are two data structures for the job:

Heaps (or Priority Queues [1])
Self-balancing Binary Search Trees (we'll talk more about them in Approach 4)
Heaps are a natural ingredient for this dish! Adding elements to them take logarithmic order of time. They also give direct access to the maximal/minimal elements in a group.

If we could maintain two heaps in the following way:

A max-heap to store the smaller half of the input numbers
A min-heap to store the larger half of the input numbers
This gives access to median values in the input: they comprise the top of the heaps!

Wait, what? How?

If the following conditions are met:

Both the heaps are balanced (or nearly balanced)
The max-heap contains all the smaller numbers while the min-heap contains all the larger numbers
then we can say that:

All the numbers in the max-heap are smaller or equal to the top element of the max-heap (let's call it xx)
All the numbers in the min-heap are larger or equal to the top element of the min-heap (let's call it yy)
Then xx and/or yy are smaller than (or equal to) almost half of the elements and larger than (or equal to) the other half. That is the definition of median elements.

This leads us to a huge point of pain in this approach: balancing the two heaps!

Algorithm

Two priority queues:

A max-heap lo to store the smaller half of the numbers
A min-heap hi to store the larger half of the numbers
The max-heap lo is allowed to store, at worst, one more element more than the min-heap hi. Hence if we have processed kk elements:

If k = 2*n + 1 \quad (\forall \, n \in \mathbb{Z})k=2∗n+1(∀n∈Z), then lo is allowed to hold n+1n+1 elements, while hi can hold nn elements.
If k = 2*n \quad (\forall \, n \in \mathbb{Z})k=2∗n(∀n∈Z), then both heaps are balanced and hold nn elements each.
This gives us the nice property that when the heaps are perfectly balanced, the median can be derived from the tops of both heaps. Otherwise, the top of the max-heap lo holds the legitimate median.

Adding a number num:

Add num to max-heap lo. Since lo received a new element, we must do a balancing step for hi. So remove the largest element from lo and offer it to hi.
The min-heap hi might end holding more elements than the max-heap lo, after the previous operation. We fix that by removing the smallest element from hi and offering it to lo.
The above step ensures that we do not disturb the nice little size property we just mentioned.

A little example will clear this up! Say we take input from the stream [41, 35, 62, 5, 97, 108]. The run-though of the algorithm looks like this:

Adding number 41
MaxHeap lo: [41]           // MaxHeap stores the largest value at the top (index 0)
MinHeap hi: []             // MinHeap stores the smallest value at the top (index 0)
Median is 41
=======================
Adding number 35
MaxHeap lo: [35]
MinHeap hi: [41]
Median is 38
=======================
Adding number 62
MaxHeap lo: [41, 35]
MinHeap hi: [62]
Median is 41
=======================
Adding number 4
MaxHeap lo: [35, 4]
MinHeap hi: [41, 62]
Median is 38
=======================
Adding number 97
MaxHeap lo: [41, 35, 4]
MinHeap hi: [62, 97]
Median is 41
=======================
Adding number 108
MaxHeap lo: [41, 35, 4]
MinHeap hi: [62, 97, 108]
Median is 51.5


c++

lass MedianFinder {
    priority_queue<int> lo;                              // max heap
    priority_queue<int, vector<int>, greater<int>> hi;   // min heap

public:
    // Adds a number into the data structure.
    void addNum(int num)
    {
        lo.push(num);                                    // Add to max heap

        hi.push(lo.top());                               // balancing step
        lo.pop();

        if (lo.size() < hi.size()) {                     // maintain size property
            lo.push(hi.top());
            hi.pop();
        }
    }

    // Returns the median of current data stream
    double findMedian()
    {
        return lo.size() > hi.size() ? lo.top() : ((double) lo.top() + hi.top()) * 0.5;
    }

Complexity Analysis

Time complexity: O(5 \cdot \log n) + O(1) \approx O(\log n)O(5⋅logn)+O(1)≈O(logn).

At worst, there are three heap insertions and two heap deletions from the top. Each of these takes about O(\log n)O(logn) time.
Finding the median takes constant O(1)O(1) time since the tops of heaps are directly accessible.
Space complexity: O(n)O(n) linear space to hold input in containers.
*/

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */