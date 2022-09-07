package com.carloso.blotify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.blotify.models.Playlist;
import com.carloso.blotify.repositories.PlaylistRepository;

@Service
public class PlaylistService {
	
	@Autowired
	private PlaylistRepository playlistRepo;
	
	public Playlist createPlaylist(Playlist p) {
		return playlistRepo.save(p);
	}
}
