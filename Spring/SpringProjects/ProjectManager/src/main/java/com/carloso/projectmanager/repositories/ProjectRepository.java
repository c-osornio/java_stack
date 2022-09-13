package com.carloso.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.projectmanager.models.Project;
import com.carloso.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

	List<Project> findByUsersIdIs(Long userId);
	List<Project> findByUsersNotContains(User user);
}
