package com.example.rakus_schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rakus_schedule.domain.Task;
import com.example.rakus_schedule.repository.TaskRepository;


@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	
	/**
	 * 新規タスク登録のDaoを呼び出すサービスメソッド.
	 * @param task
	 */
	public void createTask(Task task) {
		taskRepository.updateOrderNoForStandByAndInsertTask(task);
	}
	
	
	
	
	
	
	
	
	
	
	
}
