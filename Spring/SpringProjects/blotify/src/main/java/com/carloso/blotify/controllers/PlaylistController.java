package com.carloso.blotify.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carloso.blotify.models.Playlist;
import com.carloso.blotify.models.User;
import com.carloso.blotify.services.PlaylistService;
import com.carloso.blotify.services.UserService;

@Controller
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/create")
	public String newPlaylist(@ModelAttribute("playlist") Playlist playlist, HttpSession session ) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		return "newPlaylist.jsp";
	}
	
	@PostMapping("/create")
	public String createPlaylist(@Valid @ModelAttribute("playlist") Playlist playlist, HttpSession session, BindingResult result) {

		Long uid = (Long) session.getAttribute("userId");
		User loggedUser = userService.findUserById(uid);
		playlist.setUser(loggedUser);
		playlistService.createPlaylist(playlist);
		return "redirect:/home";
	}
	
}
