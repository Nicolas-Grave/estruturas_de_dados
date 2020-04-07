import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        SimpleReader input = new SimpleReader("./log-large.txt");

        Pattern pattern = Pattern.compile("user \"(\\w+)\"|user (\\w+)");

        List<String> users = new ArrayList<>();

        String line;
        while ((line = input.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String match = matcher.group(1);
                if (match == null) match = matcher.group(2);

                if (!users.contains(match)) {
                    users.add(match);
                }
            }
        }

        System.out.println("Found " + users.size() +" unique users.");
    }
}
