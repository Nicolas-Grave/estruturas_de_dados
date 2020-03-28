public class SimpleList {
  private Node header;
  private int size;

  public SimpleList() {
    this.size = 0;
  }

  public Node first() {
    return this.header;
  }

  public int size() {
    return this.size;
  }

  public Node insertFirst(int i) {
    this.header = new Node(i, this.header);
    this.size++;
    return header;
  }

  public Node insertAfter(Node n, int i) {
    Node newNode = new Node(i, n.next);
    n.next = newNode;
    return newNode;
  }

  public Node find(int i) {
    Node n = first();
    while(n.element != i) {
      n = n.next;
    }
    return n;
  }

  public String toString() {
    String out = "";
    Node n = first();
    while(n != null) {
      out += n.toString();
      n = n.next;
    }
    return out;
  }
}
