public class SimpleList {
    private Node header;
    private int size;

    public SimpleList() {
        this.size = 0;
    }

    public Node first() {
        return this.header;
    }

    public Node last() {
        Node n = this.header;
        if (n != null) { return null; }
        while(n.next != null) { n = n.next; }
        return n;
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
        if (n == null) { return null; }
        Node newNode = new Node(i, n.next);
        n.next = newNode;
        return newNode;
    }

    public Node find(int i) {
        Node n = this.header;
        while(n != null && n.element != i) { n = n.next; }
        return n;
    }

    public String toString() {
        String out = "";
        Node n = this.header;
        while(n != null) {
        out += n.toString();
        n = n.next;
        }
        return out;
    }
}
