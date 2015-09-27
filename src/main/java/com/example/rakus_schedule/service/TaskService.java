package com.example.rakus_schedule.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rakus_schedule.domain.OrderTask;
import com.example.rakus_schedule.domain.Task;
import com.example.rakus_schedule.repository.TaskRepository;

/**
 * Tasksテーブルに関するサービスクラス.
 * @author miyaharashuusaku
 *
 */
@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	/* 定数定義 */
	private static final int STANDBY = 0;
	private static final int WORKING = 1;
	private static final int INREVIEW = 2;
	private static final int DONE = 3;

	/**
	 * TaskRepositoryクラスのfindAllメソッドを利用し、全てのタスク情報を取得するメソッド
	 * <br>取得したタスクリストをtaskstatusの値で切り分け、リスト化する.
	 * 
	 * @return taskObject:タスクステータス毎に切り分けた、リスト群
	 */
	public List<Object> kanbanView() {
		/* 変数宣言 */
		// 全ての「タスクリスト」を格納するリスト
		List<Object> allTaskList = new ArrayList<Object>();

		// task_statusがStandByのものを格納するリスト
		List<Task> standByTaskList = new ArrayList<Task>();

		// task_statusがWorkingのものを格納するリスト
		List<Task> workingTaskList = new ArrayList<Task>();

		// task_statusがIn Reviewのものを格納するリスト
		List<Task> inReviewTaskList = new ArrayList<Task>();

		// task_statusがDoneのものを格納するリスト
		List<Task> doneTaskList = new ArrayList<Task>();

		/* アクティブなタスクを一旦取得 */
		List<Task> temporarilyTaskList = taskRepository.getActivefindAllTasks();

		/* 取得したタスクリストをtask_status毎に分ける */
		for (Task task : temporarilyTaskList) {

			switch (task.getTaskStatus()) {
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

		}
		/* それぞれのステータスで格納したリストをオブジェクト型のリストに格納する */
		allTaskList.add(standByTaskList);
		allTaskList.add(workingTaskList);
		allTaskList.add(inReviewTaskList);
		allTaskList.add(doneTaskList);

		return allTaskList;
	}

	/**
	 * 新規タスク登録のDaoを呼び出すサービスメソッド.
	 * 
	 * @param task
	 */
	public void createTask(Task task) {
		taskRepository.updateOrderNoForStandByAndInsertTasks(task);
	}
	
	/**
	 * tasksテーブルを更新するメソッド.
	 * @param task
	 */
	public void editTasks(Task task) {
		taskRepository.editTasks(task);
	}
	
	/**
	 * tasksテーブルを論理削除するメソッド.
	 * @param task
	 */
	public void deleteTasks(Task task) {
		taskRepository.deleteTasks(task);
	}
	
	/**
	 * タスク並び替えを呼び出すサービスメソッド.
	 * @param orderTask
	 */
	@Transactional
	public void orderTask(OrderTask orderTask) {
		
		//移動前のステータスにタスクが残っていれば並び順を更新する
		if( orderTask.getBeforeOrderTask() != null) {
		taskRepository.updateBeforeOrderTask(orderTask.getBeforeOrderTask());
		}
		
		//移動するタスクのステータス更新
		taskRepository.updateStatus(orderTask.getTaskId(), orderTask.getAfterStatus());
		
		//移動後のステータス列の並び順を更新する
		taskRepository.updateAfterOrderTask(orderTask.getAfterOrderTask());
	}
}