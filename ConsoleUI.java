import java.util.List;

/**
 * Шар інтерфейсу. Відповідає лише за красиве виведення даних у консоль.
 */
public final class ConsoleUI {

  private static final String SEPARATOR = "-".repeat(70);

  private ConsoleUI() {}

  public static void printHeader(String title) {
    System.out.println();
    System.out.println(SEPARATOR);
    System.out.println(title);
    System.out.println(SEPARATOR);
  }

  public static void printBooks(Book[] books) {
    printHeader("Повний перелік книг (" + books.length + " шт.)");
    for (int i = 0; i < books.length; i++) {
      printBookLine(i + 1, books[i]);
    }
  }

  public static void printBookList(String title, List<Book> books) {
    printHeader(title);
    if (books.isEmpty()) {
      System.out.println("  (нічого не знайдено)");
      return;
    }
    for (int i = 0; i < books.size(); i++) {
      printBookLine(i + 1, books.get(i));
    }
  }

  private static void printBookLine(int index, Book book) {
    System.out.printf(
        "%2d) %-25s | %-30s | %-20s | %4d р. | %4d стор.%n",
        index,
        truncate(book.getTitle(), 25),
        truncate(book.getAuthor(), 30),
        truncate(book.getPublisher(), 20),
        book.getYear(),
        book.getPageCount());
  }

  private static String truncate(String value, int maxLength) {
    return value.length() <= maxLength ? value : value.substring(0, maxLength - 1) + "…";
  }
}
