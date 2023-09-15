package chess;

/**
 * This class represents a Rook chess piece.
 */
public class Rook extends piece {
  /**
   * Constructor for Rook chess piece.
   * @param row the row position of Rook.
   * @param col the column position of Rook.
   * @param color the color of Rook.
   */
  public Rook(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    Help.checkValidPosition(row, col);
    if (this.row == row && this.col == col) {
      return false;
    }

    if (this.row == row || this.col == col) {
      return true;
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    Help.checkValidPosition(piece.getRow(), piece.getColumn());
    return canMove(piece.getRow(), piece.getColumn()) && this.color != piece.getColor();
  }
}
