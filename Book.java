

import java.util.Objects;

/**
 * Клас-сутність "Книга".
 *
 * <p>Об'єкт цього класу є незмінним (immutable): усі поля оголошені як
 * {@code private final} і встановлюються лише один раз - у конструкторі.
 * Замість класичних мутуючих сеттерів (set...), які б порушували
 * незмінність об'єкта, клас надає методи with...(), які, за аналогією з
 * класом {@link String}, повертають НОВИЙ об'єкт Book зі зміненим полем,
 * а поточний об'єкт залишається без змін.
 */
public final class Book {

  private final String author;
  private final String title;
  private final String publisher;
  private final int year;
  private final int pageCount;

  public Book(String author, String title, String publisher, int year, int pageCount) {
    this.author = Objects.requireNonNull(author, "author не може бути null");
    this.title = Objects.requireNonNull(title, "title не може бути null");
    this.publisher = Objects.requireNonNull(publisher, "publisher не може бути null");
    if (year <= 0) {
      throw new IllegalArgumentException("Рік видання має бути додатнім числом: " + year);
    }
    if (pageCount <= 0) {
      throw new IllegalArgumentException(
          "Кількість сторінок має бути додатнім числом: " + pageCount);
    }
    this.year = year;
    this.pageCount = pageCount;
  }

  // ---------- Getters (частина інкапсуляції) ----------

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public String getPublisher() {
    return publisher;
  }

  public int getYear() {
    return year;
  }

  public int getPageCount() {
    return pageCount;
  }

  // ---------- "set" методи у незмінному стилі (withers) ----------
  // Кожен метод повертає новий об'єкт Book, поточний об'єкт не змінюється.

  public Book setAuthor(String newAuthor) {
    return new Book(newAuthor, title, publisher, year, pageCount);
  }

  public Book setTitle(String newTitle) {
    return new Book(author, newTitle, publisher, year, pageCount);
  }

  public Book setPublisher(String newPublisher) {
    return new Book(author, title, newPublisher, year, pageCount);
  }

  public Book setYear(int newYear) {
    return new Book(author, title, publisher, newYear, pageCount);
  }

  public Book setPageCount(int newPageCount) {
    return new Book(author, title, publisher, year, newPageCount);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book)) {
      return false;
    }
    Book book = (Book) o;
    return year == book.year
        && pageCount == book.pageCount
        && author.equals(book.author)
        && title.equals(book.title)
        && publisher.equals(book.publisher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(author, title, publisher, year, pageCount);
  }

  @Override
  public String toString() {
    return "Book{"
        + "author='"
        + author
        + '\''
        + ", title='"
        + title
        + '\''
        + ", publisher='"
        + publisher
        + '\''
        + ", year="
        + year
        + ", pageCount="
        + pageCount
        + '}';
  }
}
