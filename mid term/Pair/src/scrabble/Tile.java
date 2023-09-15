package scrabble;

import java.util.Objects;

public class Tile {
  private String letter;
  private final int value;

  public Tile(String letter, int value) {
    if (letter == null || letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
      throw new IllegalArgumentException("Invalid input");
    }
    this.letter = letter.toUpperCase();
    this.value = value;
  }

  public String getLetter() {
    return this.letter;
  }

  public int getValue() {
    return this.value;
  }

  public boolean isVowel() {
    String vowel = "AEIOU";
    return vowel.contains(this.letter);
  }

  @Override
  public String toString() {
    return this.getLetter() + ":" + this.getValue();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (this.getClass() != other.getClass()) {
      return false;
    }
    Tile Other = (Tile) other;
    if (Objects.equals(this.getLetter(), Other.getLetter()) && this.getValue() == Other.getValue()) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.letter, this.value);
  }
}


