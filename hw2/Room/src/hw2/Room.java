package hw2;

/**
 * This is a class represents a room.
 */
public class Room {
  private RoomType roomtype;
  private double price;
  private int guests;
  private int maxOccupancy;

  /**
   * Constructor for Room class.
   * @param roomtype the type of room (single, double, or family).
   * @param price the price of the room.
   * @throws IllegalArgumentException if the price is negative.
   */
  public Room(RoomType roomtype, double price) {
    if (price < 0) {
      throw new IllegalArgumentException("Price of room can not be negative number");
    }
    this.roomtype = roomtype;
    this.guests = 0;
    switch (this.roomtype) {
      case SINGLE:
        this.maxOccupancy = 1;
        break;
      case DOUBLE:
        this.maxOccupancy = 2;
        break;
      case FAMILY:
        this.maxOccupancy = 4;
        break;
    }
  }

  /**
   * Returns true if the room is available, false otherwise.
   * @return true if room is available, false otherwise.
   */
  public boolean isAvailable() {
    return guests == 0;
  }

  /**
   * Books the room for a given number of guests.
   * @param guests the number of guests to book the room for.
   */
  public void bookRoom(int guests) {
    if (guests > 0 && guests <= maxOccupancy && isAvailable()) {
      this.guests = guests;
    }
    if (guests < 0 && guests > maxOccupancy) {
      throw new IllegalArgumentException("Guests can not be negative or more than max occupancy.");
    }
  }

  /**
   * Returns the number of guests currently in the room.
   * @return the number of guests in the room.
   */
  public int getNumberOfGuests() {
    return this.guests;
  }
}


