package com.carloso.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.lookify.models.Song;
import com.carloso.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	SongRepository songRepo;
	
	public List<Song> allSongs() {
		return songRepo.findAll();
	}
	
	public Song createSong(Song s) {
		return songRepo.save(s);
	}
	
    public Song findSong(Long id) {
    	return songRepo.findById(id).orElse(null);
    }
	
	public void updateSong(Song s) {
		songRepo.save(s);
	}
	
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	public List<Song> findByArtist(String artist) {
		return songRepo.findByArtistContaining(artist);
	}
	
	public List<Song> findByTitle(String title) {
		return songRepo.findByTitleContaining(title);
	}
	
	public List<Song> topTen() {
		return songRepo.getTopTen();
	}
}

