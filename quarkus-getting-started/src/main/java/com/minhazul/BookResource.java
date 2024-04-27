package com.minhazul;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import org.jboss.logging.Logger;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository repository;
    @Inject
    Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("Getting all books");
        return this.repository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks(){
        logger.info("Getting book count");
        return this.repository.countAllBooks();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
        logger.info("Getting book by id");
        return this.repository.getBook(id);
    }
}
