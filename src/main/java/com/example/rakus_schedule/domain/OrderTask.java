package com.example.rakus_schedule.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 並べ替え用オブジェクトのクラス.
 * @author takashionaoki
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTask {

	/** 移動するタスクのタスクID. */
	private Integer taskId;
	
	/** 並び替え移動前のタスク順序. */
	private Integer[] beforeOrderTask;
	
	/** 並び替え移動後のタスク順序. */
	private Integer[] afterOrderTask;
	
	/** 移動後のステータス. */
	private Integer afterStatus;
}
