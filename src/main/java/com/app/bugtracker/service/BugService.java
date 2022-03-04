package com.app.bugtracker.service;

import com.app.bugtracker.dao.BugRepository;
import com.app.bugtracker.model.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;

    public Optional<Bug> get(Integer id) {
        Optional<Bug> bugOptional = bugRepository.findById(id);
        if (bugOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("No element found with bug id %s", id));
        }
        return bugOptional;
    }

    public Bug save(Bug bug) {
        return bugRepository.save(bug);
    }

    public Bug update(Bug bug) {
        return bugRepository.save(bug);
    }

    public void delete(Integer id) {
        bugRepository.deleteById(id);
    }
}
