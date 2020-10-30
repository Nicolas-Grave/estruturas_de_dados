public class PackingBidimensionalCornerItems {
  static class Grid {
    static final String OBSTRUCTION = "#";
    static final String BLANK = "-";

    String[][] grid;

    public Grid(Grid object) {
      if (object.grid.length > 0 && object.grid[0].length > 0) {
        grid = new String[object.grid.length][object.grid[0].length];
        for (int line = 0; line < object.grid.length; line++) {
          for (int column = 0; column < object.grid[line].length; column++) {
            grid[line][column] = object.grid[line][column];
          }
        }
      } else {
        grid = new String[0][0];
      }
    }

    public Grid(int lines, int columns) {
      grid = new String[lines][columns];
      fillBlankSpaces();
    }

    public void fillBlankSpaces() {
      for (int line = 0; line < grid.length; line++) {
        for (int column = 0; column < grid[line].length; column++) {
          grid[line][column] = BLANK;
        }
      }
    }

    public int blankSpacesCount() {
      int count = 0;
      for (int line = 0; line < grid.length; line++) {
        for (int column = 0; column < grid[line].length; column++) {
          if (grid[line][column].equals(BLANK)) count++;
        }
      }
      return count;
    }

    public void addObstruction(int line, int column) {
      grid[line][column] = OBSTRUCTION;
    }

    public boolean addItemCornerTopLeft(String item) {
      return addItemCornerToGrid(item, +1, +1);
    }

    public boolean addItemCornerTopRight(String item) {
      return addItemCornerToGrid(item, +1, -1);
    }
    public boolean addItemCornerBottomLeft(String item) {
      return addItemCornerToGrid(item, -1, +1);
    }
    public boolean addItemCornerBottomRight(String item) {
      return addItemCornerToGrid(item, -1, -1);
    }

    private boolean addItemCornerToGrid(String item, int lineOffset, int columnOffset) {
      boolean itemAdded = false;
      int startLineIndex = lineOffset < 0 ? 1 : 0;
      int startColumnIndex = columnOffset < 0 ? 1 : 0;
      for (int line = startLineIndex; !itemAdded && line < grid.length && (line + lineOffset) >= 0 && (line + lineOffset) < grid.length; line++) {
        for (int column = startColumnIndex; !itemAdded && column < grid[line].length && (column + columnOffset) >= 0 && (column + columnOffset) < grid[line].length; column++) {
          if (positionIsBlank(line, column) && positionIsBlank((line + lineOffset), column) && positionIsBlank(line, (column + columnOffset))) {
            grid[line][column] = item;
            grid[line][column + columnOffset] = item;
            grid[line + lineOffset][column] = item;
            itemAdded = true;
          }
        }
      }
      return itemAdded;
    }

    private boolean positionIsBlank(int line, int column) {
      return line >= 0 && column >= 0 && grid.length > 0 && (grid.length - 1) >= line && grid[0].length > 0 && (grid[0].length - 1) >= column && grid[line][column].equals(BLANK);
    }
  }

  static Grid bestGrid;

  public static void main(String[] args) {
    Grid grid = buildDefaultGrid();
    bestGrid = buildDefaultGrid();

    /*
      Default valid solution
      A A B B # C # D
      A E B # C C D D
      I E E # F G G H
      I I # F F G H H
    */

    System.out.println("Blank grid");
    displayGrid(bestGrid);

    solve(grid, "A");

    System.out.println();
    System.out.println("Solved grid");
    displayGrid(bestGrid);
  }

  private static void solve(Grid grid, String letter) {
    if (bestGrid.blankSpacesCount() > grid.blankSpacesCount()) {
      bestGrid = grid;
    }

    Grid gridTopLeft = new Grid(grid);
    if (gridTopLeft.addItemCornerTopLeft(letter)) {
      solve(gridTopLeft, nextLetterFor(letter));
    }

    Grid gridTopRight = new Grid(grid);
    if (gridTopRight.addItemCornerTopRight(letter)) {
      solve(gridTopRight, nextLetterFor(letter));
    }

    Grid gridBottomRight = new Grid(grid);
    if (gridBottomRight.addItemCornerBottomRight(letter)) {
      solve(gridBottomRight, nextLetterFor(letter));
    }

    Grid gridBottomLeft = new Grid(grid);
    if (gridBottomLeft.addItemCornerBottomLeft(letter)) {
      solve(gridBottomLeft, nextLetterFor(letter));
    }
  }

  private static String nextLetterFor(String letter) {
    int charValue = letter.charAt(0);
    return String.valueOf( (char) (charValue + 1));
  }

  private static void displayGrid(Grid grid) {
    for (int line = 0; line < grid.grid.length; line++) {
      for (int column = 0; column < grid.grid[line].length; column++) {
        System.out.print(grid.grid[line][column] + " ");
      }
      System.out.println();
    }
  }

  private static Grid buildDefaultGrid() {
    Grid grid = new Grid(4, 8);
    grid.addObstruction(0, 4);
    grid.addObstruction(0, 6);
    grid.addObstruction(1, 3);
    grid.addObstruction(2, 3);
    grid.addObstruction(3, 2);
    return grid;
  }
}
