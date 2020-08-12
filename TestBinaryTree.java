public class TestBinaryTree {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    BinaryNode root = tree.addRoot("Root");

    if (tree.root == null) {
      System.out.println("Root is empty");
      System.out.println("=== Expect: 'Root'");
      System.out.println("=== Got: 'null'");
    } else if (!tree.root.value.equals("Root")) {
      System.out.println("Root is not equal to 'Root'");
      System.out.println("=== Expect: 'Root'");
      System.out.println("=== Got: '" + tree.root.value + "'");
    }

    BinaryNode nodeB = null;
    try {
      nodeB = tree.addLeftChild(root, "B");
    } catch (Exception e) {
      System.out.println("Error while add left child in root");
      System.out.println(e.getMessage());
    }

    if (nodeB != null) {
      if (!nodeB.parent.value.equals(root.value)) {
        System.out.println("Node B parent is not equal to 'Root'");
        System.out.println("=== Expect: 'Root'");
        System.out.println("=== Got: '" + nodeB.parent.value + "'");
      }

      try {
        nodeB = tree.addLeftChild(root, "B");
        System.out.println("Expect erro while add child left to root");
        System.out.println("=== Expect: 'Node already have left child'");
      } catch (Exception e) {
        if (!e.getMessage().equals("Node already have left child")) {
          System.out.println("Erro while add child left to root");
          System.out.println("=== Expect: 'Node already have left child'");
          System.out.println("=== Got: '" + e.getMessage() + "'");
        }
      }
    }

    BinaryNode nodeC = null;
    try {
      nodeC = tree.addRightChild(root, "C");
    } catch (Exception e) {
      System.out.println("Error while add right child in root");
      System.out.println(e.getMessage());
    }

    if (nodeB != null) {
      BinaryNode nodeD = null;
      try {
        nodeD = tree.addRightChild(nodeB, "D");
      } catch (Exception e) {
        System.out.println("Error while add right child in nodeB");
        System.out.println(e.getMessage());
      }
    }

    if (tree.getNodesCount() != 4) {
      System.out.println("Tree doesn't have '4' nodes");
      System.out.println("=== Expect: '4'");
      System.out.println("=== Got: '" + tree.getNodesCount() + "'");
    }
  }
}
