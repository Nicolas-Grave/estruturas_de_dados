import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Listing {

  private String path;
  private List<File> files;

  public Listing(String path) {
    this.path = path;
    this.loadFiles();
  }

  public void loadFiles() {
    File dir = new File(path);

    files = new ArrayList<>();

    for (File file : dir.listFiles()) {
      files.add(file);
    }
  }

  public void listByDate() {
    Collections.sort(files, new SortByDate());

    String pattern = "dd/MM/yyyy HH:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    for (File file : files) {
      System.out.println(file.getName() + " (last modified: " + simpleDateFormat.format(new Date(file.lastModified())) + ")");
    }
  }

  public void listBySize() {
    Collections.sort(files, new SortBySize());

    for (File file : files) {
      System.out.println(file.getName() + " (size: " + file.length() + " bytes)");
    }
  }

  private static class SortBySize implements Comparator<File> {
    public int compare(File file1, File file2) {
      int result = (int) (file1.length() - file2.length());
      if (result == 0) result = file1.getName().compareTo(file2.getName());
      return result;
    }
  }

  private static class SortByDate implements Comparator<File> {
    public int compare(File file1, File file2) {
      int result = (int) (file1.lastModified() - file2.lastModified());
      if (result == 0) result = file1.getName().compareTo(file2.getName());
      return result;
    }
  }
}
