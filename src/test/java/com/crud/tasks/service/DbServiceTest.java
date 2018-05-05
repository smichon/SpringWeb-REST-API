package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTest {

    @InjectMocks
    private DbService service;
    @Mock
    private TaskRepository repository;

    @Test
    public void getAllTasks() {
        //Given
        List<Task> taskList = Arrays.asList(new Task(1L, "test", "test content"),
                new Task(2L, "test2", "test2 content"));
        when(repository.findAll()).thenReturn(taskList);
        //When
        List<Task> expectedList = service.getAllTasks();
        //Then
        assertEquals(expectedList.size(), taskList.size());
    }

    @Test
    public void shouldFetchOneTask() {
        //Given
        Task task = new Task(1L, "test", "test content");
        when(repository.findById(1L)).thenReturn(Optional.of(task));
        //When
        Optional<Task> expectedTask = service.getOneTask(1L);
        //Then
        assertEquals(expectedTask.get().getId(), task.getId());
        assertEquals(expectedTask.get().getTitle(), task.getTitle());
        assertEquals(expectedTask.get().getContent(), task.getContent());
    }
    @Test
    public void shouldSaveTask() {
        //Given
        Task task = new Task(1L, "test", "test content");
        when(repository.save(task)).thenReturn(task);
        //When
        Task savedTask = service.saveTask(task);
        //Then
        assertEquals(savedTask.getId(), task.getId());
        assertEquals(savedTask.getTitle(), task.getTitle());
        assertEquals(savedTask.getContent(), task.getContent());
    }
    @Test
    public void shouldDeleteTask() {
        //Given
        Task task = new Task(1L, "test", "test content");
        //When
        service.deleteById(1L);
        //Then
        verify(repository, times(1)).deleteById(1L);
    }
}