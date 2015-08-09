package com.example.rakus_schedule.domain;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ttanaka
 * タスクのドメイン
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	private Integer taskId;	
	private String taskName;
	private String taskStatus;
	private String taskDetail;
	private Integer taskNo;
	/**
	 * 優先度
	 */
	private String priority;
	/**
	 * 進捗度
	 */
	private Integer progress;
	/**
	 * タグ
	 */
	private String tag;
	/**
	 * 作成日時
	 */
	private Timestamp createdAt;
	/**
	 * 作成者ID
	 */
	private Integer creatorId;
	/**
	 * 担当者ID
	 */
	private String engineerId;
	/**
	 * プロジェクトID
	 */
	private Integer projectId;
	/**
	 * 更新日時
	 */
	private Timestamp updatedAt;
	/**
	 * 開始予定日
	 */
	private Date anticipatedCommencementDate;
	/**
	 * 終了予定日
	 */
	private Date expectedCompletionDate;
	/**
	 * 開始日
	 */
	private Date commecementDate;
	/**
	 * 終了日
	 */
	private Date finishDate;
	/**
	 * 完了日
	 */
	private Date completionDate;
	/**
	 * 完了フラグ
	 */
	private Integer completionFlg;
	/**
	 * 削除フラグ
	 */
	private Integer deletedFlg;
	/**
	 * 削除日時
	 */
	private Timestamp deletedAt;

}
