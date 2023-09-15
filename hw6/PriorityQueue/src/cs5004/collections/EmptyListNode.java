package cs5004.collections;

/**
 * Represents an empty node in a linked list used to implement a priority queue.
 */
public class EmptyListNode implements ListNode {

  /**
   * Get the priority of the node.
   * @return the priority of the node.
   */
  @Override
  public Integer getPriority() {
    return 0;
  }

  /**
   * Get the value of the node.
   * @return the value of the node.
   */
  @Override
  public String getValue() {
    return null;
  }

  /**
   * Get the next node in the linked list.
   * @return the next node in the linked list.
   */
  @Override
  public ListNode getNext() {
    return null;
  }

  /**
   * Adds a new node with the given priority and value to the linked list, and returns it.
   * @param priority the priority of the new node to add.
   * @param value the value of the new node to add.
   * @return a new ChangeListNode.
   * @throws IllegalArgumentException if the priority is not between 1 and 10.
   */
  @Override
  public ListNode addListNode(Integer priority, String value) throws IllegalArgumentException {
    if (priority < 1 || priority > 10) {
      throw new IllegalArgumentException("Invalid priority, should between 1 and 10.");
    }
    return new ChangeListNode(priority,value,this);
  }

  /**
   * Get a copy instance of the EmptyListNode.
   * @return a new instance of the EmptyListNode.
   */
  @Override
  public ListNode copy() {
    return new EmptyListNode();
  }
}
