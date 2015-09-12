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

import com.example.rakus_schedule.domain.Task;
import com.example.rakus_schedule.repository.TaskRepository;
import com.example.rakus_schedule.service.TaskService;

@Controller
@RequestMapping("/")
public class TaskController {

	@Autowired
	private TaskService taskService;

//	@ModelAttribute
//	public TaskRegistrationForm setUpForm(){
//		return new TaskRegistrationForm();
//	}

	/**
	 * 最初に画面を開く際、全てのタスクを表示
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String top(Model model) {		
		List<Object> allTaskList = taskService.kanbanView();
		model.addAttribute("allTaskList",allTaskList);
		return "top";
	}
	
	
//	/**
//	 * 新規タスクを作成し、一覧に表示する。 タイトルと開始日に対するvalidateがあり
//	 * formクラスで、validateは行う
//	 * DBに登録する作業も必要
//	 * @param form 入力パラメーター
//	 * @param result 入力値チェック
//	 * @param model Taskの新規作成画面
//	 */
//	@RequestMapping(params = "create", method = RequestMethod.POST)//これもリクエストマッピングじゃない気がする
//	public String create(@Validated TaskRegistrationForm form, BindingResult result,
//			Model model){
//		if(result.hasErrors()){
////			return index();
//		}
//		Task task = new Task();
//		BeanUtils.copyProperties(form, task);
//		
//		taskRepository.save(task);	
//		return index(model);
//	}
//	
//	/**
//	 * タスクステータスを更新する。画面上で、タスクをドラッグした場合。
//	 * javascriptで制御しているので、return index()は行わない
//	 * どのタスクが更新されたかが分かる必要がある。
//	 * 送られる値はtasl_idと、task_statusだけ？ボス次第
//	 * @param model
//	 */
//	@RequestMapping(params = "statusUpdate", method = RequestMethod.GET)
//	public void taskStatusUpdate(TaskRegistrationForm form, Model model){
//		Task task = new Task();
//		BeanUtils.copyProperties(form, task);
//		taskRepository.update(task);
//	}
//
//	/**
//	 * ステータスを更新する。
//	 * どのタスクが更新されたかが分かる必要がある。
//	 * 送られる値はtasl_idと、task_statusだけ？ボス次第
//	 * @param model
//	 */
//	@RequestMapping(params = "statusUpdate", method = RequestMethod.GET)
//	public void statusUpdate(TaskRegistrationForm form, Model model){
//		Task task = new Task();
//		BeanUtils.copyProperties(form, task);
//		taskRepository.update(task);
//	}
//
//	/**
//	 * タスク編集を行う。
//	 * 送られる値はtasl_idと、task_statusだけ？ボス次第
//	 * @param model
//	 */
//	@RequestMapping(params = "edit", method = RequestMethod.POST)
//	public void edit(TaskRegistrationForm form, Model model){
//		Task task = new Task();
//		BeanUtils.copyProperties(form, task);
//		taskRepository.update(task);
//	}
}