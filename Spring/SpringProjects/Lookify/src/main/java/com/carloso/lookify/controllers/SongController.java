package com.carloso.lookify.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.carloso.lookify.models.Song;
import com.carloso.lookify.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService songService;
	
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model,  @ModelAttribute("song") Song song) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "create.jsp";
    }
	
	@GetMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	
	@GetMapping("/search/topTen")
	public String details(Model model) {
		List<Song> songs = songService.topTen();
		model.addAttribute("songs", songs);
		return "top10.jsp";
	}
	
	@GetMapping("/search/{artist}")
	public String searchArtist(@PathVariable("artist") String artist, Model model) {
		List<Song> songs = songService.findByArtist(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "search.jsp";
	}
	
	@PostMapping("/songs/new")
	public String create(Model model, @Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/dashboard")
	public String dashboard(@RequestParam("artist") String artist, Model model) {
		model.addAttribute("artist", artist);
		return "redirect:/search/"+artist;
	}
	
    @DeleteMapping("/songs/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
}
