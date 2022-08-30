package com.carloso.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	Optional<Song> findById(Long id);
	List<Song> findByArtistContaining(String artist);
	List<Song> findByTitleContaining(String title);
//	List<Song> findAllByOrderByRatingDesc();
//	List<Song> findTopByOrderByRatingDesc();
	
	@Query(value = "SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery = true) 
	List<Song> getTopTen();
}
