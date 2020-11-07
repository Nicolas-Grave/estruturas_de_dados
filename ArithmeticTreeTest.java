import javax.script.ScriptException;

public class ArithmeticTreeTest {
  public static void main(String[] args) {
    ArithmeticTree tree = ArithmeticTree.createDefault();
    System.out.println("Default formula is: " + tree.formula);
    System.out.println("Serialize formula is: " + tree.serialize());

    tree.define("a", 2);
    tree.define("b", 1);

    try {
      double result = tree.evaluate();
      System.out.println("Evaluate formula is: " + result);
      System.out.println("Evaluate is correct? " + (result == 6.2));
    } catch (ScriptException e) {
      System.out.println("Impossible to solve the formula");
    }
  }
}
