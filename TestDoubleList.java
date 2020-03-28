public class TestDoubleList {
    public static void main(String[] args) {
        DoubleList list1 = new DoubleList();

        list1.insertFirst(1);
        list1.insertFirst(3);
        list1.insertLast(0);
        list1.insertLast(-1);
        list1.insertAfter(list1.find(3), 2);
        list1.insertAfter(list1.find(-1), -3);
        list1.insertBefore(list1.find(-3), -2);
        list1.insertBefore(list1.find(3), 4);

        System.out.println(list1.toString());
        System.out.println(list1.invertToString());

        if (!list1.toString().equals("[3] <-> [2] <-> [1] <-> [0] <-> [-1] <-> [-2] <-> [-3]")) {
            System.out.println("To string list don't match");
        }
    }
}
