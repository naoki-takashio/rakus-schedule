package com.example.rakus_schedule.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * タスク並び替え用のフォーム.
 * @author takashionaoki
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTaskForm {

	/** 移動するタスクのタスクID. */
	private Integer taskId;
	
	/** 並び替え移動前のタスク順序. */
	private Integer[] beforeOrderTask;
	
	/** 並び替え移動後のタスク順序. */
	private Integer[] afterOrderTask;
	
	/** 移動後のステータス. */
	private Integer afterStatus;
}