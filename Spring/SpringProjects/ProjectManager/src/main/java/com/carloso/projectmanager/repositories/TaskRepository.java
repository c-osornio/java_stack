package com.carloso.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.projectmanager.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
	List<Task> findByProjectIdIs(Long id);
}
