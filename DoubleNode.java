public class DoubleNode {
    public DoubleNode previous;
    public int        element;
    public DoubleNode next;

    public DoubleNode(DoubleNode p, int e, DoubleNode n) {
        this.previous = p;
        this.element  = e;
        this.next     = n;
    }

    public String toString() {
        return "[" + this.element + "]";
    }
}
