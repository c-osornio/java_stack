package com.carloso.bookbroker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carloso.bookbroker.models.Book;
import com.carloso.bookbroker.models.User;
import com.carloso.bookbroker.services.BookService;
import com.carloso.bookbroker.services.UserService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String home(HttpSession session, Model model) {
		// If no userId is found, redirect to logout
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findById(userId));
		// created user to obtain string user name and show capitalized name on welcome
		User user = (User) model.getAttribute("user");
		String name = user.getUsername().substring(0, 1).toUpperCase() + user.getUsername().substring(1);
		model.addAttribute("name", name);
		// created books model to display all books on dashboard
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
	    return "home.jsp";  
	}
	
	@GetMapping("/new")
	public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
    	User user = userService.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
		return "bookForm.jsp";
	}
	
	@GetMapping("/{id}")
	public String showBook(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		model.addAttribute("book", bookService.findBook(id));
		model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		return "showBook.jsp";
	}
	
    @GetMapping("/{id}/edit")
    public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("book", bookService.findBook(id));
    	return "editBook.jsp";
    }
    
	@PostMapping("/new")
	public String createBook(Model model, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
	    	User user = userService.findById((Long)session.getAttribute("userId"));
	    	model.addAttribute("user", user);
			return "bookForm.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
    @PutMapping("/{id}")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "editBook.jsp";
    	}
        bookService.updateBook(book);
    	return "redirect:/books";
    }
    
    @DeleteMapping("/{id}/delete")
    public String destroyBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }


}
