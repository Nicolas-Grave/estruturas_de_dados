public class Node {

  public int element;
  public Node next;

  public Node(int e, Node n) {
    this.element = e;
    this.next    = n;
  }

  public String toString() {
    if (this.next != null) {
      return "[" + this.element + "] -> ";
    } else {
      return "[" + this.element + "]";
    }
  }
}
