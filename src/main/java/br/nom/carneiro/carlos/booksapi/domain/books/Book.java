package br.nom.carneiro.carlos.booksapi.domain.books;

import br.nom.carneiro.carlos.booksapi.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Book extends BaseEntity {
    private String title;
    private String description;
    @ElementCollection
    @CollectionTable(name = "authors", joinColumns = @JoinColumn(name = "book_id"))
    private List<String> authors;
    @ElementCollection
    @CollectionTable(name = "subjects", joinColumns = @JoinColumn(name = ""))
    private List<String> subjects;
    private String isbn13;
    private String isbn10;

    public Book() { }

    @Builder
    public Book(
            String title,
            String description,
            List<String> authors,
            List<String> subjects,
            String isbn13,
            String isbn10,
            LocalDateTime createdOn,
            LocalDateTime modifiedOn
    ) {
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.subjects = subjects;
        this.isbn13 = isbn13;
        this.isbn10 = isbn10;
        this.setCreatedOn(createdOn);
        this.setModifiedOn(modifiedOn);
    }
}
