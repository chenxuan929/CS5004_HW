import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import cs5004.collections.EmptyPriorityQueueException;
import cs5004.collections.ListPriorityQueue;
import cs5004.collections.PriorityQueue;
import org.junit.Test;

/**
 * Test for ListPriorityQueue class.
 */
public class ListPriorityQueueTest {

  /**
   * Test for createEmpty function.
   */
  @Test
  public void testCreateEmpty() {
    PriorityQueue p1 = ListPriorityQueue.createEmpty();
    assertTrue(p1.isEmpty());
    PriorityQueue p2 = ListPriorityQueue.createEmpty();
    assertTrue(p2.isEmpty());
  }

  /**
   * Test for isEmpty function.
   */
  @Test
  public void testIsEmpty() throws EmptyPriorityQueueException {
    PriorityQueue pq = ListPriorityQueue.createEmpty();
    assertTrue(pq.isEmpty());
    pq = pq.add(1, "A");
    assertFalse(pq.isEmpty());
    pq = pq.add(2, "B");
    pq = pq.pop();
    assertFalse(pq.isEmpty());
    pq = pq.pop();
    assertTrue(pq.isEmpty());
  }

  /**
   * Test for add function.
   */
  @Test
  public void testAdd() {
    PriorityQueue pq = ListPriorityQueue.createEmpty();
    pq = pq.add(5, "A");
    pq = pq.add(3, "B");
    pq = pq.add(7, "C");
    pq = pq.add(2, "D");
    pq = pq.add(9, "E");
    assertEquals("(9,E) (7,C) (5,A) (3,B) (2,D)", pq.toString());
    PriorityQueue p1 = pq;
    assertThrows(IllegalArgumentException.class, () -> p1.add(0, "F"));
    PriorityQueue p2 = pq;
    assertThrows(IllegalArgumentException.class, () -> p2.add(11, "F"));
  }

  /**
   * Test for peek function.
   */
  @Test
  public void testPeek() throws EmptyPriorityQueueException {
    PriorityQueue pq = ListPriorityQueue.createEmpty();
    pq = pq.add(5, "A");
    pq = pq.add(3, "B");
    pq = pq.add(7, "C");
    pq = pq.add(2, "D");
    pq = pq.add(9, "E");
    assertEquals("E", pq.peek());
    pq = pq.pop();
    assertEquals("C", pq.peek());
    pq = pq.pop();
    assertEquals("A", pq.peek());
    pq = pq.pop();
    assertEquals("B", pq.peek());
    pq = pq.pop();
    assertEquals("D", pq.peek());
    pq = pq.pop();
    PriorityQueue p1 = pq;
    assertThrows(EmptyPriorityQueueException.class, () -> p1.peek());
  }

  /**
   * Test for pop function.
   */
  @Test
  public void testPop() throws EmptyPriorityQueueException {
    PriorityQueue pq = ListPriorityQueue.createEmpty();
    pq = pq.add(5, "A");
    pq = pq.add(3, "B");
    pq = pq.add(7, "C");
    pq = pq.add(2, "D");
    pq = pq.add(9, "E");
    pq = pq.pop();
    assertEquals("(7,C) (5,A) (3,B) (2,D)", pq.toString());
    pq = pq.pop();
    assertEquals("(5,A) (3,B) (2,D)", pq.toString());
    pq = pq.pop();
    assertEquals("(3,B) (2,D)", pq.toString());
    pq = pq.pop();
    assertEquals("(2,D)", pq.toString());
    pq = pq.pop();
    assertTrue(pq.isEmpty());
    PriorityQueue p = pq;
    assertThrows(EmptyPriorityQueueException.class, () -> p.pop());
  }

  /**
   * Test ToString function.
   */
  @Test
  public void testToString() throws EmptyPriorityQueueException {
    ListPriorityQueue pq = (ListPriorityQueue) ListPriorityQueue.createEmpty();
    assertEquals("", pq.toString());

    pq = (ListPriorityQueue) pq.add(5, "apple").add(1, "banana").add(8, "orange");
    assertEquals("(8,orange) (5,apple) (1,banana)", pq.toString());

    pq = (ListPriorityQueue) pq.pop();
    assertEquals("(5,apple) (1,banana)", pq.toString());

    pq = (ListPriorityQueue) pq.pop().pop();
    assertEquals("", pq.toString());
  }

  /**
   * Test equals function.
   */
  @Test
  public void testEquals() throws EmptyPriorityQueueException {
    ListPriorityQueue pq1 = (ListPriorityQueue) ListPriorityQueue.createEmpty();
    ListPriorityQueue pq2 = (ListPriorityQueue) ListPriorityQueue.createEmpty();
    assertTrue(pq1.equals(pq2));
    assertTrue(pq2.equals(pq1));
    pq1 = (ListPriorityQueue) pq1.add(5, "apple").add(1, "banana").add(8, "orange");
    pq2 = (ListPriorityQueue) pq2.add(1, "banana").add(5, "apple").add(8, "orange");
    assertTrue(pq1.equals(pq2));
    assertTrue(pq2.equals(pq1));
    pq2 = (ListPriorityQueue) pq2.pop().pop();
    assertFalse(pq1.equals(pq2));
    assertFalse(pq2.equals(pq1));
    pq1 = (ListPriorityQueue) ListPriorityQueue.createEmpty();
    pq2 = (ListPriorityQueue) pq2.add(10, "cherry");
    assertFalse(pq1.equals(pq2));
    assertFalse(pq2.equals(pq1));
  }
}