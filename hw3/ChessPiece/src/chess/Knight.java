package chess;

/**
 * This class represents a Knight chess piece.
 */
public class Knight extends piece {
  /**
   * Constructor for Knight chess piece.
   * @param row the row position of Knight.
   * @param col the column position of Knight.
   * @param color the color of Knight.
   */
  public Knight(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * This is a method to check if the provided position is valid for this chess piece to move to.
   * @param row the row of provided position.
   * @param col the column of provided position.
   * @return true if the provided position is valid, false otherwise.
   */
  @Override
  public boolean canMove(int row, int col) {
    int moveL2 = 2;
    int moveL1 = 1;
    int rowDiff = Math.abs(this.row - row);
    int colDiff = Math.abs(this.col - col);

    Help.checkValidPosition(row, col);
    if (this.row == row && this.col == col) {
      return false;
    }

    if ((rowDiff == moveL1 && colDiff == moveL2) || (rowDiff == moveL2 && colDiff == moveL1)) {
      return true;
    }
    return false;
  }

  /**
   * This is a method to check if this chess piece can kill another piece.
   * @param piece another object of chess piece.
   * @return true if this chess piece can kill the another object, false otherwise.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    Help.checkValidPosition(piece.getRow(), piece.getColumn());
    return canMove(piece.getRow(), piece.getColumn()) && this.color != piece.getColor();
  }
}
