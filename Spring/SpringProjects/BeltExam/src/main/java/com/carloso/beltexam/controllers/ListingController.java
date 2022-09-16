package com.carloso.beltexam.controllers;

import java.util.Date;

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

import com.carloso.beltexam.models.Listing;
import com.carloso.beltexam.models.Note;
import com.carloso.beltexam.models.User;
import com.carloso.beltexam.services.ListingService;
import com.carloso.beltexam.services.NoteService;
import com.carloso.beltexam.services.UserService;



@Controller
public class ListingController {

	// SERVICES 
	@Autowired
	private UserService userService;
	
	@Autowired
	private ListingService listingService;
	
	@Autowired
	private NoteService noteService;
	
	// GET METHODS
	
		@GetMapping("/dashboard")
		public String dashboard(HttpSession session, Model model) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userService.findById(userId));
			model.addAttribute("listings", listingService.allListings());
			return "dashboard.jsp";
		}
		
		@GetMapping("/listings/new")
		public String newListing(@ModelAttribute("listing") Listing listing, Model model, HttpSession session) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			model.addAttribute("today", new Date());
			System.out.println(model.getAttribute("today"));
			User user = userService.findById((Long)session.getAttribute("userId"));
	    	model.addAttribute("user", user);
			return "listingForm.jsp";
		}

		@GetMapping("/listings/{id}")
		public String showListing(Model model, @PathVariable("id") Long id, HttpSession session, @ModelAttribute("note") Note note) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			Listing listing = listingService.findListing(id);
			model.addAttribute("listing", listing);
			model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
			model.addAttribute("notes", noteService.listingNotes(id));
			return "showListing.jsp";
		}
		
	    @GetMapping("/listings/{id}/edit")
	    public String editListing(Model model, @PathVariable("id") Long id, HttpSession session) {
	    	if (session.getAttribute("userId") == null) {
	    		return "redirect:/logout";
	    	}

	       	// Send back to /dashboard if user tries to edit another person's listing
	    	Long userId = (Long) session.getAttribute("userId");
	    	User user = userService.findById(userId);
			if ( !user.getUsername().equals(listingService.findListing(id).getUser().getUsername()) ) {
				return "redirect:/dashboard";
			}
			
	    	model.addAttribute("listing", listingService.findListing(id));
	    	model.addAttribute("user", user);
	    	return "editListing.jsp";
	    }
	    
	    @GetMapping("/listings/{id}/delete")
	    public String deleteListing(@PathVariable("id") Long id) {
	        listingService.deleteListing(id);
	        return "redirect:/dashboard";
	    }
		
		
		// POST METHODS
		
		@PostMapping("/listings/new")
		public String createListing(Model model, @Valid @ModelAttribute("listing") Listing listing, BindingResult result, HttpSession session) {
	    	if (session.getAttribute("userId") == null) {
	    		return "redirect:/logout";
	    	}
	    	
			if (result.hasErrors()) {
				User user = userService.findById((Long)session.getAttribute("userId"));
		    	model.addAttribute("user", user);
		    	model.addAttribute("today", new Date());
				return "listingForm.jsp";
			} else {
				Long userId = (Long) session.getAttribute("userId");
				User user = userService.findById(userId);
				Listing newListing = new Listing(listing.getAddress(), listing.getPrice(), user, listing.getListingDate());
				listingService.createListing(newListing);
				user.getListings().add(newListing);
				userService.updateUser(user);
				
				return "redirect:/dashboard";
			}
		}
		
		@PostMapping("/listings/{id}/notes")
		public String createNote(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("note") Note note, BindingResult result, HttpSession session) {
	    	if (session.getAttribute("userId") == null) {
	    		return "redirect:/logout";
	    	}
			
			Long userId = (Long) session.getAttribute("userId");
			User user = userService.findById(userId);
			Listing listing = listingService.findListing(id);
			
			
			if (result.hasErrors()) {
		    	model.addAttribute("listing", listing);
		    	model.addAttribute("notes", noteService.listingNotes(id));
				return "showListing.jsp";
			} else {
				Note newNote = new Note(user, listing, note.getText());
				newNote.setListing(listing);
				newNote.setUser(userService.findById(userId));
				noteService.createNote(newNote);
				return "redirect:/listings/" + id;
			}
		}
		

		// PUT METHOD
		
	    @PutMapping("/listings/{id}/edit")
	    public String updateListing(@Valid @ModelAttribute("listing") Listing listing, BindingResult result, @PathVariable("id") Long id) {
	    	if (result.hasErrors()) {
	    		return "editListing.jsp";
	    	} else {
		    	Listing thisListing = listingService.findListing(id);
		    	listing.setUser(thisListing.getUser());
		    	listing.setListingDate(listing.getListingDate());
		    	listing.setAddress(listing.getAddress());
		    	listing.setPrice(listing.getPrice());
		        listingService.updateListing(listing);
		    	return "redirect:/dashboard";
	    	}
	    }
		
		// DELETE METHOD
		
	    @DeleteMapping("/listings/{id}/{noteId}/delete")
	    public String destroyNote(@PathVariable("id") Long id, @PathVariable("noteId") Long noteId) {
	        noteService.deleteNote(noteId);
	        return "redirect:/listings/" + id;
	    }
	    
	    @DeleteMapping("/listings/{id}/delete")
	    public String destroyListing(@PathVariable("id") Long id) {
	        listingService.deleteListing(id);
	        return "redirect:/dashboard";
	    }
}
