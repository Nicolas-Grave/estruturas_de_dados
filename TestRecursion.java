public class TestRecursion {
  public static void main(String[] args) {
    System.out.println("Fatorial: " + fatorial(5));
    System.out.println("");
    System.out.println("Fibonacci: " + fibonacci(12));
    System.out.println("");
    System.out.println("Binary:");
    binary(3, "");
  }

  public static int fatorial(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n * fatorial(n - 1);
    }
  }

  public static int fibonacci(int n) {
    if (n == 0 || n == 1) {
      return n;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  public static void binary(int n, String s) {
    if (n == 0) {
      System.out.println(s);
    } else {
      binary(n - 1, s + "0");
      binary(n - 1, s + "1");
    }
  }
}
