package com.app.bugtracker.service;

import com.app.bugtracker.dao.BugRepository;
import com.app.bugtracker.model.Bug;
import com.app.bugtracker.model.State;
import com.app.bugtracker.model.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BugServiceTests {

    @MockBean
    private BugRepository bugRepository;

    @Autowired
    private BugService bugService;

    @Test
    public void getTest() {
        when(bugRepository.findById(1)).thenReturn(Optional.of(new Bug(1, "Test Bug", "Test Bug Description", Type.Task, State.New, "User")));
        Optional<Bug> bugOptional = bugService.get(1);
        if (bugOptional.isPresent()) {
            Bug bug = bugOptional.get();
            assert bug.getId() == 1;
        }
    }

    @Test
    public void saveTest() {
        Bug bug = new Bug(1, "Test Bug", "Test Bug Description", Type.Task, State.New, "User");
        when(bugRepository.save(bug)).thenReturn(bug);
        assert Objects.equals(bug, bugService.save(bug));
    }

    @Test
    public void updateTest() {
        Bug bug = new Bug(1, "Test Bug", "Test Bug Description", Type.Task, State.New, "User");
        when(bugRepository.save(bug)).thenReturn(bug);
        assert Objects.equals(bug, bugService.save(bug));
    }

    @Test
    public void deleteTest() {
        bugService.delete(1);
        verify(bugRepository, times(1)).deleteById(1);
    }
}
