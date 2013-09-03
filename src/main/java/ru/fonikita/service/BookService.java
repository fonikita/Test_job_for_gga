package ru.fonikita.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.fonikita.model.*;

@Controller
@RequestMapping("/book")
public class BookService {
	ClassPathXmlApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans.xml");

	      BookJDBCTemplate bookJDBCTemplate = 
	      (BookJDBCTemplate)context.getBean("bookJDBCTemplate");
	


	@RequestMapping(value = "/{book_id}", method = RequestMethod.GET, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public Book getBookById(@PathVariable int book_id) {
		return bookJDBCTemplate.getBook(book_id);
	}
	

	@RequestMapping( method = RequestMethod.PUT, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	@ResponseBody
	public Number editBook(@RequestBody Book book) {
		bookJDBCTemplate.update(book.getBook_id(), book.getTitle(), book.getAbst());
		return null;
	}

	@RequestMapping(value = "/{book_id}", method = RequestMethod.DELETE, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public Number deleteBook(@PathVariable int book_id) {
		bookJDBCTemplate.delete(book_id);
		return null;
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	@ResponseBody
	public Number createBook(@RequestBody Book book) {
	bookJDBCTemplate.create(book.getTitle(), book.getAbst(), book.getAut());
		return null;
	}

}
