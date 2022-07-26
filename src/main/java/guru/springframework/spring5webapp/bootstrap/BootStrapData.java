/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

/**
 *
 * @author pedro
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in bootstrap");
        
        Publisher publisher = new Publisher("Gray Matter", "Flowers Rd", "Las Vegas", "Nevada", "45218");
        
        System.out.println("Created Repository: " + publisher.toString());
        
        publisherRepository.save(publisher);
        
        System.out.println("Number of publishers: " + publisherRepository.count());
        
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","123456789");
        
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);
        
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development Without EJB","987654321");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);
        
        
        System.out.println("Number of books: " + bookRepository.count());
        
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
          
        
        
        
        
    }
    
}
