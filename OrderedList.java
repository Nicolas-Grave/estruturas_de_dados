public class OrderedList extends DoubleList {

    public void insertInOrder(int i) {
        DoubleNode n = this.first();

        if (n == null) {
            insertFirst(i);
        } else if (last().element <= i) {
            insertLast(i);
        } else {
            while(n.element < i) { n = n.next; }
            insertBefore(n, i);
        }
    }

}
