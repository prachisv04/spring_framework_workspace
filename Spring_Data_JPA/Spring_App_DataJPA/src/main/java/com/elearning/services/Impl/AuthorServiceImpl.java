package com.elearning.services.Impl;

import com.elearning.entities.Author;
import com.elearning.repositories.AuthorRepository;
import com.elearning.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
        System.out.println("AuthorServiceImpl created");
    }
    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }


}
