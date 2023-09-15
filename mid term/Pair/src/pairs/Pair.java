package pairs;

import java.util.Objects;

public class Pair<X,Y> {
  private final X first;
  private final Y second;

  public Pair(X first, Y second) {
    this.first = first;
    this.second = second;
  }

  public X getFirst() {
    return first;
  }
  public Y getSecond() {
    return second;
  }

  @Override
  public String toString() {
    return "(" + this.getFirst() + ", " + this.getSecond() + ")";
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (this.getClass() != other.getClass()) {
      return false;
    }
    Pair Other = (Pair) other;
    if (this.getFirst() == Other.getFirst() && this.getSecond() == Other.getSecond()) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.first, this.second);
  }
}
