public class TestOrdenedList {
    public static void main(String[] args) {
        Integer[] collection = new Integer[]{60,12,79,49,47,24,49,62,7,18,3,29,38,60,81,35,54,38,98,32,10};

        OrderedList list1 = new OrderedList();

        for (Integer integer : collection) {
            list1.insertInOrder(integer);
        }

        if (!list1.toString().equals("[3] <-> [7] <-> [10] <-> [12] <-> [18] <-> [24] <-> [29] <-> [32] <-> [35] <-> [38] <-> [38] <-> [47] <-> [49] <-> [49] <-> [54] <-> [60] <-> [60] <-> [62] <-> [79] <-> [81] <-> [98]")) {
            System.out.print("List1 don't match with sample");
        }

        for(int j = 1; j <= 10; j++) {
            list1 = new OrderedList();
            long start = System.currentTimeMillis();
            for (var i = 1; i <= 100_000; i++) {
                list1.insertInOrder(randomBetween(1, 1_000));
            }
            System.out.println("Time: " + (System.currentTimeMillis() - start) / 1_000.0);
        }
    }

    private static int randomBetween(int minimum, int maximum) {
        return (int) (Math.random() * (maximum - minimum)) + minimum;
    }
}
