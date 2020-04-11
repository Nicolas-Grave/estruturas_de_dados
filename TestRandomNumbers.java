import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestRandomNumbers {
  private static List<Integer> array;
  private static int sequentialComp;
  private static int binaryComp;
  private static Long start;
  public static void main(String[] args) {
    generateArray(100_000, 1, 100_000);

    int number = array.get(new Random().nextInt(array.size()));

    sequentialComp = 0;
    start = System.currentTimeMillis();
    sequentialFind(number);
    System.out.println("  Sequential find (" + number + ") time: " + ((System.currentTimeMillis() - start) / 1000.0) + " comparations: " + sequentialComp);

    Collections.sort(array);

    sequentialComp = 0;
    start = System.currentTimeMillis();
    sequentialFind(number);
    System.out.println("  Ordened sequential find (" + number + ") time: " + ((System.currentTimeMillis() - start) / 1000.0) + " comparations: " + sequentialComp);

    binaryComp = 0;
    start = System.currentTimeMillis();
    binaryFind(number);
    System.out.println("  Ordened binary find (" + number + ") time: " + ((System.currentTimeMillis() - start) / 1000.0) + " comparations: " + binaryComp);
  }

  private static void generateArray(int range, int min, int max) {
    Random rng = new Random();
    array = new ArrayList<>();

    for(int i = 0; i < range; i++) {
      array.add(rng.nextInt(max - min + 1) + min);
    }
  }

  private static void sequentialFind(int number) {
    for (int i : array) {
      sequentialComp++;
      if (i == number) { break; }
    }
  }

  private static void binaryFind(int number) {
    int lowIndex = 0;
    int highIndex = array.size();
    int midIndex;

    while (lowIndex <= highIndex) {
      midIndex = (lowIndex + highIndex) / 2;
      binaryComp++;
      if (number == array.get(midIndex)) { break; }
      binaryComp++;
      if (number < array.get(midIndex)) { highIndex = midIndex - 1; }
      else { lowIndex = midIndex + 1; }
    }
  }
}
