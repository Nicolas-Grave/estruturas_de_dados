import java.util.*;

public class SimpleSet {

    protected final ArrayList<String> array;

    public SimpleSet() {
        this.array = new ArrayList<String>();
    }

    public void add(final String e) {
        array.add(e);
    }

    public boolean contains(final String e) {
        return array.contains(e);
    }

    public void remove(final String e) {
        array.remove(e);
    }

    public int size() {
        return array.size();
    }

    public String toString() {
        Collections.sort(array);
        return array.toString();
    }

    public boolean equals(final SimpleSet set) {
        return toString().equals(set.toString());
    }
}
