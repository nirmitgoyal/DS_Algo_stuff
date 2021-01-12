**Heap:**

Min Heap: A complete BT, where the value of each node is >= the value of its parent node.

A complete vs full binary tree:
https://web.cecs.pdx.edu/~sheard/course/Cs163/Doc/FullvsComplete.html#:~:text=A%20full%20binary%20tree%20(sometimes,as%20far%20left%20as%20possible.

* Heap add() & pop():
https://www.youtube.com/watch?v=t0Cq6tVNRBA
* PriorityQ is implemented as a min-heap in java:
https://stackoverflow.com/questions/14165325/is-there-a-heap-in-java


```PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //internally it's an array for java too```

Max heap using pq:

```PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());```

* Height of a heap = log(n)
* LOT of heap does NOT gives a sorted array

Operations:
* peek

Fetches minimum element of the array O(1)

* poll

Polls  minimum element of the array. takes O(height)=O(log(n))  (since it heapifies)

* add

Inserting a new key takes O(height) = O(log(n)) time

* Inserting n elements/building a heap/pq OR inserting n elements in a heap containing m elements

O(n) //in the 2nd case n is the new size

This complexity is bcoz inserting every node takes O(h) time and h increases very slowly and due to analysis,
this comes to be the asymptomatic Top K Frequent Elements complexity

-------------------------------------------------------------------------------------------------------------------------
* log A + log B = log AB

-------------------------------------------------------------------------------------------------------------------------
* Stack Space complexity for quick sort: Av - logn (since the array is pretty much divided into half each time), Worst - O(n); since there can be case where
partitionIndex does comes out to be at the ends of the array and we have to divide it n-1 times.

Quick sort cannot be done iteratively as we will have to call the quickSort inside

-------------------------------------------------------------------------------------------------------------------------
Get int from a char(string of size 1) int like '5': 
```'5' - '0'```

-------------------------------------------------------------------------------------------------------------------------
**Binary tree(BT):**

* If there are n nodes in binary tree, maximum height of the binary tree is n-1 and minimum height is logn
* The maximum number of nodes at level ‘l’ of a binary tree is 2^l

--------------------------------------------------------------------------------------------------------------------------
**Binary search tree(BST):**
* If there are n nodes in a binary search tree, maximum height of the binary search tree is n-1 and minimum height is logn
* inorder gives sorted elements

```countBTs(n) = countBSTs(n) * n!```

--------------------------------------------------------------------------------------------------------------------------
* How to get and put(set and clear) a bit in a variable:
https://youtu.be/NLKQEOgBAnw?list=WL&t=414

-------------------------------------------------------------------------------------------------------------------------
* Time and space complexity of ```String.substring(beginIndex, endIndex)``` is O(n) //even for ```StringBuilder.substring()```

beginIndex :  inclusive.
<br>
endIndex :    exclusive.

* Complexity of ```String.contains(anotherString)``` is O(n*m)

Do not care to use .indexOf() for checking if a string(text) contains another string(pattern)

-------------------------------------------------------------------------------------------------------------------------
* Iterate map:

```
map.forEach((key, value) -> {
    sout(key + " " + value);
});
```
        

-------------------------------------------------------------------------------------------------------------------------
* LinkedList is doubly liked list(DLL)

Deque can be used as both doubly liked list and doubly ended queue. ```Deque<Integer> deque = new LinkedList<>();```

It has functions like ```addFirst(3), addLast(3), peekFirst(), peekLast(), pollFirst(), pollLast(),``` in O(1), ```remove(object: 3)``` in O(n) - (both for LinkedList<>() and ArrayDeque<>()); 

1. The diff b/w LinkedList based DQ and ArrayDeque is that Linked one uses LinkedList internally, while Array one uses Array.

2. If you want to keep track of each node in DLL, create your custom DLL, so that you can use map to store each node. (Apart from this usecase even, it's better to create custom DLL, otherwise you will have to remember methods lik: ```dll.listIterator().previous()```)

-------------------------------------------------------------------------------------------------------------------------
* total number of sub-arrays in an array: O(n^2) = O(n*n)
* total number of sub-sets in an array: O(2^n)

-------------------------------------------------------------------------------------------------------------------------
* Iteration over the collection-views of a LinkedHashMap requires time proportional to the size of the map, regardless of its capacity. Iteration over a HashMap is likely to be more
expensive, requiring time proportional to its capacity.

-------------------------------------------------------------------------------------------------------------------------
* n! grows faster than an exponential with a constant base like 2^n or e^n

-------------------------------------------------------------------------------------------------------------------------
* gcd:
https://www.geeksforgeeks.org/c-program-find-gcd-hcf-two-numbers/

O(Log min(a, b))

-------------------------------------------------------------------------------------------------------------------------
* Initialize Reference:
```
LinkedList<Integer> linkedList = new LinkedList<>();
Queue<Integer> q = new LinkedList<>();
Deque<Integer> dq = new LinkedList<>();

PriorityQueue<Integer> minHeap = new PriorityQueue<>();
Stack<Integer> stack = new Stack<>();
```


-------------------------------------------------------------------------------------------------------------------------
* in, pre, post order tree traversals are DFS

* LOT is BFS

-------------------------------------------------------------------------------------------------------------------------
```Collections.reverse(list)``` reverses a list in O(1) space

-------------------------------------------------------------------------------------------------------------------------
Time complexity of bitwise operators like <<, >> is O(1)

-------------------------------------------------------------------------------------------------------------------------
If ```o1.compareTo(o2)``` > 0, it means o1 > o2


```
String s1="9";
String s2="172";
s1.compareTo(s2); // = 8 (9 - 7 = 8)

String s1="317";
String s2="172";
s1.compareTo(s2); // = 2 +ve number shows s1 > s2. -ve number shows s1 < s2. The result is zero if the strings are equal
```

Since Strings are compared lexicographically. 

Fortunately, for same length integer strings, the order is normal as of integers. 



-------------------------------------------------------------------------------------------------------------------------
O(n + m) != O(n) + O(m)

-------------------------------------------------------------------------------------------------------------------------
log2(2^n) = n

-------------------------------------------------------------------------------------------------------------------------
Limits:

int(32 bits) : 2*10^9 (2 billion) (10 digits)

-------------------------------------------------------------------------------------------------------------------------
To convert string to char array: ```char[] chars = s.toCharArray();```

-------------------------------------------------------------------------------------------------------------------------
Sub-set != Sub-array != Sub-sequence
