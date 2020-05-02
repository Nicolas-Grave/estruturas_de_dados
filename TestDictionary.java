public class TestDictionary {
  public static void main(String[] args) {
    Dictionary dictionary = new Dictionary();

    dictionary.put(1, "um");
    dictionary.put(2, "dois");
    dictionary.put(3, "tres");
    dictionary.put(4, "quatro");
    dictionary.put(5, "cinco");

    if (!dictionary.containsKey(3)) {
      System.out.println("\nKey 3 was not find in dictionary. Check put or containsKey method.\n");
    }

    if (dictionary.get(3) != "tres") {
      System.out.println("\nValue of key 3 was different than 'tres'. Check put or get method.\n");
    }

    dictionary.put(3, "alterado");

    if (dictionary.get(3) != "alterado") {
      System.out.println("\nValue of key 3 was different than 'alterado'. Check put or get method.\n");
    }

    dictionary.remove(4);

    if (dictionary.containsKey(4)) {
      System.out.println("\nValue of key 4 was not delete. Check remove method.\n");
    }

    if (!dictionary.toString().equals("[[ 1: um ], [ 2: dois ], [ 3: alterado ], [ 5: cinco ]]")) {
      System.out.println("\nDictionary is different than expected.");
      System.out.println("Expect: [[ 1: um ], [ 2: dois ], [ 3: alterado ], [ 5: cinco ]]");
      System.out.println("Got: " + dictionary + "\n");
    }
  }
}
