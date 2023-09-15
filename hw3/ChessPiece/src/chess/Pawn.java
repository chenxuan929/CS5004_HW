package chess;

/**
 * This class represents a Pawn chess piece.
 */
public class Pawn extends piece {
  /**
   * Constructor for Pawn chess piece.
   * @param row the row position of Pawn.
   * @param col the column position of Pawn.
   * @param color the color of Pawn.
   */
  public Pawn(int row, int col, Color color) {
    super(row, col, color);
    if (color == Color.WHITE && row == 0) {
      throw new IllegalArgumentException("Invalid position for white Pawn");
    }
    if (color == Color.BLACK && row == 7) {
      throw new IllegalArgumentException("Invalid position for black Pawn");
    }
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

    if (this.col != col) {
      return false;
    }

    if (this.color == Color.WHITE && this.row == 1) {
      return (row == this.row + 2 || row == this.row + 1);
    }

    if (this.color == Color.BLACK && this.row == 6) {
      return (row == this.row - 2 || row == this.row - 1);
    }
    return Math.abs(this.row - row) == 1;
  }

  /**
   * This is a method to check if this chess piece can kill another piece.
   * @param piece another object of chess piece.
   * @return true if this chess piece can kill the another object, false otherwise.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    Help.checkValidPosition(piece.getRow(), piece.getColumn());

    if (piece.getColor() == this.color) {
      return false;
    }

    if (Math.abs(this.col - piece.getColumn()) != 1) {
      return false;
    }

    int rowDiff = this.row - piece.getRow();

    if (this.color == Color.WHITE && this.row == 1) {
      return (rowDiff == -2 || rowDiff == -1);
    }

    if (this.color == Color.BLACK && this.row == 6) {
      return (rowDiff == 2 || rowDiff == 1);
    }

    if (this.color == Color.WHITE) {
      return rowDiff == -1;
    }

    if (this.color == Color.BLACK) {
      return rowDiff == 1;
    }
    return false;
  }
}
