package cs5004.collections;

/**
 * ListNode interface class.
 */
public interface ListNode {

  /**
   * Get the priority of the node.
   * @return the priority of the node.
   */
  public Integer getPriority();

  /**
   * Get the value of the node.
   * @return the value of the node.
   */
  public String getValue();

  /**
   * Get the next node in the linked list.
   * @return the next node in the linked list.
   */
  public ListNode getNext();

  /**
   * Adds a new node with the given priority and value to the linked list, and returns it.
   * @param priority the priority of the new node to add.
   * @param value the value of the new node to add.
   * @return a new ChangeListNode.
   * @throws IllegalArgumentException if the priority is not between 1 and 10.
   */
  public ListNode addListNode(Integer priority, String value) throws IllegalArgumentException;

  /**
   * Get a copy instance of the EmptyListNode.
   * @return a new instance of the EmptyListNode.
   */
  public ListNode copy();
}
