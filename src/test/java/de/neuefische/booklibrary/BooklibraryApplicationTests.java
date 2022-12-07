package de.neuefische.booklibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class BooklibraryApplicationTests {

    BookRepo bookRepo = mock(BookRepo.class);
    BookService bookService = new BookService(bookRepo);

    @Test
    void getBooks_shouldReturnAllBook() {
        Book book1 = new Book("Unnützes Wissen für Teenager", "Lea Winterer", 8845939876l);
        Book book2 = new Book("Das einzige Buch, das Du über Finanzen lesen solltest", "Thomas Kehl", 3548065848l);
        Book book3 = new Book("Die vierte Gewalt", "Richard David Precht", 3103975074l);
        List<Book> bookList = new ArrayList<>(List.of(book1, book2, book3));
        when(bookRepo.getBooks()).thenReturn(bookList);

        List<Book> actual = bookService.getBooks();

        Assertions.assertEquals(List.of(book1, book2, book3), actual);
        verify(bookRepo).getBooks();
    }

    /*@Test
    void getBookByISBN_shouldReturnASpecificBook() {
        Book book = new Book("", "", 8845939876l);
        when(bookRepo.getBookByISBN(ISBN)).thenReturn(book);
    }*/

}
