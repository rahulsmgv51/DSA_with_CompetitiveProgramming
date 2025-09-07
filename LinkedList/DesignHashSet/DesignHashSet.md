# Design HashSet

## Problem

Design a HashSet without using any built-in hash table libraries.

Implement the `MyHashSet` class:

* `void add(int key)` Inserts the value `key` into the HashSet.
* `void remove(int key)` Removes the value `key` in the HashSet. If `key` does not exist in the HashSet, do nothing.
* `boolean contains(int key)` Returns `true` if the value `key` exists in the HashSet, otherwise `false`.

**Constraints:**

* `0 <= key <= 10^6`
* At most `10^4` calls will be made to `add`, `remove`, and `contains`.

---

## Examples

```text
Input
["MyHashSet","add","add","contains","remove","contains"]
[[],[1],[2],[1],[2],[2]]

Output
[null,null,null,true,null,false]
```

---

## Approaches

### 1) Direct boolean array (Easy, memory-heavy)

Because `key` range is limited to `0..10^6`, the simplest solution is to allocate a boolean array of size `10^6 + 1`. Each index represents whether the key exists.

* `add(key)` → `arr[key] = true`
* `remove(key)` → `arr[key] = false`
* `contains(key)` → `arr[key]`

**Time Complexity:** O(1) for each operation.

**Space Complexity:** O(U) where U = 10^6 (fixed). This is simple and fast but may be large in memory.

### 2) Bucketed boolean (Memory-efficient, classic interview solution)

Use a 2D boolean structure with `buckets` and `bucketItems` to avoid allocating `10^6+1` booleans directly while still achieving O(1) access.

* Choose `buckets = 1000` and `bucketItems = 1001` (so buckets \* bucketItems >= 10^6+1).
* Compute: `bucket = key % buckets`, `bucketItem = key / buckets`.
* Lazily allocate each bucket (a boolean array for bucket items) when you first need it.

This reduces memory when the number of distinct keys stored is small.

**Time Complexity:** O(1) average per operation.

**Space Complexity:** O(n + buckets) where n is number of keys stored (plus small overhead).

---

## Implementations

### Java — boolean array (simple)

```java
class MyHashSet {
    private boolean[] set;
    public MyHashSet() {
        set = new boolean[1000001];
    }
    public void add(int key) {
        set[key] = true;
    }
    public void remove(int key) {
        set[key] = false;
    }
    public boolean contains(int key) {
        return set[key];
    }
}
```

### Java — bucketed approach (memory-optimized)

```java
class MyHashSet {
    private boolean[][] table;
    private int buckets = 1000;
    private int bucketItems = 1001; // to cover 1_000_000

    public MyHashSet() {
        table = new boolean[buckets][];
    }

    private int getBucket(int key) {
        return key % buckets;
    }
    private int getBucketItem(int key) {
        return key / buckets;
    }

    public void add(int key) {
        int b = getBucket(key);
        int bi = getBucketItem(key);
        if (table[b] == null) table[b] = new boolean[bucketItems];
        table[b][bi] = true;
    }

    public void remove(int key) {
        int b = getBucket(key);
        int bi = getBucketItem(key);
        if (table[b] != null) table[b][bi] = false;
    }

    public boolean contains(int key) {
        int b = getBucket(key);
        int bi = getBucketItem(key);
        return table[b] != null && table[b][bi];
    }
}
```

### Python — boolean array (simple)

```python
class MyHashSet:
    def __init__(self):
        self.arr = [False] * (10**6 + 1)

    def add(self, key: int) -> None:
        self.arr[key] = True

    def remove(self, key: int) -> None:
        self.arr[key] = False

    def contains(self, key: int) -> bool:
        return self.arr[key]
```

---

## Edge cases & Notes

* The boolean-array solution is simplest and fastest for the constrained range; use it if memory is not an issue.
* The bucketed approach is commonly expected in interviews to show memory-conscious design.
* If the key range were unbounded or very large, a chaining or open-addressing hash table with linked lists / dynamic arrays would be used instead.
* Pay attention to integer division vs modulo when computing bucket and bucketItem indices.

---

## Complexity

* Time: O(1) average for `add`, `remove`, `contains`.
* Space: O(U) for direct array (U = max key + 1). Bucketed: O(n + buckets) where `n` is number of stored keys.

---

## Quick Tests (examples you can run)

* `add(1)`, `add(2)`, `contains(1)` -> `true`
* `contains(3)` -> `false`
* `add(2)`, `contains(2)` -> `true`
* `remove(2)`, `contains(2)` -> `false`

---

## Tips for README

* Keep the problem statement short and link to the LeetCode problem on your solutions page.
* Show both the naive and optimized approach to demonstrate trade-offs.
* Include sample runs and complexity analysis.

---