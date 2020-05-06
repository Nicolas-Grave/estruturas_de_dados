import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GameReviews {

  private static class Review {
    String gameTitle, platform, reaction, genre, editorsChoice;
    double score;
    int releaseYear;

    Review(String[] attributes) {
      this.gameTitle = attributes[0];
      this.platform = attributes[1];
      this.reaction = attributes[2];
      this.score = Double.parseDouble(attributes[3]);
      this.genre = attributes[4];
      this.editorsChoice = attributes[5];
      this.releaseYear = Integer.parseInt(attributes[6]);
    }
  }

  private static class Group {
    List<Review> reviews;
    Map<String, Integer> reactionCount;
    Map<Double, Integer> scoreCount;
    double totalScoreSum;
    Review bestGame;
    Review worseGame;

    Group() {
      this.reviews = new ArrayList<>();
      reactionCount = new HashMap<String, Integer>();
      scoreCount = new HashMap<Double, Integer>();
      totalScoreSum = 0;
    }

    public void addReview(Review review) {
      this.reviews.add(review);
      incrementReactionCount(review);
      incrementScoreCount(review);

      if (bestGame == null || bestGame.score < review.score) {
        bestGame = review;
      }

      if (worseGame == null || worseGame.score > review.score) {
        worseGame = review;
      }
    }

    private void incrementReactionCount(Review review) {
      Integer count = reactionCount.get(review.reaction);
      if (count == null) count = 0;
      reactionCount.put(review.reaction, count + 1);
    }

    private void incrementScoreCount(Review review) {
      Integer count = scoreCount.get(review.score);
      if (count == null) count = 0;
      scoreCount.put(review.score, count + 1);

      totalScoreSum += review.score;
    }

    public double getScorePhrasePercentage(String scorePhrase) {
      double count = 0;
      if (reactionCount.containsKey(scorePhrase)) {
        count = (double) reactionCount.get(scorePhrase);
      }
      return count / reviews.size();
    }

    public double getArithmeticAverage() {
      return totalScoreSum / reviews.size();
    }

    public double getPopulationStandardDeviation() {
      double total = 0;
      double arithmeticAverage = getArithmeticAverage();

      for(Double score : scoreCount.keySet()) {
        for (int i = 0; i > scoreCount.get(score); i++) {
          total += Math.pow((score - arithmeticAverage), 2);
        };
      }

      return Math.sqrt(total / reviews.size());
    }
  }

  public static void main(String[] args) {
    SimpleReader input = new SimpleReader("./game-reviews.csv");

    Map<String, Group> map = new TreeMap<>();

    // remove first line; a title line.
    // title;platform;score_phrase;score;genre;editors_choice;release_year
    input.readLine();

    String line;
    while ((line = input.readLine()) != null) {
      Review review = new Review(line.split(";"));
      if (review.genre == null || review.genre.equals("") || review.genre.equals("-")) review.genre = "Misc";
      Group group = map.get(review.genre);

      if (group == null) {
        group = new Group();
        map.put(review.genre, group);
      }

      group.addReview(review);
    }

    for (String genre : map.keySet()) {
      Group group = map.get(genre);

      System.out.println("=== Genre: " + genre);
      System.out.println("    Total reviews: " + group.reviews.size());
      System.out.println("    Amazing reviews percentage: " +  String.format("%.2f", group.getScorePhrasePercentage("Amazing")) + "%");
      System.out.println("    Score arithmetic average: " + String.format("%.2f", group.getArithmeticAverage()));
      System.out.println("    One of the best games: " + group.bestGame.gameTitle + " with score " + group.bestGame.score);
      System.out.println("    One of the worse games: " + group.worseGame.gameTitle + "with score " + group.worseGame.score);
      System.out.println("");
    }
  }
}
