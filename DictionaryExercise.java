import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictionaryExercise {
  public static void exercise1(String text) {
    System.out.println("Exercise 1");

    Map<String, Integer> map = new TreeMap<>();

    Pattern pattern = Pattern.compile("([A-Z]|[a-z])");

    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      String match = matcher.group(1);
      Integer count = map.get(match);
      if (count == null) count = 0;
      map.put(match, count + 1);
    }

    for(String key : map.keySet()) {
      System.out.println(key + " : " + map.get(key));
    }
    System.out.println("");
  }

  public static void exercise2(String[] list) {
    System.out.println("Exercise 2");

    Map<Integer, String> map = new TreeMap<>();

    for (String word : list) {
      int length = word.length();

      if (!map.containsKey(length)) map.put(length, word);
    }

    System.out.println(map.values().toString());
    System.out.println("");
  }

  public static void exercise3() {
    System.out.println("Exercise 3");

    Map<String, String> map = new TreeMap<>();
    SimpleReader input = new SimpleReader("./packages.txt");

    String line;
    while ((line = input.readLine()) != null) {
      String cep[] = line.split(" ");
      if (!map.containsKey(cep[0])) map.put(cep[0], cep[1]);
    }

    for(String key : map.keySet()) {
      System.out.println(key + " : " + map.get(key));
    }

    System.out.println("" + map.keySet().size() + " unique destinations" );
    System.out.println("");
  }

  // Usando o mesmo arquivo, resolva o seguinte problema: você precisa somar o valor dos pacotes para cada código postal distinto.
  // Em seguida, o resultado de cada código postal deve ser impresso na tela, em ordem crescente para os códigos.
  public static void exercise4() {
    System.out.println("Exercise 4");

    Map<String, Double> map = new TreeMap<>();
    SimpleReader input = new SimpleReader("./packages.txt");

    String line;
    while ((line = input.readLine()) != null) {
      String cep = line.split(" ")[0];
      double amount = Double.parseDouble(line.split(" ")[1]);
      Double total = map.get(cep);
      if (total == null) total = 0.0;
      Double amountRound = (double) ((int) ((total + amount) * 100)) / 100;
      map.put(cep, amountRound);
    }

    for(String key : map.keySet()) {
      System.out.println(key + " : " + map.get(key));
    }
    System.out.println("");
  }
}
