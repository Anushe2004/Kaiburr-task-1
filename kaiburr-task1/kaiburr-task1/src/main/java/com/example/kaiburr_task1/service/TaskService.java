package com.example.kaiburr_task1.service;

import com.example.kaiburr_task1.model.Task;
import com.example.kaiburr_task1.model.TaskExecution;
import com.example.kaiburr_task1.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    // ✅ Get all tasks
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // ✅ Get task by ID
    public Optional<Task> getTaskById(String id) {
        return repository.findById(id);
    }

    // ✅ Create or update a task
    public Task saveTask(Task task) {
        if (task.getName() == null || task.getName().isBlank()) {
            throw new IllegalArgumentException("Task name cannot be empty");
        }
        return repository.save(task);
    }

    // ✅ Delete a task
    public void deleteTask(String id) {
        repository.deleteById(id);
    }

    // ✅ Search by name (case-insensitive)
    public List<Task> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    // ✅ Execute task command
    public Task executeTask(String id) throws Exception {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        if (task.getCommand() == null || task.getCommand().isBlank()) {
            throw new IllegalArgumentException("Task command cannot be empty");
        }

        Instant start = Instant.now();
        Process process = Runtime.getRuntime().exec(task.getCommand());

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
        );

        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();
        Instant end = Instant.now();

        TaskExecution execution = TaskExecution.builder()
                .startTime(start)
                .endTime(end)
                .output(output.toString())
                .build();

        task.setLastExecution(execution);
        return repository.save(task);
    }
}



