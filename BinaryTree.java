public class BinaryTree {
  public BinaryNode root;

  public BinaryTree() {}

  public BinaryTree(String value) {
    this.root = new BinaryNode(value);
  }

  public BinaryNode addRoot(String value) {
    this.root = new BinaryNode(value);
    return root;
  }

  public BinaryNode addLeftChild(BinaryNode node, String value) throws Exception {
    if (node.left == null) {
      BinaryNode newNode = new BinaryNode(value, node);
      node.left = newNode;
      return newNode;
    } else {
      throw new Exception("Node already have left child");
    }
  }

  public BinaryNode addRightChild(BinaryNode node, String value) throws Exception {
    if (node.right == null) {
      BinaryNode newNode = new BinaryNode(value, node);
      node.right = newNode;
      return newNode;
    } else {
      throw new Exception("Node already have right child");
    }
  }

  public int getNodesCount() {
    return root.getChildrenCount() + 1;
  }

  public int getExternalNodesCount() {
    return root.getExternalChildrenCount();
  }

  public int getLevelsCount() {
    return countLevels(root, 0);
  }

  private int countLevels(BinaryNode node, int parentLevel) {
    int leftLevel = parentLevel;
    int rightLevel = parentLevel;

    if (node.left != null) leftLevel = countLevels(node.left, leftLevel + 1);
    if (node.right != null) rightLevel = countLevels(node.right, rightLevel + 1);

    return (leftLevel > rightLevel ? leftLevel : rightLevel);
  }

  public String printPreOrder() {
    return printPreOrder(root);
  }

  private String printPreOrder(BinaryNode node) {
    String print = "";
    print += "[" + node.value + "]";
    if (node.left != null) print += " - " + printPreOrder(node.left);
    if (node.right != null) print += " - " + printPreOrder(node.right);
    return print;
  }

  public String printPosOrder() {
    return printPosOrder(root);
  }

  private String printPosOrder(BinaryNode node) {
    String print = "";
    if (node.left != null) print += printPosOrder(node.left) + " - ";
    if (node.right != null) print += printPosOrder(node.right) + " - ";
    print += "[" + node.value + "]";
    return print;
  }

  public String printInterOrder() {
    return printInterOrder(root);
  }

  public String printInterOrder(BinaryNode node) {
    String print = "";
    if (node.left != null) print += printInterOrder(node.left) + " - ";
    print += "[" + node.value + "]";
    if (node.right != null) print += " - " + printInterOrder(node.right);
    return print;
  }
}
