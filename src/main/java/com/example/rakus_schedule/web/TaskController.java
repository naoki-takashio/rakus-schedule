package com.example.rakus_schedule.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.rakus_schedule.domain.OrderTask;
import com.example.rakus_schedule.domain.Comment;
import com.example.rakus_schedule.domain.Task;
import com.example.rakus_schedule.service.CommentService;
//import com.example.rakus_schedule.service.CreateTestTaskData;
import com.example.rakus_schedule.service.TaskService;

/**
 * カンバン操作を制御するクラス
 * @author miyaharashuusaku
 *
 */
@Controller
@RequestMapping("/kanban")
public class TaskController {

	@Autowired
	private TaskService taskService;

	// @Autowired
	// private CreateTestTaskData createTestTaskData;
	
	@Autowired
	private CommentService commentService;
	

	@ModelAttribute
	public TaskForm setUpTaskForm() {
		return new TaskForm();
	}

	@ModelAttribute
	public OrderTaskForm setupform() {
		return new OrderTaskForm();
	}

	@ModelAttribute
	public CommentForm setUpCommentForm() {
		return new CommentForm();
	}
	
	/**
	 * 最初に画面を開く際、アクティブなタスク情報を表示.
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String top(Model model) {
		List<Object> allTaskList = taskService.kanbanView();
		// 動作確認用のテストデータ。DB環境構築できてない人はこっちを使う。
		// List<Object> allTaskList = createTestTaskData.createTestTaskList();
		model.addAttribute("allTaskList", allTaskList);
		return "top";
	}

	/**
	 * 新規タスクをDBに登録する. タイトルと開始日に対するvalidateがあり formクラスで、validateは行う.
	 * @param form 入力パラメーター
	 * @return model 一覧表示画面
	 */
	@RequestMapping(value = "create")
	public String create(@Validated TaskForm form, Model model) {
		Task task = new Task();
		BeanUtils.copyProperties(form, task);
		taskService.createTask(task);
		return top(model);
	}

	/**
	 * タスク並べ替えを行う.
	 * @param form 入力パラメータ
	 * @param model 一覧画面表示
	 */
	@RequestMapping(value = "orderupdate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String orderupdate(@Validated @RequestBody OrderTaskForm form, Model model) {
		OrderTask orderTask = new OrderTask();
		BeanUtils.copyProperties(form, orderTask);
		//並べ替えを行う
		taskService.orderTask(orderTask);
		return top(model);
	}
	
	 /**
	 * タスクステータスを更新する。
	 * @param model
	 * @return トップ画面
	 */
	@Transactional
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editTasks(@Validated TaskForm taskForm, CommentForm commentForm, 
						Model model) {
		Task task = new Task();
		Comment comment = new Comment();
		BeanUtils.copyProperties(taskForm, task);
		BeanUtils.copyProperties(commentForm, comment);
		/* tasksテーブルを更新する */
		taskService.editTasks(task);
		/* commentsテーブルに登録する */
		commentService.commentsInsert(comment);
		return top(model);
	 }
	
	/**
	 * タスクを削除する（tasksテーブルから論理削除する）
	 * 後々、削除したタスク一覧を見えるようにする.
	 * @param model
	 * @return トップ画面
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String deleteTasks(TaskForm taskForm, Model model) {
		Task task = new Task();
		BeanUtils.copyProperties(taskForm, task);
		taskService.deleteTasks(task);
		return top(model);
	}	
}