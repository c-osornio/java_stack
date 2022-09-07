package com.carloso.blotify.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.blotify.models.Playlist;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
	
}
