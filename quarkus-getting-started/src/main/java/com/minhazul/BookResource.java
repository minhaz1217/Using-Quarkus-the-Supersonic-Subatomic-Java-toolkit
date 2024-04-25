package com.minhazul;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Test Book 1", "Random", 2020, "IT"),
                new Book(1, "Test Book 2", "Random", 2021, "IT"),
                new Book(1, "Test Book 3", "Random", 2022, "IT"),
                new Book(1, "Test Book 4", "Random", 2023, "IT")
        );
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks(){
        return getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
