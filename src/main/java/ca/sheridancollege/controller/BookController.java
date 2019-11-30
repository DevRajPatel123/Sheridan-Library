package ca.sheridancollege.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Book;
import ca.sheridancollege.databases.Bookdatabase;


@Controller
public class BookController {

	@Autowired
	private Bookdatabase bd;
	
	@GetMapping("/")
	public String goBook() {
		return "Home.html";
	}
	
	@GetMapping("/addBooks")
	public String addPage() {
		return "addBooks.html";
	}
	
	@GetMapping("/addBookshmc")
	public String addPageHMC() {
		return "addHMC.html";
	}
	
	@GetMapping("/addBookstra")
	public String addPageTRA() {
		return "addTRA.html";
	}
	
	@GetMapping("/searchBooks")
	public String goSearchit() {
		return "Search.html";
	}
	
	@GetMapping("/searchBookshmc")
	public String goSearchhmc() {
		return "Searchhmc.html";
	}
	
	@GetMapping("/searchBookstra")
	public String goSearchtra() {
		return "Searchtra.html";
	}
	
	@GetMapping("/add")
	public String addKar(@RequestParam String title,
			             @RequestParam String author,
			             @RequestParam double price,
			             @RequestParam int quantity,
			             @RequestParam String relatedCourses) {
		
		Book bk= new Book();
		bk.setTitle(title);
		bk.setAuthor(author);
		bk.setPrice(price);
		bk.setQuantity(quantity);
		bk.setRelatedCourses(relatedCourses);
		bd.addBook(bk);
		return"addBooks.html";
	}
	
	@GetMapping("/addhmc")
	public String addhmc(@RequestParam String title,
			             @RequestParam String author,
			             @RequestParam double price,
			             @RequestParam int quantity,
			             @RequestParam String relatedCourses) {
		
		Book bk= new Book();
		bk.setTitle(title);
		bk.setAuthor(author);
		bk.setPrice(price);
		bk.setQuantity(quantity);
		bk.setRelatedCourses(relatedCourses);
		bd.addBookhmc(bk);
		return"addHMC.html";
	}
	
	@GetMapping("/addtra")
	public String addTRA(@RequestParam String title,
			             @RequestParam String author,
			             @RequestParam double price,
			             @RequestParam int quantity,
			             @RequestParam String relatedCourses) {
		
		Book bk= new Book();
		bk.setTitle(title);
		bk.setAuthor(author);
		bk.setPrice(price);
		bk.setQuantity(quantity);
		bk.setRelatedCourses(relatedCourses);
		bd.addBooktra(bk);
		return"addTRA.html";
	}
	
	@GetMapping("/davis")
	public String goDavis() {
		return "Davis.html";
	}
	
	@GetMapping("/hmc")
	public String goHMC() {
		return "HMC.html";
	}
	
	@GetMapping("/trafalgar")
	public String goTRA() {
		return "Trafalgar.html";
	}
	
	@GetMapping("/view")
	public String goView(Model model)
	{
		model.addAttribute("bookEdition", bd.getBook());
		model.addAttribute("bookEditionhmc", bd.getBookhmc());
		model.addAttribute("bookEditiontra", bd.getBooktra());

		return "ViewBooks.html";
	}
	
 
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable int id,Model model) {
		  
		  Book c= bd.getBookById(id);
		  
		  model.addAttribute("bookEdition",c);
		  return "editBook.html";
	}
	
	@GetMapping("/modify")
	public String editBookRecord(@RequestParam int id, @RequestParam String title, @RequestParam String author, 
			@RequestParam double price, @RequestParam int quantity, @RequestParam String relatedCourses, Model model){
		
		  Book b= new Book(id, title, author, price, quantity, relatedCourses);
	      bd.editBook(b);
	      model.addAttribute("bookEdition", bd.getBook());
	      model.addAttribute("bookEditionhmc", bd.getBookhmc());
	      model.addAttribute("bookEditiontra", bd.getBooktra());
	   return "ViewBooks.html";
	}

	@GetMapping("/delete/{id}") // this is a path variable
	public String deleteBook(@PathVariable int id, Model model) {
		Book b= bd.getBookById(id);
	      bd.deleteBookById(id);
	      model.addAttribute("bookEdition", bd.getBook());
	      model.addAttribute("bookEditionhmc", bd.getBookhmc());
	      model.addAttribute("bookEditiontra", bd.getBooktra());
		  return "ViewBooks.html";
	}
	
	@GetMapping("/edithmc/{id}")
	public String editBookhmc(@PathVariable int id,Model model) {
		  
		  Book c= bd.getBookByIdhmc(id);
		  
		  model.addAttribute("bookEditionhmc",c);
		  return "editBookHMC.html";
	}
	
	@GetMapping("/modifyhmc")
	public String editBookRecordhmc(@RequestParam int id, @RequestParam String title, @RequestParam String author, 
			@RequestParam double price, @RequestParam int quantity, @RequestParam String relatedCourses, Model model){
		
		  Book b= new Book(id, title, author, price, quantity, relatedCourses);
	      bd.editBookhmc(b);
	      model.addAttribute("bookEdition", bd.getBook());
	      model.addAttribute("bookEditionhmc", bd.getBookhmc());
	      model.addAttribute("bookEditiontra", bd.getBooktra());
	   return "ViewBooks.html";
	}

	@GetMapping("/deletehmc/{id}") // this is a path variable
	public String deleteBookHMC(@PathVariable int id, Model model) {
		Book b= bd.getBookByIdhmc(id);
	      bd.deleteBookByIdhmc(id);
	      model.addAttribute("bookEdition", bd.getBook());
	      model.addAttribute("bookEditionhmc", bd.getBookhmc());
	      model.addAttribute("bookEditiontra", bd.getBooktra());
		  return "ViewBooks.html";
	}
	
	@GetMapping("/edittra/{id}")
	public String editBookTRA(@PathVariable int id,Model model) {
		  
		  Book c= bd.getBookByIdtra(id);
		  
		  model.addAttribute("bookEditiontra",c);
		  return "editBookTRA.html";
	}
	
	@GetMapping("/modifytra")
	public String editBookRecordtra(@RequestParam int id, @RequestParam String title, @RequestParam String author, 
			@RequestParam double price, @RequestParam int quantity, @RequestParam String relatedCourses, Model model){
		
		  Book b= new Book(id, title, author, price, quantity, relatedCourses);
	      bd.editBooktra(b);
	      model.addAttribute("bookEdition", bd.getBook());
	      model.addAttribute("bookEditionhmc", bd.getBookhmc()); 
	      model.addAttribute("bookEditiontra", bd.getBooktra());
	   return "ViewBooks.html";
	}

	@GetMapping("/deletetra/{id}") // this is a path variable
	public String deleteBookTRA(@PathVariable int id, Model model) {
		Book b= bd.getBookByIdtra(id);
	      bd.deleteBookByIdtra(id);
	      model.addAttribute("bookEdition", bd.getBook());
	      model.addAttribute("bookEditionhmc", bd.getBookhmc());
	      model.addAttribute("bookEditiontra", bd.getBooktra());
		  return "ViewBooks.html";
	}
	
	@GetMapping("/searchID")
	public String goSearchID(@RequestParam int id, Model model) {
	   
		model.addAttribute("search", bd.searchBox(id));
		return "Search.html";
	}
	
	@GetMapping("/searchTitle")
	public String searchByTitle(@RequestParam String title, Model model){
		
	model.addAttribute("search", bd.searchBoxTitle(title));
	return"Search.html";
	}
	
	@GetMapping("/searchAuthor")
	public String searchByAuthor(@RequestParam String author, Model model){
	model.addAttribute("search", bd.searchBoxAuthor(author));
	return"Search.html";
	}
	
	@GetMapping("/searchQuantity")
	public String searchByQuantity(@RequestParam int quantity, Model model){
	model.addAttribute("search", bd.searchBoxQuantity(quantity));
	return"Search.html";
	}
	
	@GetMapping("/searchRelatedCourses")
	public String searchByCourses(@RequestParam String relatedCourses, Model model){
	model.addAttribute("search", bd.searchBoxCourses(relatedCourses));
	return"Search.html";
	}
	
	@GetMapping("/searchIDhmc")
	public String goSearchIDhmc(@RequestParam int id, Model model) {
	   
		model.addAttribute("search", bd.searchBoxhmc(id));
		return "Searchhmc.html";
	}
	
	@GetMapping("/searchTitlehmc")
	public String searchByTitlehmc(@RequestParam String title, Model model){
		
	model.addAttribute("search", bd.searchBoxTitlehmc(title));
	return"Searchhmc.html";
	}
	
	@GetMapping("/searchAuthorhmc")
	public String searchByAuthorhmc(@RequestParam String author, Model model){
	model.addAttribute("search", bd.searchBoxAuthorhmc(author));
	return"Searchhmc.html";
	}
	
	@GetMapping("/searchQuantityhmc")
	public String searchByQuantityhmc(@RequestParam int quantity, Model model){
	model.addAttribute("search", bd.searchBoxQuantityhmc(quantity));
	return"Searchhmc.html";
	}
	
	@GetMapping("/searchRelatedCourseshmc")
	public String searchByCourseshmc(@RequestParam String relatedCourses, Model model){
	bd.searchBoxCourses(relatedCourses);	
	model.addAttribute("search", bd.searchBoxCourseshmc(relatedCourses));
	return"Searchhmc.html";
	}
	
	@GetMapping("/searchIDtra")
	public String goSearchIDtra(@RequestParam int id, Model model) {
	   
		model.addAttribute("search", bd.searchBoxtra(id));
		return "Searchhmc.html";
	}
	
	@GetMapping("/searchTitletra")
	public String searchByTitletra(@RequestParam String title, Model model){
		
	model.addAttribute("search", bd.searchBoxTitletra(title));
	return"Searchhmc.html";
	}
	
	@GetMapping("/searchAuthortra")
	public String searchByAuthortra(@RequestParam String author, Model model){
	model.addAttribute("search", bd.searchBoxAuthortra(author));
	return"Searchhmc.html";
	}
	
	@GetMapping("/searchQuantitytra")
	public String searchByQuantitytra(@RequestParam int quantity, Model model){
	model.addAttribute("search", bd.searchBoxQuantitytra(quantity));
	return"Searchhmc.html";
	}
	
	@GetMapping("/searchRelatedCoursestra")
	public String searchByCoursestra(@RequestParam String relatedCourses, Model model){
	bd.searchBoxCourses(relatedCourses);	
	model.addAttribute("search", bd.searchBoxCoursestra(relatedCourses));
	return"Searchhmc.html";
	}
	
	@GetMapping("/dummyBooks")
	public String generateD(Model model) {
	bd.dummyR();
	      model.addAttribute("bookEditionD", bd.getBook());
	      model.addAttribute("bookEditionhmcD", bd.getBookhmc());
	      model.addAttribute("bookEditiontraD", bd.getBooktra());
 
		return "DummyRecords.html";
	}
	
	@GetMapping("/dummyBookshmc")
	public String generateDhmc(Model model) {
	bd.dummyRhmc();
	   model.addAttribute("bookEditionD", bd.getBook());
	      model.addAttribute("bookEditionhmcD", bd.getBookhmc());
	      model.addAttribute("bookEditiontraD", bd.getBooktra());
 
		return "DummyRecordshmc.html";
	}
	
	@GetMapping("dummyBookstra")
	public String generateDtra(Model model) {
	bd.dummyRtra();
	   model.addAttribute("bookEditionD", bd.getBook());
	      model.addAttribute("bookEditionhmcD", bd.getBookhmc());
	      model.addAttribute("bookEditiontraD", bd.getBooktra());
 
		return "DummyRecordstra.html";
	}
}
