package com.codecool.BookShop.service;

import com.codecool.BookShop.model.Author;
import com.codecool.BookShop.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }


    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }


    public Author save(Author author) {
        return authorRepository.save(author);
    }


    public boolean existsById(Long id) {
        return authorRepository.existsById(id);
    }


    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Author> getAuthorsByNameAndSurname(String name, String surname) {
        return authorRepository.getAuthorsByNameAndSurname(name, surname);
    }
}
