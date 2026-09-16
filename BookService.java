import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Шар бізнес-логіки для роботи з масивом об'єктів Book.
 *
 * <p>Важливо: методи цього класу НЕ виконують жодного виведення в термінал
 * (System.out тощо) - вони лише обробляють дані та повертають результат.
 * Виведенням займається окремий шар інтерфейсу (ConsoleUI).
 *
 * <p>Для роботи з масивами використовується утилітарний клас Arrays
 * (Arrays.stream, Arrays.sort), а фільтрація виконується через Stream API
 * без явних циклів for/while.
 */
public final class BookService {

  private BookService() {}

  /**
   * 4.1. Список книг заданого автора.
   */
  public static List<Book> findByAuthor(Book[] books, String author) {
    return Arrays.stream(books)
        .filter(book -> book.getAuthor().equalsIgnoreCase(author))
        .collect(Collectors.toUnmodifiableList());
  }

  /**
   * 4.2. Список книг, випущених заданим видавництвом.
   */
  public static List<Book> findByPublisher(Book[] books, String publisher) {
    return Arrays.stream(books)
        .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
        .collect(Collectors.toUnmodifiableList());
  }

  /**
   * 4.3. Список книг, випущених після заданого року.
   */
  public static List<Book> findPublishedAfterYear(Book[] books, int year) {
    return Arrays.stream(books)
        .filter(book -> book.getYear() > year)
        .sorted(Comparator.comparingInt(Book::getYear))
        .collect(Collectors.toUnmodifiableList());
  }
}
