import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import cs5004.collections.ChangeListNode;
import cs5004.collections.EmptyListNode;
import cs5004.collections.ListNode;
import org.junit.Test;


/**
 * Test for EmptyListNode class.
 */
public class Empty_Change_ListNodeTest {

  /**
   * Test priority exception to ChangeListNode.
   */
  @Test
  public void testChangeListNodeInvalidPriority() {
    assertThrows(IllegalArgumentException.class, () -> {
      new ChangeListNode(0, "test", new EmptyListNode());
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new ChangeListNode(11, "test", new EmptyListNode());
    });
  }

  /**
   * Test null exception to ChangeListNode.
   */
  @Test
  public void testChangeListNodeNullValueOrNext() {
    assertThrows(IllegalArgumentException.class, () -> {
      new ChangeListNode(5, null, new EmptyListNode());
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new ChangeListNode(5, "test", null);
    });
  }

  /**
   * Test getPriority function.
   */
  @Test
  public void testGetPriority() {
    ListNode node1 = new EmptyListNode();
    assertEquals(0, node1.getPriority(), 0.01);
    ListNode node2 = new ChangeListNode(5, "value2", node1);
    assertEquals(5, node2.getPriority(), 0.01);
    ListNode node3 = new ChangeListNode(1,"a", node2);
    ListNode node4 = node3.addListNode(3, "c");
    ListNode node5 = node4.addListNode(2, "d");
    assertEquals(1, node3.getPriority(), 0.01);
    assertEquals(3, node4.getPriority(), 0.01);
    assertEquals(3, node5.getPriority(), 0.01);
  }

  /**
   * Test getValue function.
   */
  @Test
  public void testGetValue() {
    ListNode node = new EmptyListNode();
    assertNull(node.getValue());
    ListNode node1 = new ChangeListNode(1, "value1", node);
    assertEquals("value1", node1.getValue());
    ListNode node2 = new ChangeListNode(2, "value2", node1);
    assertEquals("value2", node2.getValue());
  }

  /**
   * Test getNext function.
   */
  @Test
  public void testGetNext() {
    ListNode node = new EmptyListNode();
    ListNode node1 = new ChangeListNode(1, "value1", node);
    assertEquals(node, node1.getNext());
    ListNode node2 = new ChangeListNode(2, "value2", node1);
    assertEquals(node1, node2.getNext());
  }

  /**
   * Test addListNode function.
   */
  @Test
  public void testAddListNode() {
    ListNode node = new EmptyListNode();
    ListNode node1 = node.addListNode(1, "value1");
    assertEquals(1, node1.getPriority(), 0.01);
    assertEquals("value1", node1.getValue());
    assertEquals(node, node1.getNext());
    ListNode node2 = node1.addListNode(2, "value2");
    assertEquals(2, node2.getPriority(), 0.01);
    assertEquals("value2", node2.getValue());
    assertEquals(node1, node2.getNext());
    ListNode node3 = node2.addListNode(1, "value3");
    assertEquals(2, node3.getPriority(), 0.01);
    assertEquals("value2", node3.getValue());
  }

  /**
   * Test exception to add function.
   */
  @Test
  public void testAddListNodeInvalidPriority() {
    ListNode node = new ChangeListNode(5, "value", new EmptyListNode());
    assertThrows(IllegalArgumentException.class, () -> {
      node.addListNode(0, "new value");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      node.addListNode(11, "new value");
    });
  }

  /**
   * Test copy function.
   */
  @Test
  public void testCopy() {
    ListNode node = new EmptyListNode();
    ListNode node1 = new ChangeListNode(1, "value1", node);
    ListNode copyNode = node1.copy();
    assertEquals(node1.getPriority(), copyNode.getPriority());
    assertEquals(node1.getValue(), copyNode.getValue());
    assertNotEquals(node1.getNext(), copyNode.getNext());
    assertEquals(node.getPriority(), copyNode.getNext().getPriority());
    assertEquals(node.getValue(), copyNode.getNext().getValue());
    assertEquals(node.getNext(), copyNode.getNext().getNext());
  }
}