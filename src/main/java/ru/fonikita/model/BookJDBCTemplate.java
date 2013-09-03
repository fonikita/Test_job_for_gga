package ru.fonikita.model;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class BookJDBCTemplate implements BookDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public void create(String title, String abst, String aut) {
      jdbcTemplateObject.update("call ins_proc (?, ?, ?)", title, abst, aut);
      return;
   }

   public Book getBook(Integer book_id) {
      String SQL = "select b.*,a.aut_name from books b left outer join book_aut ba on b.book_id=ba.book_book_id left outer join author a on ba.aut_aut_id=a.aut_id where book_id = ?";
      Book book = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{book_id}, new BookMapper());
      return book;
   }

   public List<Book> listBooks() {
      String SQL = "select b.*,a.aut_name from books b left outer join book_aut ba on b.book_id=ba.book_book_id left outer join author a on ba.aut_aut_id=a.aut_id";
      List <Book> book = jdbcTemplateObject.query(SQL, 
                                new BookMapper());
      return book;
   }

   public void delete(Integer book_id){
      String SQL = "delete from Books where book_id = ?";
      jdbcTemplateObject.update(SQL, book_id);
      SQL = "delete from book_aut where book_book_id = ?";
      jdbcTemplateObject.update(SQL, book_id);
      return;
   }

   public void update(Integer book_id, String title, String abst){
      String SQL = "update books set title=ifnull(?,title),abstract=ifnull(?,abstract) where book_id=?";
      jdbcTemplateObject.update(SQL,title ,abst, book_id);
      return;
   }

}

