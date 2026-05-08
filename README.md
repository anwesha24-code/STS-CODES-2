## CAT-1
## Time and Space Complexity Summary (DSA)

| Problem / Technique | Time Complexity | Space Complexity | What it Does |
|--------------------|-----------------|------------------|--------------|
| In-place sorting of linked list (using extra space) | O(N log N) | O(N) | Sorts a linked list using auxiliary array storage |
| In-place sorting of linked list (without extra space) | O(N log N) | O(1) | Sorts a linked list by rearranging node links (merge sort) |
| Sorting by frequency | O(N log N) | O(N) | Sorts elements based on frequency of occurrence |
| Priority Queue using Linked List | O(N) (insert) | O(N) | Implements priority queue where elements are ordered by priority |
| Stock Span Problem (Brute Force) | O(N²) | O(1) | Calculates span by checking previous days one by one |
| Stock Span Problem (Using Stack) | O(N) | O(N) | Uses stack to efficiently compute stock spans |
| Modified Span Problem | O(N) | O(N) | Finds nearest greater element using stack |
| Bounded Stock Span | O(N) | O(N) | Computes stock span with a fixed upper limit |
| Tower of Hanoi | O(2ⁿ) | O(N) | Recursively moves disks between rods following rules |
| Celebrity Problem (Brute Force) | O(N²) | O(1) | Checks all pairs to find a celebrity |
| Celebrity Problem (Optimized) | O(N) | O(N) | Uses stack or two-pointer technique to find celebrity |
| Merge Sort on Doubly Linked List | O(N log N) | O(1) | Sorts a DLL by changing node links |
| Minimum Stack | O(1) per operation | O(N) | Supports push, pop, and getMin in constant time |
| Segregate Even and Odd Nodes in a List | O(N) | O(1) | Rearranges list so even nodes come before odd nodes |
| Sort Bitonic Doubly Linked List | O(N) | O(1) | Sorts a DLL that first increases then decreases (optimal approach) |
| Maximum Sliding Window (Brute Force) | O(N × K) | O(N − K + 1) | Finds max of each window by scanning all elements |
| Maximum Sliding Window (Self-balancing Tree) | O(N log K) | O(K) | Maintains window elements in balanced BST |
| Maximum Sliding Window (Max Heap) | O(N log K) | O(K) | Uses heap to track maximum in each window |
| Maximum Sliding Window (Deque) | O(N) | O(K) | Uses deque to maintain decreasing order of elements |


## CAT-2
# 🌳 Recover Binary Search Tree

## 1. Inorder + Two Pointer
- Inorder of BST → sorted
- Identify two misplaced nodes
- Swap them

**Time:** O(n)  
**Space:**  
- Skewed → O(n)  
- Balanced → O(log n)

---

## 2. Morris Traversal
- Inorder traversal without recursion/stack
- Uses threaded binary tree

**Time:** O(n)  
**Space:** O(1)

---

# 🌲 K-ary Heap

## Definition
- Each node has ≤ k children

## Properties
- Max Heap → Parent ≥ children  
- Min Heap → Parent ≤ children  

## Indexing (Array Representation)
- Parent(i) = ⌊(i−1)/k⌋  
- Children(i) = (k*i) + 1 to (k*i) + k  
- Last non-leaf = ⌊(n−2)/k⌋  

## Operations
- Insert → O(logₖ n)  
- Extract Min/Max → O(k logₖ n)  
- Build Heap → O(n)  
- Space → O(n)

## Notes
- Larger k → smaller height  
- Faster insert, slightly slower extract

---

# 🌿 Binomial Heap

## Definition
- Collection of binomial trees

## Binomial Tree (order k)
- Nodes = 2^k  
- Height = k  

## Operations
- Insert → O(log n)  
- Find Min → O(log n)  
- Extract Min → O(log n)  
- Merge → O(log n)

## Key Idea
- Maintain global minimum pointer → O(1) getMin

## Decrease Key
- Swap upward until heap property holds

## Advantages
- Efficient merge  
- Useful for mergeable priority queues

## Comparison
- Better than binary heap for merge & decreaseKey  
- Binary heap simpler and often faster in practice

---

# 📊 Heap Sort

## Steps
1. Build Max Heap → O(n)  
2. Extract max repeatedly → O(n log n)

## Complexity
- Time → O(n log n)  
- Space → O(1)

## Notes
- Not stable  
- In-place sorting

---

# 🔗 Graph Algorithms

## 1. Kahn’s Algorithm (Topological Sort)
- Uses BFS

**Time:** O(V + E)  
**Space:** O(V + E)

---

## 2. Bellman-Ford

- Handles negative weights  
- Detects negative cycles  

**Time:** O(V × E)  
**Space:** O(V + E)

### Idea
- Relax all edges V−1 times  
- Dynamic programming approach

---

## 3. Dijkstra’s Algorithm

### Constraint
- Works only for non-negative weights

### Complexity
- Adjacency matrix → O(V²)  
- Priority queue → O(E + V log V)

### Space
- Matrix → O(V²)  
- Adjacency list → O(V + E)

---

## Difference: Bellman-Ford vs Dijkstra

| Feature | Bellman-Ford | Dijkstra |
|--------|-------------|----------|
| Negative weights | Yes | No |
| Negative cycle detection | Yes | No |
| Speed | Slower | Faster |

---

# 🌐 Graph Traversals

## BFS
- Time → O(V + E)  
- Space → O(V)

## DFS
- Time → O(V + E)  
- Space → O(V)

---

# 🌳 Tree Traversals

## Boundary Traversal
- Time → O(n)  
- Space → O(h)  
  - Worst → O(n)  
  - Balanced → O(log n)

---

## Vertical Order Traversal
- Uses TreeMap (sorted columns)

**Time:** O(n log n)  
**Space:** O(n)

---

# ⚡ Quick Summary

- Recover BST → Inorder / Morris (O(1) space)
- K-ary Heap → Shorter height, faster insert
- Binomial Heap → Efficient merge
- Heap Sort → O(n log n), in-place
- Kahn → Topological sort (BFS)
- Bellman-Ford → Handles negative edges
- Dijkstra → Faster, no negative edges
- BFS/DFS → O(V + E)
- Winner Tree → finds minimum element
- Loser Tree → finds maximum element
- Tree traversals → Mostly O(n)


# 📊 Time & Space Complexity Table

| Topic / Algorithm | Operation | Time Complexity | Space Complexity |
|------------------|----------|----------------|------------------|
| **Recover BST (Inorder)** | Traverse + fix | O(n) | O(n) worst, O(log n) balanced |
| **Recover BST (Morris)** | Traverse + fix | O(n) | O(1) |
| **K-ary Heap** | Insert | O(logₖ n) | O(n) |
| | Extract Min/Max | O(k logₖ n) | O(n) |
| | Build Heap | O(n) | O(n) |
| **Binomial Heap** | Insert | O(log n) | O(n) |
| | Find Min | O(log n) *(O(1) with pointer)* | O(n) |
| | Extract Min | O(log n) | O(n) |
| | Merge | O(log n) | O(n) |
| | Decrease Key | O(log n) | O(n) |
| **Heap Sort** | Build Heap | O(n) | O(1) |
| | Sort (overall) | O(n log n) | O(1) |
| **Kahn’s Algo** | Topo Sort | O(V + E) | O(V + E) |
| **Bellman-Ford** | Shortest Path | O(V × E) | O(V + E) |
| **Dijkstra** | (Matrix) | O(V²) | O(V²) |
| | Dial(Priority Queue) | O(E + V log V) | O(V + E) |
| **BFS** | Traversal | O(V + E) | O(V) |
| **DFS** | Traversal | O(V + E) | O(V) |
| **Boundary Traversal** | Tree traversal | O(n) | O(h) |
| **Vertical Order Traversal** | Tree traversal | O(n log n) | O(n) |
| **Winner Tree** | Tree traversal | O(n log k) | O(k+n) |