public class BinaryNode {
  public String value;
  public BinaryNode parent;
  public BinaryNode right;
  public BinaryNode left;

  public BinaryNode(String value) {
    this.value = value;
  }

  public BinaryNode(String value, BinaryNode parent) {
    this.value = value;
    this.parent = parent;
  }

  public BinaryNode(String value, BinaryNode parent, BinaryNode right, BinaryNode left) {
    this.value = value;
    this.parent = parent;
    this.right = right;
    this.left = left;
  }

  public boolean isInternal() {
    return this.left != null || this.right != null;
  }

  public boolean isExternal() {
    return this.left == null && this.right == null;
  }

  public boolean isRoot() {
    return this.parent == null;
  }

  public String toString() {
    return value;
  }

  public int getChildrenCount() {
    int children = 0;
    if (this.left != null) children += (left.getChildrenCount() + 1);
    if (this.right != null) children += (right.getChildrenCount() + 1);
    return children;
  }

  public int getExternalChildrenCount() {
    int children = 0;

    if (this.left != null) {
      if (this.left.isExternal()) {
        children += 1;
      } else {
        children += this.left.getExternalChildrenCount();
      }
    }

    if (this.right != null) {
      if (this.right.isExternal()) {
        children += 1;
      } else {
        children += this.right.getExternalChildrenCount();
      }
    }

    return children;
  }

  public int getParentsCount() {
    if (isRoot()) return 0;
    return parent.getParentsCount() + 1;
  }
}
