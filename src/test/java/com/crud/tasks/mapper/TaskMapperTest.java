package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {
    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test title", "Test content");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getContent(), task.getContent());
        assertEquals(taskDto.getTitle(), task.getTitle());
    }
    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Test title", "Test content");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(task.getContent(), taskDto.getContent());
        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getTitle(), taskDto.getTitle());
    }
    @Test
    public void testMapToTaskDtoList() {
        //Given
        Task task = new Task(1L, "Test title", "Test content");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(taskList.size(), taskDtoList.size());
        assertEquals(taskList.get(0).getTitle(),taskDtoList.get(0).getTitle());
        assertEquals(taskList.get(0).getId(), taskDtoList.get(0).getId());
        assertEquals(taskList.get(0).getContent(), taskDtoList.get(0).getContent());
    }
}