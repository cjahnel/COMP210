# Java Data Types
- Primitives
    - boolean (1 bit)
    - char (2B)
    - integers
        - byte (1B)
        - short (2B)
        - int (4B)
        - long (8B)
    - floating points
        - float (4B)
        - double (8B)
- Reference types
    - String
    - Array
    - Class
    - Interface
- Data Types cannot change in Java
    - Python is dynamically typed, so an instantiated variable can
    change type at runtime based on its new value
    - Java is statically typed, so a variable instantiated with its type
    cannot be set to another type value
- 1 byte = 2 nibbles; 1 nibble can be represented by a hexadecimal digit

## Stack vs Heap Memory
- On the Java call stack, call frames are stored
- A call frame is memory where local variables and parameters from the currently executing 
method live
- When a method is called (invoked):
    - A new call frame for the called method is created
        - Parameter names defined and set to their values
    - "Pushed" onto the stack
    - Method begins execution
        - Local variables added to frame when declared
        -Removed if they fall out of scope

# Lecture 3
- Primitive types are stored on the stack
- Reference types are stored on the heap
- Pointers to Reference types are stored on the stack
- The garbage collector in Java frees up memory by clearing variables in the heap which do 
not have a pointer on the stack
- Two variables initialized with the same string literal as its value, both variables will 
point to the same literal in memory
- Random Access Memory means any value in any address can be written to or read from directly 
without iteration
- Strings are not null-terminated like in C because they are Reference types, not pointers 
like in C
- Recursion can be more elegant, intuitive and easier to implement, especially if a data 
structure has a recursive structure
(binary tree); even though it may be less efficient with time (function calls) and memory 
(stack pileup)

# Lecture 4
- For an array of strings, the array stores pointers to each string as its elements
- To create an empty array (full of ``null`` values), you can write 
``String[] sA2 = new String[3];``
- An array of objects also only included pointers to each object; the fields on the objects 
are stored in other addresses in the heap

# Lecture 5
## Time complexity of Algorithms
- T(n) is the time duration taken by the algorithm
- bn + a ~ bn; b(2n) + a ~ 2(bn)
- Linear Search
  - Worst case: O(n)
  - Average case: O(n/2) = O(n)
  - Best case: O(1)

# Lecture 6
- Binary search
  - Best case = 1 iteration
  - Worst case = log_2(n) + 1 iterations
  - i.e. O(log n)
  - Base of log is not relevant by the change of base formula:
  log_2(n) = log_2(10) x log_10(n) = 3.32 x log_10(n)
- Complexity of the algorithm depends on the data structure
## Introducing the Linked List
- Each element in the linked list is a completely different object, and thus can be in
different parts of memory
- Some pointer points to the head node and the tail node points to ``null``
- Each node has its content and a pointer to the next node
- Now to access the ith element of L, ``L[i]``, you need to traverse through the whole list
- Inserting into a **sorted** linked list
  - Have to redirect two pointers
- Deleting in a Sorted Linked List
  - If we found the node and have a pointer to it, we can get its pointer and reassign
  it to the previous node's pointer, however, we need to track this previous node when
  searching for the targeted node too anyway.
  - To clear a linked list, setting the size to zero and then setting the head and tail to null
  will require the garbage collector to come through and free the nodes in the heap

# Lecture 9/S2
## Complexity: Array (Unsorted)
- Search
  - Best-case: O(1)
  - Average: O(n)
  - Worst-case: O(n)
- Insert (really appending or pushing)
  - Best-case: O(1)
  - Average: O(1)
  - Worst-case: O(1)
- Delete* (delete operation after finding element and filling space with last element)
  - Best-case: O(1)
  - Average: O(1)
  - Worst-case: O(1)
## Complexity: Array (Unsorted vs Sorted)
- Search
    - Unsorted Array: O(n)
    - Sorted Array: O(log n)
- Insert (sorted: finding where the element belongs in order, then shifting rest down)
    - Unsorted Array: O(1)
    - Sorted Array: O(log n) + O(n) = O(n)
- Delete* (sorted: delete operation after finding element and shifting to fill spaces)
    - Unsorted Array: O(1)
    - Sorted Array: O(n)
## Performance Comparison (Arrays vs Linked Lists)
|         | Unsorted Array | Sorted Array | Unsorted Linked List | Sorted Linked List |
|---------|----------------|--------------|----------------------|--------------------|
| Search  | O(n)           | O(log n)     | O(n)                 | O(n)               |
| Insert  | O(1)           | O(n)         | O(1)                 | O(n) + O(1) = O(n) |
| Delete* | O(1)           | O(n)         | O(1)                 | O(1)               |
| Memory  | Wasteful       | Wasteful     | Efficient            | Efficient          |

When the number of elements in a list are known, an array is better than a linked list in 
terms of memory and vice-versa.

Arrays
- Pros
  - Several operations are faster
  - Simpler code
- Cons
  - Poor Memory utilization
  - Less flexible

Linked Lists
- Pros
  - Better memory utilization for large lists
  - Very flexible
- Cons
  - Several operations are slower
  - More complex code

# Lecture 10/S2
## Doubly Linked List
- Not too many advantages, as pointer to previous node can just be stored in another variable
- Takes up 50% more space in memory

## Trees
- Nonlinear data structure
- Root node, leave nodes are absolute(?)
- Parents, children, and sibling nodes are relative to each other, single parent though like 
a starfish
- How is it implemented?
  - Root pointer
  - No leave pointers
  - Hard to implement children nodes, could be a pointer to array of children

## Binary Trees
- Each Node can only have up to 2 child nodes
- To traverse the tree, there must be pointers up and down the tree between parent and 
child nodes
- Each node has its contents and three pointers: left, right, and parent (these three are 
known as overhead)
 
## Binary Search Tree
- Left child is always a smaller number
- Right child is always a larger number
- Hence, the contents are ordered
- Numbers can come in any order, but at the root node, they will fall into place with 
comparisons

## Types of Binary Trees
### Perfect Binary Tree
- All leaf nodes are at the same level
- All other nodes have 2 children

### Full Binary Tree
- Every node has either 0 or 2 children

### Complete Binary Tree
- All levels are completely filled except possibly the last
- Nodes are as far left as possible in the last level

### Balanced vs Unbalanced binary trees
- If the height (number of nodes from root to leaf) of the right branch is not equal to 
that of the left (plus or minus one), then it is unbalanced

## Complexity in a Binary Search Tree
- Search (perfect): h = log_2(N + 1) - 1 => O(log n)
- Insert (balanced): O(log n) [to search] + O(1) [to make new node and point to it]
- Delete (balanced, leaf node): O(log n) [to find] + O(1) [to remove pointer to it]
- Delete (balanced, parent, 1 child): O(h) [to find] + O(1) [to redirect pointer to subtree]

## Deletions in the BST
- If a parent node of two children is deleted, you have to replace it with a successor 
that fills the gap according to searching in the binary tree; largest in left subtree 
or smallest in right subtree
- To find the smallest, you just have to find the left most, and WLOG for largest
- If the root node is to be deleted, just find the largest its left subtree or smallest of 
its right

## Complexity of Deletions in the BST
- If Leaf, just find and delete
- If only one child, just replace
- If 2 children, replace by and delete successor
  - Search for node: O(h)
  - Search for successor: O(h)
  - Delete** (after searches)
    - Replace by successor: O(1)
    - Delete successor: O(h) (because successor must not have two children since it is max 
    or min in its own subtree)
- Therefore, delete is O(h) which is O(log n) for balanced BSTs

## Advantages of BSTs
- For a balanced BST, search, insert, and delete = O(h) = O(log n)
- For an unbalanced BST, search, insert, and delete = O(h) = O(n)
- Balanced BSTs also are efficient in memory
- The big question is how to balance BSTs
- Fortunately, there are techniques to create self-balancing trees

## Types of tree traversals
1. Breadth-first: search along layers, like a zigzag or waves 
   1. Applicable to all trees, binary or not, searchable or not
2. Depth-first/Preorder: root -> left -> right: dive down then climb up when you hit bottom 
and down the other way
3. Postorder: left -> right -> root: kind of ground up, search the surface then bubble up
4. Inorder: left -> root -> right: basically traversing from left to right across levels
- Inorder would traverse the nodes in order
- Breadth traversal would make more sense for Facebook recommending friends
- Postorder would be best for deleting a tree since it is from the ground up and so no 
pointers are lost, (this is assuming the garbage collector wouldn't take care of it)
- Preorder (depth-first) is probably best for duplicating a binary tree, since each node 
will be connected as they are duplicated
- Traversing with depth-first takes advantage of the call stack for recursion
- Traversing with breadth-first requires a queue structure which adds a node's children 
before it is dequeued

Array sizes are fixed in Java, so we must use the ArrayList

## ArrayLists
- Dynamic arrays that are initially stored with a default size (1.5x?), but can dynamically 
change according to its allocated elements (both enlarging and shrinking), but only at some 
cutoff, not on every change in size; This is done by copying the existing elements and 
reallocating the array list in some area of memory sufficient in size
- Stacks and Queues are abstract data types since they support some defined set of 
methods, but they can be implemented with LinkedLists or ArrayLists

### Stack as a LinkedList
- Each node can be a layer on the stack, where we only need a pointer to the top of the 
stack, and each node points to the lower node

## Stacks and Queues using interfaces
- A stack interface must implement the push, pop, and getSize methods
- A queue interface must implement the enqueue, dequeue, and getSize methods

## Amortized Time for doubling an ArrayList
- Amortized time = time taken, averaged over a sequence of well-defined operations
- Average time = average time taken based on input drawn from a particular distribution

## Stack as a LinkedList vs as an ArrayList
|      | Linked List | ArrayList  |
|------|-------------|------------|
| Push | O(1)        | O(N)/O(1)* |
| Pop  | O(1)        | O(N)/O(1)* |

*amortized time accounts for average case (leaving out resizing array)

# Queue with a LinkedList
- The head node is the first element in, each subsequently added node becomes the tail
- Dequeued elements come off the head

## Queue as a LinkedList vs as an ArrayList
|         | Linked List | ArrayList  |
|---------|-------------|------------|
| Enqueue | O(1)        | O(N)/O(1)* |
| Dequeue | O(1)        | O(N)/O(N)* |

*amortized time accounts for average case (leaving out resizing array)

# Circular Array for a Queue
- Has a head and tail pointer, fixed length
- Head and tail pointers are adjusted upon enqueue and dequeue operations

## Complexity of a queue as a Circular Array
|         | Linked List | ArrayList  | Circular Array |
|---------|-------------|------------|----------------|
| Enqueue | O(1)        | O(N)/O(1)* | O(1)           |
| Dequeue | O(1)        | O(N)/O(N)* | O(1)           |

Circular array (must be a static size of queue)

Stacks and queues are abstract data types (ADTs)

# Priority Queues
- Unique priority assigned at time of entry
- The one with the highest priority is dequeued
- Think of patients in the ER; the most critical emergencies are handled first
- Passengers in line for airlines are often sorted by class, so within each priority 
passengers are arranged by FIFO

# Implementing the Priority Queue
- Circular, sorted array
- Unsorted array list
- BST

# Introducing the Heap
- Two versions: Max and min Heap
1. Each node is bigger (or smaller) than its children
2. The height of subtrees below differ by at most 1
- Contents are partially ordered as compared to fully ordered for a BST

## Complexity in a Heap
- Search: O(n) (some traversal like breadth-first)

# Implementing a Priority Queue using a MaxHeap
- Enqueue works by using a breadth-first traversal going down the tree until it finds a 
gap on its current level; then the new element is placed in that gap, and bubbles up
- Enqueue: O(n)
  - Inserting element at first gap in the lowest level using a breadth-first traversal
    - O(n)
  - The element will "bubble up" the tree until it meets an element bigger than it
    - O(log n)
- Dequeue:
  - Remove top of the heap, replace it with the last element
  - Bubble down algorithm (top element trickles down to the open space)

## Array implementation for Binary Heap
- Store elements in breadth-first traversal order
- Left child is located at ``2*i + 1``, right at ``2*i + 2`` relative to parent
- Parent of ``i`` is at ``floor((i-1)/2)``
- Advantages
  - Less space since pointers aren't necessary
  - No breadth-first traversal needed to find the next hole for the element to fit in,
  instead just simply append the new element to the array and bubble up/down
- Building a heap from scratch is O(n log(n)) because the enqueue is called n times
- Enqueue: O(log N)
  - Insert at end: O(1) [don't need to find gap]
  - Bubble-up: O(log N) [comparisons up tree]
- Dequeue: O(log N)
  - Remove top, replace with last element: O(1) [don't need to find gap]
  - Bubble-down: O(log N) [comparisons down tree]

## Efficient Heap Build
- Start with arbitrarily ordered array list for heap
- Set ``i`` to parent index of last node
- While ``i >= 0``:
  - Bubble down at ``i``
  - Decrement ``i``

# AVL Trees
- AVL = self-balancing BST (Adelson-Velsky and Landis)
- AVL trees are BSTs with the following additional condition:
- We define **Balance Factor**:
  - BF = H(L) - H(R), which must satisfy: |BF| <= 1 at every node

## BST vs Heap vs AVL data structure
- Binary Search Tree (BST)
  - Left children always smaller
  - Right children always bigger
  - Contents are fully ordered
  - Tree unbalanced
- Heap -- Tree:
  - Each node is bigger (or smaller) than its children
  - The tree is a Complete Binary Tree
  - Contents are partially ordered
  - Tree balanced
- AVL -- Tree:
  - Left children always smaller
  - Right children always bigger
  - BF = H(L) - H(R)

## Balancing an AVL Tree
- x, y, z are labelled in order by ascending height, imbalances are denoted by the relative
orientations of each
- RR imbalance
  - Use the top node as a fulcrum, rotating left like a pulley for the nodes to fall in place;
  rotate around z to get y at top
- LL imbalance
  - Same method as RR, but use a right pulley rotation (rotate)
- In larger trees, there will be a conflict if a stem node has three connections and is 
pushed to the top via a pulley rotation
  - So the third connection (weight) is passed off to the original root node
- RL imbalance
  - Right rotation at the y node, and left rotation at the z node
- LR imbalance
  - Same logic as previous method; left rotation at the y node, and right at the z node
- In some cases where x is ambiguous relative to y, choosing an imbalance method will result 
in different trees, but usually LL or RR is preferred when ambiguous

# Complexity in the AVL Tree
- h = O(log N) [since tree is continually balanced]
- Insertion: O(log N)
  - O(log N) to insert via BST insertion and then iterate back up looking for an imbalance
  - O(1) for each rotation
- Deletion: O(log N)
  - O(log N) to find value to delete and find a successor
  - O(1) to do the deletion
  - O(log N) to do comparisons up toward root
- So, the AVL tree provides O(log N) for search, insert, and delete

|                         | BST                    | Heap (Priority Queue) |
|-------------------------|------------------------|-----------------------|
| Operations?             | Search, Insert, Delete | Enqueue, Dequeue      |
| Order?                  | Fully-Ordered          | Partially-Ordered     |
| Balanced Tree?          | No                     | Yes                   |
| Worst Case Performance? | O(N)                   | O(log N)              |

# Red-Black Trees
- BST with additional constraints
- Each node in tree is either red or black
- The root is always black
- Every path from the root to all the null leaves encounters the same number of black nodes
- No adjacent (Parent/Child) red nodes
- A perfect binary tree with only black nodes is a valid RBT
- At any point in the RBT, one branch will never have more than double the height than the 
other, since it is limited by O(log N) has reds can be interspersed

## Height in RBTs
- BH = height of black nodes in Tree (number of black nodes until a null leaf)
- H = h + 1 = height of Tree (total nodes in the longest path from root to null leaf)
- For a RBT, ``BH <= H <= 2(BH)``
- ``H = O(log N)`` => ``H <= k log_m(N)`` => ``BH <= k log_m(N)`` => ``BH = O(log N)``
- ``2^BH - 1 <= N <= 2^(2BH) - 1`` => ``BH <= log_2(N+1)`` => ``H <= 2(BH) <= 2log_2(N+1)``
- Therefore, ``H = O(log N)``

## Insertions in RBTs
- Must re-balance BST after insertion
- Always insert new nodes as red, or else an imbalance in BH will be created
- **RULE 0: Insert new value as a red node**
  - Like normal BST insertion, new node "x" will end up as a leaf at the bottom of the tree
- Four possible cases
  - Case 1: x is the root of the red-black tree and has no parent.
    - **RULE 1: Make x black**
  - Case 2: parent of x is black
    - **Rule 2: No further steps required**
  - Case 3: parent of x is red and pibling is red (pibling refers to parent's sibling)
    - **Rule 3: Recolor as follows:**
      - Make parent and pibling black
      - Make grandparent red, and reevaluate cases from that point upwards with grandparent 
      as  the "new" x
        - (If grandparent is at root, the grandparent will be changed back to black)
      - [Recoloring from red to black doesn't pose a problem in other branches since there 
      could not have been another adjacent red in the first case or rule 3 would be broken, 
      so only one direct lineage from x to the root is affected and can use recursion]
  - Case 4: parent of x is red and pibling is black / empty
    - **Rule 4: Rotate and Recolor:**
      - Use a rotation based on LL, RR, LR, RL, etc.
      - Recolor pivot black and its children red (can be the other way around in other solutions)
        - [Doesn't have to use recursion in this case, because the root stays black]

# Red-black Trees vs AVL Performance? (Worst-case/Average-case(Amortized))
|            | Heaps          | Bal. BSTs (AVL/RBT) |
|------------|----------------|---------------------|
| Insert     | O(N)/O(log N)  | O(log N)            |
| Search     | O(N)           | O(log N)            |
| Delete*    | O(N)/O(log N)  | O(log N)            |
| PQ Enqueue | O(N)/O(log N)  | O(log N)            |
| PQ Dequeue | O(N)/O(log N)# | O(log N)#           |
| Build      | O(N)           | O(N log N)          |

- \# Heaps are much easier to implement and have lower constants vs Balanced BSTs
- * Delete after search
- Insertions and deletions in RBTs will likely be easier than in AVL due to fewer rotations
- RBT Trees may have great height and hence search in RBT may be slower than in AVL

# Hash Tables
- Putting N names in a table of M addresses
- Use a hash function based on encoding of name to find its index

## Hash Table Complexity
|            | Order |
|------------|-------|
| Insert     | O(1)  |
| Search     | O(1)  |
| Delete     | O(1)  |
| PQ Enqueue | O(1)  |
| PQ Dequeue | O(M)  |
| Build      | O(N)  |

- Data is unsorted, so there is no concept of order for a priority queue
- We are using a large array based on the range of this hash function
- Data can "collide" if two values are mapped to the same index
- Each index of the hash table can point to the head of a linked list (called "chaining")

The quality of the hash table is determined by the quality of the hash function
- A uniform distribution is favorable for a hash function
- If there is a single long linked list because of a poor hash function, search is O(N)

### Linear Probing
- If the index based on the hash function is occupied, find the next empty space
- But if the hash table is nearly filled, then it could look through the whole table 
for a space in O(N) time
- If there is a poor hash function, then there will be clustering around common indices, 
and thus the search will go to the index and then have to look for the name until the 
next gap, or if entirely filled, the entire table (O(N))
  - Could be solved by filling space in O(N) time or implementing a flag field for recently
  deleted values, telling the algorithm to go on in search

## Collision Performance
- If ``N << M``, then insert, search, and delete will average to O(1) because the probability 
of a collision is low, and thus chaining and probing are equivalent
- If ``N < M, N ~ M``, then the probability of a collision is high

|         | Chain (P low) | Prob (P low) | Chain (P high) | Probe (P high) |
|---------|---------------|--------------|----------------|----------------|
| Insert  | O(1)          | O(1)         | O(1)           | O(N)           |
| Search  | O(1)          | O(1)         | O(N)           | O(N)           |
| Delete* | O(1)          | O(1)         | O(1)           | O(1)           |

- Index of initial letter produces a poor distribution
- Sum of ascii encoding modulo M produces a more uniform distribution

## Simple Linear Probing
- Let's define h(k) as h(k, i)
- ``h(k, i) = (k + i) mod M``
  - k = integer (key)
  - M = size of table
  - i = collision number
- Make Table size (M) a prime number

## Linear vs Quadratic Probing
- Quadratic probing example:
  -``h(k, i) = (k + i^2) mod M``
- Cluster breaks down, more room for neighbors in memory
- Secondary clustering may happen around frequent outputs in the quadratic

## Double hashing
- Avoids primary and secondary clustering
- Pick two hash functions: h1 and h2
  - ``h(i, k) = (h1(k) + i * h2(k)) mod M``
    - M = size of table
    - i = collision number
- Good until nears the capacity

## Hash Table Resizing
- Load factor
  - n/m (n records in m rows in hash table)
- If table used with probing exceeds its load, the size of the table can be changed 
dynamically like an ArrayList, but if the hash function used mod, then the values will 
need to be remapped in the new table, can't just copy it by its location
- Limiting load factors are chosen for threshold to resize a hash table
  - For chaining, if load > 1.0
  - For probing, if load > 0.75

## Hash Table Complexity
- Chaining
  - Average number of elements per bucket = N/M < 1.0 (because of resizing)
  - Search: O(1 + N/M) = O(1)
- Probing
  - Additional time would be minimal with N/M < 0.75

### Time complexities (with and without resizing, worst and average (amortized) cases)
|          | Chaining w/o | Probing w/o | Chaining w | Probing w | Chaining w (Avg) | Probing w (Avg) |
|----------|--------------|-------------|------------|-----------|------------------|-----------------|
| Insert** | O(1)         | O(N)        | O(N)**     | O(N)**    | O(1)             | O(1)            |
| Search   | O(N)         | O(N)        | O(1)       | O(1)      | O(1)             | O(1)            |
| Delete*  | O(1)         | O(1)        | O(N)**     | O(N)**    | O(1)             | O(1)            |
** Assuming table is resized
*Delete after search

We still need the heap for priority queues

# Heaps vs. balanced BSTs vs Hashing?
|            | Heaps          | Bal. BSTs  | Chaining  | Probing   |
|------------|----------------|------------|-----------|-----------|
| Insert     | O(N)/O(log N)  | O(log N)   | O(N)/O(1) | O(N)/O(1) |
| Search     | O(N)           | O(log N)   | O(1)      | O(1)      |
| Delete*    | O(N)/O(log N)  | O(log N)   | O(N)/O(1) | O(N)/O(1) |
| PQ Enqueue | O(N)/O(log N)# | O(log N)   | O(N)/O(1) | O(N)/O(1) |
| PQ Dequeue | O(N)/O(log N)# | O(log N)   | O(N)      | O(N)      |
| Build      | O(N)           | O(N log N) | O(N)      | O(N)      |

#Heaps are much easier to implement and have lower constants vs Bal. BSTs
Worst-case/Average-case(amortized)

## Chaining vs. Probing
- Chaining
  - Generally has better worst-case performance
  - Performs better ar higher load
  - But requires additional Linked List
- Probing
  - Requires additional complexity due to clustering issues
  - More complex to implement when resizing tables
  - But requires less memory (no additional LL and pointers)

# Sorting Algorithms
- Very important operation in computing
- Many algorithms are based on use of specific data structures

## Selection sort
1. Consider the Array in 2 parts: Sorted and Unsorted (initially Unsorted)
2. Select the smallest element from unsorted array and swap with leftmost unsorted position
3. Increase the sorted array portion
4. Repeat process 2-3 until fully sorted
- Worst case: O(n^2)
- Best case: O(n^2)
- Average: O(n^2)
- Space: O(1) i.e. In place

## Bubble sort
1. Start from first element
2. Compare adjacent elements, swap as necessary
3. Now repeat entire process from first till last unsorted element
4. Increase sorted portion
5. Repeat 1-4 till done
- Worst case: O(n^2)
- Best case: O(n) [if case where no swaps is being tracked]
- Average: O(n^2)
- Space: In place

## Quick sort (Divide and Conquer)
- First element is the pivot
- Move all elements smaller than pivot to the left by swapping (use i and j for this)
- Move pivot into the middle (Now Pivot is in correct position)
- Apply same algorithm on each of the two halves
- Utilizes the Recursion Tree
- Worst case: O(n^2) [this is if the array is already sorted, P(sorted) = 1/n!]
- Best case: O(n log n)
- Average: O(n log n)
- Stack space: O(log n)
- It is possible to implement the algorithm

## Heap sort
- Efficient Heap Build: O(N)
- Sort in place
  - Dequeue max element off top
  - Place that max element right behind the last node in the heap, so that the array list 
  is partitioned between the heap and the sorted array list, so it is in place

# Sorting Algorithms: Summary
|            | Selection | Bubble | Quick      | Heap       |
|------------|-----------|--------|------------|------------|
| Worst Case | O(N^2)    | O(N^2) | O(N^2)     | O(N log N) |
| Best case  | O(N^2)    | O(N)   | O(N log N) | O(N log N) |
| Average    | O(N^2)    | O(N^2) | O(N log N) | O(N log N) |
| Space      | O(1)      | O(1)   | O(log N)   | O(1)       |

# Graphs (Directed)
- Already familiar with graphs:
  - **Trees**
- Graph = (V, E)
- E.g. of Directed graph (digraph)
- Edges are Ordered pairs: (52, 77), (77, 96), ...
- (52, 77) != (77, 52)

## Undirected Graphs
- **Social Network**
  - Example of Undirected graph
- Edges are Unordered pairs:
  - {Andy, Lee}, {Bob, Alice}, ...
- {Andy, Lee} = {Lee, Andy}

### Directed vs Undirected Graphs
1. Binary Search Tree: Directed
2. Social Media: Undirected
3. World Wide Web: Directed
4. Flowchart: Directed
5. Molecular Structures: Undirected (for covalent)
6. Family Tree: Directed
7. Intercity roads: Undirected

## Weighted Graphs
- Weights could be some criteria e.g.
  - Driving time (distance and delays)
  - Distance only
  - $ cost (gas/toll)
- (In unweighted graph, all weights = 1)

## Directed Acyclic Graphs (DAG)
- No cycles, directed

# Problem: Shortest Path
- How do you determine the following?
1. Shortest path from Vertex X to Y
2. Shortest path from X to all destinations
   - You must determine 2 in order to determine 1
3. Shortest path between all pairs (X, Y)
- Used with packet transmission over the internet

## Problem: Social Media
- Friend recommendations (Undirected, no weights)
- Friend recommendations for Bob? How would we solve this?
- Handles problem 2
- Breadth traversal

## Problem: Web-crawling (Spiderbot)
- Graph traversals: Web-crawling (for search engines)
- Could be cyclical, so need to keep track of where you've already been

## Problem: Travelling Salesman Problem (TSP)
- Given a list of N cities and the distances between each pair of cities, what is the 
shortest possible route that visits each city exactly once and returns to the origin city?
- NP-hard

## Problem: Telecommunications Example
- A telecoms company has to lay cable in a new neighborhoods and needs to minimize the 
total cable laid
- Is this similar or different from any of the previous problems (shortest path/TSP)?

## Types of Graphs
- Connected vs disconnected graphs
- Cyclic vs acyclic graphs

## Tree 
- A connected, acyclic graph

## Spanning Tree
- Given a graph, one can find a spanning tree, which is a tree that touches all vertices

## Tree vs Forest
- A forest is a group of several disconnected trees

## Minimum Spanning Tree
- MST is a spanning tree with the minimum total of weights
- Example is a telecomms company trying to lay cable in a new neighborhood
- Number of edges in a MST m = n - 1 [Can be thought of by proof by induction I think]

## Complete Graph
- All pairs of vertices are connected by an edge.
- Let: n = |V| and m = |E|
- For Complete graphs: m = n(n-1)/2

## Dense vs Sparse graphs
- Dense
  - m = O(n^2)
    - Complete graph: m = n(n-1)/2
- Sparse
  - m = O(n)
    - Tree: m = n-1

# Implementing graphs using data structures
- Social network (unweighted, undirected graph)
  - 1 billion users on FaceBook, about 100 friends each

## Adjacency Matrix
- Unweighted Graph
  - Array of arrays, 1 or 0 based on membership
  - First index i is the source, second index j is the destination to indicate direction
  - Since this is a relatively sparse graph for social networks, as m/n is 100 and not 
  proportional to n, there is a lot of wasted space allotted to 0s
- Weighted Graph
  - Instead of a 0 or 1 based on membership, the element is the weight on that edge
- Requires O(n^2) space
- Determining adjacent neighbors is O(n) [having to run through entire array for each]
- Only works for undirected graphs

## Adjacency List
- Each vertex object maintains a list of edge objects
- Requires O(n+m) = O(m) space

# Shortest Path Algorithms
- Single source to all destinations

## Shortest path in Unweighted Graphs
- Store vertices in a hashtable, edges in linked list, visit flag, distance (set to 
infinity if not the first which has 0), stores the previous node (like a trail of crumbs)

Create a FIFO queue (Linked List)
1. For each ``v`` in ``V``, set ``dist(v) = infinity``, except ``dist(s) = 0``; add ``s`` 
  to ``Q``, and mark as visited [O(n)]
2. While ``Q`` is not empty:
   1. u=dequeue [O(n)]
   2. Enqueue all unvisited neighbors v of u [O(n^2) for dense, O(n) for sparse]
   3. mark these as visited
   4. update dist(v) = dist(u) + 1
   5. Previous Node (PN) - u
- Overall Time Complexity
  - Dense: O(n + n^2) = O(n^2) = O(m)
  - Sparse: O(n + n) = O(n) = O(m)
  - Disconnected: O(n) [because step 1 still must be done to set all distances to infinity]
- Order in which neighbors are enqueued can change the calculated shortest path between 
equidistant path

## Shortest path in Weighted Graphs: Dijkstra's Algorithm
- Instead of using a FIFO queue, we want to use a Priority Queue

Let PQ = minHeap Priority Queue of all vertices
1. For each v in V, set dist(v) = infinity, except dist(s)=0; add v to PQ based on 
estimated distance dist(v) [O(n)]
2. While PQ is not empty:
   1. u=dequeue(min Heap). Mark u as visited. [O(n log(n))]
   2. For each *unvisited* neighbor v of u: [O(m log n)]
      - **Relax**(u, v)
      - Update dist(v) if required in PQ
        - This requires a search in O(n) time plus a bubble up from reduced node O(log n)
        - However, we can add a field to the hash table that contains the index of the node 
        in the array list so that it can be accessed in O(1) time
      - and note u as the Previous Node (PN)
- **Relax** operation sees if v is better accessible via u (i.e. if estimated distance 
between s and v is longer than that of s and u plus that of u and v)
- After this is completed you get a table with instructions that go backward, so it is a 
recursive sort of algorithm using a stack?
- Overall time complexity: O(m log n)

## Minimum Spanning Tree
- Cost of a spanning Tree = sum of all edge weights in the tree
- A minimum spanning tree (MST) is a 
  - spanning tree of an **undirected* graph
  - that has the minimum cost

## MST - Kruskal's Algorithm (Edges)
- Given a weighted/unweighted, directed/undirected graph, find the MST
- The algorithm adds the least cost edges to a tree, while ensuring no cycles are being formed;
  - this happens until the forest is united into one tree
- Sorting edges has order O(m log m), done with heap sort
- Ensuring no cycles complexity O(alpha(m)) ~ O(1)
1. Construct minHeap PQ with m edges with key = edge weight; start with empty Forest(F) [O(m)]
2. Dequeue each edge, and add in F, ensuring that no cycle is created [O(m log m)]
3. Repeat 2 until all vertices included in F (F is now the MST)
- Overall time complexity: O(m log m)

### Kruskal's Algorithm with Negative weights (directed graph)?
- Negative weights might make sense in a situation where the government is giving grants 
to lay cable between two points or where an uber driver picks up another carpooling rider 
so that they are making more profit

### Dijkstra's algorithm with Negative weights (directed graph)?
- Negative values don't work because it assumes that a direct path will always be favorable 
over one via a longer edge
- Example of a greedy algorithm: 
  - Assumes locally optimal solution is globally optimal
