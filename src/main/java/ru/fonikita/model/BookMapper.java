package ru.fonikita.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {
   public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
      Book Book_n = new Book();
      Book_n.setBook_id(rs.getInt("book_id"));
      Book_n.setTitle(rs.getString("title"));
      Book_n.setAbst(rs.getString("abstract"));
      Book_n.setAut(rs.getString("aut_name"));
      
     return Book_n;
   }
}