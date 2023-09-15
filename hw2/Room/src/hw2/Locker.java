package hw2;

/**
 * The class represents a locker with size and mailitem that can be picked up.
 */
public class Locker {
  private final int maxWidth;
  private final int maxHeight;
  private final int maxDepth;
  private MailItem mailItem;

  /**
   * Constructor for a Locker, takes the max size of locker that can be stored.
   * @param maxWidth max width of locker.
   * @param maxHeight max height of locker.
   * @param maxDepth max depth of locker.
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) {
    if (maxWidth < 1 || maxHeight < 1 || maxDepth < 1) {
      throw new IllegalArgumentException("Max size information can not be less than 1.");
    }
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null;
  }

  /**
   * Adds a MailItem to locker if no item stored and its size is within the max size.
   * @param mailItem the MailItem to add.
   */
  public void addMail(MailItem mailItem) {
    if (this.mailItem == null && mailItem.getWidth() <= this.maxWidth
          && mailItem.getHeight() <= this.maxHeight
          && mailItem.getDepth() <= this.maxDepth) {
      this.mailItem = mailItem;
    }
  }

  /**
   * Picks up a MailItem from the locker if the recipient matches.
   * @param person the recipient of the MailItem.
   * @return the MailItem if matches, else null.
   */
  public MailItem pickupMail(Recipient person) {
    if (this.mailItem == null || !this.mailItem.getRecipient().equals(person)) {
      return null;
    }
    MailItem item = this.mailItem;
    this.mailItem = null;
    return item;
  }
}
