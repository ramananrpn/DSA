package sorting;

// https://www.programiz.com/dsa/heap-sort
// https://www.geeksforgeeks.org/heap-sort/

/*
* Working of Heap Sort
Since the tree satisfies Max-Heap property, then the largest item is stored at the root node.

Swap: Remove the root element and put at the end of the array (nth position) Put the last item of the tree (heap) at the vacant place.

Remove: Reduce the size of the heap by 1.

Heapify: Heapify the root element again so that we have the highest element at root.

The process is repeated until all the items of the list are sorted.
*/

/* If the index of any element in the array is i,
the element in the index 2i+1 will become the left child and element in 2i+2 index will become the right child.
Also, the parent of any element at index i is given by the lower bound of (i-1)/2
*/

// Java program for implementation of Heap Sort
public class HeapSort {
    public void sort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        // first index of a non-leaf node is given by n/2 - 1.
        // All other nodes after that are leaf-nodes and thus don't need to be heapified.
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
