public class TestListing {
  public static void main(String[] args) {
    String path = "./";
    Listing listing = new Listing(path);

    System.out.println("List by date:");
    listing.listByDate();

    System.out.println("\nList by size:");
    listing.listBySize();
  }
}
