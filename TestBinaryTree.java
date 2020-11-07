public class TestBinaryTree {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    BinaryNode root = tree.addRoot("Root");
    BinaryNode nodeB = null;
    BinaryNode nodeD = null;
    BinaryNode nodeE = null;

    if (tree.root == null) {
      System.out.println("Root is empty");
      System.out.println("=== Expect: 'Root'");
      System.out.println("=== Got: 'null'");
    } else if (!tree.root.value.equals("Root")) {
      System.out.println("Root is not equal to 'Root'");
      System.out.println("=== Expect: 'Root'");
      System.out.println("=== Got: '" + tree.root.value + "'");
    }

    try {
      nodeB = tree.addLeftChild(root, "B");
    } catch (Exception e) {
      System.out.println("Error while add left child in root");
      System.out.println(e.getMessage());
    }

    if (nodeB != null && !nodeB.parent.value.equals(root.value)) {
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

    try {
      tree.addRightChild(root, "C");
    } catch (Exception e) {
      System.out.println("Error while add right child in root");
      System.out.println(e.getMessage());
    }

    try {
      nodeD = tree.addRightChild(nodeB, "D");
    } catch (Exception e) {
      System.out.println("Error while add right child in nodeB");
      System.out.println(e.getMessage());
    }

    try {
      nodeE = tree.addRightChild(nodeD, "E");
    } catch (Exception e) {
      System.out.println("Error while add right child in nodeD");
      System.out.println(e.getMessage());
    }

    if (tree.getNodesCount() != 5) {
      System.out.println("Tree doesn't have '5' nodes");
      System.out.println("=== Expect: '5'");
      System.out.println("=== Got: '" + tree.getNodesCount() + "'");
    }

    if (tree.getLevelsCount() != 3) {
      System.out.println("Tree doesn't have '3' lavels");
      System.out.println("=== Expect: '3'");
      System.out.println("=== Got: '" + tree.getLevelsCount() + "'");
    }

    if (nodeB != null && nodeB.getParentsCount() != 1) {
      System.out.println("Node B doesn't have '1' parent");
      System.out.println("=== Expect: '1'");
      System.out.println("=== Got: '" + nodeB.getParentsCount() + "'");
    }

    if (nodeE != null && nodeE.getParentsCount() != 3) {
      System.out.println("Node E doesn't have '3' parents");
      System.out.println("=== Expect: '3'");
      System.out.println("=== Got: '" + nodeE.getParentsCount() + "'");
    }

    if (tree.getExternalNodesCount() != 2) {
      System.out.println("Tree doesn't have '2' external nodes");
      System.out.println("=== Expect: '2'");
      System.out.println("=== Got: '" + tree.getExternalNodesCount() + "'");
    }

    if (!tree.printPreOrder().equals("[Root] - [B] - [D] - [E] - [C]")) {
      System.out.println("Tree pre order don't match");
      System.out.println("=== Expect: '[Root] - [B] - [D] - [E] - [C]'");
      System.out.println("=== Got: '" + tree.printPreOrder() + "'");
    }

    if (!tree.printPosOrder().equals("[E] - [D] - [B] - [C] - [Root]")) {
      System.out.println("Tree pos order don't match");
      System.out.println("=== Expect: '[E] - [D] - [B] - [C] - [Root]'");
      System.out.println("=== Got: '" + tree.printPosOrder() + "'");
    }

    if (!tree.printInterOrder().equals("[B] - [D] - [E] - [Root] - [C]")) {
      System.out.println("Tree pos order don't match");
      System.out.println("=== Expect: '[B] - [D] - [E] - [Root] - [C]'");
      System.out.println("=== Got: '" + tree.printInterOrder() + "'");
    }
  }
}
