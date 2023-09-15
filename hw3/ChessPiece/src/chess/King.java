package chess;

/**
 * This class represents a King chess piece.
 */
public class King extends piece {
  /**
   * Constructor for King chess piece.
   * @param row the row position of King.
   * @param col the column position of King.
   * @param color the color of King.
   */
  public King(int row, int col, Color color) {
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
    Help.checkValidPosition(row, col);
    if (this.row == row && this.col == col) {
      return false;
    }

    if (this.row == row && Math.abs(this.col - col) == 1) {
      return true;
    }
    if (this.col == col && Math.abs(this.row - row) == 1) {
      return true;
    }
    if (Math.abs(this.row - row) == 1 && Math.abs(this.col - col) == 1) {
      return true;
    }
    else {
      return false;
    }
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
