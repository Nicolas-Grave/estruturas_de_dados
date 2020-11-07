public class BinarySearchTree extends BinaryTree {

  public BinaryNode add(String value) {
    BinaryNode node = new BinaryNode(value);

    if (root == null) {
      root = node;
    } else {
      addNodeToBestParet(node);
    }

    return node;
  }

  public boolean remove(String value) {
    // TODO:
    return false;
  }

  private void addNodeToBestParet(BinaryNode node) {
    BinaryNode currentNode = root;

    while (node.parent == null) {
      if (currentNode.value.compareTo(node.value) >= 0) {
        if (currentNode.left == null) {
          node.parent = currentNode;
          currentNode.left = node;
        } else {
          currentNode = currentNode.left;
        }
      } else {
        if (currentNode.right == null) {
          node.parent = currentNode;
          currentNode.right = node;
        } else {
          currentNode = currentNode.right;
        }
      }
    }
  }

  public String minValue() {
    return minValue(root);
  }

  public String minValue(BinaryNode node) {
    if (node.left != null) {
      return minValue(node.left);
    } else {
      return node.value;
    }
  }

  public boolean hasValue(String value) {
    return findNodeByValue(root, value) != null;
  }

  public BinaryNode findNodeByValue(BinaryNode node, String value) {
    if (node == null || node.value == null || value == null) {
      return null;
    } else if (node.value.equals(value)) {
      return node;
    } else if (node.value.compareTo(value) > 0 && node.left != null) {
      return findNodeByValue(node.left, value);
    } else if (node.value.compareTo(value) < 0 && node.right != null) {
      return findNodeByValue(node.right, value);
    } else {
      return null;
    }
  }

  public boolean isBinarySearchTree() {
    if (root == null) {
      return true;
    } else {
      return isBinarySearchTree(root);
    }
  }

  public boolean isBinarySearchTree(BinaryNode node) {
    return (node.left == null || node.parent == null || (node.left.value.compareTo(node.parent.value) < 0 && isBinarySearchTree(node.left))) &&
      (node.right == null || node.parent == null || (node.right.value.compareTo(node.parent.value) > 0 && isBinarySearchTree(node.right)));
  }
}
