package ru.fonikita.model;

import java.util.List;

import javax.sql.DataSource;

public interface BookDAO {

   public void setDataSource(DataSource ds);
   
   public void create(String title, String abst, String aut);
  
   public Book getBook(Integer book_id);
   
   public List<Book> listBooks();
   
   public List<Book> listBooksAut(String book_aut);
   
   public void delete(Integer book_id);
  
   public void update(Integer book_id ,String title, String abst);
}