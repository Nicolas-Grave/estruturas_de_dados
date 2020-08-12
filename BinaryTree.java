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
}
