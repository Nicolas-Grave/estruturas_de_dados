public class TestSimpleStack {
    public static void main(String[] args) {
        SimpleStack stack1 = new SimpleStack();

        stack1.push(1);
        stack1.push(1);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);

        if (!stack1.toString().equals("[1, 1, 1, 2, 3, 4]")) {
            printWarning("Push test: Stack 1 is not equals to [1, 1, 1, 2, 3, 4]");
        }

        if (stack1.size() != 6) {
            printWarning("Size test: Stack 1 dont has 6 elements");
        }
        
        if (stack1.pop() != 4) {
            printWarning("Pop test: Stack 1 last element is not equals to 4");
        }

        if (stack1.size() != 5) {
            printWarning("Pop and Size test: Stack 1 dont has 5 elements");
        }

        if (stack1.peek() != 3) {
            printWarning("Peek test: Stack 1 last element is not equals to 3");
        }

        if (stack1.size() != 5) {
            printWarning("Peek and Size test: Stack 1 dont has 5 elements");
        }

        while (stack1.size() != 0) {
            stack1.pop();    
        }

        if (stack1.pop() != null) {
            printWarning("Empty pop test: Stack 1 after empty pop not returned null");
        }

        for (char c : "(()())".toCharArray()) {
            if (c == '(') stack1.push(1);
            
            if (c == ')') {
                if (stack1.pop() == null) {
                    printWarning("Tentou fechar um parentes sendo que não tem mais para fechar");
                }
            }
        }

        if (stack1.size() != 0) {
            printWarning("Teve parenteses sem fechar");
        }
    }

    private static void printWarning(String message) {
        String ANSI_RESET = "";
        String ANSI_YELLOW = "";
        
        System.out.println(ANSI_YELLOW + message + ANSI_RESET);
    }
}
