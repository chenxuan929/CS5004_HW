package cs5004.collections;

import java.util.Objects;

/**
 * Class ListPriorityQueue implements PriorityQueue using a linked list.
 */
public class ListPriorityQueue implements PriorityQueue  {
  private ListNode head;

  /**
   * Private constructor for ListPriorityQueue class.
   * @param head head of node.
   */
  private ListPriorityQueue(ListNode head) {
    this.head = head;
  }

  /**
   * Constructs an empty priority queue with no elements.
   */
  public ListPriorityQueue() {
    this.head = new EmptyListNode();
  }

  /**
   * create a new empty priority queue.
   * @return a new empty priority queue.
   */
  public static PriorityQueue createEmpty() {
    return new ListPriorityQueue();
  }

  /**
   * Checks if this priority queue is empty.
   * @return true if the priority queue is empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return this.head instanceof EmptyListNode;
  }

  /**
   * Adds an element with the given priority and value to this priority queue.
   * @param priority The element's (non-negative) priority.
   * @param value The element's value.
   * @return a new priority queue with the added element.
   * @throws IllegalArgumentException if the priority is invalid (not in [1, 10]).
   */
  @Override
  public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    if (priority < 1 || priority > 10) {
      throw new IllegalArgumentException("Invalid priority, should between 1 and 10.");
    }
    if (isEmpty()) {
      return new ListPriorityQueue(new ChangeListNode(priority,value,new EmptyListNode().copy()));
    }
    return new ListPriorityQueue(this.head.addListNode(priority,value).copy());
  }

  /**
   * Returns the value of the element with the lowest priority in this priority queue.
   * @return the value of the element with the lowest priority in this priority queue.
   * @throws EmptyPriorityQueueException if the priority queue is empty.
   */
  @Override
  public String peek() throws EmptyPriorityQueueException {
    if (isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    return this.head.getValue();
  }

  /**
   * Removes the element with the lowest priority from this priority queue.
   * @return a new priority queue without the element with the lowest priority.
   * @throws EmptyPriorityQueueException if the priority queue is empty.
   */
  @Override
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    if (isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    return new ListPriorityQueue(this.head.getNext().copy());
  }

  /**
   * Returns a string representation of this priority queue.
   * @return a string representation of this priority queue.
   */
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    ListNode cur = this.head;
    boolean adjust = true;
    while (cur != null) {
      if (cur instanceof ChangeListNode) {
        ChangeListNode curNode = (ChangeListNode) cur;
        if (!adjust) {
          str.append(" ");
        } else {
          adjust = false;
        }
        str.append("(").append(curNode.getPriority())
        .append(",").append(curNode.getValue()).append(")");
      }
      cur = cur.getNext();
    }
    return str.toString();
  }

  /**
   * Checks if this priority queue is equal to the given object.
   * @param o the object to be compared with this priority queue.
   * @return true if this priority queue is equal to the given object, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListPriorityQueue otr = (ListPriorityQueue) o;
    ListNode theNode = this.head;
    ListNode otrNode = otr.head;
    while (otrNode != null && theNode != null) {
      if (theNode.getValue() != (otrNode.getValue())
          || theNode.getPriority() != (otrNode.getPriority())) {
        return false;
      }
      theNode = theNode.getNext();
      otrNode = otrNode.getNext();
    }
    return theNode == null && otrNode == null;
  }

  /**
   * Returns the hash code value for this priority queue.
   * @return the hash code value for this priority queue.
   */
  @Override
  public int hashCode() {
    return Objects.hash(head);
  }
}

