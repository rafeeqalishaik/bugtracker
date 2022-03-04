package com.app.bugtracker.controller;

import com.app.bugtracker.model.Bug;
import com.app.bugtracker.service.BugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
public class BugController {

    @Autowired
    BugService bugService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Bug Tracker!";
    }

    @GetMapping("/bug/{id}")
    public Optional<Bug> index(@PathVariable Integer id) {
        log.info(String.format("fetching bug with id %s", id));
        return bugService.get(id);
    }

    @PostMapping("/bug")
    public Bug save(@RequestBody Bug bug) {
        Bug savedBug = bugService.save(bug);
        log.info(String.format("saved bug with id %s", savedBug.getId()));
        return savedBug;
    }

    @PutMapping("/bug")
    public Bug update(@RequestBody Bug bug) {
        Bug updatedBug = bugService.update(bug);
        log.info(String.format("updated bug with id %s", updatedBug.getId()));
        return updatedBug;
    }

    @DeleteMapping("/bug/{id}")
    public void delete(@PathVariable Integer id) {
        bugService.delete(id);
        log.info(String.format("deleted bug with id %s", id));
    }
}
