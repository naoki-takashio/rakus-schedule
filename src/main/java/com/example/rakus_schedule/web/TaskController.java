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

import com.example.rakus_schedule.domain.Task;
import com.example.rakus_schedule.service.CreateTestTaskData;
import com.example.rakus_schedule.service.TaskService;

@Controller
@RequestMapping("/kanban")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private CreateTestTaskData createTestTaskData;

	@ModelAttribute
	public TaskForm setUpForm() {
		return new TaskForm();
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
		Task task = new Task();
		BeanUtils.copyProperties(form, task);

		taskService.createTask(task);
		return top(model);
	}

	// /**
	// * タスクステータスを更新する。画面上で、タスクをドラッグした場合。 javascriptで制御しているので、return
	// index()は行わない
	// * どのタスクが更新されたかが分かる必要がある。 送られる値はtasl_idと、task_statusだけ？ボス次第
	// *
	// * @param model
	// */
	// @RequestMapping(params = "statusUpdate", method = RequestMethod.GET)
	// public void taskStatusUpdate(TaskRegistrationForm form, Model model) {
	// Task task = new Task();
	// BeanUtils.copyProperties(form, task);
	// taskRepository.update(task);
	// }
	//
	// /**
	// * ステータスを更新する。 どのタスクが更新されたかが分かる必要がある。 送られる値はtasl_idと、task_statusだけ？ボス次第
	// *
	// * @param model
	// */
	// @RequestMapping(params = "statusUpdate", method = RequestMethod.GET)
	// public void statusUpdate(TaskRegistrationForm form, Model model) {
	// Task task = new Task();
	// BeanUtils.copyProperties(form, task);
	// taskRepository.update(task);
	// }
	//
	// /**
	// * タスク編集を行う。 送られる値はtasl_idと、task_statusだけ？ボス次第
	// *
	// * @param model
	// */
	// @RequestMapping(params = "edit", method = RequestMethod.POST)
	// public void edit(TaskRegistrationForm form, Model model) {
	// Task task = new Task();
	// BeanUtils.copyProperties(form, task);
	// taskRepository.update(task);
	// }
}