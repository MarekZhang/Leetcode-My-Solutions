# 284. Peeking Iterator

![284%20Peeking%20Iterator%20855edf8aafda46e4895002d7fb9a60dc/Untitled.png](284%20Peeking%20Iterator%20855edf8aafda46e4895002d7fb9a60dc/Untitled.png)

### Solution

- we pre-get the next value and store it in a tempt variable named peek

```java
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
  private Integer peek;
  private Iterator<Integer> iterator;
  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iterator = iterator;
    if(iterator.hasNext()) peek = iterator.next();
    else peek = null;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return peek;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    Integer old = peek;
    if(iterator.hasNext()) peek = iterator.next();
    else peek = null;
    return old;
  }

  @Override
  public boolean hasNext() {
    return peek != null;
  }
}
```