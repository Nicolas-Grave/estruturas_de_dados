import java.util.ArrayList;
import java.util.List;

class Project2Task2 {
  static class Item {
    public String description;
    public double volume;

    public Item(String description, double volume) {
      this.description = description;
      this.volume = volume;
    }

    public String toString() {
      return description;
    }
  }

  static class Container {
    public List<Item> items;

    public Container() {
      this.items = new ArrayList<>();
    }

    public double volumeUsed() {
      double volume = 0;
      for (Item item : items) {
        volume += item.volume;
      }
      return volume;
    }
  }

  static List<Container> bestContainers;
  static List<Item> items;
  static double containerVolume;

  public static void main(String[] args) {
    setDefaultValues();

    /*
      Best default solution:
      Container 1: volume 3.3, items 1 and 4
      Container 2: volume 3.2, items 3 and 5
      Container 2: volume 2.0, items 2
    */

    solve(new ArrayList<>());
    displayContainers();
  }

  private static void solve(List<Item> solveItems) {
    if (solveItems.size() == items.size()) {
      List<Container> containers = buildSolveContainers(solveItems);

      if (bestContainers.size() == 0 || bestContainers.size() > containers.size()) {
        bestContainers = containers;
      } else if (bestContainers.size() == containers.size() && bestContainers.get(bestContainers.size() - 1).volumeUsed() > containers.get(containers.size() - 1).volumeUsed()) {
        bestContainers = containers;
      }
    } else {
      for (Item item : items) {
        if (!listContainerItem(solveItems, item)) {
          List<Item> nextSolveItems = new ArrayList<>(solveItems);
          nextSolveItems.add(new Item(item.description, item.volume));
          solve(nextSolveItems);
        }
      }
    }
  }

  private static boolean listContainerItem(List<Item> items, Item item) {
    boolean containsItem = false;
    for (Item _item : items) {
      if (_item.description.equals(item.description)) containsItem = true;
    }
    return containsItem;
  }

  private static List<Container> buildSolveContainers(List<Item> items) {
    List<Container> containers = new ArrayList<>();
    containers.add(new Container());

    for(Item item : items) {
      Container lastContainer = containers.get(containers.size() - 1);

      if ((lastContainer.volumeUsed() + item.volume) > containerVolume) {
        containers.add(new Container());
        lastContainer = containers.get(containers.size() - 1);
      }

      lastContainer.items.add(new Item(item.description, item.volume));
    }

    return containers;
  }

  private static void setDefaultValues() {
    bestContainers = new ArrayList<>();
    containerVolume = 3.3;

    items = new ArrayList<>();
    items.add(new Item("1", 1.5));
    items.add(new Item("2", 2.0));
    items.add(new Item("3", 2.3));
    items.add(new Item("4", 1.8));
    items.add(new Item("5", 0.9));
  }

  private static void displayContainers() {
    System.out.println(bestContainers.size() + " containers were used");
    System.out.println();
    for(int i = 0; i < bestContainers.size(); i++) {
      Container container = bestContainers.get(i);
      System.out.println("Container #" + (i + 1) + " volume used: " + container.volumeUsed());
      for(Item item : container.items) {
        System.out.println("--- Item " + item.description + " volume " + item.volume);
      }
      System.out.println();
    }
  }
}
