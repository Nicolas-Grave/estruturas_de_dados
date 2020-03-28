import java.util.*;

public class SimpleStack {
    private List<Integer> array;

    public SimpleStack() {
        this.array = new ArrayList<>();
    }

    public void push(int i) {
        this.array.add(i);
    }

    public Integer pop() {
        int lastIndex = size() - 1;
        
        if (lastIndex >= 0) {
            int i = this.array.get(lastIndex);
            this.array.remove(lastIndex);
            return i;
        } else {
            return null;
        }
    }

    public Integer peek () {
        int lastIndex = size() - 1;
        
        if (lastIndex >= 0) {
            int i = this.array.get(lastIndex);
            return i;
        } else {
            return null;
        }
    }

    public int size() {
        return this.array.size();
    }

    public String toString() {
        return this.array.toString();
    }

}