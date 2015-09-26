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

import com.example.rakus_schedule.domain.OrderTask;
import com.example.rakus_schedule.domain.Task;
import com.example.rakus_schedule.service.CreateTestTaskData;
import com.example.rakus_schedule.service.TaskService;

@Controller
@RequestMapping("/kanban")
public class TaskController {

	@Autowired
	private TaskService taskService;

	// @Autowired
	// private CreateTestTaskData createTestTaskData;

	@ModelAttribute
	public TaskForm setUpForm() {
		return new TaskForm();
	}

	@ModelAttribute
	public OrderTaskForm setupform() {
		return new OrderTaskForm();
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
		// List<Object> allTaskList = createTestTaskData.createTestTaskList();
		model.addAttribute("allTaskList", allTaskList);
		return "top";
	}

	/**
	 * 新規タスクをDBに登録する. タイトルと開始日に対するvalidateがあり formクラスで、validateは行う.
	 * 
	 * @param form
	 *            入力パラメーター
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
	 * 
	 * @param form
	 *            入力パラメータ
	 * @param model
	 *            一覧画面表示
	 * @return
	 */
	@RequestMapping(value = "orderupdate")
	public void orderupdate(@Validated OrderTaskForm form, Model model) {
		OrderTask orderTask = new OrderTask();
		BeanUtils.copyProperties(form, orderTask);

		taskService.orderTask(orderTask);
	}
}