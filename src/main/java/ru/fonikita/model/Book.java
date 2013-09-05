package ru.fonikita.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonAutoDetect;


@XmlType(propOrder = { "book_id", "title","abst", "aut" })
@XmlRootElement
@JsonAutoDetect
public class Book {
   
   private Integer book_id;
   private String title;
   private String abst;
   private String aut;

   public void setAbst(String abst) {
      this.abst = abst;
   }
   public String getAbst() {
      return abst;
   }

   public void setTitle(String title) {
      this.title = title;
   }
   public String getTitle() {
      return title;
   }

   public void setBook_id(Integer book_id) {
      this.book_id = book_id;
   }
   public Integer getBook_id() {
      return book_id;
   }
   
   public void setAut(String aut) {
	      this.aut = aut;
	   }
	   public String getAut() {
	      return aut;
	   }
	   
	 
	
		

	   
}