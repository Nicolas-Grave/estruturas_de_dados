import java.util.ArrayList;
import java.util.List;

class PackingContainersLiquidItems {
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

    public void addItem(Item item) {
      items.add(new Item(item.description, item.volume));
    }

    public double volumeUsed() {
      double volume = 0;
      for (Item item : items) {
        volume += item.volume;
      }
      return (double) Math.round(volume * 100.0) / 100.0;
    }
  }

  static class PackContainer {
    List<Container> containers;
    double maxContainerVolume;

    public PackContainer(double maxContainerVolume, List<Item> items) {
      this.maxContainerVolume = maxContainerVolume;
      this.containers = buildContainersByItems(items);
    }

    public List<Container> buildContainersByItems(List<Item> items) {
      List<Container> containers = new ArrayList<>();

      Container container = new Container();
      containers.add(container);

      for(Item item : items) {
        if (item.volume > this.maxContainerVolume) break;

        double volume = (container.volumeUsed() + item.volume);
        volume = Math.round(volume * 100.0) / 100.0;

        if (volume > this.maxContainerVolume) {
          container = new Container();
          containers.add(container);
        }

        container.addItem(item);
      }

      return containers;
    }

    private Container lastContainer() {
      if (containers == null || containers.isEmpty()) {
        return null;
      } else {
        return containers.get(containers.size() - 1);
      }
    }

    public boolean isBetterThan(PackContainer packContainer) {
      return (containers.size() < packContainer.containers.size()) ||
        (containers.size() == packContainer.containers.size() && lastContainer().volumeUsed() < packContainer.lastContainer().volumeUsed());
    }

    public boolean allContainersIsFull() {
      double emptySpace = 0;
      for (Container container : containers) {
        emptySpace += (container.volumeUsed() - maxContainerVolume);
      }
      return emptySpace == 0;
    }
  }

  static PackContainer bestPackContainer;
  static List<Item> items;
  static double maxContainerVolume;
  static int complete, partial, solution;

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

    System.out.println("partial:  " + partial);
    System.out.println("complete: " + complete);
    System.out.println("solution: " + solution);
  }

  private static void solve(List<Item> solveItems) {
    if (solveItems.size() == items.size()) {
      solution++;
      PackContainer packContainer = new PackContainer(maxContainerVolume, solveItems);;

      if (packContainer.allContainersIsFull()) complete++;

      if (packContainer.isBetterThan(bestPackContainer)) bestPackContainer = packContainer;
    } else {
      for (Item item : items) {
        if (!listContainsItem(solveItems, item)) {
          List<Item> nextSolveItems = new ArrayList<>(solveItems);
          nextSolveItems.add(new Item(item.description, item.volume));
          partial++;
          solve(nextSolveItems);
        }
      }
    }
  }

  private static boolean listContainsItem(List<Item> items, Item newItem) {
    boolean containsItem = false;
    for (Item item : items) {
      if (item.description.equals(newItem.description)) containsItem = true;
    }
    return containsItem;
  }

  private static void setDefaultValues() {
    maxContainerVolume = 3.3;

    items = new ArrayList<>();
    items.add(new Item("1", 1.5));
    items.add(new Item("2", 2.0));
    items.add(new Item("3", 2.3));
    items.add(new Item("4", 1.8));
    items.add(new Item("5", 0.9));

    bestPackContainer = new PackContainer(maxContainerVolume, items);
  }

  private static void displayContainers() {
    System.out.println(bestPackContainer.containers.size() + " containers were used");
    System.out.println();
    for(int i = 0; i < bestPackContainer.containers.size(); i++) {
      Container container = bestPackContainer.containers.get(i);
      System.out.println("Container #" + (i + 1) + " volume used: " + container.volumeUsed());
      for(Item item : container.items) {
        System.out.println("--- Item " + item.description + " volume " + item.volume);
      }
      System.out.println();
    }
  }
}
