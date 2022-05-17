package br.nom.carneiro.carlos.booksapi.application.books;

import br.nom.carneiro.carlos.booksapi.application.books.dto.UpdateBookDTO;
import br.nom.carneiro.carlos.booksapi.application.books.model.BookModel;
import br.nom.carneiro.carlos.booksapi.domain.books.Book;
import br.nom.carneiro.carlos.booksapi.domain.books.BookRepository;
import br.nom.carneiro.carlos.booksapi.application.books.dto.CreateBookDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookModel> findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookModel::new)
                .collect(Collectors.toList());
    }

    public BookModel findBookById(Long id) {
        var book = bookRepository.findById(id);
        book.orElseThrow(() -> new RuntimeException("Error finding book by id: Book with id " + id + " not found."));

        return book.map(BookModel::new).get();
    }

    public BookModel createBook(CreateBookDTO body) {
        body.validateRequiredFields();

        var book = Book.builder()
                .title(body.title())
                .description(body.description())
                .authors(body.authors())
                .subjects(body.subjects())
                .isbn10(body.isbn10())
                .isbn13(body.isbn13())
                .createdOn(LocalDateTime.now())
                .build();

        return new BookModel(bookRepository.save(book));
    }

    public BookModel updateBook(Long id, UpdateBookDTO body) {
        body.validateRequiredFields();

        var bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty())
            throw new RuntimeException("There is no book with id " + id);

        var book = bookOptional.get();
        book.setTitle(body.title());
        book.setDescription(body.description());
        book.setAuthors(body.authors());
        book.setSubjects(body.subjects());
        book.setIsbn10(body.isbn10());
        book.setModifiedOn(LocalDateTime.now());

        book = bookRepository.save(book);

        return new BookModel(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

/*

    public Book findBookById() {}

    public List<Book> findAllBooks() {}
 */
}
