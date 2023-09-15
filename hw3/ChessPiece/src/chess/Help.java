package chess;

/**
 * This is a help function to check if the position if valid in chess board.
 * Ensure the chess wouldn't out of boundary.
 */
public class Help {
  /**
   * Check if the chess position is valid in chess borad.
   * @param row the row position of chess piece.
   * @param col the column position of chess piece.
   */
  public static void checkValidPosition(int row, int col) {
    if (row < 0 || row > 7 || col < 0 || col > 7) {
      throw new IllegalArgumentException("Invalid position for chess piece");
    }
  }
}


