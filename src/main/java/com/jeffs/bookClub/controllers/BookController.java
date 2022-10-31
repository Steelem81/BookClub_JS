package com.jeffs.bookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeffs.bookClub.models.Book;
import com.jeffs.bookClub.models.User;
import com.jeffs.bookClub.services.BookService;
import com.jeffs.bookClub.services.UserService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookServ;
	@Autowired
	private UserService userServ;
	
	@GetMapping("/all")
	public String books(Model model, HttpSession session) {
		if(session == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.getUserById((Long)session.getAttribute("userId")));
		model.addAttribute("allBooks", bookServ.getAllBooks());
		return "books.jsp";
	}
	
	@GetMapping("/addBook")
	public String addBook(@ModelAttribute("newBook")Book newBook, Model model, HttpSession session) {
		if(session == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.getUserById((Long)session.getAttribute("userId")));
		return "addBook.jsp";
	}
	
	@PostMapping("/create")
	public String createBook(@Valid @ModelAttribute("newBook")Book newBook, BindingResult result, Model model, HttpSession session) {
//		if(result.hasErrors()){
//			return "redirect:/books/addBook";
//		}else {
			Long userId = (Long) session.getAttribute("userId");
			System.out.println(userId);
			User user = userServ.getUserById(userId);
			newBook.setUser(user);
			bookServ.createBook(newBook);
			return "redirect:/books/all";
		
	}
	
	@GetMapping("/{bookId}")
	public String viewBook(@PathVariable(name="bookId")Long id, Model model, HttpSession session) {
		Book book = bookServ.getBookById(id);
		if(book == null) {
			return "redirect:/books/all";
		}else {
			User user = userServ.getUserById((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
			model.addAttribute("book", book);
			return "viewBook.jsp";
		}
	}
	

}
