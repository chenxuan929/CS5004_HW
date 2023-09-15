package chess;

/**
 * This is a abstract class implements ChessPiece.
 */
public abstract class piece implements ChessPiece {
  protected int row;
  protected int col;

  protected Color color;

  /**
   * abstract class constructor for piece.
   * @param row the row position if chess piece.
   * @param col the column position chess piece.
   * @param color the color chess piece.
   */
  public piece(int row, int col, Color color) {
    Help.checkValidPosition(row, col);
    this.row = row;
    this.col = col;
    this.color = color;
  }

  /**
   * Get the row position of the chess piece.
   * @return the row position of the chess piece.
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * Get the column of the chess piece.
   * @return the column of the chess piece.
   */
  @Override
  public int getColumn() {
    return this.col;
  }

  /**
   * Get the color of the chess piece.
   * @return the color of the chess piece.
   */
  @Override
  public Color getColor() {
    return this.color;
  }
}
