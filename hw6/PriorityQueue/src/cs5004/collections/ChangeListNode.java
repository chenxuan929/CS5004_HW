package cs5004.collections;

/**
 * Class ChangeListNode implement ListNode interface.
 */
public class ChangeListNode implements ListNode {
  private Integer priority;
  private String value;
  private ListNode next;

  /**
   * Constructs a ChangeListNode with the given priority, value, and next node.
   * @param priority the priority of the node.
   * @param value the value of the node.
   * @param next next node in the priority queue.
   */
  public ChangeListNode(Integer priority, String value, ListNode next) {
    if (priority < 1 || priority > 10) {
      throw new IllegalArgumentException("Invalid priority, should between 1 and 10.");
    }
    if (next == null || value == null) {
      throw new IllegalArgumentException("next or value should not be null");
    }
    this.priority = priority;
    this.value = value;
    this.next = next;
  }

  /**
   * Get the priority of the node, which is always 0 for an empty node.
   * @return the priority of the node.
   */
  @Override
  public Integer getPriority() {
    return this.priority;
  }

  /**
   * Get the value of the node, which is always null for an empty node.
   * @return the value of the node.
   */
  @Override
  public String getValue() {
    return this.value;
  }

  /**
   * Get the next node in the linked list, which is always null for an empty node.
   * @return the next node in the linked list.
   */
  @Override
  public ListNode getNext() {
    return this.next;
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
    if (priority > this.priority) {
      return new ChangeListNode(priority, value, this);
    }
    return new ChangeListNode(this.priority, this.value, this.next.addListNode(priority, value));
  }

  /**
   * Get a copy instance of the EmptyListNode.
   * @return a new instance of the EmptyListNode.
   */
  @Override
  public ListNode copy() {
    return new ChangeListNode(this.priority, this.value, this.next.copy());
  }
}
