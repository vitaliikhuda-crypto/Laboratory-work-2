import java.util.List;

/**
 * Точка входу в програму. Клас містить лише один метод - main (runner).
 */
public class Main {

  public static void main(String[] args) {
    Book[] books = createBooks();
    ConsoleUI.printBooks(books);

    // 4.1. Список книг заданого автора
    String searchAuthor = "Іван Франко";
    List<Book> byAuthor = BookService.findByAuthor(books, searchAuthor);
    ConsoleUI.printBookList("4.1. Книги автора \"" + searchAuthor + "\"", byAuthor);

    // 4.2. Список книг, випущених заданим видавництвом
    String searchPublisher = "Либідь";
    List<Book> byPublisher = BookService.findByPublisher(books, searchPublisher);
    ConsoleUI.printBookList(
        "4.2. Книги видавництва \"" + searchPublisher + "\"", byPublisher);

    // 4.3. Список книг, випущених після заданого року
    int searchYear = 2000;
    List<Book> afterYear = BookService.findPublishedAfterYear(books, searchYear);
    ConsoleUI.printBookList("4.3. Книги, видані після " + searchYear + " року", afterYear);
  }

  private static Book[] createBooks() {
    return new Book[] {
      new Book("Іван Франко", "Захар Беркут", "Либідь", 1995, 176),
      new Book("Іван Франко", "Перехресні стежки", "Каменяр", 1990, 320),
      new Book("Леся Українка", "Лісова пісня", "Дніпро", 1988, 128),
      new Book("Тарас Шевченко", "Кобзар", "Либідь", 2005, 400),
      new Book("Джоел Спольскі", "Joel on Software", "O'Reilly", 2004, 361),
      new Book("Роберт Мартін", "Чиста архітектура", "Пітер", 2018, 352),
      new Book("Роберт Мартін", "Чистий код", "Пітер", 2008, 464),
      new Book("Ерік Фріман", "Head First Design Patterns", "O'Reilly", 2020, 638),
      new Book("Джошуа Блох", "Effective Java", "Addison-Wesley", 2018, 412),
      new Book("Панас Мирний", "Хіба ревуть воли, як ясла повні?", "Дніпро", 1975, 512)
    };
  }
}
