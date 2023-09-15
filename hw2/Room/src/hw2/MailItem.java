package hw2;

/**
 *This is a class representing a mail item with size and recipient information.
 */
public class MailItem {
  private final int width;
  private final int height;
  private final int depth;
  private final Recipient person;

  /**
   * Constructs a MailItem instance with the given size and recipient information.
   * @param width width of the item.
   * @param height height of the item.
   * @param depth depth of the item.
   * @param person the recipient of the item.
   */
  public MailItem(int width, int height, int depth, Recipient person) {
    if (width < 1 || height < 1 || depth < 1) {
      throw new IllegalArgumentException("Size information can not be less than 1.");
    }
    if (person == null) {
      throw new IllegalArgumentException("Recipient must be provided, can not be null.");
    }
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.person = person;
  }

  /**
   * Returns the recipient of the mail item.
   * @return the recipient.
   */
  public Recipient getRecipient() {
    return this.person;
  }

  /**
   * Returns the height of the mail item.
   * @return the height.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Returns the width of the mail item.
   * @return the width.
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Returns the depth of the mail item.
   * @return the depth.
   */
  public int getDepth() {
    return this.depth;
  }
}
