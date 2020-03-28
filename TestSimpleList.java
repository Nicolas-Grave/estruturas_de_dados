public class TestSimpleList {
    public static void main(String[] args) {
        SimpleList list1 = new SimpleList();

        list1.insertFirst(1);
        list1.insertFirst(2);
        list1.insertFirst(3);
        list1.insertFirst(4);
        list1.insertFirst(5);
        list1.insertAfter(list1.find(3), 0);

        System.out.println(list1.toString());
    }
}
