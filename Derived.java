public class Derived extends Base {
    private char c;

    public Derived() {
        this.c = 'C';
        this.i = 6;
    }

    public String toString() {
        return "i=" + i + " d= " + d + " c=" + c;
    }
}
