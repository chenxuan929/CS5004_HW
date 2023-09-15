package scrabble;

import java.util.*;
import java.util.function.Predicate;

public class ScrabbleBag {
  private Map<String, Integer> mapValue;
  private List<Tile> listTile;


  public ScrabbleBag() {
    this.mapValue = new HashMap<>();
    this.listTile = new ArrayList<>();
  }

  public void addTile(String aLetter, int value) {
    addTile(new Tile(aLetter, value));
  }

  public void addTile(Tile aTile) {
    char l = Character.toUpperCase(aTile.getLetter().charAt(0));
    if (!Character.isLetter(l) || !mapValue.containsKey(l)) {
      throw new IllegalArgumentException("Invalid letter");
    }
    int value = aTile.getValue();
    for (Tile n : listTile) {
      if (n.getLetter().equalsIgnoreCase(aTile.getLetter()) && n.getValue() != value) {
        throw new IllegalArgumentException("Same letter already occur");
      }
    }

    listTile.add(aTile);
  }

  public Tile removeTile(String aLetter) {
    for (Tile n : listTile) {
      if (n.getLetter().equalsIgnoreCase(aLetter)) {
        listTile.remove(n);
        return n;
      }
    }
    return null;
  }

  public List<Tile> getAllTiles() {
    return new ArrayList<>(listTile);
  }

  public List<Tile> filter(Predicate<Tile> pred) {
    List<Tile> filteredTiles = new ArrayList<>();
    for (Tile tile : listTile) {
      if (pred.test(tile)) {
        filteredTiles.add(tile);
      }
    }
    return filteredTiles;
  }
}

