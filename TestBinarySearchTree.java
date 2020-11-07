public class TestBinarySearchTree {
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();

    tree.add("4");
    tree.add("6");
    tree.add("2");
    tree.add("3");
    tree.add("5");
    tree.add("1");
    tree.add("7");
    tree.add("8");

    if (!tree.minValue().equals("1")) {
      System.out.println("Method minValue dont match");
      System.out.println("=== Expect: '1'");
      System.out.println("=== Got: '" + tree.minValue() + "'");
    }

    if (!tree.hasValue("3")) {
      System.out.println("Method hasValue dont find value '3'");
      System.out.println("=== Expect: 'true'");
      System.out.println("=== Got: 'false'");
    }

    if (tree.hasValue("0")) {
      System.out.println("Method hasValue should not have found '0'");
      System.out.println("=== Expect: 'false'");
      System.out.println("=== Got: 'true'");
    }

    if (tree.hasValue(null)) {
      System.out.println("Method hasValue should not have found null");
      System.out.println("=== Expect: 'false");
      System.out.println("=== Got: 'true'");
    }

    if (!tree.printPreOrder().equals("[4] - [2] - [1] - [3] - [6] - [5] - [7] - [8]")) {
      System.out.println("Tree pre order don't match");
      System.out.println("=== Expect: '[4] - [2] - [1] - [3] - [6] - [5] - [7] - [8]'");
      System.out.println("=== Got: '" + tree.printPreOrder() + "'");
    }

    if (!tree.isBinarySearchTree()) {
      System.out.println("Tree is not binary search");
      System.out.println("=== Expect: 'true'");
      System.out.println("=== Got: 'false'");
    }

    if (!tree.remove("4") || tree.hasValue("4")) {
      System.out.println("Tree dont remove value '4'");
      System.out.println("=== Expect: 'true'");
      System.out.println("=== Got: 'false'");
    }

    if (!tree.printPreOrder().equals("[5] - [2] - [1] - [3] - [6] - [7] - [8]")) {
      System.out.println("Tree pre order don't match");
      System.out.println("=== Expect: '[5] - [2] - [1] - [3] - [6] - [7] - [8]'");
      System.out.println("=== Got: '" + tree.printPreOrder() + "'");
    }
  }
}
