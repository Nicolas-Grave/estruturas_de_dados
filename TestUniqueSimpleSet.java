public class TestUniqueSimpleSet {
    public static void main(String[] args) {
        UniqueSimpleSet set1 = new UniqueSimpleSet();
        UniqueSimpleSet set2 = new UniqueSimpleSet();
        UniqueSimpleSet set3 = new UniqueSimpleSet();

        set1.add("A");
        set1.add("A");
        set1.add("A");
        set1.add("B");
        set1.add("C");
        set1.add("D");

        if (!set1.toString().equals("[A, B, C, D]")) {
            printWarning("Uniq teste: Set 1 is not equals to [A, B, C, D]");
        }        

        if (set1.size() != 4) {
            printWarning("Size test: Set 1 dont has 4 elements");
        }
        
        set1.remove("A");

        if (!set1.toString().equals("[B, C, D]")) {
            printWarning("Remove test: Set 1 is not equals to [B, C, D]");
        }

        if (!set1.contains("B")) {
            printWarning("Contains test: Set 1 dont contains letter B");
        }

        set2.add("B");
        set2.add("C");
        set2.add("D");

        if (!set1.equals(set2)) {
            printWarning("Equals test: Set 1 is not equals to set 2");
        }

        set2.add("A");
        set2.add("E");

        set1.addAll(set2);

        if (!set1.toString().equals("[A, B, C, D, E]")) {
            printWarning("Add all test: Set 1 is not equals to [A, B, C, D, E]");
        }

        set3 = set1.copy();

        set1.add("G");
        set2.add("Z");
        set3.add("F");

        if (!set1.union(set3).toString().equals("[A, B, C, D, E, F, G]")) {
            printWarning("Union test: Set 1 union with set 3 is not equals to [A, B, C, D, E, F, G]");
        }

        if (!set1.intersections(set3).toString().equals("[A, B, C, D, E]")) {
            printWarning("Intersections test: Set 1 intersections with set 3 is not equals to [A, B, C, D, E]");
        }

        if (!set1.complements(set3).toString().equals("[G]")) {
            printWarning("Complements test: Set 1 complements with set 3 is not equals to [G]");
        }

        if (!set2.difference(set1.union(set3)).toString().equals("[F, G, Z]")) {
            printWarning("Difference test: Set 2 difference with union of set 1 and 3 is not equals to [F, G, Z]");   
        }

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Set 3: " + set3);
    }

    private static void printWarning(String message) {
        String ANSI_RESET = "";
        String ANSI_YELLOW = "";
        
        System.out.println(ANSI_YELLOW + message + ANSI_RESET);
    }
}
