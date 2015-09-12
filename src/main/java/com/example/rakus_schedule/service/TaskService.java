package com.example.rakus_schedule.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rakus_schedule.domain.Task;
import com.example.rakus_schedule.repository.TaskRepository;

/**
 * TaskRepositoryで取得したデータを加工するサービスクラス
 * @author miyaharashuusaku
 *
 */
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	/* 定数定義 */
	public static final int STANDBY = 1;
	public static final int WORKING = 2;
	public static final int INREVIEW = 3;
	public static final int DONE = 4;

	/**
	 * TaskRepositoryクラスのfindAllメソッドを利用し、全てのタスク情報を取得するメソッド
	 * 取得したタスクリストをtaskstatusの値で切り分け、リスト化する。
	 * 
	 * @return taskObject:タスクステータス毎に切り分けた、リスト群。
	 */
	public List<Object> kanbanView() {
		/* 変数宣言 */
		// 全ての「タスクリスト」を格納するリスト
		List<Object> allTaskList = new ArrayList<Object>();
		
		// task_statusがstandByのものを格納するリスト
		List<Task> standByTaskList = new ArrayList<Task>();
		
		// task_statusがworlingのものを格納するリスト
		List<Task> workingTaskList = new ArrayList<Task>();
		
		// task_statusがin Reviewのものを格納するリスト
		List<Task> inReviewTaskList = new ArrayList<Task>();
		
		// task_statusがDoneのものを格納するリスト
		List<Task> doneTaskList = new ArrayList<Task>();
		
		/* 全てのタスクを一旦取得 */
		List<Task> taskList = taskRepository.findAll();
		
		/* 取得したタスクリストをtask_status毎に分ける */
		for (Task task : taskList){
			
			switch (task.getTaskStatus()){
				case STANDBY:
					// task_statusがStandByの場合
					standByTaskList.add(task);
					break;
				case WORKING:
					// task_statusがWorkingの場合
					workingTaskList.add(task);
					break;
				case INREVIEW:
					// task_statusがInReviewの場合
					inReviewTaskList.add(task);
					break;
				case DONE:
					// task_statusがDoneの場合
					doneTaskList.add(task);
					break;
			}
//			
//			if (task.getTaskStatus() == 1){
//				// task_statusがStandByの場合
//				standByTaskList.add(task);
//						
//			} else if (task.getTaskStatus() == 2){
//				// task_statusがWorkingの場合
//				workingTaskList.add(task);
//				
//			} else if(task.getTaskStatus() == 3){
//				// task_statusがInReviewの場合
//				inReviewTaskList.add(task);
//				
//			}else if(task.getTaskStatus() == 4){
//				// task_statusがDoneの場合
//				doneTaskList.add(task);
//			}
			
		}
		/* それぞれのステータスで格納したリストをオブジェクト型のリストに格納する */
		allTaskList.add(standByTaskList);
		allTaskList.add(workingTaskList);
		allTaskList.add(inReviewTaskList);
		allTaskList.add(doneTaskList);
		
		return allTaskList;
	}
		
}
