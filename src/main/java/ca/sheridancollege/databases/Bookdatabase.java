package ca.sheridancollege.databases;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.Book;
import ca.sheridancollege.beans.Drecord;


@Repository
public class Bookdatabase {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void addBook(Book book) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="INSERT INTO davisC (title, author, price, quantity, relatedCourses)"
				+ " VALUES (:title, :author, :price, :quantity, :relatedCourses)";
		parameters.addValue("title", book.getTitle());
		parameters.addValue("author", book.getAuthor());
		parameters.addValue("price", book.getPrice());
		parameters.addValue("quantity", book.getQuantity());
		parameters.addValue("relatedCourses", book.getRelatedCourses());
		 
		jdbc.update(query, parameters);
		}
	
	public void addBookhmc(Book book) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="INSERT INTO hmcc (title, author, price, quantity, relatedCourses)"
				+ " VALUES (:title, :author, :price, :quantity, :relatedCourses)";
		parameters.addValue("title", book.getTitle());
		parameters.addValue("author", book.getAuthor());
		parameters.addValue("price", book.getPrice());
		parameters.addValue("quantity", book.getQuantity());
		parameters.addValue("relatedCourses", book.getRelatedCourses());
		 
		jdbc.update(query, parameters);
		}
	
	public void addBooktra(Book book) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="INSERT INTO trafalgarc (title, author, price, quantity, relatedCourses)"
				+ " VALUES (:title, :author, :price, :quantity, :relatedCourses)";
		parameters.addValue("title", book.getTitle());
		parameters.addValue("author", book.getAuthor());
		parameters.addValue("price", book.getPrice());
		parameters.addValue("quantity", book.getQuantity());
		parameters.addValue("relatedCourses", book.getRelatedCourses());
		 
		jdbc.update(query, parameters);
		}
	
	public ArrayList<Book> getBook() {
		String  query="SELECT * FROM davisC";
		  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,new BeanPropertyRowMapper<Book>(Book.class));
		  return books;
	}
	
	public ArrayList<Book> getBookhmc() {
		String  query="SELECT * FROM hmcc";
		  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,new BeanPropertyRowMapper<Book>(Book.class));
		  return books;
	}
	
	public ArrayList<Book> getBooktra() {
		String  query="SELECT * FROM trafalgarc";
		  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,new BeanPropertyRowMapper<Book>(Book.class));
		  return books;
	}
	
	public Book getBookById(int id){ 
		  MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davisC where id=:id";
		  parameters.addValue("id",id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  if(books.size()>0)
		return books.get(0);
	  else
	  return null;
	  }
	
	public Book getBookByIdhmc(int id){ 
		  MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmcc where id=:id";
		  parameters.addValue("id",id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  if(books.size()>0)
		return books.get(0);
	  else
	  return null;
	  }
	
	public Book getBookByIdtra(int id){ 
		  MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgarc where id=:id";
		  parameters.addValue("id",id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  if(books.size()>0)
		return books.get(0);
	  else
	  return null;
	  }
	
	public void editBook(Book book) {	  
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String  query="UPDATE davisC SET title =:title, author=:author, price=:price, quantity=:quantity, relatedCourses=:relatedCourses WHERE id=:id";
		  parameters.addValue("id",book.getId());
		  parameters.addValue("title",book.getTitle());
		  parameters.addValue("author",book.getAuthor());
		  parameters.addValue("price",book.getPrice());
		  parameters.addValue("quantity",book.getQuantity());
		  parameters.addValue("relatedCourses",book.getRelatedCourses());
		  jdbc.update(query, parameters); 	  
	  }
	
	public void editBookhmc(Book book) {	  
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String  query="UPDATE hmcc SET title =:title, author=:author, price=:price, quantity=:quantity, relatedCourses=:relatedCourses WHERE id=:id";
		  parameters.addValue("id",book.getId());
		  parameters.addValue("title",book.getTitle());
		  parameters.addValue("author",book.getAuthor());
		  parameters.addValue("price",book.getPrice());
		  parameters.addValue("quantity",book.getQuantity());
		  parameters.addValue("relatedCourses",book.getRelatedCourses());
		  jdbc.update(query, parameters); 	  
	  }
	
	public void editBooktra(Book book) {	  
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String  query="UPDATE trafalgarc SET title =:title, author=:author, price=:price, quantity=:quantity, relatedCourses=:relatedCourses WHERE id=:id";
		  parameters.addValue("id",book.getId());
		  parameters.addValue("title",book.getTitle());
		  parameters.addValue("author",book.getAuthor());
		  parameters.addValue("price",book.getPrice());
		  parameters.addValue("quantity",book.getQuantity());
		  parameters.addValue("relatedCourses",book.getRelatedCourses());
		  jdbc.update(query, parameters); 	  
	  }
	
	public void deleteBookById(int id) {	  	  
		   MapSqlParameterSource parameters = new MapSqlParameterSource();  
		   String  query="DELETE FROM davisC WHERE id=:id";
			  parameters.addValue("id",id);
			  jdbc.update(query, parameters);
		  }
	
	public void deleteBookByIdhmc(int id) {	  	  
		   MapSqlParameterSource parameters = new MapSqlParameterSource();  
		   String  query="DELETE FROM hmcc WHERE id=:id";
			  parameters.addValue("id",id);
			  jdbc.update(query, parameters);
		  }
	
	public void deleteBookByIdtra(int id) {	  	  
		   MapSqlParameterSource parameters = new MapSqlParameterSource();  
		   String  query="DELETE FROM trafalgarc WHERE id=:id";
			  parameters.addValue("id",id);
			  jdbc.update(query, parameters);
		  }
	
	public ArrayList<Book> searchBox(int id){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davisC where id=:id";
		  parameters.addValue("id",id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	
    public ArrayList<Book> searchBoxTitle(String title){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davisC where title=:title";
		  parameters.addValue("title",title);
		  
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));
	  System.out.print(books);
	  return books;
	}
    
    public ArrayList<Book> searchBoxAuthor(String author){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davisC where author=:author";
		  parameters.addValue("author",author);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
    
    public ArrayList<Book> searchBoxQuantity(int quantity){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davisC where quantity=:quantity";
		  parameters.addValue("quantity",quantity);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
    
    public ArrayList<Book> searchBoxCourses(String relatedCourses){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davisC where relatedCourses=:relatedCourses";
		  parameters.addValue("relatedCourses",relatedCourses);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
    
    public ArrayList<Book> searchBoxhmc(int id){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmcc where id=:id";
		  parameters.addValue("id",id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	
    public ArrayList<Book> searchBoxTitlehmc(String title){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmcc where title=:title";
		  parameters.addValue("title",title);
		  
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));
	  System.out.print(books);
	  return books;
	}
    
    public ArrayList<Book> searchBoxAuthorhmc(String author){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmcc where author=:author";
		  parameters.addValue("author",author);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
    
    public ArrayList<Book> searchBoxQuantityhmc(int quantity){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmcc where quantity=:quantity";
		  parameters.addValue("quantity",quantity);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
    
    public ArrayList<Book> searchBoxCourseshmc(String relatedCourses){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmcc where relatedCourses=:relatedCourses";
		  parameters.addValue("relatedCourses",relatedCourses);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
    
    public ArrayList<Book> searchBoxtra(int id){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgarc where id=:id";
		  parameters.addValue("id",id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	
    public ArrayList<Book> searchBoxTitletra(String title){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgarc where title=:title";
		  parameters.addValue("title",title);
		  
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));
	  System.out.print(books);
	  return books;
	}
    
    public ArrayList<Book> searchBoxAuthortra(String author){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgarc where author=:author";
		  parameters.addValue("author",author);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
    
    public ArrayList<Book> searchBoxQuantitytra(int quantity){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgarc where quantity=:quantity";
		  parameters.addValue("quantity",quantity);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
    
    public ArrayList<Book> searchBoxCoursestra(String relatedCourses){		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgarc where relatedCourses=:relatedCourses";
		  parameters.addValue("relatedCourses",relatedCourses);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	
	public void dummyR() {
		for(int i=1;i <=6;i++) {
			dummyKar(new Drecord("Math","Dorota",i+i,i+i+i,"Math-9928, Statistics"+i*i),
			 new Drecord("JAVAEE","Jonathan",i+i,i+i+i,"Programming, Web"+i*i),
			 new Drecord("Art","Dev",i+i,i+i+i,"SPDV, PBSC"+i*i),
			 new Drecord("Data","Dim",i+i,i+i+i,"NDBC"+i*i),
			 new Drecord("Security","Bro",i+i,i+i+i,"BBND"+i*i));
		}
	}
	
	public void dummyRhmc() {
		for(int i=1;i <=6;i++) {
			dummyhmc(new Drecord("C++","Jon",i+i,i+i+i,"PBSC"+i*i),
			 new Drecord("C#","Nik",i+i,i+i+i,"JBAC"+i*i),
			 new Drecord("JAVA I","Dev",i+i,i+i+i,"SPDV"+i*i),
			 new Drecord("JAVA II","Dim",i+i,i+i+i,"NDBC"+i*i),
			 new Drecord("JAVA III","Bro",i+i,i+i+i,"BBND"+i*i));
		}
	}
	
	public void dummyRtra() {
		for(int i=1;i <=6;i++) {
			dummytra(new Drecord("Animation","kim",i+i,i+i+i,"Art, Drawing"+i*i),
			 new Drecord("Civil","liam",i+i,i+i+i,"EG, analysis"+i*i),
			 new Drecord("Mech","Pruthil",i+i,i+i+i,"ElectoMechanical, Mech3320"+i*i),
			 new Drecord("Electrical","freak",i+i,i+i+i,"Security, Data"+i*i),
			 new Drecord("Drawing","urimal",i+i,i+i+i,"Art"+i*i));
		}
	}
	
	
	
	public void dummyKar(Drecord b1,Drecord b2,Drecord b3,Drecord b4,Drecord b5) {
		
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String query="INSERT INTO davisC (title, author, price, quantity, relatedCourses)"
					+ " VALUES (:title, :author, :price, :quantity, :relatedCourses)";
		  
		  parameters.addValue("title",b1.getTitle());
		  parameters.addValue("author",b1.getAuthor());
		  parameters.addValue("price",b1.getPrice());
		  parameters.addValue("quantity",b1.getQuantity());
		  parameters.addValue("relatedCourses",b1.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  
		  parameters.addValue("title",b2.getTitle());
		  parameters.addValue("author",b2.getAuthor());
		  parameters.addValue("price",b2.getPrice());
		  parameters.addValue("quantity",b2.getQuantity());
		  parameters.addValue("relatedCourses",b2.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b3.getTitle());
		  parameters.addValue("author",b3.getAuthor());
		  parameters.addValue("price",b3.getPrice());
		  parameters.addValue("quantity",b3.getQuantity());
		  parameters.addValue("relatedCourses",b3.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b4.getTitle());
		  parameters.addValue("author",b4.getAuthor());
		  parameters.addValue("price",b4.getPrice());
		  parameters.addValue("quantity",b4.getQuantity());
		  parameters.addValue("relatedCourses",b4.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b5.getTitle());
		  parameters.addValue("author",b5.getAuthor());
		  parameters.addValue("price",b5.getPrice());
		  parameters.addValue("quantity",b5.getQuantity());
		  parameters.addValue("relatedCourses",b5.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		
	}
	
	public void dummyhmc(Drecord b1,Drecord b2,Drecord b3,Drecord b4,Drecord b5) {
		
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String query="INSERT INTO hmcc (title, author, price, quantity, relatedCourses)"
					+ " VALUES (:title, :author, :price, :quantity, :relatedCourses)";
		  
		  parameters.addValue("title",b1.getTitle());
		  parameters.addValue("author",b1.getAuthor());
		  parameters.addValue("price",b1.getPrice());
		  parameters.addValue("quantity",b1.getQuantity());
		  parameters.addValue("relatedCourses",b1.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  
		  parameters.addValue("title",b2.getTitle());
		  parameters.addValue("author",b2.getAuthor());
		  parameters.addValue("price",b2.getPrice());
		  parameters.addValue("quantity",b2.getQuantity());
		  parameters.addValue("relatedCourses",b2.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b3.getTitle());
		  parameters.addValue("author",b3.getAuthor());
		  parameters.addValue("price",b3.getPrice());
		  parameters.addValue("quantity",b3.getQuantity());
		  parameters.addValue("relatedCourses",b3.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b4.getTitle());
		  parameters.addValue("author",b4.getAuthor());
		  parameters.addValue("price",b4.getPrice());
		  parameters.addValue("quantity",b4.getQuantity());
		  parameters.addValue("relatedCourses",b4.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b5.getTitle());
		  parameters.addValue("author",b5.getAuthor());
		  parameters.addValue("price",b5.getPrice());
		  parameters.addValue("quantity",b5.getQuantity());
		  parameters.addValue("relatedCourses",b5.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		
	}
	
	public void dummytra(Drecord b1,Drecord b2,Drecord b3,Drecord b4,Drecord b5) {
		
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String query="INSERT INTO trafalgarc (title, author, price, quantity, relatedCourses)"
					+ " VALUES (:title, :author, :price, :quantity, :relatedCourses)";
		  
		  parameters.addValue("title",b1.getTitle());
		  parameters.addValue("author",b1.getAuthor());
		  parameters.addValue("price",b1.getPrice());
		  parameters.addValue("quantity",b1.getQuantity());
		  parameters.addValue("relatedCourses",b1.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  
		  parameters.addValue("title",b2.getTitle());
		  parameters.addValue("author",b2.getAuthor());
		  parameters.addValue("price",b2.getPrice());
		  parameters.addValue("quantity",b2.getQuantity());
		  parameters.addValue("relatedCourses",b2.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b3.getTitle());
		  parameters.addValue("author",b3.getAuthor());
		  parameters.addValue("price",b3.getPrice());
		  parameters.addValue("quantity",b3.getQuantity());
		  parameters.addValue("relatedCourses",b3.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b4.getTitle());
		  parameters.addValue("author",b4.getAuthor());
		  parameters.addValue("price",b4.getPrice());
		  parameters.addValue("quantity",b4.getQuantity());
		  parameters.addValue("relatedCourses",b4.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b5.getTitle());
		  parameters.addValue("author",b5.getAuthor());
		  parameters.addValue("price",b5.getPrice());
		  parameters.addValue("quantity",b5.getQuantity());
		  parameters.addValue("relatedCourses",b5.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		
	}
	
}
