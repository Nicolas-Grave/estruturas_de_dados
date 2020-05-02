import java.util.ArrayList;

public class Dictionary {
  private static class Item {
    public int key;
    public String value;

    public Item(int k, String v) {
      this.key = k;
      this.value = v;
    }

    public String toString() {
      return "[ " + this.key + ": " + this.value + " ]";
    }
  }

  private ArrayList<Item> array;

  public Dictionary() {
    this.array = new ArrayList<>();
  }

  private Item search(int k) {
    for (Item item : this.array) {
      if (item.key == k) return item;
    }
    return null;
  }

  public void put(int k, String v) {
    Item item = search(k);

    if (item != null) {
      item.value = v;
    } else {
      array.add(new Item(k, v));
    }
  }

  public String get(int k) {
    Item item = search(k);

    if (item != null) {
      return item.value;
    } else {
      return null;
    }
  }

  public void remove(int k) {
    Item item = search(k);
    if (item != null) this.array.remove(item);
  }

  public boolean containsKey(int k) {
    return search(k) != null;
  }

  public String toString() {
    return this.array.toString();
  }
}
