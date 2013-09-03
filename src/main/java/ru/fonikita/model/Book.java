package ru.fonikita.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;

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
	   
	   @Override
		public String toString() {
			return "Book [id=" + book_id + ", title=" + title + ", hashCode()="
					+ hashCode() + "]";
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.book_id;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Book) {
				if(this.book_id == ((Book)obj).book_id)
					return true;
			}
			return false;
		}   
	   
}