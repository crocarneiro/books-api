package br.nom.carneiro.carlos.booksapi.application.books.model;

import br.nom.carneiro.carlos.booksapi.domain.books.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class BookModel {
    private Long id;
    private String title;
    private String description;
    private List<String> authors;
    private List<String> subjects;
    private String isbn13;
    private String isbn10;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;

    public BookModel(Book book) {
        super();

        id = book.getId();
        title = book.getTitle();
        description = book.getDescription();
        authors = book.getAuthors();
        subjects = book.getSubjects();
        isbn13 = book.getIsbn13();
        isbn10 = book.getIsbn10();
        createdOn = book.getCreatedOn();
        modifiedOn = book.getModifiedOn();
    }
}
