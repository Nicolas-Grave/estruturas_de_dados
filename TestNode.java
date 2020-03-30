public class TestNode {
    public static void main(String[] args) {
        Node a = new Node(1, null);
        Node b = new Node(2, null);
        Node c = new Node(3, null);

        a.next = b;
        b.next = c;

        Node n = a;
        while(n != null) {
        System.out.print(n);
        n = n.next;
        }

        System.out.println("");
    }
}
