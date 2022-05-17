package br.nom.carneiro.carlos.booksapi.application.books;

import br.nom.carneiro.carlos.booksapi.application.books.dto.CreateBookDTO;
import br.nom.carneiro.carlos.booksapi.application.books.dto.UpdateBookDTO;
import br.nom.carneiro.carlos.booksapi.application.books.model.BookModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController("/api")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookModel>> findAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookModel> findBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @PostMapping("/book")
    public ResponseEntity<BookModel> createBook(@RequestBody CreateBookDTO body) {
        return ResponseEntity.ok(bookService.createBook(body));
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<BookModel> updateBook(@PathVariable Long id, @RequestBody UpdateBookDTO body) {
        return ResponseEntity.ok(bookService.updateBook(id, body));
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
