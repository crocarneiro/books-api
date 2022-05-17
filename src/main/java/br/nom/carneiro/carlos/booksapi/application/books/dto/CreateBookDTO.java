package br.nom.carneiro.carlos.booksapi.application.books.dto;

import java.util.List;
import java.util.Objects;

public record CreateBookDTO(String title,
        String description,
        List<String> authors,
        List<String> subjects,
        String isbn13,
        String isbn10) {

    public void validateRequiredFields() {
        Objects.requireNonNull(authors, "title cannot be null.");
        Objects.requireNonNull(description, "description cannot be null.");
        Objects.requireNonNull(authors, "authors cannot be null.");
        Objects.requireNonNull(subjects, "subjects cannot be null");

        if(title.isBlank()) throw new RuntimeException("The book should not have a blank title.");
        if(description.isBlank()) throw new RuntimeException("The book should not have a blank description.");
        if(authors.isEmpty()) throw new RuntimeException("The book should have at least one author.");
        if(subjects.isEmpty()) throw new RuntimeException("The book should have at least one subject.");
    }
}