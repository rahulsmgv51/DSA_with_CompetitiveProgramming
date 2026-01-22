# Online Stock Span

## 📝 Problem Summary

Design a class `StockSpanner` that processes daily stock prices and returns the **stock span** for each day.

### 📘 What is Stock Span?

For each day's price, the span is the number of **consecutive previous days (including today)** where the price is **less than or equal** to today’s price.

---

## 📌 Example

**Input**

```
["StockSpanner", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75]]
```

**Output**

```
[null, 1, 1, 1, 2, 1, 4]
```

### Explanation

* 100 → span = 1
* 80 → span = 1
* 60 → span = 1
* 70 → spans across (70, 60) → span = 2
* 60 → span = 1
* 75 → spans across (75, 60, 70, 60) → span = 4

---

## 💡 Intuition / Approach – Monotonic Stack

A brute force solution checks previous prices → **O(N)** per query → too slow.

Instead, use a **monotonic decreasing stack** storing:

```
(price, span)
```

### For each new price:

1. Set `span = 1`
2. Pop entries while `stack.top.price <= price`
3. Add their span to current span
4. Push `(price, span)` onto the stack
5. Return `span`

This works because **each price is pushed and popped at most once**, giving **O(1) amortized** time.

---

## 🚀 Time & Space Complexity

| Operation     | Complexity         |
| ------------- | ------------------ |
| `next(price)` | **O(1) amortized** |
| Space         | **O(N)**           |

---

## 🧠 Why Monotonic Stack Works?

* Stack maintains **strictly decreasing prices**.
* If a new price is higher, previous smaller prices can't block future spans → so pop them.
* Their spans get merged into the new day's span.

---

## 🧪 Edge Cases

* **Strictly decreasing prices:** every span = 1
* **Strictly increasing prices:** spans grow like `[1,2,3,...]`
* **Random large input:** stack holds at most N items

---

## 🧩 Implementations

### 🐍 Python

```python
class StockSpanner:
    def __init__(self):
        self.stack = []  # (price, span)

    def next(self, price: int) -> int:
        span = 1
        while self.stack and self.stack[-1][0] <= price:
            span += self.stack.pop()[1]
        self.stack.append((price, span))
        return span
```

---

### ☕ Java

```java
import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    private Deque<int[]> stack;  // {price, span}

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}
```

---

### 🌐 JavaScript

```javascript
class StockSpanner {
  constructor() {
    this.stack = [];  // [price, span]
  }

  next(price) {
    let span = 1;
    while (this.stack.length && this.stack[this.stack.length - 1][0] <= price) {
      span += this.stack.pop()[1];
    }
    this.stack.push([price, span]);
    return span;
  }
}
```