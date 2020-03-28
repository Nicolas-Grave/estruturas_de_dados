public class DoubleList {
  private DoubleNode header, trailer;
  private int size;

  public DoubleList() {
    this.size = 0;
  }

  public DoubleNode first() {
    return this.header;
  }

  public DoubleNode last() {
    return this.trailer;
  }

  public int size() {
    return this.size;
  }

  public DoubleNode insertFirst(int i) {
    this.header = new DoubleNode(null, i, this.header);
    if (this.trailer == null) { this.trailer = this.header; }
    if (this.header.next != null) { this.header.next.previous = this.header; }
    this.size++;
    return this.header;
  }

  public DoubleNode insertLast(int i) {
    this.trailer = new DoubleNode(this.trailer, i, null);
    if (this.header == null) { this.header = this.trailer; }
    if (this.trailer.previous != null) { this.trailer.previous.next = this.trailer; }
    this.size++;
    return this.trailer;
  }

  public DoubleNode insertBefore(DoubleNode n, int i) {
    if (n == null) { return null; }
    DoubleNode newNode = new DoubleNode(n.previous, i, n);
    n.previous = newNode;
    if (newNode.previous == null ) {
      this.header = newNode;
    } else {
      newNode.previous.next = newNode;
    }
    return newNode;
  }

  public DoubleNode insertAfter(DoubleNode n, int i) {
    if (n == null) { return null; }
    DoubleNode newNode = new DoubleNode(n, i, n.next);
    n.next = newNode;
    if (newNode.next == null ) {
      this.trailer = newNode;
    } else {
      newNode.next.previous = newNode;
    }
    return newNode;
  }

  public DoubleNode find(int i) {
    DoubleNode n = this.header;
    while(n != null && n.element != i) { n = n.next; }
    return n;
  }

  public String toString() {
    String out = "";
    DoubleNode n = this.header;
    while(n != null) {
      out += n.toString();
      n = n.next;
      if (n != null) { out += " <-> "; }
    }
    return out;
  }

  public String invertToString() {
    String out = "";
    DoubleNode n = this.trailer;
    while(n != null) {
      out += n.toString();
      n = n.previous;
      if (n != null) { out += " <-> "; }
    }
    return out;
  }
}
