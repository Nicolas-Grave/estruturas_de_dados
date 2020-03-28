public class Base {
    protected int    i;
    protected double d;

    public Base() {
        this.i = 1;
        this.d = 2.345;
    }

    public void print() {
        System.out.println("i=" + i + " d= " + d);
    }
}
