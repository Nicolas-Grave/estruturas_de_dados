public class TestSimpleQuele {
    public static void main(String[] args) {
        SimpleQuele quele1 = new SimpleQuele();

        quele1.add(1);
        quele1.add(4);
        quele1.add(7);
        quele1.add(2);
        quele1.add(3);
        quele1.add(8);

        if (!quele1.toString().equals("[1, 4, 7, 2, 3, 8]")) {
            printWarning("Add test: Quele 1 is not equals to [1, 4, 7, 2, 3, 8]");
        }

        if (quele1.size() != 6) {
            printWarning("Size test: Quele 1 dont has 6 elements");
        }

        try {
            if (quele1.remove() != 1) {
                printWarning("Remove test: Quele 1 last element is not equals to 1");
            }
        } catch (Exception ex) {
            printWarning("Erro while get first element that must be iguals to 1");
        }

        if (quele1.size() != 5) {
            printWarning("Remove and Size test: Quele 1 dont has 5 elements");
        }

        try {
            if (quele1.first() != 4) {
                printWarning("First test: Quele 1 last element is not equals to 4");
            }
        } catch (Exception ex) {
            printWarning("Erro while get first element that must be iguals to 4");
        }

        if (quele1.size() != 5) {
            printWarning("First and Size test: Quele 1 dont has 5 elements");
        }

        while (quele1.size() != 0) {
            try {
                quele1.remove();
            } catch (Exception ex) {
                printWarning("Erro while removing all elements from quele 1");
            }
        }

        try {
            quele1.remove();
            printWarning("Empty remove test: Quele 1 after empty remove not returned exception");
        } catch (Exception ex) {

        }
    }

    private static void printWarning(String message) {
        String ANSI_RESET = "";
        String ANSI_YELLOW = "";

        System.out.println(ANSI_YELLOW + message + ANSI_RESET);
    }
}
