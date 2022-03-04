package com.app.bugtracker.dao;

import com.app.bugtracker.model.Bug;
import org.springframework.data.repository.CrudRepository;

public interface BugRepository extends CrudRepository<Bug, Integer> {
}
