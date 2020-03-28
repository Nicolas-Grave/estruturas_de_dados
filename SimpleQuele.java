import java.util.*;

public class SimpleQuele {
    private List<Integer> array;

    public SimpleQuele() {
        this.array = new ArrayList<>();
    }

    public void add(int i) {
        this.array.add(i);
    }

    public Integer remove() throws Exception {
        int value = this.array.get(0);
        this.array.remove(0);
        return value;
    }

    public Integer first() throws Exception {
        return this.array.get(0);
    }

    public int size() {
        return this.array.size();
    }

    public String toString() {
        return this.array.toString();
    }

}
