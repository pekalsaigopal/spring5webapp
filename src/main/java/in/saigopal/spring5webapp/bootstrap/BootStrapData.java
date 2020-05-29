package in.saigopal.spring5webapp.bootstrap;

import in.saigopal.spring5webapp.domain.Author;
import in.saigopal.spring5webapp.domain.Book;
import in.saigopal.spring5webapp.domain.Publisher;
import in.saigopal.spring5webapp.repositories.AuthorRepository;
import in.saigopal.spring5webapp.repositories.BookRepository;
import in.saigopal.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

   private final AuthorRepository authorRepository;
   private final BookRepository bookRepository;
   private final PublisherRepository publisherRepository;

   public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
      this.authorRepository = authorRepository;
      this.bookRepository = bookRepository;
      this.publisherRepository=publisherRepository;
   }

   @Override
   public void run(String... args) throws Exception {


      Publisher publisher = new Publisher();
      publisher.setName("SFG Publisher");
      publisher.setCity("Bengaluru");
      publisher.setState("Karnataka");
      publisher.setZip("560037");
      publisher.setAddressLine1("KR Road");
      publisherRepository.save(publisher);




      Author eric = new Author("Eric","Evans");
      Book ddd = new Book("Domain Driven Design","123123");
      eric.getBooks().add(ddd);
      ddd.getAuthors().add(eric);

      ddd.setPublisher(publisher);
      publisher.getBooks().add(ddd);


      authorRepository.save(eric);
      bookRepository.save(ddd);
      publisherRepository.save(publisher);

      Author rod = new Author("Rod","Jhonson");
      Book noEJB = new Book("J2EE Development without EJB","321321");
      rod.getBooks().add(noEJB);
      noEJB.getAuthors().add(rod);

      noEJB.setPublisher(publisher);
      publisher.getBooks().add(noEJB);

      authorRepository.save(rod);
      bookRepository.save(noEJB);
      publisherRepository.save(publisher);

      System.out.println("Started in BootStrap.............");
      System.out.println("Number of Authors : "+authorRepository.count());
      System.out.println("Number of Books : "+bookRepository.count());
      System.out.println("Number of Publishers : "+publisherRepository.count());

   }
}
