package com.example.rakus_schedule.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rakus_schedule.domain.Comment;
import com.example.rakus_schedule.domain.Task;
import com.example.rakus_schedule.service.CommentService;
import com.example.rakus_schedule.service.CreateTestTaskData;
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
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CreateTestTaskData createTestTaskData;

	@ModelAttribute
	public TaskForm setUpTaskForm() {
		return new TaskForm();
	}
	
	@ModelAttribute
	public CommentForm setUpCommentForm() {
		return new CommentForm();
	}
	
	/**
	 * 最初に画面を開く際、アクティブなタスク情報を表示
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String top(Model model) {
		List<Object> allTaskList = taskService.kanbanView();
		// 動作確認用のテストデータ。DB環境構築できてない人はこっちを使う。
		//List<Object> allTaskList = createTestTaskData.createTestTaskList();
		model.addAttribute("allTaskList", allTaskList);
		return "top";
	}

	/**
	 * 新規タスクをDBに登録する。 タイトルと開始日に対するvalidateがあり formクラスで、validateは行う
	 * 
	 * @param form
	 *            入力パラメーター
	 * @param result
	 *            入力値チェック
	 * @return model 一覧表示画面
	 */
	@RequestMapping(value = "create")
	public String create(@Validated TaskForm form, BindingResult result,
			Model model) {
		// formでの入力値チェックはひとまず置いとく。JS側への戻し方わからん。
		// if(result.hasErrors()){
		// return null;
		// }
		Task task = new Task();
		BeanUtils.copyProperties(form, task);
		taskService.createTask(task);
		return top(model);
	}

	 /**
	 * タスクステータスを更新する。
	 * @param model
	 * @return トップ画面
	 */
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String taskEdit(@Validated TaskForm taskform, CommentForm commentForm, 
							BindingResult result, Model model) {
		Task task = new Task();
		Comment comment = new Comment();
		BeanUtils.copyProperties(taskform, task);
		BeanUtils.copyProperties(commentForm, comment);
		/* tasksテーブルを更新する */
		taskService.taskUpdate(task);
		/* commentsテーブルに登録する */
		commentService.commentsInsert(comment);
		return top(model);
	 }
	
	/**
	 * タスクを削除する（tasksテーブルから論理削除する）
	 * 後々、削除したタスク一覧を見えるようにする。
	 * @param model
	 * @return トップ画面
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String taskDelete(TaskForm taskform, Model model){
		Task task = new Task();
		BeanUtils.copyProperties(taskform, task);
		taskService.taskDelete(task);
		return top(model);
	}
	
}