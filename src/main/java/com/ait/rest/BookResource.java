package com.ait.rest;

import com.ait.books.Book;
import com.ait.books.BookDAO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Produces;

import java.util.List;



@Path("/books")
public class BookResource {

	BookDAO dao = new BookDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Book> findAll() {
		return dao.findAll();
	}
	
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Book findById(@PathParam("id") String id) {
		return dao.findById(Integer.parseInt(id));
	}

}
