package chess;

/**
 * This is an interface class of ChessPiece.
 * Contains method: getRow(), getColumn(), getColor(), canMove(), and canKill().
 */
public interface ChessPiece {
  /**
   * Get the row position of the chess piece.
   * @return the row position of the chess piece.
   */
  int getRow();

  /**
   * Get the column of the chess piece.
   */
  int getColumn();

  /**
   * Get the color of the chess piece.
   */
  Color getColor();

  /**
   * This is a method to check if the provided position is valid for this chess piece to move to.
   * @param row the row of provided position.
   * @param col the column of provided position.
   * @return true if the provided position is valid, false otherwise.
   */
  boolean canMove(int row, int col);

  /**
   * This is a method to check if this chess piece can kill another piece.
   * @param piece another object of chess piece.
   * @return true if this chess piece can kill the another object, false otherwise.
   */
  boolean canKill(ChessPiece piece);
}

