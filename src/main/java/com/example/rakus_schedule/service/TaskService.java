package com.example.rakus_schedule.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rakus_schedule.domain.Task;
import com.example.rakus_schedule.repository.TaskRepository;

public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	/**
	 * TaskRepositoryクラスのfindAllメソッドを利用し、全てのタスク情報を取得するメソッド
	 * 取得したタスクリストをtaskstatusの値で切り分け、リスト化する。
	 * 
	 * @return taskObject:タスクステータス毎に切り分けた、リスト群。
	 */
	public List<Object> kanbanView(){
		/*変数宣言*/
		//全ての「タスクリスト」を格納するリスト
		List<Object> allTaskList = new ArrayList<Object>();
		
		
		//task_statusがstandByのものを格納するリスト
		List<Task> standByList = new ArrayList<Task>();
		
		//task_statusがworlingのものを格納するリスト
		List<Task> workingList = new ArrayList<Task>();
		
		//task_statusがin Reviewのものを格納するリスト
		List<Task> inReviewList = new ArrayList<Task>();
		
		//task_statusがdoneListのものを格納するリスト
		List<Task> doneList = new ArrayList<Task>();
		
		/*全てのタスクを一旦取得*/
		List<Task> taskList = taskRepository.findAll();
		
		/*取得したタスクリストをtask_status毎に分ける*/
		for(Task task : taskList){
			
			if(task.getTaskStatus() == 1){
				//task_statusがStandByの場合
				standByList.add(task);
						
			}else if(task.getTaskStatus() == 2){
				//task_statusがWorkingの場合
				workingList.add(task);
				
			}else if(task.getTaskStatus() == 3){
				//task_statusがInReviewの場合
				inReviewList.add(task);
				
			}else if(task.getTaskStatus() == 4){
				//task_statusがDoneの場合
				doneList.add(task);
			}
			
		}
		/*それぞれのステータスで格納したリストをオブジェクト型のリストに格納する*/
		allTaskList.add(standByList);
		allTaskList.add(workingList);
		allTaskList.add(inReviewList);
		allTaskList.add(doneList);
		
		return allTaskList;
	}
		
}
